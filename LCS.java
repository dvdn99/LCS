//David Novizky & Miri Lipson

public class LCS {

    static void lcs(String X, String Y, int m, int n) {
        //table
        int[][] L = new int[m + 1][n + 1];

        //building the table like we learn at class
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }

        //in order to print LCS
        int index = L[m][n];
        int temp = index;

        //character array to store the lcs string
        char[] lcs = new char[index + 1];
        lcs[index] = ' ';

        int i = m, j = n;
        while (i > 0 && j > 0) {
            // if current character in X[] and Y are equal, then
            // current character is part of LCS
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                // put current character in result
                lcs[index - 1] = X.charAt(i - 1);

                // reduce i, j and index
                i--;
                j--;
                index--;
            }

            // if not equal, then find the larger of two and
            // go in the direction of larger value
            else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }

        // print lcs
        System.out.print("LCS of " + X + " and " + Y + " is ");
        for (int k = 0; k <= temp; k++)
            System.out.print(lcs[k]);
        System.out.print(" Length: " + temp);
    }

    //reverse string function
    public static String reverse(String word) {
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--)
            reverse = reverse + word.charAt(i);

        return reverse;
    }

    //main method
    public static void main(String[] args) {
        String X = "ABACADABRA";
        String Y = reverse(X);

        String Z = "BSASPSIRIPASA";
        String W = reverse(Z);


        int m = X.length();
        int n = Z.length();

        lcs(X, Y, m, m);
        System.out.println();
        lcs(Z, W, n, n);
    }
}


