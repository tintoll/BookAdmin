package com.book;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by tinoll on 2017. 1. 25..
 */
@Component
@ConfigurationProperties("amazon") //프로퍼티 주입
public class AmazonProperties {

    private String associateId;

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
}
