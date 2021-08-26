--[[
1.获取所有的 goods uuid
2.获取每个 goods 对象
3.判断每个 goods 对象是否满足条件
4.满足条件的对象就存放到要返回的集合中
]]

local ret = {}

-- 获取传入的条件
local qm = cjson.decode(ARGV[1])

-- 检索条件
local check = function(uuid, name, imgPath, description)
    if qm.uuid~=nil and tonumber(qm.uuid) > 0 then
        if tonumber(qm.uuid) ~= tonumber(uuid) then
            return false
        end
    end

    if qm.name~=nil and string.len(qm.name) > 0 then
        if string.find(name, qm.name) == nil then
            return false
        end
    end

    if qm.imgPath~=nil and string.len(qm.imgPath) > 0 then
        if string.find(imgPath, qm.imgPath) == nil then
            return false
        end
    end

    if qm.description~=nil and string.len(qm.description) > 0 then
        if string.find(description, qm.description) == nil then
            return false
        end
    end
    return true
end

-- 1.获取所有的 goods uuid
local goodsUuids = redis.call("lrange", "GoodsUuidsL", 0, -1)

local count = 0

local pageStart = qm.page.nowPage *
local pageStart = 0
local pageEnd = 1

if tonumber(qm.page.nowPage) >= 1 then
    pageStart = (tonumber(qm.pageEnd.nowPage) - 1) * tonumber(qm.page.pageShow)
    pageEnd = pageStart + tonumber(qm.page.pageShow)
elseif tonumber(qm.page.nowPage) < 1 then
    pageStart = 0
    pageEnd = tonumber(qm.page.pageShow)
end

for i=1,#goodsUuids do
    -- 2.获取每个 goods 对象
    redis.log(redis.LOG_NOTICE, "goodsUuids[i]==="..i)
    -- local uuid = redis.call("hget", "GoodsH:"..goodsUuids[i], uuid)
    local goods = redis.call("hgetall", "GoodsH:"..goodsUuids[i])
    local uuid = goods.uuid;
    local name = goods.name
    local imgPath = goods.imgPath
    local description = goods.description
    -- 3.判断每个 goods 对象是否满足条件
    if check(uuid, name, imgPath, description) then
        -- 4.满足条件的对象就存放到要返回的集合中
        -- 5.满足分页的条件
        if count > pageStart and count <= pageEnd then
            --[[
            local gm = {
                uuid = uuid,
                name = name,
                imgPath = imgPath,
                description = description
            }
            ]]
            count = count + 1

            table.insert(ret, cjson.encode(goods))
        end
    end
end
return cjson.encode(ret)

