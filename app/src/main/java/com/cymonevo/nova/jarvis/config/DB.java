package com.cymonevo.nova.jarvis.config;

public class DB {
    public static int STATUS_OK = 200;
    public static String MSG_OK = "success";

    public static int STATUS_ERROR_NO_ROW = 404;
    public static String MSG_ERROR_NO_ROW = "no record found";

    public static int STATUS_ERROR_CONNECTION = 500;
    public static String MSG_ERROR_CONNECTION = "failed to connect db";

    public static int STATUS_ERROR_UNKNOWN = 600;
    public static String MSG_ERROR_UNKNOWN = "unknown error";
}
