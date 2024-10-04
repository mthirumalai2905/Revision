import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String str = "Abcdef";
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        backtrack(chars, 0, result);
        System.out.println(result);
    }

    private static void backtrack(char[] chars, int start, List<String> result) {
        if (start == chars.length) {
            result.add(new String(chars));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            backtrack(chars, start + 1, result);
            swap(chars, start, i); 
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
