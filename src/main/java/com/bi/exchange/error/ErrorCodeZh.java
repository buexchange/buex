package com.bi.exchange.error;

public class ErrorCodeZh implements ErrorCodeHandler {
    private static ErrorCodeZh instance = null;

    public static synchronized ErrorCodeZh getInstance() {
        if (instance == null)
            instance = new ErrorCodeZh();
        return instance;
    }

    private final String code1 = "账户信息失效";
    private final String code2 = "非法请求";
    private final String code3 = "资金密码不能为空";
    private final String code4 = "资金密码错误";
    private final String code5 = "请先设置资金密码";
    private final String code6 = "请输入短信验证码";
    private final String code7 = "短信验证码错误";
    private final String code8 = "请输入谷歌验证码";
    private final String code9 = "谷歌验证码错误";
    private final String code10 = "暂不开放提现";
    private final String code11 = "提现地址或账号不能为空";
    private final String code12 = "提现类型不能为空";
    private final String code13 = "无效的资产编码";
    private final String code14 = "提现数量不能为空";
    private final String code15 = "开户行名称不能为空";
    private final String code16 = "请选择转账费";
    private final String code17 = "无效的提现类型";
    private final String code18 = "无效的账户";
    private final String code19 = "资产编码错误,请重新输入";
    private final String code20 = "请先完成实名认证";
    private final String code21 = "请先启用提现验证策略";
    private final String code22 = "无效的提现验证策略";
    private final String code23 = "资金余额不足";
    private final String code24 = "创建提现订单异常";
    private final String code25 = "费率为空";
    private final String code26 = "转账手续费不匹配";
    private final String code27 = "转账手续费区间为空";
    private final String code28 = "单笔最小提现金额";
    private final String code29 = "单笔最大提现金额";
    private final String code30 = "单笔每日提现上限";
    private final String code31 = "请指定银行卡账户";
    private final String code32 = "未找到指定的银行卡账户";
    private final String code33 = "此账户已是默认账户";
    private final String code34 = "银行名称不能为空";
    private final String code35 = "支行不能为空";
    private final String code36 = "银行卡编号不能为空";
    private final String code37 = "开户姓名与实名认证姓名不一致";
    private final String code38 = "银行卡号格式错误";
    private final String code39 = "银行卡信息重复,添加失败";
    private final String code40 = "持卡人姓名不能为空";
    private final String code41 = "注册账号不能为空";
    private final String code42 = "资产类型不能为空";
    private final String code43 = "订单编号不能为空";
    private final String code44 = "货币类型不能为空";
    private final String code45 = "交易订单不存在";
    private final String code46 = "订单获取失败";
    private final String code47 = "交易金额不能为空";
    private final String code48 = "交易数量不能为空";
    private final String code49 = "交易类型不能为空";
    private final String code50 = "货币对不能为空";
    private final String code51 = "无效的资产货币对";
    private final String code52 = "价格不能小于0";
    private final String code53 = "数量不能小于0";
    private final String code54 = "卖出价不得小于0.01";
    private final String code55 = "卖出量不得小于0.01";
    private final String code56 = "请先启用交易验证策略";
    private final String code57 = "请输入资金密码";
    private final String code58 = "资金密码错误";
    private final String code59 = "无效的交易验证策略";
    private final String code60 = "无法获取最新成交价,委托市价买单失败";
    private final String code61 = "未达到最小交易数量0.001";
    private final String code62 = "账户可用余额不足";
    private final String code63 = "账户绑定类型不能为空";
    private final String code64 = "账户已绑定手机";
    private final String code65 = "账户已绑定邮箱";
    private final String code66 = "账户绑定失败";
    private final String code67 = "手机格式错误";
    private final String code68 = "身份证号码不能为空";
    private final String code69 = "请选择国籍";
    private final String code70 = "真实姓名不能为空";
    private final String code71 = "证件类型不能为空";
    private final String code72 = "请上传手持身份证正面";
    private final String code73 = "请上传身份证正面";
    private final String code74 = "请上传身份证反面";
    private final String code75 = "身份证号码错误";
    private final String code76 = "无效的出生年月";
    private final String code77 = "您未满18周岁";
    private final String code78 = "证件编号已被认证,请重新输入";
    private final String code79 = "证件编号与姓名不符合";
    private final String code80 = "旧密码不能为空";
    private final String code81 = "旧密码错误";
    private final String code82 = "资金密码不能与登录密码一样";
    private final String code83 = "旧密码与新密码不能一样";
    private final String code84 = "原手机短信验证码不能为空";
    private final String code85 = "新手机号不能为空";
    private final String code86 = "新手机短信验证码不能为空";
    private final String code87 = "无效的短信类型";
    private final String code88 = "该手机号已被注册，请重新输入";
    private final String code89 = "原手机验证码错误";
    private final String code90 = "新手机验证码错误";
    private final String code91 = "策略类型不能为空";
    private final String code92 = "请先绑定谷歌验证器";
    private final String code93 = "无效的策略";
    private final String code94 = "请先绑定手机";
    private final String code95 = "请先绑定手机和谷歌验证器";
    private final String code96 = "无效的策略类型";
    private final String code97 = "谷歌私钥不能为空";
    private final String code98 = "谷歌验证器已被绑定";
    private final String code99 = "谷歌验证码错误";
    private final String code100 = "谷歌验证码格式错误";
    private final String code101 = "用户昵称不能空";
    private final String code102 = "暂不开放充值";
    private final String code103 = "请选择充值方式";
    private final String code104 = "充值账号不能为空";
    private final String code105 = "充值金额不能为空";
    private final String code106 = "人民币充值范围为100 -- 9999999999";
    private final String code107 = "资产编码不能为空";
    private final String code108 = "未找到资产编码对应的资产";
    private final String code109 = "图片不能为空";
    private final String code110 = "图片格式错误";
    private final String code111 = "图片不能超过5M";
    private final String code112 = "图片上传失败";
    private final String code113 = "注册失败";
    private final String code114 = "账号不存在或未激活";
    private final String code115 = "邮箱用户不存在";
    private final String code116 = "邮箱格式错误";
    private final String code117 = "参数错误";
    private final String code118 = "请填写身份证信息";
    private final String code119 = "实名认证信息错误";
    private final String code120 = "请先完成找回密码第一步";
    private final String code121 = "账号不能为空";
    private final String code122 = "密码不能为空";
    private final String code123 = "账号或密码错误";
    private final String code124 = "服务器异常";
    private final String code125 = "获取验证码失败";
    private final String code126 = "获取频率太高，请稍后再试";
    private final String code127 = "接收次数超限，请联系客服";
    private final String code128 = "请指定数字资产账户";
    private final String code129 = "未找到指定的数字资产账户";
    private final String code130 = "钱包类型不能为空";
    private final String code131 = "数字资产钱包地址不能为空";
    private final String code132 = "钱包地址已存在,添加失败";
    private final String code133 = "验证码类型不能为空";
    private final String code134 = "验证码验证失败";
    private final String code135 = "账户验证失败";
    private final String code136 = "单价不能为空";
    private final String code137 = "无效的订单类型";
    private final String code138 = "账户余额不足";
    private final String code139 = "挂单失败";
    private final String code140 = "订单已成交";
    private final String code141 = "订单已撤销";
    private final String code142 = "撤销订单失败";
    private final String code143 = "请输入确认密码";
    private final String code144 = "两次密码输入不一致";
    private final String code145 = "请输入手机号";
    private final String code146 = "图形验证码不能为空";
    private final String code147 = "请刷新网页再试";
    private final String code148 = "图形验证码错误";

    private final String code149 = "登录成功";
    private final String code150 = "谷歌二次验证";
    private final String code151 = "谷歌校验成功";
    private final String code152 = "登出成功";
    private final String code153 = "绑定手机完成";
    private final String code154 = "验证成功";
    private final String code155 = "修改绑定手机完成";
    private final String code156 = "绑定谷歌验证器完成";
    private final String code157 = "修改谷歌验证器完成";
    private final String code158 = "登录用户安全";
    private final String code159 = "生成成功";
    private final String code160 = "关闭成功";
    private final String code161 = "获取成功";
    private final String code162 = "验证码发送完成";
    private final String code163 = "创建提现订单完成";
    private final String code164 = "添加银行卡成功";
    private final String code165 = "删除成功";
    private final String code166 = "申请完成";
    private final String code167 = "实名认证请求完成";
    private final String code168 = "资金密码设置完成";
    private final String code169 = "重置密码完成";
    private final String code170 = "策略设置完成";
    private final String code171 = "挂单完成";
    private final String code172 = "批量撤单完成";
    private final String code173 = "撤单请求成功";


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

    @Override
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


