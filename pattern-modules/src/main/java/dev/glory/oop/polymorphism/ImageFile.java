package dev.glory.oop.polymorphism;

import lombok.Getter;
import lombok.Setter;

/*
GenericFile 클래스를 확장하고 getFileInfo() 메서드를 오버라이드할 수 있다.
 */
@Getter
@Setter
public class ImageFile extends GenericFile {

    private int height;
    private int width;

    @Override
    public String getFileInfo() {
        return "Image File Impl";
    }

}
