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

    public void foo(byte[] in, byte[] out) {
        out = new byte[in.length];
        out[1] = in[0];
        out[0] = 5;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String concat(Integer num) {
        return this.str.toUpperCase() + String.valueOf(num);
    }

    public static class Inner {
        private int some;

        public Inner(int number) {
            this.some = number;
        }
    }
}
