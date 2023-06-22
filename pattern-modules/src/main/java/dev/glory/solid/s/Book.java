package dev.glory.solid.s;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Book {

    private String name;
    private String author;
    private String text;


    /*
    Book 속성과 관련된 메서드들은 Book 클래스에 있어야 한다.
     */

    public String replaceWordInText(String word, String replacementWord) {
        return text.replaceAll(word, replacementWord);
    }

    public boolean isWordInText(String word) {
        return text.contains(word);
    }
}
