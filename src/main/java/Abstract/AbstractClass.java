package Abstract;

//추상클래스
public abstract class AbstractClass {
    Integer num;
    String str;

    void method01(){
        System.out.println("메소드1  실행");
    }

    abstract void method02(); //추상클래스를 사용하기 위해서는 가장 위 class 선언부에도 abstract를 선언해줘야함
}
