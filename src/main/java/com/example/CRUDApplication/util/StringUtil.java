package com.example.CRUDApplication.util;

public class StringUtil {

    public static boolean stringIsNullOrEmpty(String txt){
        return txt==null || txt.isEmpty() || txt.isBlank();
    }
}
