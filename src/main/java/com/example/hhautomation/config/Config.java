package com.example.hhautomation.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    private static final Dotenv dotenv = Dotenv.load();

    public static final String BASE_URL = "https://hh.ru";
    public static final String LOGIN_URL = BASE_URL + "/account/login?role=applicant";

    public static final String RESUME_NAME = "Постоянная работа Python";

    public static final String EMAIL = dotenv.get("HH_EMAIL");
    public static final String PASSWORD = dotenv.get("HH_PASSWORD");

    public static final String STORAGE_PATH = "hh-auth.json";
}