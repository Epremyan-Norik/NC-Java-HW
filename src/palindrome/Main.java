package palindrome;

public class Main {
    public static void main(String[] args) {

        int x = 0;
        if (args.length>0) {
            x = Integer.parseInt(args[0]);
        }


        CheckPalindrome checkPalindrome = new CheckPalindrome();

        System.out.format("Output: %s", checkPalindrome.isPalindrome(x));

    }
}
