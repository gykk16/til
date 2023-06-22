package dev.glory.oop.polymorphism;

import lombok.Getter;
import lombok.Setter;

/*
GenericFile 은 TextFile, ImageFile 의 부모 클래스이다.
TextFile 이 될수도 있고, ImageFile 이 될수도 있다.
 */
@Getter
@Setter
public class GenericFile {

    private String name;
    private byte[] content;

    public String getFileInfo() {
        return "Generic File Impl";
    }

}
