--[[
1.获取所有的 goods uuid
2.获取每个 goods 对象
3.判断每个 goods 对象是否满足条件
4.满足条件的对象就存放到要返回的集合中
]]

local ret = {}

local check = function(uuid, name, imgPath, description)

end


-- 获取传入的条件
local qm = ARGV[1]
-- local qm = cjson.decode(ARGV[1])
-- qm.uuid = "321123"

-- 1
local goodsUuids = redis.call("lrange", "GoodsUuidsL", 0, -1)


for i=1,#GoodsUuidsL do
    -- 2
    local goods = redis.call("hget", "GoodsH:"..GoodsUuidsL[i])
    local uuid = goods.uuid;
    local name = goods.name
    local imgPath = goods.imgPath
    local description = goods.description
    -- 3



end






 return qm
 --return cjson.encode(ret)




