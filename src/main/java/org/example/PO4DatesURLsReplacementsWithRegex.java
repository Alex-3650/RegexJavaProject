package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PO4DatesURLsReplacementsWithRegex {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);



    }
    public static String dateExtract(String text){
        Pattern datePattern=Pattern.compile("(0[1-9]|[1-2][0-9]|3[0-1]*)([-\\/.])(0[1-9]|1[0-2])\\2((1[0-9]{3})|2[0-1][0-9]{2})");
        Matcher dateMatcher=datePattern.matcher(text);
        List<String> dates=new ArrayList<>();
        while (dateMatcher.find()){
            dates.add(dateMatcher.group());
        }
        String countable="date";
        if (dates.size()>1)countable="dates";

        if (dates.isEmpty()) return "No valid dates found in the text.";

        else return  "Valid "+countable+" found: " + String.join(", ",dates);
    }
    public static String urlExtract(String text){

        Pattern ulrPattern=Pattern.compile("(http|ftp|https):\\/\\/([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:\\/~+#-]*[\\w@?^=%&\\/~+#-])");
        Matcher urlMatcher=ulrPattern.matcher(text);

        List<String> URLs=new ArrayList<>();
        while ((urlMatcher.find())){
            URLs.add(urlMatcher.group());
        }
        String countable="URL";
        if (URLs.size()>1)countable="URLs";

        if (URLs.isEmpty()) return "No valid URLs found in the text.";

        else return  countable +" found: " + String.join(", ",URLs);
    }
    public static String replaceWord(String text,String oldWord,String newWord){

        Pattern wordPattern=Pattern.compile(oldWord);
        Matcher wordMatcher=wordPattern.matcher(text);

        while (wordMatcher.find()){

            text=text.replaceAll(wordMatcher.group(),newWord);
        }

        return "The replaced text -> "+text;
    }
}
