package Interface;

public class Main {
    public static void main(String[] args) {
        //인터페이스
        Interface_Animal dog = new Interface_ImplementsDog();
        Interface_Animal cat = new Interface_ImplementsCat();

        dog.makeSound(); // 출력: 멍멍
        cat.makeSound(); // 출력: 야옹

    }
}