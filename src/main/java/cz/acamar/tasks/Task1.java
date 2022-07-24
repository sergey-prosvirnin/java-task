package cz.acamar.tasks;

import cz.acamar.tasks.exception.NotValidStringException;

public class Task1 {
    private String sentence;

    /**
     * Task 1. Length of the last word.
     * <p>
     * Given a string s consisting of some words separated by some number of spaces,
     * return the length of the last word in the string.
     * <p>
     * A word is a maximal substring consisting of non-space characters only.
     * <p>
     * Example input: "Hello World"
     * Expected output: 5
     *
     * @param str - a string s consisting of some words separated by some number of spaces.
     * @return - the length of the last word in the string.
     */
    public int lengthOfLastWord(String str) {
        sentence = str;

        if (isNullPointerOrBlankString()) {
            throw new NotValidStringException("Getting null pointer or empty string!");
        }

        final String[] arrayOfWords = getArrayOfWords();
        final String lastElementOfArray = arrayOfWords[arrayOfWords.length - 1];

        return lastElementOfArray.length();
    }

    private boolean isNullPointerOrBlankString() {
        return sentence == null || sentence.isBlank();
    }

    private String[] getArrayOfWords() {
        return sentence.split("\\s");
    }
}
