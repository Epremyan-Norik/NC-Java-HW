package palindrome;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckPalindromeTest {

    @Test
    public void checkForZeroInput() {
        CheckPalindrome checkPalindrome = new CheckPalindrome();

        Assert.assertTrue(checkPalindrome.isPalindrome(0));
    }

    @Test
    public void checkForOddInput() {
        CheckPalindrome checkPalindrome = new CheckPalindrome();

        Assert.assertTrue(checkPalindrome.isPalindrome(15351));
    }

    @Test
    public void checkForEvenInput() {
        CheckPalindrome checkPalindrome = new CheckPalindrome();

        Assert.assertTrue(checkPalindrome.isPalindrome(153351));
    }

    @Test
    public void checkForNegativeInput() {
        CheckPalindrome checkPalindrome = new CheckPalindrome();

        Assert.assertTrue(checkPalindrome.isPalindrome(-153351));
    }


}