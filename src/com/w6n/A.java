package com.w6n;

public class A {

    public class B{

    }

    public static class C{

    }

    public static void main(String[] args) {
        A.B b = new A().new B();

        A.C c = new A.C();

        new AAA(){

        };
    }

}
