package dev.glory.java14.textblock;

/*
https://www.baeldung.com/java-text-blocks
 */
public class TextBlock14 {

    public String getIgnoredNewLines() {
        return """
                This is a long test which looks to \
                have a newline but actually does not
                """;
    }

    public String getEscapedSpaces() {
        return """
                line 1
                line 2       \s
                """;
    }
}
