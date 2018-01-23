package com.company.project.wechatweb.support.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class HttpServlets {

    /**
     * 获取请求实体
     *
     * @param request
     * @return String
     */
    public static String getBodyString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            Closeables.closeQuietly(is);
            Closeables.closeQuietly(reader);
        }
        return sb.toString();
    }
}
