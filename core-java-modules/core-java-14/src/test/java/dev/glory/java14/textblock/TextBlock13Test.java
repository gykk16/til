package dev.glory.java14.textblock;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TextBlock13Test {

    private final TextBlock13 block = new TextBlock13();

    @Test
    void compare_old_multiline_test() throws Exception {
        // given
        String expected = "<html>\n"
                + "    <body>\n"
                + "        <span>example text</span>\n"
                + "    </body>\n"
                + "</html>\n";

        // when

        // then
        assertThat(block.getBlockOfHtml()).isEqualTo(expected);
    }

    @Test
    void compare_old_line_test() throws Exception {
        // given
        String expected = "<html>\n    <body>\n        <span>example text</span>\n    </body>\n</html>\n";

        // when

        // then
        assertThat(block.getBlockOfHtml()).isEqualTo(expected);
    }

    @Test
    void intident_test() throws Exception {
        // given
        String expected = "    Indent\n";

        // when

        // then
        assertThat(block.getNonStandardIndent()).isEqualTo(expected);
    }

    @Test
    void multiline_query_with_quotes_test() throws Exception {
        // given
        String expected = "select \"id\", \"user\"\n"
                + "from \"table\"\n";

        // when

        // then
        assertThat(block.getQuery()).isEqualTo(expected);
    }

    @Test
    void formmater_test() throws Exception {
        // given
        String expected = "Some parameter: test\n";

        // when

        // then
        assertThat(block.getFormattedText("test")).isEqualTo(expected);
    }
}