
print("----------")

local score1 = {yw=80, sx=70}
score1.yy = 100
redis.log(redis.LOG_NOTICE, "yy=="..score1.yy)

function score1:show(a,b)
    redis.log(redis.LOG_NOTICE, "yy=="..self.yy..",a+b="..(a+b))
end

score1:show(1, 2)


--[[
local score1 = {yw=80, sx=70}
local score2 = {yw=90, sx=60}


local myAdd = {}
function myAdd.__add(f1, f2)
	local ret = {}
	ret.yw = f1.yw + f2.yw
	ret.sx = f1.sx + f2.sx

	return ret
end

setmetatable(score1, myAdd)
setmetatable(score2, myAdd)

local sum = score1 + score2
redis.log(redis.LOG_NOTICE, "yw=="..sum.yw..",sx=="..sum.sx)

]]


--[[
for i=1,#KEYS do
	local s = redis.call("get", KEYS[i])
	redis.log(redis.LOG_NOTICE, "key=="..s)
end
]]

--[[
redis.call("set", "k2", "v22")
redis.call("set", "k3", "v33")
redis.call("set", "k4", "v44")
local ks = redis.call("keys", "*")
for i=1,#ks do
	redis.log(redis.LOG_NOTICE, "k=="..ks[i])
end
]]


--[[

local a = {id="user1", name="user1Name", age=8}

local s = cjson.encode(a)

local a2 = cjson.decode(s)

redis.log(redis.LOG_NOTICE, "s="..s)

redis.log(redis.LOG_NOTICE, "a2.name="..a2.name)
]]

--[[
math.randomseed("123")

for i=1,10 do
	redis.log(redis.LOG_NOTICE, "r="..math.random(5,10))
end

]]

--[[
local a = {"a1", "a3", "a2"}

local fun1 = function(t1, t2)
	return t1 > t2
end

table.sort(a, fun1)

local s = table.concat( a, "-")
redis.log(redis.LOG_NOTICE, "s="..s)

]]


--[[
local ind = string.find("abcdef", "ef")
redis.log(redis.LOG_NOTICE, "ind="..ind)


local num = string.char(97)
redis.log(redis.LOG_NOTICE, "num="..num)

local sub = string.sub("123", 1, 2)
redis.log(redis.LOG_NOTICE, "sub="..sub)


local s = string.rep("123", 3)
redis.log(redis.LOG_NOTICE, "s="..s)
]]





--[[
 	local args = {...}
	for i=1, #args do
		redis.log(redis.LOG_NOTICE, "args"..i.."="..args[i])
	end
return a + b
end

local retFun = myAdd(3, 4, 5, 6, 7)

redis.log(redis.LOG_NOTICE, "retFun="..retFun)



-- local a = {'user1', 'userName111'}
local a = {id="user1", name = "userName111"}

for k, v in pairs(a) do
	print("k="..k..",v="..v)
end

]]

--[[
redis.log(redis.LOG_NOTICE, "a.id="..a[1])
redis.log(redis.LOG_NOTICE, "a.name="..a[2])
]]

--[[
local a = {id="user1", name = "userName111"}
redis.log(redis.LOG_NOTICE, "a.id="..a.id)
redis.log(redis.LOG_NOTICE, "a.name="..a["name"])
]]



--[[
print("hello world")

redis.log(redis.LOG_NOTICE, "hello world".."123")

local a = #'helloworl'
local ret

if a%2 == 0 then
	ret = 2
elseif a%3 == 0 then
	ret = 3
else
	ret = 1
end

-- 分割线

local sum = 0

for i=1,10,1 do
	if i%2 == 0 then
	 sum = sum + i
	end
end

-- 分割线

sum = 0
local i = 1
while i < 10 do
	sum = sum + i
	i = i + 1
end

-- 分割线

sum = 0
i = 1

repeat
	redis.log(redis.LOG_NOTICE, "i="..i..",sum="..sum)
	sum = sum + i
	i = i+1
	if i == 3 then
		break
	end
until i > 3
]]

return 1




