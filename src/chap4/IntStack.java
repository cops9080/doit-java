package chap4;

public class IntStack {
    private int[] stk;  // 푸시된 데이터를 저장하는 스택용 배열, 가장 먼저 푸시된 데이터 = stk[0]
    private int capacity;   // 스택의 용량(스택에 쌓을 수 있는 최대 데이터 수)
    private int ptr;    // 스택에 쌓여있는 데이터 수를 나타내는 필드, 스택이 비어있으면 0, 가득 차있으면 capacity값과 같다.

    // 스택이 비어있는 예외
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }
    // 스택이 가득 차있는 예외
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    // 생성자
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity]; // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException{
        if (ptr >= capacity) { // 스택이 가득차면 예외를 던짐
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)   // 스택이 비어있는데 pop을 시도하면 예외를 던진다.
            throw new EmptyIntStackException();
        return stk[ptr--];
    }
    // 가장 위에 있는 데이터를 들여다보는 메서드, 스택에서 꺼내지는 않는다. => 스택 포인터(ptr)의 변화는 없음
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr-1];
    }
    public void clear() {   // 스택을 비우는 메서드
        ptr = 0;
    }
    public int indexOf(int x) {
        for (int i=ptr-1; i>=0; i--) { // 꼭대기 부터 선형 검색
            if (stk[i] == x)
                return i; // 검색 성공
        }
        return -1; // 검색 실패
    }
    public int getCapacity() {
        return capacity;
    }
    // 스택에 쌓여있는 데이터 개수를 반환
    public int size() {
        return ptr;
    }
    // 스택이 비어있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }
    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptr >= capacity;
    }
    // 스택안의 모든 데이터를 바닥 -> 꼭대기 순으로 출력
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i=0; i<ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
