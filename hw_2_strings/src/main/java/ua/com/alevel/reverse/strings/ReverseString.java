package ua.com.alevel.reverse.strings;

import java.util.stream.Stream;

public final class ReverseString {
    private ReverseString() {
    }

    public static String reverse(String src) {

        String resultString = Stream.of(src.split(" "))
                .map(ReverseString::reverseString)
                .reduce((a, w) -> a + " " + w).get();
        return resultString;
    }

    public static String reverse(String src, String dest) {
        return src.replace(dest, reverse(dest));
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        String startSubstring = src.substring(0, firstIndex);
        String lastSubstring = src.substring(lastIndex + 1, src.length());
        String substring = src.substring(firstIndex, lastIndex + 1);

        return startSubstring + reverse(substring) + lastSubstring;
    }


    private static String reverseString(String str) {
        return str.chars().mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }
}
