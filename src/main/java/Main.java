import mai.lesson.MyClass;
import mai.lesson.MoneyExchange;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        MyClass mc = new MyClass("hello");
//
//        System.out.println(mc.getStr());
//        mc.setStr("bye");
//        System.out.println(mc.getStr());
//        System.out.println(mc.concat(23));

        String str = "5, 2, 4, 1, 3, 6";

        MoneyExchange service = new MoneyExchange();
        String res = "";
        try {
            res = service.exchange(10, "");
            System.out.println(res);
        } catch (Exception ex) {
            System.out.println("string error");
        }
    }
}