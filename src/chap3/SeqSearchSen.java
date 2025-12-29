package chap3;

import java.util.Scanner;

// 선형 탐색 : 보초법 이용
public class SeqSearchSen {
    static int seqSearchSen(int[] a, int n, int key){
        int i = 0;

        a[n] = key; // 배열의 맨 끝에 찾고자 하는 요소와 같은 보초를 둠

        while(true){
            if(a[i] == key){
                break;
            }
            i++;
        }
        return i == n ? -1 : i; // 마지막 인덱스(보초)이면 -1을 반환(요소를 찾지 못했다는 뜻), 그렇지 않으면 인덱스를 반환한다
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num+1];

        for (int i = 0; i < num; i++) {
            System.out.print("x["+i+"]: ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값: ");
        int ky = sc.nextInt();

        int idx = seqSearchSen(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x["+idx+"]에 있습니다.");
    }
}
