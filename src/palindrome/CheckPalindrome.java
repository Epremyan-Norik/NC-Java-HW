package palindrome;

public class CheckPalindrome implements Palindrome {

    private CheckPalindrome() {
    }

    @Override
    public static boolean isPalindrome(int x) {
        x = Math.abs(x);
        Integer x_obj = new Integer(x);
        String x_str = x_obj.toString();

        System.out.println(x_str);

        return false;
    }
}
