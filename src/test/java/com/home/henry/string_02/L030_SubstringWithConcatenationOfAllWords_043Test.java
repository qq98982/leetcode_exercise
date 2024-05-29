package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class L030_SubstringWithConcatenationOfAllWords_043Test {

    @Test
    void testFindSubstring() {
        assertIterableEquals(new HashSet<>(Arrays.asList(0, 9)), new HashSet<>(
                L030_SubstringWithConcatenationOfAllWords_043.findSubstring("barfoothefoobarman", new String[] {
                        "foo", "bar"
                })));

        assertIterableEquals(new HashSet<>(Arrays.asList()), new HashSet<>(
                L030_SubstringWithConcatenationOfAllWords_043.findSubstring("wordgoodgoodgoodbestword",
                                                                            new String[] {
                                                                                    "word", "good", "best",
                                                                                    "word"
                                                                            })));
    }
}
