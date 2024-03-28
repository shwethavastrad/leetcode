public class Solution {
    public final static int d = 256;
    public int strStr(String haystack, String needle) {
        int q = 101;
        int M = needle.length();
        int N = haystack.length();
        if(M == 0)
            return 0;
        if (N < M)
            return -1;
        int i, j;
        int p = 0; // hash value for needle
        int t = 0; // hash value for haystact
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of needle and first
        // window of haystack
        for (i = 0; i < M; i++) {
            p = (d * p + needle.charAt(i)) % q;
            t = (d * t + haystack.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of
            // haystack and needle. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M)
                    return i;
            }

            // Calculate hash value for next window of haystack:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - haystack.charAt(i) * h)
                        + haystack.charAt(i + M))
                        % q;

                // We might get negative value of t,
                // converting it to positive by adding a random prime
                if (t < 0)
                    t = (t + q);
            }
        }

        return -1;
    }
}