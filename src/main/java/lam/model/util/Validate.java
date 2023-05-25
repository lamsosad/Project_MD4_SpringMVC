package lam.model.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String validateEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String validatePhone = "^0(\\d){9}$";
    public static final String validateUserName = "^[a-z0-9._-]{6,15}$";
    public static final String validatePassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";

    public static boolean setValidateEmail(String email) {
        Pattern pattern = Pattern.compile(validateEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean setValidatePhone(String phone) {
        Pattern pattern = Pattern.compile(validatePhone);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    public static boolean setValidateUserName(String username) {
        Pattern pattern = Pattern.compile(validateUserName);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    public static boolean setValidatePassword(String password) {
        Pattern pattern = Pattern.compile(validatePassword);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
