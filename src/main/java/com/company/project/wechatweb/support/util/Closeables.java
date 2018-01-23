package com.company.project.wechatweb.support.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by wangzhj on 2016/12/23.
 */
public class Closeables {

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
