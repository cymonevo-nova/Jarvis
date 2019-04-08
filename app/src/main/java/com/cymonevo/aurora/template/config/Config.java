package com.cymonevo.aurora.template.config;

public class Config {
    public static boolean DEBUG_MODE = false;

//    Internal API
    public static String BASE_URL_STAGING = "http://api.cymonevo.com/";
//    Third party API
    public static String API_GITHUB_URL = "https://api.github.com/";
    public static String API_PLACEHOLDER_URL = "https://via.placeholder.com/%dx%d/%s/%s?text=%s";

    public static String getPlaceholderUrl(int width, int height, String bg, String fg, String text) {
        return String.format(API_PLACEHOLDER_URL, width, height, bg, fg, text);
    }
}
