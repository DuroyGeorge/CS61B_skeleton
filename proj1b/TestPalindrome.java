import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("aaaaab"));
        assertTrue(palindrome.isPalindrome(""));
        CharacterComparator d = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", d));
        assertTrue(palindrome.isPalindrome("a", d));
        assertTrue(palindrome.isPalindrome("ab", d));
        assertTrue(palindrome.isPalindrome("b", d));
        assertFalse(palindrome.isPalindrome("racecar", d));
        assertFalse(palindrome.isPalindrome("noon", d));
        assertFalse(palindrome.isPalindrome("horse", d));
        assertFalse(palindrome.isPalindrome("rancor", d));
        assertFalse(palindrome.isPalindrome("aaaaab", d));
        assertTrue(palindrome.isPalindrome("", d));
    }
}
