package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAndPasswordChecker {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.println(validateEmail("george@gmail.com.bg"));
        System.out.println(validatePassword("12Jedadadadaday#"));




    }
    public static String validateEmail(String email){
        Pattern emailPattern=Pattern.compile("^[a-zA-Z0-9][\\w.+-]*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}$");
        Matcher matcher= emailPattern.matcher(email);

        if (matcher.find()) return  "Your email is valid! Welcome :)";
        else return "Invalid email format. Please enter a valid email address.";

    }
    public static String validatePassword(String password){
   Pattern passwordPatter=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_\\-=+\\[\\]{}|;:'\",.<>/?])[A-Za-z\\d!@#$%^&*()_\\-=+\\[\\]{}|;:'\",.<>/?]{8,}$");
       Matcher matcher=passwordPatter.matcher(password);

       if (matcher.find()) return "Password is strong and meets all requirements!";
       else return """
               Password does not meet requirements. Password must contain:
               - At least 8 characters
               - At least one lowercase letter
               - At least one uppercase letter
               - At least one digit
               - At least one special character""";




    }

}
