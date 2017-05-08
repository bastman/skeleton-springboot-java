package com.example.demo.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final public class AppLogger {

    private AppLogger() {
    }

    public static Logger get(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

}
