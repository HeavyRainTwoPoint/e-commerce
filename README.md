

## 管理员

<hr>

#### 登录

~~~url
POST /admin/login   
~~~

~~~json
//附带参数
{
    "adminName": "admin1",
    "adminPassword": "123456"
}

//返回结果
{
    "result": true,
    "message": "登录成功！",
    "code": 200,
    "token": "P8a8gkf11602748446308"
}
~~~



## 抽奖模块

<hr>

#### 添加一个新活动

~~~url
POST /addAct
~~~

~~~json
//需要附带数据
{
    "activity": {
        "actName": "定时抽奖",    #活动名称
        "actType": 2,           #活动类型  值只能为：  1 / 2
        "limited": 1,            #活动限制  也是用1234表示群体
        "actDescribe": "测试接口",   #活动描述
        "startTime": 1601395200000,  #开始时间，时间戳格式数据
        "endTime": 1601395200000,    #结束时间，同上
        "wayOfAwarding": "邮递"   #发奖方式 无实际意义，保持老板给定效果
    },
    "prizeList": [         #列表类型数据
        { 
            "prizeName": null,  #奖品名称
            "prizeLevel": 1,    #奖品等级
            "prizeType": null,  #奖品类型
            "prizeCount": 1,    #奖品数量
        }
    ]
}

//返回数据  成功
{
    "result": true, 
    "message": "成功添加一个活动",
    "code": 200
}
//失败
{
    "result": false, 
    "message": "活动添加失败！",
    "code": 200
}

//数据样例
{
    "activity": {
        "actName": "定时抽奖",
        "actType": 2,
        "limited": 1,
        "actDescribe": "测试接口",
        "startTime": 1601395200000,
        "endTime": 1601395200000,
        "wayOfAwarding": "邮递"
    },
    "prizeList": [
        {
            "prizeName": "无门槛红包50元",
            "prizeLevel": 1,
            "prizeType": "优惠券",
            "prizeCount": 3
        }
    ]
}
~~~

#### 

#### 删除某个活动

~~~url
POST /delAct
~~~

~~~json
//附带参数
{
    "actID": "一个字符串"  #暂时无模板数据，长度6
}

//返回结果
{
    "result": true, 
    "message": "删除了一个活动！",
    "code": 200
}
{
    "result": false, 
    "message": "删除活动失败！",
    "code": 200
}
~~~



#### 查看某个活动详情

~~~url
POST /actDetails
~~~

~~~json
//附带参数
{
    "actID": "i0BdK2uG"
}

//返回结果
{
    "activity": {
        "actID": "i0BdK2uG",
        "actName": "定时抽奖",
        "actType": 2,
        "limited": 1,
        "actDescribe": "测试接口",
        "actStatus": 0,             # 0表示活动已结束 1表示活动进行中 2表示活动未开始
        "wayOfAwarding": null,
        "startTime": 1601395200000,
        "endTime": 1601395200000,
        "actId": "i0BdK2uG"
    },
    "prizeList": [
        {
            "prizeName": "无门槛红包10元",
            "prizeLevel": 3,
            "prizeType": "优惠券",
            "prizeCount": 5,
            "referenceTo": "i0BdK2uG",    #这里开始都是多余数据 start
            "startCode": 0,
            "endCode": 0,
            "prizeWeight": 0.0,
            "hitCode": 0                                    # end
        },
        {
            "prizeName": "无门槛红包50元",
            "prizeLevel": 1,
            "prizeType": "优惠券",
            "prizeCount": 3,
            "referenceTo": "i0BdK2uG",
            "startCode": 0,
            "endCode": 0,
            "prizeWeight": 0.0,
            "hitCode": 0,
            "prizeId": "502944"
        },
        {
            "prizeName": "无门槛红包30元",
            "prizeLevel": 2,
            "prizeType": "优惠券",
            "prizeCount": 3,
            "referenceTo": "i0BdK2uG",
            "startCode": 0,
            "endCode": 0,
            "prizeWeight": 0.0,
            "hitCode": 0,
            "prizeId": "504350"
        }
    ]
}
~~~



#### 获取所有活动

~~~url
POST /getAll
~~~

~~~json
[
    {
        "actID": "5RyaziaL",
        "actName": "限时秒杀",
        "actType": 1,
        "limited": 1,
        "actDescribe": "测试接口",
        "actStatus": 0,
        "wayOfAwarding": "邮递",
        "startTime": 1601395200000,
        "endTime": 1601395200000,
    }
]
~~~



#### 按条件查询活动

~~~URL
POST /searchAct
~~~

~~~json
//附带参数   注：默认精确查询，参数数量没下限，最多下面四个，没有附带参数则是查询全部
{
    "actID": "5RyaziaL",
    "actName": "限时秒杀",
    "actStatus": 0,
    "endTime": 1601395200000,
}

//返回结果
[
    {
        "actID": "5RyaziaL",
        "actName": "限时秒杀",
        "actType": 1,
        "limited": 1,
        "actDescribe": "测试接口",
        "actStatus": 0,
        "wayOfAwarding": "邮递",
        "startTime": 1601395200000,
        "endTime": 1601568000000
    },
    {
        "actID": "dLajQZ4e",
        "actName": "定时抽奖",
        "actType": 2,
        "limited": 1,
        "actDescribe": "测试接口",
        "actStatus": 0,
        "wayOfAwarding": "邮递",
        "startTime": 1601395200000,
        "endTime": 1601568000000
    }
]
~~~



#### 参与活动

~~~url
POST /lottery
~~~

~~~json
//附带参数
{
    "userID": "GR32825083",
    "actID": "i0BdK2uG",
    "identity": 2
}

//返回结果
"""
code值说明：
	200开头表示本次抽奖发起已经被后台接受
	   1/2/3/4分别表示中奖等级，其中2004表示谢谢惠顾
	   5表示本次参与的是定时抽奖，而且已经记录在后台了
"""
{
    "result": true,
    "message": "恭喜中奖！",
    "code": 2001
}
~~~



## 用户模块

<hr>

#### 注册用户

~~~url
POST /user/register
~~~

~~~json
//附加参数
{
    "userNickname": "hhh",         #用户昵称
    "password": 123456,            #密码
    "address": "广东广州",          #地址
    "birthday": 1601395200000,     #生日（时间戳）
    "loginAccout": "13435923454"   #账号（默认手机号码格式）
}

//返回结果
{
    "result": false, 
    "message": "活动添加失败！",
    "code": 200
}
~~~

#### 登录验证

~~~URL
POST /user/login
~~~

~~~json
//附带参数
{
 	"loginAccount": "",
    "password": ""
}

//返回结果待定
~~~

#### 查看当前开始的活动（定时和抽奖是分开两个接口的，但是他们干同样的事情）

~~~URL
POST /timing
~~~

~~~json
//附带参数  无
//返回结果
[
    {
        "actID": "5khM2Lb2",
        "actName": "定时抽奖",
        "actType": 2,
        "limited": 1,
        "actDescribe": "测试接口",
        "actStatus": 3,
        "wayOfAwarding": "邮递",
        "startTime": 1603468800000,
        "endTime": 1601395200000
    }
]
~~~

~~~URL
POST /spiking
~~~

~~~json
//附带参数  无
//返回结果
[
    {
        "actID": "5RyaziaL",
        "actName": "限时秒杀",
        "actType": 1,
        "limited": 1,
        "actDescribe": "测试接口",
        "actStatus": 3,
        "wayOfAwarding": "邮递",
        "startTime": 1603468800000,
        "endTime": 1601568000000
    },
    {
        "actID": "CBMMBRR6",
        "actName": "滴滴滴滴",
        "actType": 1,
        "limited": 1,
        "actDescribe": "测试接口",
        "actStatus": 3,
        "wayOfAwarding": "邮递",
        "startTime": 1603497600000,
        "endTime": 1601395200000
    }
]
~~~



#### XXXX

~~~URL

~~~

~~~json

~~~





## 商品模块

<hr>

#### 商品的三种状态码：

​	**1：上架中**

​	**0：下架中**

​	**-1：售罄**

#### 获取商品信息（分页获取）

~~~url
POST /goods/allGoods
~~~

~~~json
//附加参数
{
	"targetPage": 1                      #1表示第一页
}

//返回结果
{
    "targetPage": 1,
    "totalPage": 0,
    "totalCount": 0,
    "limit": 10,
    "entryList": [                     #这是列表来的，别给我看错了！
        {
            "id": 0,
            "goodsID": null,
            "goodsName": null,
            "goodsCount": null,
            "goodsPrice": 0.0,
            "goodsDescribe": null,
            "goodsStatus": 0,
            "goodsUnit": null,
            "referToBrand": null,
            "categoryID": null,
            "categoryName": null
        }
    ]
}
~~~



#### 添加商品

~~~url
POST /goods/addGoods
~~~

~~~json
//附带参数
{
    "goodsName": "小米K30",
    "goodsCount": 20,
    "goodsPrice": 3999.99,
    "goodsDescribe": "前后柔光三摄， 瞅人更拽！",
    "goodsStatus": 1,
    "goodsUnit": "台",
    "referToBrand": null,
    "categoryID": null
}

//返回结果
{
    "result": true,
    "message": "成功添加一个商品！",
    "code": 200
}

//添加失败的返回结果
{
    "result": false,
    "message": "添加失败！请重试！",
    "code": 500
}
~~~



#### 查看商品详情

~~~urtl
POST /goods/details
~~~

~~~json
//附带参数
{
    "goodsID": "G34092"
}

//返回结果
{
    "id": 1,
    "goodsID": "G34092", 
    "goodsName": "小米K30",
    "goodsCount": "20",           //库存量
    "goodsPrice": 3999.99,        //售价
    "goodsDescribe": "前后柔光三摄， 瞅人更拽！",     //商品描述
    "goodsStatus": 1,             //商品状态 1：上架， 0：售罄， -1：下架
    "goodsUnit": "台",            //计量单位
    "referToBrand": null,         //所属品牌
    "categoryID": "C0114",        //所属类别
    "categoryName": "手机"         //类别的名称
}
~~~



#### 删除商品

~~~url
POST /goods/delGoods
~~~

~~~json
//附带参数
{
	"goodsID": "G34092"
}
//返回结果
{
    "result": true,
    "message": "成功删除一个商品！",
    "code": 200
}

{
    "result": false,
    "message": "删除商品失败！请重试！",
    "code": 200
}
~~~



#### 修改商品状态

~~~url
POST /goods/updateStatus
~~~

~~~json
//附带参数
{
    "goodsStatus": 1 / 0 / -1,       #取值的时候三选一
    "goodsID": "G34092"
}
//返回结果
{
    "result": true,
    "message": "添加失败！请重试！",
    "code": 200
}

//参数说明
goodsStatus:商品的状态；
1：上架中
0：下架中
-1：售罄
~~~



#### 查找商品

~~~url
POST /goods/search
~~~

~~~json
//附带参数
{
    "targetPage": 1,     //当前页数一定要的
    "goodsID": "",       //这里开始随缘  商品ID
    "goodsName": "",     //商品名称
    "referToBrand": "华为",    //品牌
    "categoryID": "",         //类别ID
    "goodsStatus": 1     //商品状态
}

//返回结果
{
    "targetPage": 1,
    "totalPage": 6,
    "totalCount": 52,
    "limit": 10,
    "entryList": [
        {
            "id": 3,
            "goodsID": "G72509",
            "goodsName": "HUAWEI 华为 P40",
            "goodsCount": "187",
            "goodsPrice": 1739.12,
            "goodsDescribe": null,
            "goodsStatus": 1,
            "goodsUnit": null,
            "referToBrand": "华为",
            "categoryID": null,
            "categoryName": null,
            "count": 0
        },
        {
            "id": 4,
            "goodsID": "G60347",
            "goodsName": "HUAWEI P40 lite",
            "goodsCount": "271",
            "goodsPrice": 1729.93,
            "goodsDescribe": null,
            "goodsStatus": 1,
            "goodsUnit": null,
            "referToBrand": "华为",
            "categoryID": null,
            "categoryName": null,
            "count": 0
        }
    ]
}

~~~







## 类别模块

<hr>

#### 获取所有类别


~~~URL
POST /category/getAll
~~~

~~~json
//附带参数
无

//返回结果
[                  #这是一个列表！别看错了
    {
        "id": 1,
        "categoryName": "手机",
        "categoryID": "C0114"
    }
]
~~~



#### 添加一个类别

~~~url
POST /category/addCategory
~~~

~~~json
//附带参数
{
    "categoryName": "手机"
}

//返回结果
{
    "result": true,
    "message": "成功添加一个分类",
    "code": 200
}

//添加失败的返回结果
{
    "result": false,
    "message": "添加失败！请重试！",
    "code": 500
}
~~~



#### 获取某个类别下的所有商品

~~~url
POST /category/getGBC
~~~

~~~json
//附带参数
{
    "category": {
        "id": 0,
        "categoryName": "手机",
        "categoryID": "C0114"
    },
    "goodsList": [                  #这是个列表，参数含义和商品的一致
        {
            "id": 1,
            "goodsID": "G34092",
            "goodsName": "小米K30",
            "goodsCount": "20",
            "goodsPrice": 3999.99,
            "goodsDescribe": "前后柔光三摄， 瞅人更拽！",
            "goodsStatus": 1,
            "goodsUnit": "台",
            "categoryID": "C0114",
            "categoryName": "手机"
        }
    ]
}
~~~



#### 修改类别的名称

~~~Url
POST /category/updateName
~~~

~~~json
//附带参数
{
    "newName": "",
    "oldName": ""
}

//返回结果
{
    "result": true,
    "message": "已将【手机】修改为【手机】",
    "code": 200
}

{
    "result": false,
    "message": "重命名【手机】失败！",
    "code": 200
}	
~~~



## 品牌模块

<hr>

#### 获取所有的品牌

~~~url
POST /brand/getAll
~~~

~~~json
//附带参数
无

//返回数据
[               #这是一个列表
    {
        "id": 1,
        "brandName": "小米"
    }
]
~~~



#### 添加新的品牌

~~~url
POST /brand/addBrand
~~~

~~~json
//附带参数
{
    "brandName": "红米"
}

//返回结过
{
    "result": true,
    "message": "成功添加品牌：",
    "code": 200
}
//失败
{
    "result": false,
    "message": "成功添加品牌：",
    "code": 200
}

{
    "result": false,
    "message": "品牌名不能为空！",
    "code": 500
}
~~~



#### 修改某个品牌的Name

~~~url
POST /brand/updateName
~~~

~~~json
//附带参数
{
    "newName": "红米",
    "oldName": "黑米"
}

//返回结果
{
    "result": true,
    "message": "已将品牌【黑米】修改为【红米】",
    "code": 200
}

{
    "result": false,
    "message": "重命名【黑米】失败！",
    "code": 200
}
~~~



#### 获取某品牌下的所有商品

~~~url
POST /brand/getGBB
~~~

~~~json
//附带参数
{
    "brandName": "小米"
}

//返回结果
{
    "brand": {
        "brandName": "小米"
    },
    "goodsList": [      #还是列表呀姐妹！
        {
            "id": 1,
            "goodsID": "G34092",
            "goodsName": "小米K30",
            "goodsCount": "20",
            "goodsPrice": 3999.99,
            "goodsDescribe": "前后柔光三摄， 瞅人更拽！",
            "goodsStatus": 1,
            "goodsUnit": "台"
        }
    ]
}
~~~



## 订单模块

<hr>

#### 订单的五种状态码:

​	**3：待确认**

​	**2：配送中**

​	**1：订单已完成**

​	**0：订单已关闭**

​	**-1：退货受理中**

​	**-2：退货处理完毕**

#### 分页获取订单

~~~URL
POST /order/getAll
~~~

~~~json
//附带参数
{
    "targetPage": 1
}

//返回数据
{
    "targetPage": 0,        
    "totalPage": 0,
    "totalCount": 0,
    "limit": 10,
    "entryList": [
        {
            "id": 0,
            "orderID": null,
            "userID": null,
            "createTime": null,
            "orderStatus": 0
        }
    ]
}
~~~



#### 发起购买

~~~URL
POST /order/addOrder
~~~

~~~json
//附带参数
{
    "userID": "GR72159178",    #用户ID
    "goodsID": "G34092",       #货物ID
    "count": 3				   #购买数量
}

//返回数据
{
    "result": true,           
    "message": "购买成功！",
    "code": 200
}
~~~



#### 修改订单状态

~~~URL
POST /order/updateStatus
~~~

~~~json
//附带参数
{
    "orderID": "20201013201454",      #订单ID
    "orderStatus": 2                  #新的状态值
}

//返回数据
{
    "result": true,
    "message": "订单状态已修改！",
    "code": 200
}

{
    "result": false,
    "message": "更新订单状态失败！",
    "code": 200
}
~~~

#### 

#### 按条件查询

~~~URL
POST /order/search
~~~

~~~json
//附带参数
{
    "orderID": "20201013201454",   #订单ID
    "orderStatus": 2,     #订单状态
    "userID": "",         #订单发起人ID
    "createTime": null,   #创建时间      此以上四项为可选项，此查询为精确查询，0个表示查询全部
    "targetPage": 1       #目标页      此项必须要有
}

//返回数据
{
    "targetPage": 0,
    "totalPage": 0,
    "totalCount": 0,
    "limit": 10,
    "entryList": [
        {
            "id": 1,
            "orderID": "20201013201454",
            "userID": "GR72159178",
            "createTime": 1602562529000,
            "orderStatus": 2
        }
    ]
}
~~~



#### 分页获取订单

~~~URL
POST /order/getDetail
~~~

~~~json
//附带参数
{
    "orderID": "20201013201454"
}

//返回数据
{
    "order": {
        "id": 1,
        "orderID": "20201013201454",
        "userID": "GR72159178",
        "createTime": 1602562529000,
        "orderStatus": 2
    },
    "goodsList": [
        {
            "goodsID": "G34092",
            "goodsName": "小米K30",
            "goodsPrice": 3999.99,
            "goodsDescribe": "前后柔光三摄， 瞅人更拽！",          
            "goodsUnit": "台",
            "referToBrand": "小米",
            "count": 3                 #该商品的购买数量
        }
    ]
}
~~~