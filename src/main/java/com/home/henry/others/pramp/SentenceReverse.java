package com.home.henry.others.pramp;

/**
 * You are given an array of characters arr that consists of sequences of characters separated by space characters.
 * Each space-delimited sequence of characters defines a word.
 *
 */
public class SentenceReverse {
    static char[] reverseWords(char[] arr) {
        if (arr.length <= 1) {return arr;}

        int start = 0, end = 0;
        while (start < arr.length) {
            // skip spaces
            while (start < end || start < arr.length && arr[start] == ' ') {
                start++;
            }
            // skip non spaces
            while (end < start || end < arr.length && arr[end] != ' ') {
                end++;
            }
            // reverse the word
            reverse(arr, start, end - 1);
        }
        reverse(arr, 0, arr.length - 1);
        return arr;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a  b".toCharArray()));
    }

}