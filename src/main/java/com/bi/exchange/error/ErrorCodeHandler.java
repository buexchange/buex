package com.bi.exchange.error;

public interface ErrorCodeHandler {
    /**
     * 账户信息失效
     *
     * @return
     */
    public String invalidAccount();

    /**
     * 非法请求
     *
     * @return
     */
    public String illegalRequst();

    /**
     * 资金密码不能为空
     *
     * @return
     */
    public String noFundsPwdError();

    /**
     * 资金密码错误
     *
     * @return
     */
    public String fundsPwdError();

    /**
     * 请先设置资金密码
     *
     * @return
     */
    public String noSetFundsPwdError();

    /**
     * 短信验证码不能为空
     *
     * @return
     */
    public String noSmsCodeError();

    /**
     * 短信验证码错误
     *
     * @return
     */
    public String smsCodeError();

    /**
     * 谷歌验证码不能为空
     *
     * @return
     */
    public String nogoogleError();

    /**
     * 谷歌验证码错误
     *
     * @return
     */
    public String googleError();

    /**
     * 暂不开放提现
     *
     * @return
     */
    public String dontDrawError();

    /**
     * 提现地址或账号不能为空
     *
     * @return
     */
    public String noDrawAddressError();

    /**
     * 提现类型不能为空
     *
     * @return
     */
    public String noDrawTypeError();

    /**
     * 提现数量不能为空
     *
     * @return
     */
    public String noDrawAmountError();

    /**
     * 无效的资产类型
     *
     * @return
     */
    public String invalidAssetError();

    /**
     * 开户行名称不能为空
     *
     * @return
     */
    public String noBankNameError1();

    /**
     * 请选择转账费
     *
     * @return
     */
    public String noSelectFeeError();

    /**
     * 无效的提现类型
     *
     * @return
     */
    public String invalidDrawTypeError();

    /**
     * 无效的账户
     *
     * @return
     */
    public String invalidAcountError();

    /**
     * 资产编码错误,请重新输入
     *
     * @return
     */
    public String assetCodeError();

    /**
     * 请先完成实名认证
     *
     * @return
     */
    public String noRealAuthError();

    /**
     * 请先启用提现验证策略
     *
     * @return
     */
    public String noSetDrawPolicyError();

    /**
     * 无效的提现验证策略
     *
     * @return
     */
    public String invalidDrawPolicyError();

    /**
     * 资金余额不足
     *
     * @return
     */
    public String fundsError();

    /**
     * 创建提现订单异常
     *
     * @return
     */
    public String createDrawOrderError();

    /**
     * 费率为空
     *
     * @return
     */
    public String noFeeError();

    /**
     * 转账手续费不匹配
     *
     * @return
     */
    public String transferFeeError();

    /**
     * 转账手续费区间为空
     *
     * @return
     */
    public String feeIntervalError();

    /**
     * 单笔最小提现金额
     *
     * @return
     */
    public String drawMinError();

    /**
     * 单笔最大提现金额
     *
     * @return
     */
    public String drawMaxError();

    /**
     * 单笔每日提现上限
     *
     * @return
     */
    public String drawLimitError();

    /**
     * 请指定银行卡账户
     *
     * @return
     */
    public String noBankError();

    /**
     * 未找到指定的银行卡账户
     *
     * @return
     */
    public String notExistBankError();

    /**
     * 此账户已是默认账户
     *
     * @return
     */
    public String existDefaultBankError();

    /**
     * 银行名称不能为空
     *
     * @return
     */
    public String noBankNameError();

    /**
     * 支行不能为空
     *
     * @return
     */
    public String noBranchNameError();

    /**
     * 银行卡编号不能为空
     *
     * @return
     */
    public String noBankNoError();

    /**
     * 开户姓名与实名认证姓名不一致
     *
     * @return
     */
    public String noMatchNameError();

    /**
     * 银行卡号格式错误
     *
     * @return
     */
    public String bankCardFormatError();

    /**
     * 银行卡信息重复，添加失败
     *
     * @return
     */
    public String duplicateBankError();

    /**
     * 持卡人姓名不能为空
     *
     * @return
     */
    public String noCardNameError();

    /**
     * 注册账号不能为空
     *
     * @return
     */
    public String noAccoutError();

    /**
     * 资产类型不能为空
     */
    public String noAssetError();

    /**
     * 订单ID不能为空
     *
     * @return
     */
    public String noOrderError();

    /**
     * 货币类型不能为空
     *
     * @return
     */
    public String noCurrencyTypeError();

    /**
     * 交易订单不存在
     *
     * @return
     */
    public String noTransactionOrderError();

    /**
     * 订单获取失败
     *
     * @return
     */
    public String acquisitionOrderError();

    /**
     * 交易金额不能为空
     *
     * @return
     */
    public String transactionAmountEmptyError();

    /**
     * 交易数量不能为空
     *
     * @return
     */
    public String transactionNumEmptyError();

    /**
     * 交易类型不能为空
     *
     * @return
     */
    public String transactionTypeEmptyError();

    /**
     * 货币对不能为空
     *
     * @return
     */
    public String moneyTwoEmptyError();

    /**
     * 无效的资产货币对
     *
     * @return
     */
    public String currencyPairError();

    /**
     * 价格不能小于0
     *
     * @return
     */
    public String priceError();

    /**
     * 数量不能小于0
     *
     * @return
     */
    public String amountError();

    /**
     * 卖出价不得小于0.01
     *
     * @return
     */
    public String sellingPriceError();

    /**
     * 卖出量不得小于0.01
     *
     * @return
     */
    public String sellingAmountError();

    /**
     * 请先启用交易验证策略
     *
     * @return
     */
    public String transactionValidationError();

    /**
     * 请输入资金密码
     *
     * @return
     */
    public String nofundPasswordError();

    /**
     * 资金密码错误
     *
     * @return
     */
    public String fundPasswordError();

    /**
     * 无效的交易验证策略
     *
     * @return
     */
    public String invalidFundPasswordError();

    /**
     * 无法获取最新成交价,委托市价买单失败
     *
     * @return
     */
    public String commissionMarketPriceError();

    /**
     * 未达到最小交易数量0.001
     *
     * @return
     */
    public String minTradeNumError();

    /**
     * 账户可用余额不足
     *
     * @return
     */
    public String balanceInsufficientError();

    /**
     * 绑定账户类型不能空
     */
    public String bindTypeError();

    /**
     * 账户已绑定手机
     */
    public String bindMobileError();

    /**
     * 账户已绑定邮箱
     */
    public String bindEmailError();

    /**
     * 绑定失败
     */
    public String bindFaileError();

    /**
     * 手机格式错误
     */
    public String mobileFormatError();

    /**
     * 身份证号码不能为空
     */
    public String idNumberError();

    /**
     * 请选择国籍
     */
    public String countryError();

    /**
     * 请输入真实姓名
     */
    public String realNameError();

    /**
     * 证件类型不能为空
     */
    public String certificateTypeError();

    /**
     * 请上传手持照
     */
    public String handFrontError();

    /**
     * 请上传正面照
     */
    public String frontPhotoError();

    /**
     * 请上传背面照
     */
    public String backPhotoError();

    /**
     * 身份证号码格式错误
     */
    public String idNumberFormateError();

    /**
     * 无效的出生年月
     */
    public String birthdayError();

    /**
     * 您未满18周岁
     */
    public String ageError();

    /**
     * 证件编号已被认证,请重新输入
     */
    public String UsedIdNumberError();

    /**
     * 证件编号与姓名不符合
     */
    public String idNumberInfoError();

    /**
     * 旧密码不能为空
     */
    public String noOldPwdError();

    /**
     * 旧密码错误
     */
    public String oldPwdError();

    /**
     * 资金密码不能与登录密码一样
     */
    public String noSamePayLoginPwdError();

    /**
     * 旧密码与新密码相同
     */
    public String noSameOldNewPwdError();

    /**
     * 原手机短信验证码不能为空
     */
    public String noOldSmsCode();

    /**
     * 新手机号不能为空
     */
    public String noNewMobileNumber();

    /**
     * 新手机短信验证码不能为空
     */
    public String noNewSmsCode();

    /**
     * 无效的短信类型
     */
    public String invalidSmsTypeError();

    /**
     * 该手机号已被注册,请重新输入
     */
    public String usedMobileError();

    /**
     * 原手机验证码错误
     */
    public String oldSmsCodeError();

    /**
     * 新手机验证码错误
     */
    public String newSmsCodeError();

    /**
     * 策略类型不能为空
     */
    public String noPolicyTypeError();

    /**
     * 请先设置谷歌验证器
     */
    public String noSetGoogleError();

    /**
     * 无效的策略
     */
    public String invalidPolicyError();

    /**
     * 请先绑定手机
     */
    public String noSetMobileError();

    /**
     * 请先绑定手机和谷歌验证器
     */
    public String noSetMobileAndGoogleError();

    /**
     * 无效的策略类型
     */
    public String invalidPolicyTypeError();

    /**
     * 秘钥不能空
     */
    public String noSecretKeyError();

    /**
     * 谷歌验证器已被绑定
     */
    public String usedGoogleError();

    /**
     * 谷歌验证码错误
     */
    public String googleCodeError();

    /**
     * 谷歌验证码格式错误
     */
    public String googleCodeFormatError();

    /**
     * 用户昵称不能空
     */
    public String noUserNameError();

    /**
     * 暂不开放充值
     */
    public String dontDepositError();

    /**
     * 请选择充值方式
     */
    public String choiceDepositTypeError();

    /**
     * 充值账号不能为空
     */
    public String noDepositAccountError();

    /**
     * 充值金额不能为空
     */
    public String noDepositAmountError();

    /**
     * 人民币充值范围为100 -- 9999999999
     */
    public String RmbDepositRangeError();

    /**
     * 资产编码不能为空
     */
    public String noAsserCodeError();

    /**
     * 未找到资产编码对应的资产
     */
    public String findAssetError();

    /**
     * 图片不能为空
     */
    public String noPictureError();

    /**
     * 图片格式错误
     */
    public String noPictureFormatError();

    /**
     * 图片不能超过5M
     */
    public String pictureRangError();

    /**
     * 图片上传失败
     */
    public String pictureUploadError();

    /**
     * 注册失败
     */
    public String registerError();

    /**
     * 账号不存在或未激活
     */
    public String accountNotExists();
    /**
     *邮箱用户不存在
     */
    public String emailUserNotExists();
    /**
     * 邮箱格式错误
     */
    public String emailFormatError();
    /**
     * 参数错误
     */
    public String paramError();
    /**
     * 请填写身份证信息
     */
    public String noidNumberInfoError();
    /**
     * 实名认证信息错误
     */
    public String identityError();
    /**
     * 请先完成找回密码第二步
     */
    public String stepTwoError();
    /**
     * 账号不能为空
     */
    public String noAccountError();
    /**
     * 密码不能为空
     */
    public String noPasswordError();
    /**
     * 账号或者密码错误
     */
    public String accountOrPasswordError();

    /**
     * 服务器异常
     */
    public String serviceError();
    /**
     * 获取验证码失败
     */
    public String getSmsCodeError();
    /**
     * 获取频率太高，请稍后再试
     */
    public String smsHighFrequencyError();
    /**
     * 接收次数超限，请联系客服
     */
    public String smsLimitError();
    /**
     * 请指定数字资产用户
     */
    public String noDigitalAssetError();
    /**
     * 未找到指定的数字资产账户
     */
    public String findDigitalAsserError();
    /**
     * 钱包类型不能为空
     */
    public String noWalletTypeError();
    /**
     * 数字资产钱包地址不能为空
     */
    public String noDigitalAssetAddressError();
    /**
     * 钱包地址已存在,添加失败
     */
    public String addDigitalError();
    /**
     * 验证码类型不能为空
     */
    public String noCodeTypeError();
    /**
     * 验证码验证失败
     */
    public String validateCodeError();
    /**
     * 账户验证失败
     */
    public String validateAccountError();
    /**
     * 单价不能为空
     */
    public String noPriceError();
    /**
     * 无效的订单类型
     */
    public String invalidOrderTypeError();
    /**
     * 账户余额不足
     */
    public String accountBalanceError();
    /**
     * 挂单失败
     */
    public String placeOrderError();
    /**
     * 订单已成交
     */
    public String orderConcludedError();
    /**
     * 订单已撤销
     */
    public String orderCancledError();
    /**
     * 撤销订单失败
     */
    public String orderCancleError();
    /**
     * 请输入确认密码
     */
    public String noConfirmPasswordError();
    /**
     * 两次密码输入不一致
     */
    public String twoPasswordCompareError();
    /**
     * 请输入手机号
     */
    public String noMobileError();
    /**
     * 图形验证码不能为空
     */
    public String noGraphicCodeError();
    /**
     * 请刷新网页再试
     */
    public String refreshError();
    /**
     * 图形验证码错误
     */
    public String graphicCodeError();

    /**
     *登录成功
     */
    public String successLogin();

    /**
     * 谷歌二次验证
     */
    public String successGoogleTwice();

    /**
     * 谷歌校验成功
     */
    public String successCheckGoogle();

    /**
     * 登出成功
     */
    public String successLoginOut();

    /**
     * 绑定手机完成
     */
    public String successBindMobile();

    /**
     * 验证成功
     */
    public String successCheck();

    /**
     * 修改绑定手机完成
     */
    public String successUpdateMobile();

    /**
     * 绑定谷歌验证器完成
     */
    public String successBindGoogle();

    /**
     * 修改谷歌验证器完成
     */
    public String successUpdateGoogle();

    /**
     * 登录用户安全
     */
    public String successUserSafe();

    /**
     * 生成成功
     */
    public String successGenerative();

    /**
     * 关闭成功
     */
    public String successClose();

    /**
     * 获取成功
     */
    public String successGetInfo();

    /**
     * 验证码发送完成
     */
    public String successSendSmsCode();

    /**
     * 创建提现订单完成
     */
    public String successCreateDrawOrder();

    /**
     *添加银行卡成功
     */
    public String successAddBank();

    /**
     * 删除成功
     */
    public String successDelete();

    /**
     * 申请完成
     */
    public String successRequest();

    /**
     * 实名认证请求完成
     */
    public String successAuthentication();

    /**
     * 资金密码设置完成
     */
    public String successFundPassword();

    /**
     * 重置密码完成
     */
    public String successSetPassword();

    /**
     * 策略设置完成
     */
    public String successSetPolicy();

    /**
     * 挂单完成
     */
    public String successCreateOrder();

    /**
     * 批量撤单完成
     */
    public String successBatchRevoke();

    /**
     *撤单请求成功
     */
    public String successRequestRevoke();




}