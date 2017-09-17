package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016073100134493";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC6Hla6NaLdmBUwET3KpyhPkKjGfgDlabTBD1TDB2jm2fMIMP976jq/QAsRmx7S7vji5TlXB0LRqdXcL5ntPG0/nQsT79szZFigrAbZoKkIzXQQfccH2UnB1B7y7hOWxxt9BIRfHiXfFftbf9VOVYzAKiEACzpE41iCZnDrsK4qMdLowIigq3N8Ef/64mhmqCWXorFwZ9oXNwHlMz2rnnOvp5z1+Jw46zfWrHm1tmFmdF5Zh4mGt6++XGg4uDuteg/VU9evRi60+twHdYrLJ//lS0tMZx2+tcGNM32zDCj9feSnXcks4gSYoFziRzvMPPcKjKZtxTmrSn5sDrDTwXqzAgMBAAECggEAd/ug+3Aia2pkllU3GZLDSO+/7h5C46JOlXsVsJjxRolQxIIZ4b9xWeOmfxYaO+804cjWO0WCDPnI1aaWO7sNzsml35dsH2hcPlBIJjoNXpBcd1kuWt/4TY062m8ij7wR+3lTAKLF1Vgtb6IsV9CM6UD/fzC9wrUxVPdHapm+3ZGhrhdjR004eq4a2MYMpQ2zTv3QPW13VI1DMEJrSfQcPKViWNAeI6g2mhoRGaSeqQuXfxi8/Lsw0jXiQaZZGlapU3GfTIDQ1dSAqWLeFBftcTlGdykfdg5ukO8756a5NyybcCBUrECwbPxykFcEpfrgXdjFYfZYwDq35UVXlm5owQKBgQDbU59fvQR+m2Ys5BQERy3aeFUCi7RfsfFV+0fDVmymBQCn1EdTzps12pCEhQ1eB1n1eD5XP7QU3ZxRdUHv86xb8dWSyOY1X6gJUZTImwZhcFo4z1vYx5CRcbG60EDttkjKRRFlGKnA/w/Bxz+cqQWXCWPWZZ1lqd8+61+xeOLOYQKBgQDZPToE03ufJR0ZqzGDTbbZGZa6ELYwJpQyHkyGzoFzsX1IGDT1SGiVMBmixeWS/c0YeYyNHaVkM8n7H65jbPkMCGm3rkVgqKxlHDj/XoDTY9srcCVvkT8U56uvyBYvo4pUZcDsxgpRdy3UZEJWIovuP6X3ZRCP5sLb4zmLaU2ZkwKBgQCMe+GntzC7z9oAgw73Noh+WXlKKiYc7aOByXRMAH2TUbz7wxL08W+lbRwIZhkL03Whr6VuyVUV0GUiIBNeGRybwClm3dvm8CB355N/cx0BKLABl4BjOGC3aLXIzT/pg0rYlKjxsnx5LGbxXii2teTou5EBcRECX26ppKYkzSOpwQKBgQCs5qdD6hKNUtu7b17kE7mBR3WIt/5ZiosO7MCZ1sh/jXeaJvIXez8J5pOw0vNqr6hKX4u3US4u9209+zQwHC6IHjYOJJ1BVl6HxxOyZMQB+4sYIpUZHDBp8g3axVSrK+3QSIBpsyHJPyLx1a5aofpfcLcmlYC+F7tliY9mXzSNEwKBgBUUvolH5Yq1n9vXS6WrP23Qj3Jun/IaSKSDO7lN9b7Az5yZ2u2kHhj6ODPv/PYdiiMmfmatcmVl0t368U1KXJztEoiN//LMeOO+kMOkEnx3X3kmQum3S19YCFI5oEY17y+AVhjVKFxCA1c+CdZj/GPQJLpQW8QEc0hnTHtfV37u";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0J+IqQWGQf+pvx3iFAdWt/YOKrxMVoz4UvUQTrwqIUyRXovcaVKKoJkBf5jv1iD1HywZNtPW8hGIuZiX6epR/FxZgpVlnnYu+8YdKLKEQuPHo8VQfgqBlTeAFDOqjLux7BhIyl8vIrzATRD3vnnVeyxJ0F2yagDsU327ZUZAtO1zwgQF1QjxqY/bmfzFdL5SmmOkq+7Co4tgVDyBAkEWAZU/kWk1A7CFfvfrx12WpgvGUyj+9cP3a5Od5P9XlSc6FymY3M8Jvw2S8Q5vhx8xSe4eOGUB2+RG0I+yUafvmfxK6eQT8nm4jR7t9z6926n5GapZ+caDPCcEua5xhHbRIwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/notify_url.do";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/return_url.do";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

