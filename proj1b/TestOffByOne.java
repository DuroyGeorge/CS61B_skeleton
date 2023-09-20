import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));  // true
        assertTrue(offByOne.equalChars('r', 'q'));  // true
        assertFalse(offByOne.equalChars('a', 'e'));  // false
        assertFalse(offByOne.equalChars('z', 'a'));  // false
        assertFalse(offByOne.equalChars('a', 'B'));  // false
        assertFalse(offByOne.equalChars('A', 'b'));  // false
        assertTrue(offByOne.equalChars('A', 'B'));  // true
        assertFalse(offByOne.equalChars('A', 'a'));  // false
        assertFalse(offByOne.equalChars('a', 'A'));  // false
        assertFalse(offByOne.equalChars('a', 'B'));  // false
        assertFalse(offByOne.equalChars('B', 'a'));  // false
        assertTrue(offByOne.equalChars('B', 'A'));  // false
        assertFalse(offByOne.equalChars('a', 'c'));  // false
        assertFalse(offByOne.equalChars('c', 'a'));  // false
        assertFalse(offByOne.equalChars('A', 'C'));  // false
        assertFalse(offByOne.equalChars('C', 'A'));  // false
    }

    @Test
    public void testNonAlphabeticCharacters() {
        assertTrue(offByOne.equalChars('!', '\"'));  // true
        assertTrue(offByOne.equalChars('1', '2'));  // true
        assertTrue(offByOne.equalChars('#', '$'));  // true
        assertTrue(offByOne.equalChars('%', '&'));  // true
        assertTrue(offByOne.equalChars('&', '\''));  // true
        assertFalse(offByOne.equalChars('-', '+'));  // true
        assertTrue(offByOne.equalChars('?', '@'));  // true
        assertTrue(offByOne.equalChars('*', '+'));  // true
        assertTrue(offByOne.equalChars('`', 'a'));  // true
        assertTrue(offByOne.equalChars(':', ';'));  // true
    }

    @Test
    public void testWhitespaceCharacters() {
        assertFalse(offByOne.equalChars(' ', '\t'));  // true
        assertTrue(offByOne.equalChars('\t', '\n'));  // true
        assertFalse(offByOne.equalChars('\n', '\r'));  // true
        assertFalse(offByOne.equalChars('\r', ' '));  // true
    }

    @Test
    public void testMixedCharacters() {
        assertFalse(offByOne.equalChars('a', '!'));  // true
        assertFalse(offByOne.equalChars('A', '2'));  // true
        assertFalse(offByOne.equalChars(' ', 'B'));  // true
        assertFalse(offByOne.equalChars('\t', 'a'));  // true
        assertFalse(offByOne.equalChars('\n', 'R'));  // true
        assertFalse(offByOne.equalChars('\r', '3'));  // true
        assertTrue(offByOne.equalChars('=', '<'));  // true
        assertTrue(offByOne.equalChars('>', '?'));  // true
        assertFalse(offByOne.equalChars(',', '.'));  // true
        assertFalse(offByOne.equalChars('-', '/'));  // true
        assertTrue(offByOne.equalChars(';', ':'));  // true
        assertTrue(offByOne.equalChars('?', '>'));  // true
        assertFalse(offByOne.equalChars('.', ','));  // true
        assertFalse(offByOne.equalChars('/', '-'));  // true
    }
}
