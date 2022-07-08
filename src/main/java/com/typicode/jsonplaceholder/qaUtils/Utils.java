package com.typicode.jsonplaceholder.qaUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean validEmail(String regex, String email){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
