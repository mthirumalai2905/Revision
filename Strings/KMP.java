public class KMPAlgorithm {

    // Function to preprocess the pattern and build the LPS array
    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] LPS = new int[m];
        int length = 0;  // Length of the previous longest prefix suffix
        int i = 1;

        // Build the LPS array
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                LPS[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = LPS[length - 1];  // Use the previous LPS value
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
        return LPS;
    }

    // Function to perform KMP search
    public static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] LPS = computeLPSArray(pattern);

        int i = 0;  // Index for text
        int j = 0;  // Index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = LPS[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // Mismatch occurs
                if (j != 0) {
                    j = LPS[j - 1];  // Skip comparisons based on LPS array
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        
        KMPSearch(text, pattern);
    }
}
