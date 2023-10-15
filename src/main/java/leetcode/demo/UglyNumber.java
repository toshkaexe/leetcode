package leetcode.demo;

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false; // Negative numbers and 0 are not considered ugly.
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;


    }

    public static void main(String[] args) {

        UglyNumber solution = new UglyNumber();

        System.out.println(solution.isUgly(6)); // Output: true
        System.out.println(solution.isUgly(1)); // Output: true
        System.out.println(solution.isUgly(14)); // Output: false
    }
}
