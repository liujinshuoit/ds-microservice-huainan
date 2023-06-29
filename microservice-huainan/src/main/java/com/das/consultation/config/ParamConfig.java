package com.das.consultation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by LJS on 2022/2/9.
 */
@Component("ParamConfig")
public class ParamConfig {

    @Value("${tripartite-system.fuyou.url:http://hn.cnhealth.cn:88/DataExchanges/WISHandler.ashx}")
    private String fuYouUrl;

    @Value("${tripartite-system.fuyou.authtoken:46E9405B17B04371A4F320E41F357F4E}")
    private String fuYouAuthToken;

    @Value("${tripartite-system.fuyou.key:EEC8C913}")
    private String fuYouKey;

    public String getFuYouUrl() {
        return fuYouUrl;
    }

    public void setFuYouUrl(String fuYouUrl) {
        this.fuYouUrl = fuYouUrl;
    }

    public String getFuYouAuthToken() {
        return fuYouAuthToken;
    }

    public void setFuYouAuthToken(String fuYouAuthToken) {
        this.fuYouAuthToken = fuYouAuthToken;
    }

    public String getFuYouKey() {
        return fuYouKey;
    }

    public void setFuYouKey(String fuYouKey) {
        this.fuYouKey = fuYouKey;
    }
}
