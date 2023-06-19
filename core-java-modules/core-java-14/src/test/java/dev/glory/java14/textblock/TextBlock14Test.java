package dev.glory.java14.textblock;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TextBlock14Test {

    private final TextBlock14 block = new TextBlock14();

    @Test
    void no_new_line_test() throws Exception {
        // given
        String expected = "This is a long test which looks to have a newline but actually does not\n";

        // when

        // then
        assertThat(block.getIgnoredNewLines()).isEqualTo(expected);
    }

    @Test
    void ending_spaces_test() throws Exception {
        // given
        String expected = "line 1\nline 2        \n";

        // when

        // then
        assertThat(block.getEscapedSpaces()).isEqualTo(expected);
    }
}