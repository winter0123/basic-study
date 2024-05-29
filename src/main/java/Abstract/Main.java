package Abstract;


import Interface.Interface_Animal;
import Interface.Interface_ImplementsCat;
import Interface.Interface_ImplementsDog;

public class Main {
    public static void main(String[] args) {
        //추상클래스
        AbstractChildClass1 a1 = new AbstractChildClass1();
        a1.method02();
        a1.method01();

        AbstractChildClass1 a2 = new AbstractChildClass1();
        a2.method02();
        a2.method01();

    }
}