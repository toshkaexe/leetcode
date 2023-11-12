package leetcode.demo.tasks;
/*
You are given a string s. You can convert s to a
palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.
Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: s = "abcd"
Output: "dcbabcd"

 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0;
        int n = s.length();

        // Find the longest palindromic prefix
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        // If the whole string is already a palindrome, return it as is
        if (i == n) {
            return s;
        }

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();

        // Add the reversed suffix in front of the original string
        return prefix + shortestPalindrome(s.substring(0, i)) + suffix;

   }

    public static void main(String[] args) {
        ShortestPalindrome solution = new ShortestPalindrome();

        System.out.println(solution.shortestPalindrome("aacecaaa")); // Output: "aaacecaaa"
        System.out.println(solution.shortestPalindrome("abcd"));      // Output: "dcbabcd"
    }

}
