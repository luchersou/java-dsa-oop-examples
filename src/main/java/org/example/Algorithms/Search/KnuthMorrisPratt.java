package org.example.Algorithms.Search;

public class KnuthMorrisPratt {
    public int kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;
        while(i < text.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if(j == pattern.length()) return i - j;
            } else {
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }
        return -1;
    }
}
