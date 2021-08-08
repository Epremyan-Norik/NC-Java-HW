package palindrome;

public class CheckPalindrome implements Palindrome {

    CheckPalindrome() {
    }

    @Override
    public  boolean isPalindrome(int x) {
        x = Math.abs(x);
        if (x<10) return true;

        Integer x_obj = new Integer(x);
        String x_str = x_obj.toString();

        int half_size = x_str.length() / 2;
        if ((x_str.length()%2)!=0) {
            half_size++;
        }
        char[] str_char = x_str.toCharArray();

        for(int i=0; i<half_size; i++){
            if (str_char[i]!=str_char[str_char.length-1-i]) {
                return false;
            }
        }



        return true;
    }
}
