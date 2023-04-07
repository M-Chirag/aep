package edu.berkeley.aep;

//Understands how to turn a string inside out
public class Recursion {
    private final String text;

    public Recursion(String text) {
        this.text = text;
    }

    public String reverse() {
        return reverseHelper(0);
    }

    private String reverseHelper(int i) {
        if (i == text.length()) {
            return "";
        }
        return reverseHelper(i + 1) + text.charAt(i);
    }

    public String reverseHelp() {
        var length = text.length();
        if (length == 0) {
            return "";
        }
        return text.charAt(length - 1) + new Recursion(text.substring(0, length - 1)).reverseHelp();
    }
}