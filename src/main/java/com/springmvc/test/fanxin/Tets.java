package com.springmvc.test.fanxin;
interface  Color {
    String   getColor();
}

enum Gli implements Color{
    RED("红色"), GREEN("绿色"),BLACK("黑色");
    private String title;
     private Gli(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return this.title;
    }
    @Override
    public String getColor() {
        return this.title;
    }
}

enum Sex{
    BOY("男"),GIILR("女");
    private  String result;
    private Sex(String  result){
        this.result = result;
    }
    @Override
    public  String toString(){
        return  this.result;
    }
}
class Person {
    private String name;
    private int age ;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}


public class Tets {
    public static  void main(String[] args){
/*        Message message = new  MeassageImpl();
        message.print("中国好男人");
        Integer data [] = new Integer[]{1,2,3,5,6};
        System.out.println(data.length);
        Integer datas [] = fun(8,89,789,797,8646,456);
        for (int string : datas){
            System.out.println(string);
        }*/
        for (Gli gg:Gli.values()) {
            System.out.println(gg.ordinal()+"=="+gg.name());
        }
        Color color = Gli.RED;
        System.out.println(color.getColor());
        System.out.println(Gli.RED);

        Person person = new Person("秦朗",26,Sex.BOY);
        System.out.println(person);
    }
    public static <T> T[] fun(T ...ts){
        System.out.println("================"+ts.length);
        return ts;

    }
}
