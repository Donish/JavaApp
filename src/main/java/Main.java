import mai.lesson.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Main {
    private static void foo(byte[] arr) {
        arr[1] = 6;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.remove(2);

        byte[] array = new byte[2];
        array[0] = 1;
        array[1] = 2;

        MyClass myClass = new MyClass("hello");
        byte[] res = new byte[0];
        myClass.foo(array, res);

        System.out.println(res[0]);
        System.out.println(res[1]);

        MyClass.Inner some = new MyClass.Inner(23);

        SomeClass someClass = new SomeClass();

    }
}