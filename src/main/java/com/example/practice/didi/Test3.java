package com.example.practice.didi;

public class Test3 {
    Test2 test2 = new Test2();
    public void test() {
        try {
            test2.show();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}

class Test2 {
    public Test2() {
    }
    public void show() {
        try {
            throw new Exception();
        } catch (Throwable e) {
           // throw new Throwable();
        }
    }
}