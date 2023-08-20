package dev.glory.stream.foreach;

import java.util.List;

public class StreamForEach {


    List<String> list = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");

    public void forLoop() {
        for (String s : list) {
            System.out.println(s);
            if (s.equals("c")) {
                break;
            }
        }
    }

    public void streamForEach() {
        list.forEach(s -> {
            System.out.println(s);
            if (s.equals("c")) {
                return;
            }
        });
    }

    public static void main(String[] args) {
        StreamForEach streamForEach = new StreamForEach();
        streamForEach.forLoop();
        System.out.println("==>  = ");
        streamForEach.streamForEach();
    }

}
