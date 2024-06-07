package makeStack;

import java.util.Stack;

public class StackMake {
    int top;
    int[] intStack;

    public StackMake() {
        top = -1;
        intStack = new int[10];

        for(int i=0; i<intStack.length; i++){
            intStack[i] = -1;
        }

        Stack stack = new Stack();
    }

    public void push(int data) {

        // 스택에 데이터 추가
        if(isFull()) {
            //배열의 사이즈만큼 데이터가 꽉 차있는 경우
            System.out.println("stack is full");
            return;
        }

        //배열에 데이터 추가
        intStack[top+1] = data;

        //최상위 데이터 위치 1 증가
        top++;
    }

    public int pop() {

        // 스택에 데이터 꺼내기
        if(top == -1) {
            // 최상위 데이터가 없는 경우
            System.out.print("stack is empty : ");
            return -1;
        }

        int returnNum = intStack[top];
        intStack[top] = -1;

        top --;

        // 최상위 데이터를 꺼낸 후(배열의 맨 마지막 데이터 제거)
        return returnNum;
    }

    public int peek() {

        // 스택에 데이터 꺼내기
        if(top == -1) {
            // 최상위 데이터가 없는 경우
            System.out.print("stack is empty ");
            return -1;
        }
        return intStack[top];
    }


    public boolean isFull() {
        // 스택의 사이즈가 찼는지, 체크
        if(top == intStack.length-1) {
            return true;
        }
        else return false;
    }

    public String display() {
        for(int i=0; i<intStack.length; i++) {
            System.out.print(intStack[i] + " ");
        }
        return "";
    }
}

// 숫자 배열을 저장할 수 있는 변수
// 어디까지 저장했는지를 기억할 변수

// 생성자
//  숫자 10개 저장할 수 있는 배열을 생성해서 변수에 저장
//  어디까지 저장했는지를 기억할 변수에 -1을 저장

// push 기능
//    저장할 데이터를 전달받고
//    스택이 가득차 있지 않으면
//      top을 1증가하고 해당 인덱스 번호의 배열에 데이터 저장