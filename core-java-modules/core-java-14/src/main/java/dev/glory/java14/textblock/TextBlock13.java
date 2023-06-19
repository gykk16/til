package dev.glory.java14.textblock;

/*
https://www.baeldung.com/java-text-blocks
 */
public class TextBlock13 {

    public String getBlockOfHtml() {
        return """
                <html>
                    <body>
                        <span>example text</span>
                    </body>
                </html>
                """;
    }

    public String getNonStandardIndent() {
        return """
                    Indent
                """;
    }

    public String getQuery() {
        return """
                select "id", "user"
                from "table"
                """;
    }

    public String getTextWithCarriageReturns() {
        return """
                separated with\r
                carriage returns
                """;
    }

    public String getTextWithEscapes() {
        return """
                fun with\n
                whitespace\t\r
                and other escapes \"""
                """;
    }

    public String getFormattedText(String parameter) {
        return """
                Some parameter: %s
                """.formatted(parameter);
    }
}
