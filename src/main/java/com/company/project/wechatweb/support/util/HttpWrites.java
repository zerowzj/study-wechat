package com.company.project.wechatweb.support.util;

import com.google.common.io.Closeables;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Http Write
 *
 * @author wangzhj
 */
public class HttpWrites {

    private static final String CHARSET_UTF_8 = "UTF-8";

    /**
     * 写到客户端
     *
     * @param response
     * @param obj
     */
    public static void writeByJson(HttpServletResponse response, Object obj) {
        write(response, JsonUtil.toJson(obj));
    }

    /**
     * 写到客户端
     *
     * @param response
     * @param msg
     */
    public static void write(HttpServletResponse response, String msg) {
        writeInternal(response, msg);
    }

    private static void writeInternal(HttpServletResponse response, String msg) {
        PrintWriter out = null;
        try {
            response.setContentType("text/plain;charset=" + CHARSET_UTF_8);
            out = response.getWriter();
            out.write(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                Closeables.close(out, false);
            } catch (Exception ex) {
            }
        }
    }
}
