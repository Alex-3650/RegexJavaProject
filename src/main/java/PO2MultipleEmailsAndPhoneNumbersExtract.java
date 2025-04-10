import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PO2MultipleEmailsAndPhoneNumbersExtract {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String text=scanner.nextLine();
         phoneAndEmailChecker(text);

    }
    private static void phoneAndEmailChecker(String text){
        Map<String, List<String>> emails=new LinkedHashMap<>();
        Map<String, List<String>> phones=new LinkedHashMap<>();

        Pattern emailPatter=Pattern.compile("[A-Za-z0-9]+[\\_\\.]*[A-Za-z0-9]*\\@[a-z]+\\.[a-z]+\\.*[a-z]*");
        Matcher emailMatcher= emailPatter.matcher(text);


        Pattern phonePatter=Pattern.compile("\\+\\d{1,3}([\\s|\\-])\\d{2,3}\\1\\d{3,4}\\1\\d{3,4}");
        Matcher phoneMatcher= phonePatter.matcher(text);
       emails.put(text,new ArrayList<>());
       phones.put(text,new ArrayList<>());
       while (emailMatcher.find()){
             emails.get(text).add(emailMatcher.group());
        }
        while (phoneMatcher.find()){
            phones.get(text).add(phoneMatcher.group());
        }
        System.out.println("Emails: "+ String.join(", ",emails.get(text)));
        System.out.println("Phone Numbers: "+ String.join(", ",phones.get(text)));
   }
}
