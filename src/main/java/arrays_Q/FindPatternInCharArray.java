package main.java.arrays_Q;
public class FindPatternInCharArray {

    public static void main(String[] args) {

        char[] array = {'a','a','a','a','c','d','a','e','f'};
        String pattern = "cda";

        int base = 26;
        int mod = 1_000_000_007; // large prime
        int len = pattern.length();

        // 1. Compute pattern hash
        long patternHash = 0;
        for (int i = 0; i < len; i++) {
            patternHash = (patternHash +
                    pattern.charAt(i) * pow(base, len - 1 - i, mod)) % mod;
        }
        System.out.println("Pattern Hash: " + patternHash);

        // 2. Compute first window hash
        long windowHash = 0;
        for (int i = 0; i < len; i++) {
            windowHash = (windowHash +
                    array[i] * pow(base, len - 1 - i, mod)) % mod;
        }

        long highestPower = pow(base, len - 1, mod);

        // 3. Sliding window
        for (int start = 0; start <= array.length - len; start++) {

            if (windowHash == patternHash) {
                // Verify to avoid collision
                boolean match = true;
                for (int j = 0; j < len; j++) {
                    if (array[start + j] != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("Pattern found at index " + start);
                }
            }

            // Slide the window
            if (start < array.length - len) {
                // Remove left character
                windowHash = (windowHash - array[start] * highestPower) % mod;
                if (windowHash < 0) windowHash += mod;

                // Shift left
                windowHash = (windowHash * base) % mod;

                // Add new character
                windowHash = (windowHash + array[start + len]) % mod;
            }
        }
    }

    // Fast power with mod
    static long pow(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
