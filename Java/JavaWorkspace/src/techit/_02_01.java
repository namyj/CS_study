package techit;

// 중-3 Stack 클래스 구현
/* 
 * 조건
 * - 생성자 default 10000, size 변환 가능
 * - push 메소드
 * - pop 메소드
 */

class Stack1 {
    int[] stack;
    int top;
    int size;

    Stack1() {
        stack = new int[10000];
        this.size = 10000;
        top = -1;
    }
   
    Stack1(int size) {
        stack = new int[size];
        this.size = size;
        top = -1;
    }

    public void push(int num) {
        // when stack is not full
        if (top < size-1) {
            stack[++top] = num;
        }
    }

    public int pop() {
        // when stack is not empty
        if (top > -1) {
            return stack[top--];
        } else {
            return -1;
        }
    }

    public int size() {
        return size;
    }

}    

public class _02_01 {
    public static void main(String[] args) {
        
        Stack1 st = new Stack1(5000);
        st.push(10);
        System.out.println(st.pop());
    
    }
}
