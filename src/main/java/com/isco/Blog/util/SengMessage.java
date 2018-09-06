package com.isco.Blog.util;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;



/**
 * @author sazhijie
 * time 2018/9/6
 * 发送短信
 */
public class SengMessage {
    private static String number="";
    private static String check="";
    public SengMessage(String phonenumber,String checknumber){
        number=phonenumber;
        check=checknumber;
    };

    public boolean Send() throws HttpException, IOException{
        if(number==null){
            return false;
        }
        if(check == null){
            return false;
        }
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn/");
        // PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");
        post.addRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
        NameValuePair[] data = { new NameValuePair("Uid", "iscotophilia"),// 注册的用户名
                new NameValuePair("Key", "76a81443335f2ad640db"),// 注册成功后，登录网站后得到的密钥
                new NameValuePair("smsMob", number),// 手机号码
                new NameValuePair("smsText", "您好，您本次注册的验证码为:"+check+", 5分钟内有效") };// 短信内容
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);

        for (Header h : headers) {
            System.out.println("---" + h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes(
                "gbk"));
        if(result.equals("1")){
            return true;
        }
        System.out.println(result);
        return false;
    }
}
