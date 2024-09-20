import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(permutations("", "abc"));
    }

    private static ArrayList<String> permutations(String p, String up) {

        if (up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        ArrayList<String> ans = new ArrayList<>();

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            ans.addAll(permutations(f + ch + s, up.substring(1)));
        }

        return ans;
    }
}
