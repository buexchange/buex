package com.bi.exchange.error;

public class ErrorCodeEn implements ErrorCodeHandler {
    private static ErrorCodeEn instance = null;

    public static synchronized ErrorCodeEn getInstance() {
        if (instance == null)
            instance = new ErrorCodeEn();
        return instance;
    }


    private final String code1 = "Invalid account";//账户信息失效
    private final String code2 = "Illegal request";//非法请求
    private final String code3 = "Fund password cannot be empty";//资金密码不能为空
    private final String code4 = "Fund password error";//资金密码错误
    private final String code5 = "Please set up the fund password first";//请先设置资金密码
    private final String code6 = "SMS verification code can not be empty";//请输入短信验证码
    private final String code7 = "SMS verification code error";//短信验证码错误
    private final String code8 = "Please enter Google authentication code";//请输入谷歌验证码
    private final String code9 = "Google verification code error";//谷歌验证码错误
    private final String code10 = "Withdrawal is not supported now";//暂不开放提现
    private final String code11 = "The address or account cannot be empty";//提现地址或账号不能为空
    private final String code12 = "The types of withdrawals cannot be empty";//提现类型不能为空
    private final String code13 = "Invalid asset code";//无效的资产编码
    private final String code14 = "The number of withdrawals cannot be empty";//提现数量不能为空
    private final String code15 = "The name of the bank cannot be empty";//开户行名称不能为空
    private final String code16 = "Please select fee";//请选择转账费
    private final String code17 = "Invalid withdrawals type";//无效的提现类型
    private final String code18 = "Invalid account";//无效的账户
    private final String code19 = "Asset encoding error, please re-enter";//资产编码错误,请重新输入
    private final String code20 = "Please complete the real name authentication first";//请先完成实名认证
    private final String code21 = "Please enable the validation policy first";//请先启用提现验证策略
    private final String code22 = "Invalid validation strategy for cash withdrawals";//无效的提现验证策略
    private final String code23 = "Not sufficient funds";//资金余额不足
    private final String code24 = "Create order exception";//创建提现订单异常
    private final String code25 = "The rate is empty";//费率为空
    private final String code26 = "The fee donot match";//转账手续费不匹配
    private final String code27 = "The fee interval is empty";//转账手续费区间为空
    private final String code28 = "The minimum amount of cash paid for a single sum is ";//单笔最小提现金额
    private final String code29 = "The maximum amount of cash paid for a single sum is  ";//单笔最大提现金额
    private final String code30 = "Single daily upper limit is ";//单笔每日提现上限
    private final String code31 = "Please choose a bank card account";//请指定银行卡账户
    private final String code32 = "Account does not exist";//未找到指定的银行卡账户
    private final String code33 = "Is the default account";//此账户已是默认账户
    private final String code34 = "The name of the bank cannot be empty";//银行名称不能为空
    private final String code35 = "Sub branch can not be empty";//支行不能为空
    private final String code36 = "The bank card number should not be empty";//银行卡编号不能为空
    private final String code37 = "User name does not match the name of real name authentication";//开户姓名与实名认证姓名不一致
    private final String code38 = "Bank card number format error";//银行卡号格式错误
    private final String code39 = "Duplicate bank card";//银行卡信息重复,添加失败
    private final String code40 = "The cardholder's name cannot be empty";//持卡人姓名不能为空
    private final String code41 = "Account cannot be empty";//注册账号不能为空
    private final String code42 = "Asset type cannot be empty";//注册账号不能为空
    private final String code43 = "Order ID cannot be empty ";// 订单ID不能为空
    private final String code44 = "Currency type cannot be empty ";// 货币类型不能为空
    private final String code45 = "Transaction order does not exist";// 交易订单不存在
    private final String code46 = "Order acquisition failed";// 订单获取失败
    private final String code47 = "The amount of the transaction cannot be empty";// 交易金额不能为空
    private final String code48 = "The number of the transaction cannot be empty";// 交易数量不能为空
    private final String code49 = "The type of the transaction cannot be empty";// 交易数量不能为空
    private final String code50 = "Money can not be empty";// 货币对能为空
    private final String code51 = "Invalid asset currency pair";// 无效的资产货币对
    private final String code52 = "The price must not be less than 0";//价格不能小于0
    private final String code53 = "The amount must not be less than 0";//数量不能小于0
    private final String code54 = "The selling price shall not be less than 0.01";// 卖出价不得小于0.01
    private final String code55 = "The selling amount shall not be less than 0.01";// 卖出量不得小于0.01
    private final String code56 = "Please enable transaction validation policy first";// 请先启用交易验证策略
    private final String code57 = "Please input the fund password";// 请输入资金密码
    private final String code58 = "Fund password error";// 资金密码错误
    private final String code59 = "Invalid transaction verification strategy";// 无效的交易验证策略
    private final String code60 = "Unable to obtain the latest transaction price, commission market price failed";// 无法获取最新成交价,委托市价买单失败
    private final String code61 = "Minimum trading volume 0.001";// 未达到最小交易数量0.001
    private final String code62 = "Insufficient available balance of account";// 账户可用余额不足
    private final String code63 = "Bind type of Account is not empty";//账户绑定类型不能为空
    private final String code64 = "Account has bound mobile phone";//账户已绑定手机
    private final String code65 = "Account has bound email";//账户已绑定邮箱
    private final String code66 = "Account bind is failed";//账户绑定失败
    private final String code67 = "Mobile phone format error";//手机格式错误
    private final String code68 = "ID number can not be empty";//身份证号码不能为空
    private final String code69 = "Please choice country";//请选择国籍
    private final String code70 = "Real name can not be empty";//真实姓名不能为空
    private final String code71 = "Certificates type can not be empty";//证件类型不能为空
    private final String code72 = "Please upload front of Handheld ID card";//请上传手持身份证正面
    private final String code73 = "Please upload Front of ID card";//请上传身份证正面
    private final String code74 = "Please upload Reverse of ID card";//请上传身份证反面
    private final String code75 = "Id Number is error";//身份证号码错误
    private final String code76 = "Invalid birth date";//无效的出生年月
    private final String code77 = "You are under 18 years of age";//您未满18周岁
    private final String code78 = "The id number has been certified";//证件编号已被认证,请重新输入
    private final String code79 = "The real name is invalid";//证件编号与姓名不符合
    private final String code80 = "The old password can not be empty";//旧密码不能为空
    private final String code81 = "The old password is not correct";//旧密码错误
    private final String code82 = "The fund password cannot be the same as the login password";//资金密码不能与登录密码一样
    private final String code83 = "The old password cannot be the same as the new password";//旧密码与新密码不能一样
    private final String code84 = "The old sms captcha code can not be empty";//原手机短信验证码不能为空
    private final String code85 = "The new mobile number can not be empty";//新手机号不能为空
    private final String code86 = "The new sms captcha code can not be empty";//新手机短信验证码不能为空
    private final String code87 = "Invalid sms captcha code type";//无效的短信类型
    private final String code88 = "The new phone number has been registered.";//该手机已被注册，请重新输入
    private final String code89 = "The old sms captcha code is not correct";//原手机验证码错误
    private final String code90 = "The new sms captcha code is not correct";//新手机验证码错误
    private final String code91 = "The policy type can not be empty";//策略类型不能为空
    private final String code92 = "Please set up the Google authenticator first";//请先绑定谷歌验证器
    private final String code93 = "Invalid policy";//无效的策略
    private final String code94 = "Please set up the mobile phone first";//请先绑定手机
    private final String code95 = "Please set up the Google authenticator and mobile phone first";//请先绑定手机和谷歌验证器
    private final String code96 = "Invalid policy type";//无效的策略类型
    private final String code97 = "The Google secretKey can not be empty";//秘钥不能空
    private final String code98 = "The Google authenticator has been bound";//谷歌验证器已被绑定
    private final String code99 = "The Google verification code is not correct";//谷歌验证码错误
    private final String code100 = "The Google verification code format is not correct";//谷歌验证码格式错误
    private final String code101 = "The userName can not be empty";//用户昵称不能空
    private final String code102 = "Deposit is not supported now";//暂不开放充值
    private final String code103 = "Please select recharge mode";//请选择充值方式
    private final String code104 = "Recharge account can not be empty";//充值账号不能为空
    private final String code105 = "Recharge amount can not be empty";//充值金额不能为空
    private final String code106 = "RMB recharge range is 100 - 9999999999";//人民币充值范围为100 -- 9999999999
    private final String code107 = "Asset code cannot be empty";//资产编码不能为空
    private final String code108 = "Asset not found in asset code";//未找到资产编码对应的资产
    private final String code109 = "The picture can not be empty";//图片不能为空
    private final String code110 = "The Picture format is not correct";//图片格式错误
    private final String code111 = "The picture should not exceed 5M";//图片不能超过5M
    private final String code112 = "The picture upload filed";//图片上传失败
    private final String code113 = "Register has failed";//注册失败
    private final String code114 = "The account does not exist or is not activated";//账号不存在或未激活
    private final String code115 = "Mailbox user does not exist";//邮箱用户不存在
    private final String code116 = "Mailbox format is not correct";//邮箱格式错误
    private final String code117 = "Parameter error";//参数错误
    private final String code118 = "Please fill in the ID card information";//请填写身份证信息
    private final String code119 = "Real name authentication information error";//实名认证信息错误
    private final String code120 = "Please complete the first steps of password retrieval";//请先完成找回密码第二步
    private final String code121 = "account can not be empty";//账号不能为空
    private final String code122 = "password can not be empty";//密码不能空
    private final String code123 = "Account or password is not correct";//账号或密码错误
    private final String code124 = "Server exception";//服务器异常
    private final String code125 = "Failed to obtain validation code";//获取验证码失败
    private final String code126 = "The access frequency is too high,please try again later";//获取频率太高，请稍后再试
    private final String code127 = "The number of receiving exceeds the limit, please contact customer service";//接收次数超限，请联系客服
    private final String code128 = "Please specify a digital asset account";//请指定数字资产账户
    private final String code129 = "The specified digital asset account was not found";//未找到指定的数字资产账户
    private final String code130 = "Wallet type cannot be empty";//钱包类型不能为空
    private final String code131 = "Digital asset wallet address can not be empty";//数字资产钱包地址不能为空
    private final String code132 = "The wallet address already exists and failed to add";//钱包地址已存在,添加失败
    private final String code133 = "The code type cannot be empty";//验证码类型不能为空
    private final String code134 = "Validation code failed";//验证码验证失败
    private final String code135 = "Account validation failed";//账户验证失败
    private final String code136 = "Price can not be empty";//单价不能为空
    private final String code137 = "Invalid order type";//无效的订单类型
    private final String code138 = "Insufficient account balance";//账户余额不足
    private final String code139 = "Failed to place an order";//挂单失败
    private final String code140 = "The order has been concluded";//订单已成交
    private final String code141 = "The order has been cancelled";//订单已撤销
    private final String code142 = "Failure to cancel order";//撤销订单失败
    private final String code143 = "Please enter the confirmation password";//请输入确认密码
    private final String code144 = "The two password input is inconsistent";//两次密码输入不一致
    private final String code145 = "Please enter your cell phone number";//请输入手机号
    private final String code146 = "The graphic verification code cannot be empty";//图形验证码不能为空
    private final String code147 = "Please refresh the page and try again";//请刷新网页再试
    private final String code148 = "Graphic verification code error";//图形验证码错误

    private final String code149 = "Login successful";//登录成功
    private final String code150 = "Google twice verification";//谷歌二次验证
    private final String code151 = "Google verification successful";//谷歌校验成功
    private final String code152 = "Logout success";//登出成功
    private final String code153 = "Bind mobile phone complete";//绑定手机完成
    private final String code154 = "Verify success";//验证成功
    private final String code155 = "Modify binding mobile phone to complete";//修改绑定手机完成
    private final String code156 = "Google authenticator complete binding";//绑定谷歌验证器完成
    private final String code157 = "The modified Google authenticator completed";//修改谷歌验证器完成
    private final String code158 = "Login user security";//登录用户安全
    private final String code159 = "Generative success";//生成成功
    private final String code160 = "Shutdown success";//关闭成功
    private final String code161 = "Get success";//获取成功
    private final String code162 = "Send the verification code";//验证码发送完成
    private final String code163 = "Create order completion";//创建提现订单完成
    private final String code164 = "Add bank card success";//添加银行卡成功
    private final String code165 = "Delete successfully";//删除成功
    private final String code166 = "Apply for completion";//申请完成
    private final String code167 = "Real name authentication request completed";//实名认证请求完成
    private final String code168 = "Fund password settings completed";//资金密码设置完成
    private final String code169 = "Reset password completion";//重置密码完成
    private final String code170 = "Policy settings completed";//策略设置完成
    private final String code171 = "Pending completion";//挂单完成
    private final String code172 = "Batch Revoke order success";//批量撤单完成
    private final String code173 = "Revoke order success";//撤单请求成功


    @Override
    public String invalidAccount() {
        return code1;
    }

    @Override
    public String illegalRequst() {
        return code2;
    }

    @Override
    public String noFundsPwdError() {
        return code3;
    }

    @Override
    public String fundsPwdError() {
        return code4;
    }

    @Override
    public String noSetFundsPwdError() {
        return code5;
    }

    @Override
    public String noSmsCodeError() {
        return code6;
    }

    @Override
    public String smsCodeError() {
        return code7;
    }

    @Override
    public String nogoogleError() {
        return code8;
    }

    @Override
    public String googleError() {
        return code9;
    }

    @Override
    public String dontDrawError() {
        return code10;
    }

    @Override
    public String noDrawAddressError() {
        return code11;
    }

    @Override
    public String noDrawTypeError() {
        return code12;
    }

    @Override
    public String noDrawAmountError() {
        return code14;
    }

    @Override
    public String invalidAssetError() {
        return code13;
    }


    @Override
    public String noBankNameError1() {
        return code15;
    }

    @Override
    public String noSelectFeeError() {
        return code16;
    }

    @Override
    public String invalidDrawTypeError() {
        return code17;
    }

    @Override
    public String invalidAcountError() {
        return code18;
    }

    @Override
    public String assetCodeError() {
        return code19;
    }

    @Override
    public String noRealAuthError() {
        return code20;
    }

    @Override
    public String noSetDrawPolicyError() {
        return code21;
    }

    @Override
    public String invalidDrawPolicyError() {
        return code22;
    }

    @Override
    public String fundsError() {
        return code23;
    }

    @Override
    public String createDrawOrderError() {
        return code24;
    }

    @Override
    public String noFeeError() {
        return code25;
    }

    @Override
    public String transferFeeError() {
        return code26;
    }

    @Override
    public String feeIntervalError() {
        return code27;
    }

    @Override
    public String drawMinError() {
        return code28;
    }

    @Override
    public String drawMaxError() {
        return code29;
    }

    @Override
    public String drawLimitError() {
        return code30;
    }

    @Override
    public String noBankError() {
        return code31;
    }

    @Override
    public String notExistBankError() {
        return code32;
    }

    @Override
    public String existDefaultBankError() {
        return code33;
    }

    @Override
    public String noBankNameError() {
        return code34;
    }

    @Override
    public String noBranchNameError() {
        return code35;
    }

    @Override
    public String noBankNoError() {
        return code36;
    }

    @Override
    public String noMatchNameError() {
        return code37;
    }

    @Override
    public String bankCardFormatError() {
        return code38;
    }

    @Override
    public String duplicateBankError() {
        return code39;
    }

    @Override
    public String noCardNameError() {
        return code40;
    }

    @Override
    public String noAccoutError() {
        return code41;
    }

    @Override
    public String noAssetError() {
        return code42;
    }

    @Override
    public String noOrderError() {
        return code43;
    }

    @Override
    public String noCurrencyTypeError() {
        return code44;
    }

    @Override
    public String noTransactionOrderError() {
        return code45;
    }

    @Override
    public String acquisitionOrderError() {
        return code46;
    }

    @Override
    public String transactionAmountEmptyError() {
        return code47;
    }

    @Override
    public String transactionNumEmptyError() {
        return code48;
    }

    @Override
    public String transactionTypeEmptyError() {
        return code49;
    }

    @Override
    public String moneyTwoEmptyError() {
        return code50;
    }

    @Override
    public String currencyPairError() {
        return code51;
    }

    @Override
    public String priceError() {
        return code52;
    }

    @Override
    public String amountError() {
        return code53;
    }

    @Override
    public String sellingPriceError() {
        return code54;
    }

    @Override
    public String sellingAmountError() {
        return code55;
    }

    @Override
    public String transactionValidationError() {
        return code56;
    }

    @Override
    public String nofundPasswordError() {
        return code57;
    }

    @Override
    public String fundPasswordError() {
        return code58;
    }

    @Override
    public String invalidFundPasswordError() {
        return code59;
    }

    @Override
    public String commissionMarketPriceError() {
        return code60;
    }

    @Override
    public String minTradeNumError() {
        return code61;
    }

    @Override
    public String balanceInsufficientError() {
        return code62;
    }

    @Override
    public String bindTypeError() {
        return code63;
    }

    @Override
    public String bindMobileError() {
        return code64;
    }

    @Override
    public String bindEmailError() {
        return code65;
    }

    @Override
    public String bindFaileError() {
        return code66;
    }

    @Override
    public String mobileFormatError() {
        return code67;
    }

    @Override
    public String idNumberError() {
        return code68;
    }

    @Override
    public String countryError() {
        return code69;
    }

    @Override
    public String realNameError() {
        return code70;
    }

    @Override
    public String certificateTypeError() {
        return code71;
    }

    @Override
    public String handFrontError() {
        return code72;
    }

    @Override
    public String frontPhotoError() {
        return code73;
    }

    @Override
    public String backPhotoError() {
        return code74;
    }

    @Override
    public String idNumberFormateError() {
        return code75;
    }

    @Override
    public String birthdayError() {
        return code76;
    }

    @Override
    public String ageError() {
        return code77;
    }

    @Override
    public String UsedIdNumberError() {
        return code78;
    }

    @Override
    public String idNumberInfoError() {
        return code79;
    }

    @Override
    public String noOldPwdError() {
        return code80;
    }

    @Override
    public String oldPwdError() {
        return code81;
    }

    @Override
    public String noSamePayLoginPwdError() {
        return code82;
    }

    @Override
    public String noSameOldNewPwdError() {
        return code83;
    }

    @Override
    public String noOldSmsCode() {
        return code84;
    }

    @Override
    public String noNewMobileNumber() {
        return code85;
    }

    @Override
    public String noNewSmsCode() {
        return code86;
    }

    @Override
    public String invalidSmsTypeError() {
        return code87;
    }

    @Override
    public String usedMobileError() {
        return code88;
    }

    @Override
    public String oldSmsCodeError() {
        return code89;
    }

    @Override
    public String newSmsCodeError() {
        return code90;
    }

    @Override
    public String noPolicyTypeError() {
        return code91;
    }

    @Override
    public String noSetGoogleError() {
        return code92;
    }

    @Override
    public String invalidPolicyError() {
        return code93;
    }

    @Override
    public String noSetMobileError() {
        return code94;
    }

    @Override
    public String noSetMobileAndGoogleError() {
        return code95;
    }

    @Override
    public String invalidPolicyTypeError() {
        return code96;
    }

    @Override
    public String noSecretKeyError() {
        return code97;
    }

    @Override
    public String usedGoogleError() {
        return code98;
    }

    @Override
    public String googleCodeError() {
        return code99;
    }

    @Override
    public String googleCodeFormatError() {
        return code100;
    }

    @Override
    public String noUserNameError() {
        return code101;
    }

    @Override
    public String dontDepositError() {
        return code102;
    }

    @Override
    public String choiceDepositTypeError() {
        return code103;
    }

    @Override
    public String noDepositAccountError() {
        return code104;
    }

    @Override
    public String noDepositAmountError() {
        return code105;
    }

    @Override
    public String RmbDepositRangeError() {
        return code106;
    }

    @Override
    public String noAsserCodeError() {
        return code107;
    }

    @Override
    public String findAssetError() {
        return code108;
    }

    @Override
    public String noPictureError() {
        return code109;
    }

    @Override
    public String noPictureFormatError() {
        return code110;
    }

    @Override
    public String pictureRangError() {
        return code111;
    }

    @Override
    public String pictureUploadError() {
        return code112;
    }

    @Override
    public String registerError() {
        return code113;
    }


    public String accountNotExists() {
        return code114;

    }

    @Override
    public String emailUserNotExists() {
        return code115;
    }

    @Override
    public String emailFormatError() {
        return code116;
    }

    @Override
    public String paramError() {
        return code117;
    }

    @Override
    public String noidNumberInfoError() {
        return code118;
    }

    @Override
    public String identityError() {
        return code119;
    }

    @Override
    public String stepTwoError() {
        return code120;
    }

    @Override
    public String noAccountError() {
        return code121;
    }

    @Override
    public String noPasswordError() {
        return code122;
    }

    @Override
    public String accountOrPasswordError() {
        return code123;
    }

    @Override
    public String serviceError() {
        return code124;
    }

    @Override
    public String getSmsCodeError() {
        return code125;
    }

    @Override
    public String smsHighFrequencyError() {
        return code126;
    }

    @Override
    public String smsLimitError() {
        return code127;
    }

    @Override
    public String noDigitalAssetError() {
        return code128;
    }

    @Override
    public String findDigitalAsserError() {
        return code129;
    }

    @Override
    public String noWalletTypeError() {
        return code130;
    }

    @Override
    public String noDigitalAssetAddressError() {
        return code131;
    }

    @Override
    public String addDigitalError() {
        return code132;
    }

    @Override
    public String noCodeTypeError() {
        return code133;
    }

    @Override
    public String validateCodeError() {
        return code134;
    }

    @Override
    public String validateAccountError() {
        return code135;
    }

    @Override
    public String noPriceError() {
        return code136;
    }

    @Override
    public String invalidOrderTypeError() {
        return code137;
    }

    @Override
    public String accountBalanceError() {
        return code138;
    }

    @Override
    public String placeOrderError() {
        return code139;
    }

    @Override
    public String orderConcludedError() {
        return code140;
    }

    @Override
    public String orderCancledError() {
        return code141;
    }

    @Override
    public String orderCancleError() {
        return code142;
    }

    @Override
    public String noConfirmPasswordError() {
        return code143;
    }

    @Override
    public String twoPasswordCompareError() {
        return code144;
    }

    @Override
    public String noMobileError() {
        return code145;
    }

    @Override
    public String noGraphicCodeError() {
        return code146;
    }

    @Override
    public String refreshError() {
        return code147;
    }

    @Override
    public String graphicCodeError() {
        return code148;
    }

    @Override
    public String successLogin() {
        return code149;
    }

    @Override
    public String successGoogleTwice() {
        return code150;
    }

    @Override
    public String successCheckGoogle() {
        return code151;
    }

    @Override
    public String successLoginOut() {
        return code152;
    }

    @Override
    public String successBindMobile() {
        return code153;
    }

    @Override
    public String successCheck() {
        return code154;
    }

    @Override
    public String successUpdateMobile() {
        return code155;
    }

    @Override
    public String successBindGoogle() {
        return code156;
    }

    @Override
    public String successUpdateGoogle() {
        return code157;
    }

    @Override
    public String successUserSafe() {
        return code158;
    }

    @Override
    public String successGenerative() {
        return code159;
    }

    @Override
    public String successClose() {
        return code160;
    }

    @Override
    public String successGetInfo() {
        return code161;
    }

    @Override
    public String successSendSmsCode() {
        return code162;
    }

    @Override
    public String successCreateDrawOrder() {
        return code163;
    }

    @Override
    public String successAddBank() {
        return code164;
    }

    @Override
    public String successDelete() {
        return code165;
    }

    @Override
    public String successRequest() {
        return code166;
    }

    @Override
    public String successAuthentication() {
        return code167;
    }

    @Override
    public String successFundPassword() {
        return code168;
    }

    @Override
    public String successSetPassword() {
        return code169;
    }

    @Override
    public String successSetPolicy() {
        return code170;
    }

    @Override
    public String successCreateOrder() {
        return code171;
    }

    @Override
    public String successBatchRevoke() {
        return code172;
    }

    @Override
    public String successRequestRevoke() {
        return code173;
    }
}
