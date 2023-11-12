package mai.lesson;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {
    private String str;

    public MyClass(String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String concat(Integer num) {
        return this.str.toUpperCase() + String.valueOf(num);
    }
}
