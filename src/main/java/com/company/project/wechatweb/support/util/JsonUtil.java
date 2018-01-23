package com.company.project.wechatweb.support.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    /**
     * 对象转Json
     *
     * @param obj
     * @return String
     */
    public static String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
    }
}
