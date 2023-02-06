package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class L003_LongestSubstringWithoutRepeatingCharacters_022Test {

    @Test
    void testLengthOfLongestSubstring() {
        assertEquals(1, L003_LongestSubstringWithoutRepeatingCharacters_022.lengthOfLongestSubstring("s"));
        assertEquals(3,
                     L003_LongestSubstringWithoutRepeatingCharacters_022.lengthOfLongestSubstring("pkwwkew"));
        assertEquals(1, L003_LongestSubstringWithoutRepeatingCharacters_022.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3,
                     L003_LongestSubstringWithoutRepeatingCharacters_022.lengthOfLongestSubstring("abcabcbb"));
    }
}
