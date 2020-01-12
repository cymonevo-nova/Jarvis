package com.cymonevo.nova.jarvis.config;

public class Http {
    public static int STATUS_OK = 200;
    public static String MSG_OK = "success";

    public static int STATUS_ERROR_FORBIDDEN = 403;
    public static String MSG_ERROR_FORBIDDEN = "forbidden access";
    public static int STATUS_ERROR_NOT_FOUND = 404;
    public static String MSG_ERROR_NOT_FOUND = "not found";

    public static int STATUS_ERROR_INTERNAL_SERVER = 500;
    public static String MSG_ERROR_INTERNAL_SERVER = "internal server error";

    public static int STATUS_ERROR_UNKNOWN = 600;
    public static String MSG_ERROR_UNKNOWN = "unknown error";
}
