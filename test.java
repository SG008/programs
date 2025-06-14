import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    private static String queryCom = "B> ?";
    private static String tcValue = "\\r\\n";
    public static void main(String[] args) {

        StringBuilder tmpData = new StringBuilder();
        StringBuffer completeData = new StringBuffer();
        String s = """
                B
                >
                 u
                pP
                a
                rtCount=660
                10
                B
                >\s
                ?
                 P
                550/P1
                1631
                A>
                 0.829833
                984375
                
                
                B
                > ?
                 u
                pSystemS
                tatus
                A>
                 1
                
                B>
                 ?
                 P
                550/P
                631
                A>
                 0.8298339
                84375
                
                B
                > ?
                 u
                pToolChe
                ckCoun
                t
                A>
                 34280
                
                
                B>
                 ?
                 P
                550/P6
                31
                A>
                 0.8298339
                84375
                
                B
                > ?
                 u
                pPartsPer
                Hour
                A>
                 4215.456
                6744730
                6
                
                B>
                 ?
                 P
                550/P6
                31
                A>
                 0.82983398
                4375
                
                B
                > ?
                 u
                pPartsSin
                ceRotate
                
                A>
                 40
                
                B>
                 ?
                 P
                550/P631
                
                A>
                 0.829833984
                375
                
                B
                > ?
                 u
                pWireWeight
                
                A>
                 2.55225
                2925018
                
                
                B>
                 ?
                 P
                550/P6
                31
                A>
                 0.8298339
                84375
                
                B
                > ?
                 u
                pRecipeN
                ame
                A>
                 6726
                
                B>
                 ?
                 P
                550/P1
                2631
                A>
                 0.82983
                3984375
                
                
                B
                > ?
                \s
                upPartCou
                nt""";

        String regex = "B>\\s*\\?([\\s\\S]*?A>[\\s\\S]*?)B>\\s*\\?";
        Pattern pattern = Pattern.compile(regex);
        tmpData.append(s);
        System.out.println("tempoaray data: " + tmpData);
        Matcher matcher = pattern.matcher(tmpData.toString());

        while (matcher.find()) {
            System.out.println("inside matcher");
            String dataBetween = matcher.group(1).trim();
            completeData.append(dataBetween);

            // Remove the matched portion from tmpData
            tmpData.delete(matcher.start(), (matcher.end() - queryCom.length() + 1));  // remove processed data
            matcher = pattern.matcher(tmpData); // reset matcher on remaining data
        }

        replaceAll(completeData, "\n", "");
        replaceAll(completeData, "\r", "");
        replaceAll(completeData, tcValue, "");
        removeSpecificKeys(completeData);

        System.out.println("=================================" + completeData);
    }

    public static void replaceAll(StringBuffer sb, String regex, String replacement) {
        // Convert StringBuffer to String
        String modifiedString = sb.toString().replaceAll(regex, replacement);
        // Clear StringBuffer and append the modified string
        sb.setLength(0);
        sb.append(modifiedString);
    }

    public static void removeSpecificKeys(StringBuffer input) {
        // Convert the contents of the buffer to a String
        String data = input.toString();

        // Define a regex pattern that matches:
        // "B>" followed by any characters (non-greedy) until "B>" then optional whitespace and a "?"
        char prefix = queryCom.charAt(0);
        String regex = String.format("%c>.*?%c>\\s*\\?", prefix, prefix);

        // Replace all occurrences of the pattern with an empty string
        String newData = data.replaceAll(regex, "");

        // Update the buffer with the modified data:
        // Clear its contents and append the new string
        input.setLength(0);
        input.append(newData);
    }
}
