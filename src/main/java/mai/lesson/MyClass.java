package mai.lesson;

public class MyClass
{
    private String str;

    public MyClass(String str)
    {
        this.str = str;
    }

    public String getStr()
    {
        return this.str;
    }

    public void setStr(String str)
    {
        this.str = str;
    }

    public String concat(Integer num)
    {
        return this.str.toUpperCase() + String.valueOf(num);
    }
}
