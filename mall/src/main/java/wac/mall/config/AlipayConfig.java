package wac.mall.config;

public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102200737869";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDPfTEmutN7m//WY2roHu7/znr6EjX40rYoPZKteFQpST87yWrroKNRu6eldEvaZRM2KR4Hkbus8AEbF4LrHB6q6mXnrYDT5rsHJ4jgFVgZCJhggUM3eLYUUy5tX/K7FkanhAFioROUnp3WYiDXi+zpjg5CyEVxuNVWdmnJocucIi7VZ6JMc69baqUvWU1CKEWObpPNs/3bhkm6EfIMmNu35Y1wo81FIS9Ng39w5SUrKqUIk7bK/YRMxFNY0MHIwCGgQML8K/F9adW0lk6yb9sY5ilIpU683my5omQFe55EQRaynuicu7QVXgcK7ng8ziSQt/JOC6pu9R4Nh8YOWFhfAgMBAAECggEBAMxI+XSlawT/0cM1/RLvKebIV8IQ3fzPETPLc7fBijNf/5cQt2morkQRm3zGZMxwyZqAnyVascoSPzR6UJbFB9jFkXGqHPYE7M2deiEOQr/a+5PAkPpzqemXAFYFqsnSo9vYlziRWOLxzHtAAA/Yn3hQOfA8mErgbYOEcKFp4DsmkZ4OBgjLezwgpOZtW48oI2oL4VcBKQvX5yjMRDN1ryvVJDEEqSFBD6wZcFbiZjhaVVYgqubCn7+J54QShm+gOSX8sq2MLiAaphSwSBzEpj1JpbpjxC24xFYeX1+jmXCCIakuzJMv45evXE7EZkZ5RJUus1KJJqB5B7i9PUpTIzECgYEA+CDq3sNdkLf4fO6uSnErq3sJ/Q+4UDIOvaPBC4Xbi7eYu9coiwMK2CxlmXiGr3AmOMz5mPRPwBYGRoM6WtLArj/US74BOvVx6/3m11d6D0TSpOjuGzIL2TIQKThh6FPwRVaH4au1hr3zzA5snPUPCCVsGj3gh3drtGihILKms6kCgYEA1hI8WxXFMgViDaBx/60SEELzGzAoEvBt18J2UUurJJ1xF9SuMkYLyIK5QhTQDTmMkjkshgCd3OYQyYbMM+xJcM4OldKwZtLnEgOAd/NCf7yjEEEYyVv+srfbNYU76/eT7TfLOdQAF4ez+jyrit1LKXRTN62JJAwuSI96E5BbMMcCgYB58TN8ZucEyGUGgQaG7zdW/xDZnXAneXJlIKUu1IohEAmvxv3V05jwxGDqG6GVdrhSEepYkTjgXfKXlMaI/CpVeGkNEEPqhdWG9TENg6ApANnE0fSyyNWp2EC5AUycsSPT78K31XtQzOmTz0LxoD3S8xE9lEtUSAxWjVUijKoAgQKBgGq+RxhIH79UjdMrqQyLmVFAgQaSmbjv6GXI0sSwzZMBas4uP/pTkTaXcJcx15hwlNao6bmb/xuSINbMf3B4pxo3tXAh0dJD4fLKijnFs+gMAOdu/lQRqkwlf4oNeJauKjYENzMLskwJX8YskIE63Wq7VW+S+ape5IlL+dxdhAsrAoGBAKV80NXtLnYyBwoyOdJL5ku2XX56fOe1aFsHGgir21MFXAX2GXvaxhMyBxPN48WFPHfybi1NZiDDEYIribqTZEYak4PoZZ+V7DFU5XrAcibmznMSLxwCaPqZrOt6Pl0jmnvtLgIy9Lm9kzY3OhtMCOnVNbPToEJrziJ1ysBUBpEO";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv9xJwBSNn3cP5waLwl6VYJRj7MQn6kIBlGW+G4uI4gY8Z1t5kluzYvJ7xn4JizIf0+TmACUusoUv0soyyagOmsj9+IrX+wFpCF0/onHSBVc0oRUvOfi2rMaMMrYJxAp7ZVaOIEmwHUEsb3edpMvHv1sXYLv4nFdJ/+I7TnmAgYVs/v8itZTdH5VaJ3m449g4pvSrK5KbzilT5bgfGQKZZdb8ODy5AZAAWfRZO3cpfW3RuPIOiCoj7XyNMUWu4iQ/nCcidPNBCzXpvdcTPbnbVE4SQRQQjGtWnXL0c7bEoqS5IA054MYSTu4tUrdpwBtafYiVW78nMMZvPLXC/7PXNQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:82/pay/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8081/pay/alipayReturnNotice";

    // 签名方式
    public static String sign_type = "RSA2";

    // 返回格式
    public static String FORMAT = "json";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关日志
    public static String log_path = "D:\\支付资料\\alipay支付宝\\log";
}
