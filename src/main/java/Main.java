import mai.lesson.MyClass;

public class Main
{
    public static void main(String[] args)
    {

        MyClass mc = new MyClass("hello");

        System.out.println(mc.getStr());
        mc.setStr("bye");
        System.out.println(mc.getStr());
        System.out.println(mc.concat(23));

    }
}