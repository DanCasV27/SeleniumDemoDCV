package com.example.seleniumdemodcv.utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EnvUtils {
    private static final Properties props = new Properties();
    static {
        try (InputStream in = EnvUtils.class.getClassLoader().getResourceAsStream(".env")) {
            if ((in!=null)){
                props.load(in);
            }else{
                throw new FileNotFoundException("No se encontro el archivo .env");
            }

        }catch (Exception e){
            throw new RuntimeException("Error al cargar el .env"+e);
        }
    }
    public static String getProperty(String key){
        return props.getProperty(key);
    }
}
