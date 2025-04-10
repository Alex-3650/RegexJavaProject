package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PO1EmailExtract {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String text=scanner.nextLine();
        System.out.println(findEmail(text));

    }
    public static String findEmail(String text){
        Pattern pattern =Pattern.compile("[A-Za-z0-9]+[\\_\\.]*[A-Za-z0-9]*\\@[a-z]+\\.[a-z]+\\.*[a-z]*");
        Matcher matcher= pattern.matcher(text);
      if (matcher.find()){
          return  "The email is: "+matcher.group();
      }


        return "This text does not contain email";
    }
}
