package com.typicode.jsonplaceholder.qaUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean validEmail(String regex, String email) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String getJsonFromFileAsString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
