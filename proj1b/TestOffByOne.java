import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        CharacterComparator offByOne = new OffByOne();
        assertTrue(offByOne.equalChars('a', 'b'));  // true
        assertTrue(offByOne.equalChars('r', 'q'));  // true
        assertFalse(offByOne.equalChars('a', 'e'));  // false
        assertFalse(offByOne.equalChars('z', 'a'));  // false
        assertFalse(offByOne.equalChars('a', 'B'));  // false
        assertFalse(offByOne.equalChars('A', 'b'));  // false
        assertTrue(offByOne.equalChars('A', 'B'));  // True
        assertFalse(offByOne.equalChars('A', 'a'));  // false
        assertFalse(offByOne.equalChars('a', 'A'));  // false
        assertFalse(offByOne.equalChars('a', 'B'));  // false
        assertFalse(offByOne.equalChars('B', 'a'));  // false
        assertTrue(offByOne.equalChars('B', 'A'));  // false
        assertFalse(offByOne.equalChars('a', 'c'));  // false
        assertFalse(offByOne.equalChars('c', 'a'));  // false
        assertFalse(offByOne.equalChars('A', 'C'));  // false
        assertFalse(offByOne.equalChars('C', 'A')); // false
    }
}
