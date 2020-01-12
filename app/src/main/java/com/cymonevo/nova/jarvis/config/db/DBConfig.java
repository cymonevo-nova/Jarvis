package com.cymonevo.nova.jarvis.config.db;

import com.cymonevo.nova.jarvis.config.Config;

public class DBConfig {
    public static final String SQLITE_DB_NAME = String.format("%s%s", Config.PACKAGE_NAME, ".sqlite-db");
}
