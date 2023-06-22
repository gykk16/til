package dev.glory.oop.polymorphism;

import lombok.Getter;
import lombok.Setter;

/*
동일한 메서드 이름이 다른 메서드 시그니처를 가지고 있고
다른 기능을 수행하는 것을 의미한다.
    read()
    read(int limit)
    read(int start, int stop)
 */
@Getter
@Setter
public class TextFile extends GenericFile {

    public String read() {
        return this.getContent()
                .toString();
    }

    public String read(int limit) {
        return this.getContent()
                .toString()
                .substring(0, limit);
    }

    public String read(int start, int stop) {
        return this.getContent()
                .toString()
                .substring(start, stop);
    }
}
