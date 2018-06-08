# exchange 接口文档

> 常规Ajax接口

1.注册
http://127.0.0.1:8080/exchange/register?mobile=15908450002&mcode=1234&password=a123456&cfmpwd=a123456  手机注册
http://127.0.0.1:8080/exchange/register?email=15908450002@163.com&ecode=1234&password=a123456&cfmpwd=a123456  邮箱注册
mcode为手机验证码   ecode为邮箱验证码
{
  "status": 0,
  "dataWrapper": {
    "userid": "25"
  },
  "msg": "注册成功",
  "success": true,
  "sourceUrl": null
}

2.登录
http://localhost:8080/exchange/login?username=15908401995&password=a123456			手机登录
http://localhost:8080/exchange/login?username=15908401995@163.com&password=a123456	邮箱登录
登录验证为 登录密码+谷歌验证器 返回结果
{
  "status": 0,
  "dataWrapper": {
    "oauth": 1
  },
  "msg": "谷歌二次验证",
  "success": true,
  "sourceUrl": null
}

登录验证为 登录密码 返回结果：
{																							
  "status": 0,																
  "dataWrapper": {
    "paysecurity": true,
    "policyList": [																	
      {
        "id": 1,
        "userId": 1,															
        "securityId": "1",												
        "showText": "密码登录",										
        "validationMode": "login",										
        "isEnabled": "1"															
      },														
      {
        "id": 3,
        "userId": 1,
        "securityId": "6",
        "showText": "不需要资金密码",
        "validationMode": "trade",
        "isEnabled": "1"
      },
      {
        "id": 6,
        "userId": 1,
        "securityId": "2-4",
        "showText": "短信验证+资金密码验证",
        "validationMode": "draw",
        "isEnabled": "1"
      },
      {
        "id": 11,
        "userId": 1,
        "securityId": "2-3",
        "showText": "短信验证+谷歌验证",
        "validationMode": "security",
        "isEnabled": "1"
      }
    ],
    "customerInfo": {
      "id": 1,
      "mobile": "15908401995",
      "email": "15908401995@163.com",
      "birthday": null,
      "userName": "lucky",
      "realName": "小明",
      "customerType": "s",
      "payPassword": "f7c7188ca8bb16aee74a422f40336c39",
      "password": null,
      "isAuth": "1",
      "authType": "C2",
      "idcard": "510921187654321082",
      "googleIdentifier": "BEYWKU7VRGKSPKIK",
      "activated": "1",
      "customerLevel": null,
      "validationMobile": "1",
      "validationEmail": "1",
      "validationGoogle": "1",
      "registerTime": null
    },
	"_token": "Phhdgzjt/iw=",
    "oauth": 0
  },
  "msg": "登录成功",
  "success": true,
  "sourceUrl": null
}

 _token:安全校验码


  
客户登录（谷歌二次验证）
http://localhost:8080/exchange/oauth?username=15908450002&token=794702
	token 谷歌验证码
{
  "status": 0,
  "dataWrapper": {
    "paysecurity": true,
    "policyList": [
      {
        "ip": null,
        "id": 2,
        "userId": 5000,
        "securityId": "1-3",
        "showText": "密码验证+谷歌验证",
        "validationMode": "login",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 3,
        "userId": 5000,
        "securityId": "6",
        "showText": "不需要资金密码",
        "validationMode": "trade",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 6,
        "userId": 5000,
        "securityId": "2-4",
        "showText": "短信验证+资金密码验证",
        "validationMode": "draw",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 11,
        "userId": 5000,
        "securityId": "2-3",
        "showText": "短信验证+谷歌验证",
        "validationMode": "security",
        "isEnabled": "1"
      }
    ],
    "customerInfo": {
      "ip": null,
      "id": 5000,
      "mobile": "15908450002",
      "email": "454545215@qq.com",
      "birthday": null,
      "userName": null,
      "realName": "李小华",
      "customerType": "s",
      "payPassword": "14e1b600b1fd579f47433b88e8d85291",
      "password": null,
      "isAuth": "1",
      "authType": "C2",
      "idcard": "510921199204080318",
      "googleIdentifier": "BEYWKU7VRGKSPKIK",
      "activated": "1",
      "customerLevel": null,
      "validationMobile": "1",
      "validationEmail": "1",
      "validationGoogle": "1",
      "registerTime": null
    },
    "_token": "Phhdgzjt/iw="
  },
  "msg": "谷歌校验成功",
  "success": true,
  "sourceUrl": null
}



3.忘记密码
------------step1
http://localhost:8080/exchange/findPwdOne?username=15908450002@163.com		//通过邮箱

{
  "status": 0,
  "dataWrapper": {
    "isAuth": null,
    "findUserName": "15908450002@163.com",
    "type": "email"
  },
  "msg": "获取用户成功",
  "success": true,
  "sourceUrl": null
}

http://localhost:8080/exchange/findPwdOne?username=15908450002	//通过手机

{
  "status": 0,
  "dataWrapper": {
    "isAuth": null,
    "findUserName": "15908450002",
    "type": "mobile"
  },
  "msg": "获取用户成功",
  "success": true,
  "sourceUrl": null
}
------------step2
http://localost:8080/exchange/?email=15908450002@163.com&ecode=1234   没有实名认证的用户(通过邮箱)
http://localost:8080/exchange/?mobile=15908450002&mcode=1234		  没有实名认证的用户(通过手机)
http://localost:8080/exchange/?mobile=15908401995&mcode=1234&idcode=510921187654321082   实名认证的用户
idcode:身份证号码    用户是邮箱还是手机进行找回,需要改变参数名称（类型第一步有返回type）
{
  "status": 0,
  "dataWrapper": {
    "userid": 26
  },
  "msg": "验证成功！",
  "success": true,
  "sourceUrl": null
}
------------step3
http://localhost:8080/exchange/findPwdThree?userid=26&password=a1234567&cfmpwd=a1234567			//重置密码
		userid:第二步返回值
{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "重置密码成功",
  "success": true,
  "sourceUrl": null
}


4.获取登录会员安全级别(GET)
http://localhost:8080/exchange/account/auth?_token=Phhdgzjt/iw=

_token：安全码

{
  "status": 0,
  "dataWrapper": {
    "isAuth": "1",
    "validationMobile": "1",
    "validationGoogle": "1",
    "validationEmail": "1"
  },
  "msg": "登录用户安全",
  "success": true,
  "sourceUrl": null
}

1:代表是    0：代表否

isAuth : 是否实名认证
validationMobile：是否绑定手机
validationGoogle：是否绑定谷歌验证器
validationEmail:是否绑定邮箱

5.用户注销(GET)
http://localhost:8080/exchange/loginOut

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "登出成功",
  "success": true,
  "sourceUrl": null
}

6.修改昵称

http://localhost:8080/exchange/customerInfo/changeInfo?_token=Phhdgzjt/iw=

_token 安全码

{
  "status": 0,
  "dataWrapper": {
    "nickname": "TOM"
  },
  "msg": "修改用户信息成功",
  "success": true,
  "sourceUrl": null
}
一、个人中心
1.邮箱绑定
http://localhost:8080/exchange/account/bind?email=454545215@qq.com&ecode=1234&type=ebind&_token=Phhdgzjt/iw=

_token 安全码

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "绑定邮箱完成",
  "success": true,
  "sourceUrl": null
}

2.手机绑定
发验证码（新手机号）：/sendVCode?userid=1232&mobile=18611628888&type=mbind&_token=Phhdgzjt/iw=
http://localhost:8080/exchange/account/bind?mobile=15908401111&mcode=1234&type=mbind&_token=Phhdgzjt/iw=

mcode 短信验证码  type 验证码类型

绑定手机完成 重新获取用户信息
{
  "status": 0,
  "dataWrapper": {
    "paysecurity": false,
    "policyList": [
      {
        "ip": null,
        "id": 148,
        "userId": 22,
        "securityId": "1",
        "showText": "密码登录",
        "validationMode": "login",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 150,
        "userId": 22,
        "securityId": "6",
        "showText": "不需要资金密码",
        "validationMode": "trade",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 156,
        "userId": 22,
        "securityId": "2",
        "showText": "短信验证",
        "validationMode": "security",
        "isEnabled": "1"
      }
    ],
    "customerInfo": {
      "ip": null,
      "id": 22,
      "mobile": "15908401111",
      "email": "15908450000@163.com",
      "birthday": null,
      "userName": null,
      "realName": null,
      "customerType": "s",
      "payPassword": null,
      "password": null,
      "isAuth": "0",
      "authType": null,
      "idcard": null,
      "googleIdentifier": null,
      "activated": "1",
      "customerLevel": null,
      "validationMobile": "1",
      "validationEmail": "1",
      "validationGoogle": "0",
      "registerTime": null
    }
  },
  "msg": "绑定手机完成",
  "success": true,
  "sourceUrl": null
}

3.实名认证
文件上传
http://localhost:8080/exchange/fileUpload/loadFile?type=P&_token=Phhdgzjt/iw=
http://localhost:8080/exchange/account/identify?realname=某某某&type=idcard&code=510921199504080318&_token=Phhdgzjt/iw=&photoHand=E:/images&photoFront=E:images&photoBack=E:/iamges

photoHand 手持照
photoFront 正面照
photoBack 背面照
_token 安全码

上传成功结果
{
  "status": 0,
  "dataWrapper": {
    "fileName": "3bb49731-f9dc-46ad-b7bd-b1cc72b6ca8c.jpg",
    "filePathName": "F:/images/2017/09/3bb49731-f9dc-46ad-b7bd-b1cc72b6ca8c.jpg",
    "type": "P"
  },
  "msg": "上传成功",
  "success": true,
  "sourceUrl": null
}

type为idcard （身份证认证）

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "会员实名认证成功",
  "success": true,
  "sourceUrl": null
}


4.资金密码设置(#代表注释)
http://localhost:8080/exchange/account/resetasset?password=a123456&cfmpwd=a123456&mcode=1234&type=mcode&_token=Phhdgzjt/iw=

#http://localhost:8080/exchange/account/resetasset?password=a123456&cfmpwd=a123456&mcode=1234&type=mcode&_token=Phhdgzjt/iw=    //设置验证策略为短信
#http://localhost:8080/exchange/account/resetasset?password=a123456&cfmpwd=a123456&token=1231&_token=Phhdgzjt/iw=			   //设置验证策略为谷歌
#http://localhost:8080/exchange/account/resetasset?password=a123456&cfmpwd=a123456&mcode=1234&type=mcode&token=1215&_token=Phhdgzjt/iw=  //设置验证策略为短信+谷歌

	token  谷歌验证码    mcode 短信验证码

{
  "status": 0,
  "dataWrapper": {
    "paysecurity": true,
    "policyList": [
      {
        "ip": null,
        "id": 23,
        "userId": 4,
        "securityId": "1",
        "showText": "密码登录",
        "validationMode": "login",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 25,
        "userId": 4,
        "securityId": "6",
        "showText": "不需要资金密码",
        "validationMode": "trade",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 28,
        "userId": 4,
        "securityId": "2-4",
        "showText": "短信验证+资金密码验证",
        "validationMode": "draw",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 31,
        "userId": 4,
        "securityId": "2",
        "showText": "短信验证",
        "validationMode": "security",
        "isEnabled": "1"
      }
    ],
    "customerInfo": {
      "ip": null,
      "id": 4,
      "mobile": "15908401997",
      "email": null,
      "birthday": null,
      "userName": null,
      "realName": null,
      "customerType": "s",
      "payPassword": "d477887b0636e5d87f79cc25c99d7dc9",
      "password": null,
      "isAuth": "0",
      "authType": null,
      "idcard": null,
      "googleIdentifier": null,
      "activated": "1",
      "customerLevel": null,
      "validationMobile": "1",
      "validationEmail": "0",
      "validationGoogle": "0",
      "registerTime": null
    }
  },
  "msg": "资金密码设置完成",
  "success": true,
  "sourceUrl": null
}

5.资金密码修改(#代表注释)
http://localhost:8080/exchange/account/resetasset?oldpassword=a123456&password=a1234567&cfmpwd=a1234567&mcode=1234&type=mcode&_token=Phhdgzjt/iw=

#http://localhost:8080/exchange/account/resetasset?oldpassword=a123456&password=a1234567&cfmpwd=a1234567&mcode=1234&type=mcode&_token=Phhdgzjt/iw=	    //设置验证策略为短信
#http://localhost:8080/exchange/account/resetasset?oldpassword=a123456&password=a1234567&cfmpwd=a1234567&token=1234&_token=Phhdgzjt/iw=			//设置验证策略为谷歌
#http://localhost:8080/exchange/account/resetasset?oldpassword=a123456&password=a1234567&cfmpwd=a1234567&token=1234&mcode=1234&type=mcode&_token=Phhdgzjt/iw= //设置验证策略为短信+谷歌

token  谷歌验证码    mcode 短信验证码

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "资金密码设置完成",
  "success": true,
  "sourceUrl": null
}

6.谷歌验证器绑定
发送验证码：/sendVCode?userid=1232&type=gbind&_token=Phhdgzjt/iw=
http://localhost:8080/exchange/account/gbind?secretKey=BEYWKU7VRGKSPKIK&mcode=1234&token=196533&_token=Phhdgzjt/iw=

secretKey : 谷歌验证器密匙  mcode:短信验证码  token:谷歌验证码

{
  "status": 0,
  "dataWrapper": {
    "paysecurity": true,
    "policyList": [
      {
        "ip": null,
        "id": 2,
        "userId": 5000,
        "securityId": "1-3",
        "showText": "密码验证+谷歌验证",
        "validationMode": "login",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 3,
        "userId": 5000,
        "securityId": "6",
        "showText": "不需要资金密码",
        "validationMode": "trade",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 6,
        "userId": 5000,
        "securityId": "2-4",
        "showText": "短信验证+资金密码验证",
        "validationMode": "draw",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 11,
        "userId": 5000,
        "securityId": "2-3",
        "showText": "短信验证+谷歌验证",
        "validationMode": "security",
        "isEnabled": "1"
      }
    ],
    "customerInfo": {
      "ip": null,
      "id": 5000,
      "mobile": "15908450002",
      "email": "454545215@qq.com",
      "birthday": null,
      "userName": null,
      "realName": "李小华",
      "customerType": "s",
      "payPassword": "14e1b600b1fd579f47433b88e8d85291",
      "password": null,
      "isAuth": "1",
      "authType": "C2",
      "idcard": "510921199204080318",
      "googleIdentifier": "BEYWKU7VRGKSPKIK",
      "activated": "1",
      "customerLevel": null,
      "validationMobile": "1",
      "validationEmail": "1",
      "validationGoogle": "1",
      "registerTime": null
    }
  },
  "msg": "绑定谷歌验证器完成",
  "success": true,
  "sourceUrl": null
}

7.谷歌去关闭
http://localhost:8080/exchange/account/gclose?_token=Phhdgzjt/iw=&mcode=1234

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "关闭成功！",
  "success": true,
  "sourceUrl": null
}


7.谷歌验证器修改
发送手机验证码：/sendVCode?userid=1232&type=gbind&_token=Phhdgzjt/iw=
http://localhost:8080/exchange/account/chgbind?mcode=1234&token=131825&secretKey=3GWUTDRB2FUILJTD&_token=Phhdgzjt/iw=

mcode：短信验证码 token:谷歌验证码 secretKey:谷歌密匙

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "修改谷歌验证器成功！",
  "success": true,
  "sourceUrl": null
}

8.修改登录密码

http://localhost:8080/exchange/account/changepwd?oldpwd=a123456&password=a1234567&cfmpwd=a1234567&_token=Phhdgzjt/iw=

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "密码重置完成",
  "success": true,
  "sourceUrl": null
}

9.修改手机号码
发验证码（原手机号）：/sendVCode?userid=1232&type=change&_token=Phhdgzjt/iw=
发验证码（新手机号）：/sendVCode?userid=1232&mobile=18611628888&type=newmobile2&_token=Phhdgzjt/iw=
http://localhost:8080/exchange/account/changemobile?ocode=1234&mobile=15908401995&mcode=1234&type=change&token=384094&_token=Phhdgzjt/iw=		//设置验证策略为  谷歌验证 或 短信+谷歌验证
http://localhost:8080/exchange/account/changemobile?ocode=1234&mobile=15908401995&mcode=1234&type=change&_token=Phhdgzjt/iw=					//设置验证策略为  短信验证

ocode:旧手机验证码  mobile:新绑定手机  mcode=新手机验证码 token:谷歌验证器


{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "修改绑定手机完成",
  "success": true,
  "sourceUrl": null
}

10.安全策略设置（）

1).修改登录验证策略
http://localhost:8080/exchange/account/setstrategy?validmode=login&policyid=1-3

#http://localhost:8080/exchange/account/setstrategy?validmode=login&policyid=1-3&mcode=1234&token=634772&_token=Phhdgzjt/iw=   	设置验证策略为  谷歌验证+密码验证
#http://localhost:8080/exchange/account/setstrategy?validmode=login&policyid=1&mcode=1234&_token=Phhdgzjt/iw=					设置验证策略为  密码验证

2).修改交易验证策略
http://localhost:8080/exchange/account/setstrategy?validmode=trade&policyid=4

#http://localhost:8080/exchange/account/setstrategy?validmode=trade&policyid=4&mcode=1234&token=457357&_token=Phhdgzjt/iw=		设置验证策略为  资金密码
#http://localhost:8080/exchange/account/setstrategy?validmode=trade&policyid=5&mcode=1234&_token=Phhdgzjt/iw=					设置验证策略为  6小时验证一次密码
#http://localhost:8080/exchange/account/setstrategy?validmode=trade&policyid=6&token=458621&_token=Phhdgzjt/iw=					设置验证策略为  不需要资金密码

3).修改提现验证策略
http://localhost:8080/exchange/account/setstrategy?validmode=draw&policyid=2-3-4

#http://localhost:8080/exchange/account/setstrategy?validmode=draw&policyid=2-3-4&mcode=1234&token=743816&_token=Phhdgzjt/iw=		设置验证策略为  谷歌验证+短信验证+资金密码
#http://localhost:8080/exchange/account/setstrategy?validmode=draw&policyid=2-4&mcode=1234&_token=Phhdgzjt/iw=					设置验证策略为  资金密码+短信验证
#http://localhost:8080/exchange/account/setstrategy?validmode=draw&policyid=3-4&token=145685&_token=Phhdgzjt/iw=					设置验证策略为  资金密码+谷歌验证码

#4).修改设置验证策略
#http://localhost:8080/exchange/account/setstrategy?validmode=security&policyid=2-3&mcode=1234&token=148996&_token=Phhdgzjt/iw=	设置验证策略为  谷歌验证+短信验证
#http://localhost:8080/exchange/account/setstrategy?validmode=security&policyid=2&mcode=1234&_token=Phhdgzjt/iw=					设置验证策略为  短信验证
#http://localhost:8080/exchange/account/setstrategy?validmode=security&policyid=3&token=123487&_token=Phhdgzjt/iw=			    设置验证策略为  谷歌


validmode: 策略类型
policyid: 验证方式
token:谷歌验证码
mcode:短信验证码

{
  "status": 0,
  "dataWrapper": {
    "paysecurity": true,
    "policyList": [
      {
        "ip": null,
        "id": 1,
        "userId": 5000,
        "securityId": "1",              //策略ID
        "showText": "密码登录",         
        "validationMode": "login",      //策略类型
        "isEnabled": "1"                //是否使用
      },
      {
        "ip": null,
        "id": 4,
        "userId": 5000,
        "securityId": "5",
        "showText": "每6小时验证资金密码",
        "validationMode": "trade",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 7,
        "userId": 5000,
        "securityId": "3-4",
        "showText": "谷歌验证+资金密码验证",
        "validationMode": "draw",
        "isEnabled": "1"
      },
      {
        "ip": null,
        "id": 9,
        "userId": 5000,
        "securityId": "2",
        "showText": "短信验证",
        "validationMode": "security",
        "isEnabled": "1"
      }
    ],
    "customerInfo": {
      "ip": null,
      "id": 5000,
      "mobile": "15908450002",
      "email": "454545215@qq.com",
      "birthday": null,
      "userName": null,
      "realName": "李小华",
      "customerType": "s",
      "payPassword": "14e1b600b1fd579f47433b88e8d85291",
      "password": null,
      "isAuth": "1",
      "authType": "C2",
      "idcard": "510921199204080318",
      "googleIdentifier": "3GWUTDRB2FUILJTD",
      "activated": "1",
      "customerLevel": null,
      "validationMobile": "1",
      "validationEmail": "1",
      "validationGoogle": "1",
      "registerTime": null
    }
  },
  "msg": "策略设置完成",
  "success": true,
  "sourceUrl": null
}

11人民币现货(获取用户账户信息) --下拉页资产预览

http://localhost:8080/exchange/customerAsset/cnyAccount?_token=Phhdgzjt/iw=

{
  "status": 0,
  "dataWrapper": {
    "account": {
      "all_freeze": 0.00,
      "all_cny": 0.00,
      "all_usable": 0.00
    }
  },
  "msg": "账户获取成功",
  "success": true,
  "sourceUrl": null
}

三、资产管理

1.账户充值申请
http://localhost:8080/exchange/depositOrder/deposit?depositType=online&account=1598565144@qq.com&userName=TOM&assetAmt=2000&assetCode=btc

depositType:充值方式
account:充值账号
assetAmt:充值金额
assetCode:资产编码

{
  "status": 0,
  "dataWrapper": {
    "mark": "6308"
  },
  "msg": "充值订单已提交",
  "success": true,
  "sourceUrl": null
}

2.银行卡添加

http://localhost:8080/exchange/bankInfo/add?bankName=招商&branchName=分行&bankAccount=2103456812358888&cardHolderName=李小华&idNumber=510921199204080318&cardHolderMobile=15908401995&isDefault=0&bankProvince=云南&bankCity=昆明&isAuth=1


{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "添加银行卡成功",
  "success": true,
  "sourceUrl": null
}

3.设为默认银行卡

http://localhost:8080/exchange/bankInfo/default?id=1

id：银行卡id;

{
  "status": -1,
  "dataWrapper": {

  },
  "msg": "此账户已是默认账户",
  "success": false,
  "sourceUrl": null
}

4.删除银行卡

http://localhost:8080/exchange/bankInfo/delete

id:银行卡id

{
  "status": -1,
  "dataWrapper": {

  },
  "msg": "此账户已是默认账户",
  "success": false,
  "sourceUrl": null
}

5.获取用户银行卡列表（分页）

http://localhost:8080/exchange/bankInfo/getBankInfoByPage

可选参数：pageSize  pageNo

{
  "status": 0,
  "dataWrapper": {
    "list": {
      "page": {
        "pageSize": 20,
        "pageNo": 1,
        "sortName": null,
        "sortDirect": null,
        "start": 0,
        "startIndex": 0
      },
      "resultList": [
        {
          "ip": null,
          "id": 1,
          "userId": 5000,
          "bankName": "招商",
          "branchName": "招商",
          "bankAccount": "2103456812358888",
          "cardHolderName": "李小华",
          "idNumber": "510921199204080318",
          "cardHolderMobile": "15908401995",
          "isDefault": "1",
          "isAuth": "1",
          "remark": null,
          "bankProvince": "云南",
          "bankCity": "昆明"
        }
      ],
      "hasNext": false,
      "totalCount": 0,
      "totalPages": 0
    }
  },
  "msg": "查询完成",
  "success": true,
  "sourceUrl": null
}


6.创建提现订单(账户提现,人民币或btc)

http://localhost:8080/exchange/drawOrder/createDrawOrder?account=6210555522222222&drawType=figit&assetCode=btc&amount=2&walletFee=0.5&bankName=zhaoshang&payPwd=123456&token=765164&_token=Phhdgzjt/iw=  			提现验证策略为  资金密码+谷歌验证
http://localhost:8080/exchange/drawOrder/createDrawOrder?account=6210555522222222&drawType=figit&assetCode=btc&amount=2&walletFee=0.5&bankName=zhaoshang&payPwd=123456&mcode=1234&_token=Phhdgzjt/iw=   		 	提现验证策略为  资金密码+短信验证
http://localhost:8080/exchange/drawOrder/createDrawOrder?account=6210555522222222&drawType=figit&assetCode=btc&amount=2&walletFee=0.5&bankName=zhaoshang&payPwd=123456&mcode=1234&token=456213&_token=Phhdgzjt/iw=  提现验证策略为  资金密码+谷歌验证+短信验证

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "创建提现订单成功",
  "success": true,
  "sourceUrl": null
}

分页查询提现记录(以assetCode区分)

http://localhost:8080/drawOrder/drawOrderRecord?assetCode=btc

{
  "status": 0,
  "dataWrapper": {
    "list": {
      "page": {
        "pageSize": 20,
        "pageNo": 1,
        "sortName": null,
        "sortDirect": null,
        "start": 0,
        "startIndex": 0
      },
      "resultList": [
        {
          "ip": null,
          "id": 1,
          "userId": 5001,
          "assetId": 1,
          "assetCode": "btc",
          "amount": 1,
          "walletAddress": null,
          "walletFee": 0,
          "bankName": "招商",
          "branchName": "分行",
          "bankProvince": null,
          "bankCity": null,
          "status": "0",
          "approveStatus": "1",
          "failureReason": null,
          "mark": null,
          "fstApprove": null,
          "secApprove": null,
          "trdApprove": null,
          "forApprove": null,
          "fifApprove": null
        }
      ],
      "hasNext": false,
      "totalCount": 1,
      "totalPages": 1
    }
  },
  "msg": "查询完成",
  "success": true,
  "sourceUrl": null
}

7.账单明细-分页
http://localhost:8080/exchange/userAssetRecord/historyList&type=all&assetCode=btc&_token=Phhdgzjt/iw=

type: all(全部),recharge(充币),drawals(提币),activity(活动)
assetCode:  币种

可选参数：pageSize pageNo startTime endTime

{
  "status": 0,
  "dataWrapper": {
    "list": {
      "page": {
        "pageSize": 20,
        "pageNo": 1,
        "sortName": null,
        "sortDirect": null,
        "start": 0,
        "startIndex": 0
      },
      "resultList": [

      ],
      "hasNext": false,
      "totalCount": 0,
      "totalPages": 0
    }
  },
  "msg": "查询完成",
  "success": true,
  "sourceUrl": null
}

获取充值钱包地址（根据assetCode区分）
http://localhost:8080/walletInfo/getByType?assetCode = btc

{
  "status": 0,
  "dataWrapper": {
    "walletInfos": [
      {
        "deleted": false,
        "createTime": "2017-09-28 18:01:01",
        "createUser": null,
        "updateTime": "2017-09-28 18:01:01",
        "updateUser": null,
        "id": 4,
        "userid": "5001",
        "digitAssetId": 2,
        "walletType": "drawals",
        "digitAssetAddress": "f4ad4ds4b4cx4n44g5f56v8b7",
        "assetCode": "btc",
        "remark": null,
        "deleted" : "0",
        "isCertification": null,
        "isDefault": null,
        "ip":null
      }
    ]
  },
  "msg": "",
  "success": true,
  "sourceUrl": null
}

添加提币钱包地址（数字资产账户）
http://localhost:8080/walletInfo/add?assetCode=btc&walletType=drawals&digitAssetAddress=f4ad4ds4b4cx4n44g5f56v8b7&payPassword=a123456


walletType=drawals(此参数固定)

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "添加成功",
  "success": true,
  "sourceUrl": null
}


分页查询提现钱包地址(以assetCode区分各币种)
http://localhost:8080/walletInfo/getWalletInfoPageList?assetCode=btc

{
  "status": 0,
  "dataWrapper": {
    "list": {
      "page": {
        "pageSize": 20,
        "pageNo": 1,
        "sortName": null,
        "sortDirect": null,
        "start": 0,
        "startIndex": 0
      },
      "resultList": [
        {
          "id": 4,
          "userId": 5001,
          "digitAssetId": 2,
          "walletType": null,
          "digitAssetAddress": "f4ad4ds4b4cx4n44g5f56v8b7",
          "assetCode": null,
          "isDefault": null,
          "isCertification": null,
          "remark": null
        }
      ],
      "hasNext": false,
      "totalCount": 0,
      "totalPages": 0
    }
  },
  "msg": "查询完成",
  "success": true,
  "sourceUrl": null
}

删除提币钱包地址(数字资产账户)
http://localhost:8080/walletInfo/delete?id=1

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "删除成功",
  "success": true,
  "sourceUrl": null
}


获取充值记录列表 根据 assetCode 区分 btc eth  cny

http://localhost:8080/depositOrder/depositRecord?assetCode=btc

可选参数 pageSize pageNo

{
  "status": 0,
  "dataWrapper": {
    "list": {
      "page": {
        "pageSize": 20,
        "pageNo": 1,
        "sortName": null,
        "sortDirect": null,
        "start": 0,
        "startIndex": 0
      },
      "resultList": [
        {
          "ip": null,
          "id": 1,
          "userId": 5001,
          "depositType": "bankCard",
          "account": "6211111122254562",
          "mark": "4290",
          "userName": null,
          "assetId": 2,
          "assetCode": "btc",
          "assetAmt": 200,
          "realAmt": null,
          "depositStatus": "0",
          "approveStatus": "0",
          "failureReason": null,
          "fstApprove": null,
          "secApprove": null,
          "mobile": null
        }
      ],
      "hasNext": false,
      "totalCount": 1,
      "totalPages": 1
    }
  },
  "msg": "查询完成",
  "success": true,
  "sourceUrl": null
}


订单：
1.通过订单id查询订单接口

http://localhost:8080/exchange/order/getOrderById?id=1&category=btc_cny

{
  "status": 0,
  "dataWrapper": {
    "order": {
      "deleted": "0",
      "createTime": "2017-09-19 15:01:32",
      "createUser": null,
      "updateTime": "2017-09-19 15:01:32",
      "updateUser": null,
      "ip": null,
      "id": null,
      "userid": null,
      "price": null,
      "amount": null,
      "freezeAmt": null,
      "remainFreezeAmt": null,
      "orderTime": null,
      "orderStatus": null,
      "tradeType": null,
      "avgPrice": null,
      "realAmount": null,
      "isJumpQueue": null,
      "transList": [
        {
          "ip": null,
          "id": 1,
          "userId": 5000,
          "orderId": 1,
          "sellOrderId": 1,
          "buyOrderId": 1,
          "sellUserId": 5000,
          "buyUserId": 5000,
          "transactionTime": null,
          "transactionType": "exchange",
          "transactionPrice": 200,
          "transactionAmount": 2,
          "showTransactionTime": 1505804988815
        }
      ],
      "spotOrderTime": null,
      "surplusAmount": null,
      "makeMarket": 0,
      "stopLessTriggerPrice": null,
      "stopSuccessTriggerPrice": null,
      "stopLessOrderPrice": null,
      "stopSuccessOrderPrice": null,
      "triggerPrice": null,
      "currentPage": 0,
      "pageTotal": 0
    }
  },
  "msg": "订单获取成功",
  "success": true,
  "sourceUrl": null
}

2.内部 通过订单id获取订单

http://localhost:8080/exchange/order/findOrderById?id=1&category=btc_cny

{
  "status": 0,
  "dataWrapper": {
    "order": {
      "avgPrice": null,
      "dealAmount": null,
      "type": null,
      "status": null
    }
  },
  "msg": "订单获取成功",
  "success": true,
  "sourceUrl": null
}

3.通过订单id查询订单未成交冻结金额(数量)接口

http://localhost:8080/exchange/order/getFreezeAmtById?id=1&category=btc_cny

{
  "status": 0,
  "dataWrapper": {
    "order": {
      "remainFreezeAmt": null,
      "tradeType": null
    }
  },
  "msg": "订单获取成功",
  "success": true,
  "sourceUrl": null
}

4.内部挂单接口

http://localhost:8080/exchange/order/inorder?amount=123&price=1&quantity=2&type=buy_market&category=btc_cny&time=2017-9-19&_token=Phhdgzjt/iw=

{
  "status": 0,
  "dataWrapper": {
    "order": {
      "deleted": "0",
      "createTime": null,
      "createUser": "5000",
      "updateTime": null,
      "updateUser": "5000",
      "ip": null,
      "id": 2,
      "userid": 5000,
      "price": 123,
      "amount": 123.00,
      "freezeAmt": 123.00,
      "remainFreezeAmt": 123.00,
      "orderTime": 1505806490191,
      "orderStatus": "0",
      "tradeType": "buy_market",
      "avgPrice": 0,
      "realAmount": 0,
      "isJumpQueue": "0",
      "transList": null,
      "spotOrderTime": null,
      "surplusAmount": null,
      "makeMarket": 2,
      "stopLessTriggerPrice": null,
      "stopSuccessTriggerPrice": null,
      "stopLessOrderPrice": null,
      "stopSuccessOrderPrice": null,
      "triggerPrice": null,
      "currentPage": 0,
      "pageTotal": 0
    }
  },
  "msg": "挂单完成",
  "success": true,
  "sourceUrl": null
}

5.交易所行情

http://localhost:8080/exchange/order/ticker?category=btc_cny

{
  "status": 0,
  "dataWrapper": {
    "result": {

    }
  },
  "msg": "行情获取成功",
  "success": true,
  "sourceUrl": null
}


6. 挂单接口

http://localhost:8080/exchange/order/createorder?category=btc_cny&price=20&quantity=1&type=buy&paypwd=123456&_token=Phhdgzjt/iw=   			type不为buy_market
http://localhost:8080/exchange/order/createorder?category=btc_cny&price=20&amount=2&type=buy_market&paypwd=123456&_token=Phhdgzjt/iw=		type为buy_market

type:  buy：买入   sell：卖出

资金密码根据交易验证策略判断是否输入

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "挂单完成",
  "success": true,
  "sourceUrl": null
}

7.撤单接口

http://localhost:8080/exchange/order/revokeorder?id=1&category=btc_cny&_token=Phhdgzjt/iw=

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "撤单请求成功！",
  "success": true,
  "sourceUrl": null
}

8.批量撤单接口

http://localhost:8080/exchange/order/revokeorder?ids=1,2&category=btc_cny&_token=Phhdgzjt/iw=

ids:订单ID，多个用逗号隔开

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "撤单请求成功！",
  "success": true,
  "sourceUrl": null
}

9.修改委托

http://localhost:8080/exchange/order/change?id=2&category=btc_cny&price=100&quantity=2&type=buy&paypwd=123456&_token=Phhdgzjt/iw=			type不为buy_market
http://localhost:8080/exchange/order/change?id=2&category=btc_cny&price=100&amount=3&type=buy_market&paypwd=123456&_token=Phhdgzjt/iw=		type为buy_market

{
  "status": 0,
  "dataWrapper": {

  },
  "msg": "挂单完成",
  "success": true,
  "sourceUrl": null
}

10.委托历史接口

http://localhost:8080/exchange/order/recordList?pageSize=5&pageNo=1&category=btc_cny&_token=Phhdgzjt/iw=


可选参数：pageSize  pageNo

{
  "status": 0,
  "dataWrapper": {
    "list": {
      "page": {
        "pageSize": 5,
        "pageNo": 1,
        "sortName": null,
        "sortDirect": null,
        "start": 0,
        "startIndex": 0
      },
      "resultList": [
        {
          "deleted": null,
          "createTime": null,
          "createUser": null,
          "updateTime": null,
          "updateUser": null,
          "ip": null,
          "id": 2,
          "userid": 5000,
          "price": 123,
          "amount": 123,
          "freezeAmt": 123,
          "remainFreezeAmt": 123,
          "orderTime": 1505806490191,
          "orderStatus": "2",
          "tradeType": "buy_market",
          "avgPrice": 0,
          "realAmount": 0,
          "isJumpQueue": "0",
          "transList": [

          ],
          "spotOrderTime": "2017-09-19 15:34:50",
          "surplusAmount": null,
          "makeMarket": 2,
          "stopLessTriggerPrice": null,
          "stopSuccessTriggerPrice": null,
          "stopLessOrderPrice": null,
          "stopSuccessOrderPrice": null,
          "triggerPrice": null,
          "currentPage": 0,
          "pageTotal": 0
        },
        {
          "deleted": null,
          "createTime": null,
          "createUser": null,
          "updateTime": null,
          "updateUser": null,
          "ip": null,
          "id": 1,
          "userid": 5000,
          "price": 200,
          "amount": 2,
          "freezeAmt": 100,
          "remainFreezeAmt": 1200,
          "orderTime": 1505806911927,
          "orderStatus": "2",
          "tradeType": "buy",
          "avgPrice": 200,
          "realAmount": 1,
          "isJumpQueue": "0",
          "transList": [
            {
              "ip": null,
              "id": 1,
              "userId": 5000,
              "orderId": 1,
              "sellOrderId": 1,
              "buyOrderId": 1,
              "sellUserId": 5000,
              "buyUserId": 5000,
              "transactionTime": null,
              "transactionType": "exchange",
              "transactionPrice": 200,
              "transactionAmount": 2,
              "showTransactionTime": 1505811998256
            }
          ],
          "spotOrderTime": "2017-09-19 15:41:51",
          "surplusAmount": null,
          "makeMarket": 0,
          "stopLessTriggerPrice": null,
          "stopSuccessTriggerPrice": null,
          "stopLessOrderPrice": null,
          "stopSuccessOrderPrice": null,
          "triggerPrice": null,
          "currentPage": 0,
          "pageTotal": 0
        }
      ],
      "hasNext": false,
      "totalCount": 2,
      "totalPages": 1
    }
  },
  "msg": "查询完成",
  "success": true,
  "sourceUrl": null
}

11.交易记录接口

http://localhost:8080/exchange/order/list?category=btc_cny&pageSize=5&pageNo=1&_token=Phhdgzjt/iw=

可选参数：pageSize  pageNo
{
  "status": 0,
  "dataWrapper": {
    "list": {
      "page": {
        "pageSize": 5,
        "pageNo": 1,
        "sortName": null,
        "sortDirect": null,
        "start": 0,
        "startIndex": 0
      },
      "resultList": [
        {
          "deleted": null,
          "createTime": null,
          "createUser": null,
          "updateTime": null,
          "updateUser": null,
          "ip": null,
          "id": 9,
          "userid": 5000,
          "price": 123,
          "amount": 3,
          "freezeAmt": 3,
          "remainFreezeAmt": 3,
          "orderTime": 1505810153421,
          "orderStatus": "0",
          "tradeType": "buy_market",
          "avgPrice": 0,
          "realAmount": 0,
          "isJumpQueue": "0",
          "transList": null,
          "spotOrderTime": "2017-09-19 16:35:53",
          "surplusAmount": 3,
          "makeMarket": 0,
          "stopLessTriggerPrice": null,
          "stopSuccessTriggerPrice": null,
          "stopLessOrderPrice": null,
          "stopSuccessOrderPrice": null,
          "triggerPrice": null,
          "currentPage": 0,
          "pageTotal": 0
        },
        {
          "deleted": null,
          "createTime": null,
          "createUser": null,
          "updateTime": null,
          "updateUser": null,
          "ip": null,
          "id": 8,
          "userid": 5000,
          "price": 100,
          "amount": 2,
          "freezeAmt": 200,
          "remainFreezeAmt": 200,
          "orderTime": 1505810128858,
          "orderStatus": "0",
          "tradeType": "buy",
          "avgPrice": 0,
          "realAmount": 0,
          "isJumpQueue": "0",
          "transList": null,
          "spotOrderTime": "2017-09-19 16:35:28",
          "surplusAmount": 2,
          "makeMarket": 0,
          "stopLessTriggerPrice": null,
          "stopSuccessTriggerPrice": null,
          "stopLessOrderPrice": null,
          "stopSuccessOrderPrice": null,
          "triggerPrice": null,
          "currentPage": 0,
          "pageTotal": 0
        },
        {
          "deleted": null,
          "createTime": null,
          "createUser": null,
          "updateTime": null,
          "updateUser": null,
          "ip": null,
          "id": 7,
          "userid": 5000,
          "price": 100,
          "amount": 2,
          "freezeAmt": 200,
          "remainFreezeAmt": 200,
          "orderTime": 1505809785186,
          "orderStatus": "0",
          "tradeType": "buy",
          "avgPrice": 0,
          "realAmount": 0,
          "isJumpQueue": "0",
          "transList": null,
          "spotOrderTime": "2017-09-19 16:29:45",
          "surplusAmount": 2,
          "makeMarket": 0,
          "stopLessTriggerPrice": null,
          "stopSuccessTriggerPrice": null,
          "stopLessOrderPrice": null,
          "stopSuccessOrderPrice": null,
          "triggerPrice": null,
          "currentPage": 0,
          "pageTotal": 0
        },
        {
          "deleted": null,
          "createTime": null,
          "createUser": null,
          "updateTime": null,
          "updateUser": null,
          "ip": null,
          "id": 6,
          "userid": 5000,
          "price": 123,
          "amount": 2,
          "freezeAmt": 2,
          "remainFreezeAmt": 2,
          "orderTime": 1505807469256,
          "orderStatus": "0",
          "tradeType": "buy_market",
          "avgPrice": 0,
          "realAmount": 0,
          "isJumpQueue": "0",
          "transList": null,
          "spotOrderTime": "2017-09-19 15:51:09",
          "surplusAmount": 2,
          "makeMarket": 0,
          "stopLessTriggerPrice": null,
          "stopSuccessTriggerPrice": null,
          "stopLessOrderPrice": null,
          "stopSuccessOrderPrice": null,
          "triggerPrice": null,
          "currentPage": 0,
          "pageTotal": 0
        },
        {
          "deleted": null,
          "createTime": null,
          "createUser": null,
          "updateTime": null,
          "updateUser": null,
          "ip": null,
          "id": 5,
          "userid": 5000,
          "price": 20,
          "amount": 1,
          "freezeAmt": 20,
          "remainFreezeAmt": 20,
          "orderTime": 1505807267998,
          "orderStatus": "0",
          "tradeType": "buy",
          "avgPrice": 0,
          "realAmount": 0,
          "isJumpQueue": "0",
          "transList": null,
          "spotOrderTime": "2017-09-19 15:47:47",
          "surplusAmount": 1,
          "makeMarket": 0,
          "stopLessTriggerPrice": null,
          "stopSuccessTriggerPrice": null,
          "stopLessOrderPrice": null,
          "stopSuccessOrderPrice": null,
          "triggerPrice": null,
          "currentPage": 0,
          "pageTotal": 0
        }
      ],
      "hasNext": true,
      "totalCount": 9,
      "totalPages": 2
    }
  },
  "msg": "获取成功",
  "success": true,
  "sourceUrl": null
}


#######20180514--------
1.可以资金划转的币种(场外交易币种)
URL:http://192.168.0.138:8000/buexSymbol
返回结果：
{
  "status": 0,
  "dataWrapper": {
    "symbol": [
      {
        "code": "BTC"
      },
      {
        "code": "ETH"
      }
    ]
  },
  "msg": "",
  "success": true,
  "sourceUrl": null
}

2.交易平台币种
URL:http://192.168.0.138:8000/exchangeSymbol
返回结果：
{
  "status": 0,
  "dataWrapper": {
    "symbol": [
      {
        "code": "BTC"
      },
      {
        "code": "ETH"
      }
    ]
  },
  "msg": "",
  "success": true,
  "sourceUrl": null
}

3.币币资金划转接口
URL:http://192.168.0.138:8000/customerAsset/assetTransfer?assetcode=btc&amount=5&type=1
assetcode 币种
amount 转移数量
type 0 币币划场外 1场外划币币
{
  "status": 0,
  "dataWrapper": {
    
  },
  "msg": "success",
  "success": true,
  "sourceUrl": null
}





## ws 接口文档

>webSocket接口

1.最新币价
发送channel: sub_s_btc_bss_latestprice    
参数变化：usdt_btc usdt_eth usdt_bss btc_eth btc_bss eth_btc eth_bss
返回结果：
{
  data: {
    lastprice: "9370.00"	最新价格
  },
  channel: "sub_s_usdt_btc_latestprice"
}

2.今日的交易信息
发送channel：sub_s_usdt_eth_dailydata		
参数变化：usdt_btc usdt_eth usdt_bss btc_eth btc_bss eth_btc eth_bss
返回结果：{
  "data": {
    "usdtPrice": "762.56",	美元价格
    "cnyPrice": "4799.93",	折合人名币价格
    "minPrice": 762.56,		今日最低
    "volumePrice": 0.0,		24小时成交量
    "changePercent": 0.0,	涨跌幅
    "closingPrice": 762.56, 收盘价格
    "maxPrice": 762.56,		今日最高
    "volumeQuantity": 0.0	24小时成交量
  },
  "channel": "sub_s_usdt_eth_dailydata"
}

3.用户资产信息
发送channel：sub_customer_asset,uuid=?
返回结果：
{
  "data": {
    "asset": [
      {
        "name": "btc",
        "useable": 20000.00000000,
        "freeze": 0
      },
      {
        "name": "eth",
        "useable": 20000.00000000,
        "freeze": 0
      },
      {
        "name": "bss",
        "useable": 20000.00000000,
        "freeze": 0
      },
      {
        "name": "usdt",
        "useable": 20000.00000000,
        "freeze": 0
      }
    ],
    "totalCny": 1276846477.19,
    "totalUsdt": 202674043.99,
    "totalBtc": 21630.10074702,
  },
  "channel": "sub_customer_asset"
}

4.K线图
发送channel：sub_s_eth_btc_allkline_mi15
参数变化：
	币种：usdt_btc usdt_eth usdt_bss btc_eth btc_bss eth_btc eth_bss
	时间：mi1 mi5 mi15 mi30 h1 d1 w1 -->1分钟 5分钟 15分钟 30 分钟 1小时 1天 1周
返回结果：
{
  "depth": null, //暂时没用  深度级别
  "data": {
    "depths": {
      "asks": [		//买单信息
        [
          12.141856220000, 数量
          0.099265920000	价格
        ],
      ],
      "bids": [		//卖单信息
        [
          15.408320490000,	数量
          0.367107480000	价格
        ],
        [
          15.375153750000,
          0.496738770000
        ],
    },
    "trades": [		//交易信息
      {
        "amount": 0.17419838,	数量
        "price": 12.22772076,	价格
        "time": 1525654405095,	时间
        "type": "sell",			交易类型：sell卖  buy 买
        "tid": null
      },
      {
        "time": 1525654474200,
        "tid": null,
        "price": 12.22643355,
        "amount": 0.04,
        "type": "sell"
      },
    ],
    "lines": [		//k线数据
      [
        1524847500000,	时间
        13.6779745198,	开
        13.70764338,	高
        13.62542985,	低
        13.6272401993,	收
        18.96450414		量
      ],
    ]
  },
  "success": true,
  "channel": "sub_s_eth_btc_allkline_mi15"
}

5.交易行情

channel名称：发送是把area换成对应的 btc eth usdt
areamarket_area//默认
priceAscAreamarket_area//24小时最新价格升序
priceDescAreamarket_area//24小时最新价格降序
changeAscAreamarket_area//24小时涨跌幅升序
changeDescAreamarket_area//24小时涨跌幅降序
maxPriceAscAreamarket_area//24小时最高价升序
maxPriceDescAreamarket_area//24小时最高价降序
minPriceAscAreamarket_area//24小时最低价升序
minPriceDescAreamarket_area//24小时最低价降序
volumeAscAreamarket_area//24小时成交量升序
volumeDescAreamarket_area//24小时成交量降序
volumePriceAscAreamarket_area//24小时成交额升序
volumePriceDescAreamarket_area//24小时成交额降序
返回结果：
   {
     "changePercent": 3.37,     涨跌幅   <0 跌
     "closingPrice": 700.89,    最新价格（收盘价格）
     "cnyPrice": 4410.82,       折合人民币
     "code": "ETH",                 币种
     "currencyPair": "usdt_eth",    
     "maxPrice": 729.49,            最高价格
     "minPrice": 0,                 最低价格
     "usdtPrice": 700.9,            折合USDT
     "volumePrice": 234234.94,      
     "volumeQuantity": 333.1212121  量
   }
   
   //获取买卖家信息（深度）
   发送 sub_s_usdt_btc_depth      usdt_btc  币种变化获取相应的信息
   {
     "depth": null,
     "data": {
       "asks": [ //卖
         [
           11.000000000000,
           11.000000000000
         ],
       ],
       "bids": [	//买
         [
           8890.000000000000,
           0.065000000000
         ],
       ]
     },
     "channel": "sub_s_usdt_btc_depth"
   }