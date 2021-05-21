package com.sjf.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * @author guofeng
 * @email 
 * @time 2019年5月22日 下午15:18:08
 * @description:HTTP工具类
 */

public class HttpClientUtil {
    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private static CloseableHttpClient client = HttpClients.createDefault();

    /*
     * public static String httpPost(String url, Map<String, Object> param) { HttpPost httpPost = new HttpPost(url);
     * List<NameValuePair> nvps = new ArrayList<NameValuePair>(); if (param != null) { for (Map.Entry<String, Object>
     * entry : param.entrySet()) { nvps.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue()))); }
     * } CloseableHttpResponse response2 = null; try { httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
     * response2 = client.execute(httpPost); HttpEntity entity2 = response2.getEntity(); String respContent =
     * EntityUtils.toString(entity2, "utf-8").trim(); httpPost.abort(); EntityUtils.consume(entity2); return
     * respContent; } catch (Exception e) { logger.error("发送http POST请求错误，错误信息为:{}", e); return null; } finally { if
     * (response2 != null) { try { response2.close(); } catch (Exception e) { } } } }
     */

    public static String httpPost(String url, Map<String, Object> param) {
        HttpPost httpPost = new HttpPost(url);
        Gson gson = new Gson();
        String data = gson.toJson(param);
        CloseableHttpResponse response2 = null;
        try {
            httpPost.setEntity(new StringEntity(data, Charset.forName("UTF-8")));
            response2 = client.execute(httpPost);
            HttpEntity entity2 = response2.getEntity();
            String respContent = EntityUtils.toString(entity2, "utf-8").trim();
            httpPost.abort();
            EntityUtils.consume(entity2);
            return respContent;
        } catch (Exception e) {
            logger.error("发送http POST请求错误，错误信息为:{}", e);
            return null;
        } finally {
            if (response2 != null) {
                try {
                    response2.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static String httpDelete(String url) {
        HttpDelete httpDelete = new HttpDelete(url);
        CloseableHttpResponse response2 = null;
        try {
            response2 = client.execute(httpDelete);
            HttpEntity entity2 = response2.getEntity();
            String respContent = EntityUtils.toString(entity2, "utf-8").trim();
            httpDelete.abort();
            EntityUtils.consume(entity2);
            return respContent;
        } catch (Exception e) {
            logger.error("发送http DELETE请求错误，错误信息为:{}", e);
            return null;
        } finally {
            if (response2 != null) {
                try {
                    response2.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static String httpPut(String url, Map<String, Object> param) {
        HttpPut httpPut = new HttpPut(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (param != null) {
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
        }
        CloseableHttpResponse response2 = null;
        try {
            httpPut.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            response2 = client.execute(httpPut);
            HttpEntity entity2 = response2.getEntity();
            String respContent = EntityUtils.toString(entity2, "utf-8").trim();
            httpPut.abort();
            EntityUtils.consume(entity2);
            return respContent;
        } catch (Exception e) {
            logger.error("发送http PUT请求错误，错误信息为:{}", e);
            return null;
        } finally {
            if (response2 != null) {
                try {
                    response2.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
	      
	    paramMap.put("userid", "000000010000002");
	    paramMap.put("password", "123456");
	    paramMap.put("idno", "232301192302134312");
	    paramMap.put("name", "网三");
	    paramMap.put("idtype", "112");
	    paramMap.put("txndate", "20210112");	
	    paramMap.put("txntime", "112205");
        String resultJson = HttpClientUtil.httpPost("http://127.0.0.1:8080/blog/register", paramMap);  //
        System.out.print(resultJson);
    }
}
