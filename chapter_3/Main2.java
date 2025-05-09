package chapter_3;


class Foo {
    public void foo() {
        System.out.println("foo");
    }
}

public class Main2 {
    public static void main(String[] args) {

        Foo f = null;

        try {
            f.foo();
        } catch (Exception e) {
            f = new Foo();
        } finally {
            f.foo();
        }
    }
}