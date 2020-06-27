package com.taoge.poi.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author taoxuefeng
 * @date 2019/11/25
 */
public class HttpClientUtil {

    /**
     * 高德key
     */
    private static final String GAODE_KEY="26fd9dae7ae6d3769c88c1e85f2062da";

    private static final String CHARSET="utf-8";

    private HttpClientUtil(){}

    public static String getHttpResponse(String url){
        if (StringUtils.isEmpty(url)) {
            return null;
        }
        url=url+"&key="+GAODE_KEY;
        CloseableHttpClient client=getHttpClient();
        HttpGet get=new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(get);
            System.out.println(response.getStatusLine());
            HttpEntity entity=response.getEntity();
            return EntityUtils.toString(entity,CHARSET);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static CloseableHttpClient getHttpClient(){
        CloseableHttpClient client= HttpClients.createDefault();
        return client;
    }


}
