package com.cp.utils;

import com.cp.config.Constance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:  公共方法
 *
 * @author: LF
 * @create: 2018-04-17 14:38
 **/
@Component
public class CommonUtil {

    @Value("${imageUrl}")
    private String imageUrl;


    public String imageShortToUrl(String sht){
        if (StringUtils.hasText(sht)) {
            return  imageUrl + sht.split(Constance.SEPARATOR_JAVA)[0] + ".jpg";
        }
        return sht == null ? "" : sht;
    }

    public String imageShortToUrlWithOutSuffix(String sht){
        if (StringUtils.hasText(sht)) {
            return  imageUrl + sht.split(Constance.SEPARATOR_JAVA)[0];
        }
        return sht == null ? "" : sht;
    }

    public List<String> imagesShortToUrl(String sht){

        List<String> iamgeList = new ArrayList<>();
        if (StringUtils.hasText(sht)) {
            String[] iamges = sht.split(Constance.SEPARATOR_JAVA);
            for (String img:iamges) {
                iamgeList.add(imageUrl + img + ".jpg");
            }
        }
        return iamgeList;
    }
}
