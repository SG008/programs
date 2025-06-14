public class SkipACharacter {
    public static void main(String[] args) {
//        skipCharacter("baccad", 'c', "");
        System.out.println(skipString("abcappledf","apple"));
    }

    private static void skipCharacter(String str, char c, String result) {

        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }

        if (str.charAt(0) == c) {
            skipCharacter(str.substring(1), c, result);
        } else {
            skipCharacter(str.substring(1), c, result + str.charAt(0));
        }
    }

    private static String skipString(String str, String s) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.startsWith(s)) {
            return skipString(str.substring(s.length()), s);
        }
        else {
            return str.charAt(0) + skipString(str.substring(1),s);
        }
    }
}
