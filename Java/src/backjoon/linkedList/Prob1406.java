package backjoon.linkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 접근법
 * - 문자열, 커서 포인터 사용 > 오답
 * - 연결 리스트 > 시간 초과
 * - 연결 리스트, ListIterator > 정답
 */
public class Prob1406 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // String inStr = sc.nextLine();
        // int cursor = inStr.length(); // 커서 초기값 : 입력 문자열 뒤
        // int nVal = Integer.parseInt(sc.nextLine());
        //
        // for (int i = 0; i < nVal; i++) {
        //     String command = sc.nextLine();
        //
        //     if (command.charAt(0) == 'L') {
        //         cursor = (cursor > 0 ? cursor-- : cursor);
        //     } else if (command.charAt(0) == 'D') {
        //         cursor = (cursor < inStr.length() ? cursor++ : cursor);
        //     } else if (command.charAt(0) == 'B' && cursor > 0) {
        //         cursor--;
        //         inStr = inStr.substring(0, cursor) + inStr.substring(cursor + 1, inStr.length());
        //     } else if (command.charAt(0) == 'P') {
        //         inStr = inStr.substring(0, cursor) +  command.split(" ")[1] + inStr.substring(cursor, inStr.length());
        //         cursor++;
        //     }
        // }
        //
        // System.out.printf("%s", inStr);

    }


    /**
     * 해결 방법 - 연결 리스트 사용 > 시간 초과
     * 시간 초과 이유?
     * - 연결 리스트의 add, remove 동작 원리
     *  연결 리스트에서 원소의 위치를 접근할 때 링크를 타고 해당 원소 위치까지 이동 -> O(n)
     *  그래서 시간초과 발생
     * 시간초과 해결 방법?
     * - ListIterator<E>
     *  기존 연결 리스트의 add, remove와 다르게 iterator의 위치에서 시작할 수 있음
     * [참고 - https://catnap-jo.tistory.com/105]
     */
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inStr = br.readLine();
        int nVal = Integer.parseInt(br.readLine());

        // 1. 문자열 > 연결 리스트
        LinkedList<Character> list = new LinkedList<Character>();

        for (int i = 0; i < inStr.length() ; i++) {
            list.add(inStr.charAt(i));
        }

        int cursor = list.size();

        // 2. 커서를 이동하며 명령 수행
        for (int i = 0; i < nVal ; i++) {
            String comman = br.readLine();

            switch(comman.charAt(0)) {
                case 'L': // 커서 좌측으로 한 칸 이동 = 연결 리스트 인덱스 한칸 이동
                    if (cursor > 0) {
                        cursor--;
                    }
                    break;
                case 'D': // 커서 우측으로 한칸 이동 = 연결 리스트 인덱스 한칸 이동
                    if (cursor < list.size()) {
                        cursor++;
                    }
                    break;
                case 'B': // 커서 왼쪽 원소 삭제 후 커서 왼쪽으로 한 칸 이동 = 연결 리스트 원소 삭제(remove) 후, 인덱스 한칸 이동
                    if (cursor > 0) {
                        list.remove(cursor - 1);
                        cursor--;
                    }
                    break;
                case 'P': // 커서 왼쪽에 원소 삽입 후 커서 오른쪽으로 한 칸 이동 = 연결 리스트 원소 삽입(add) 후, 인덱스 한칸 이동
                    list.add(cursor, comman.charAt(2));
                    cursor++;
                    break;
                default:
                    break;
            }
        }

        // 3. 결과 출력
        for (Character chr : list) {
            bw.write(chr);
        }
        bw.flush();

        br.close();
        bw.close();
    }

    /**
     * 해결방법 - ListIterator<E> 이용
     * - iter.add()를 이용할 경우, 커서의 위치가 자동으로 추가한 요소에 위치하게 된다.
     */
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문자열 > 연결 리스트
        String inStr = br.readLine(); // 각 문자로 쪼개기
        LinkedList<Character> list = new LinkedList<Character>();
        ListIterator<Character> iter = list.listIterator();

        for (int i = 0; i < inStr.length() ; i++) {
            iter.add(inStr.charAt(i));
        }

        // 2. 명령어 개수
        int nVal = Integer.parseInt(br.readLine());

        // 3. 명령어 수행
        for (int i = 0; i < nVal ; i++) {
            String comman = br.readLine();

            switch(comman.charAt(0)) {
                case 'L': // 커서 좌측으로 한 칸 이동 = 연결 리스트 인덱스 한칸 이동
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'D': // 커서 우측으로 한칸 이동 = 연결 리스트 인덱스 한칸 이동
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'B': // 커서 왼쪽으로 한 칸 이동하며 원소 삭제 = 연결 리스트 원소 삭제(remove) 후, 인덱스 한칸 이동
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove(); // previos()에 의해 최근에 반환된 요소를 리스트에서 제거
                    }
                    break;
                case 'P': // 커서 왼쪽에 원소 삽입 후 커서 오른쪽으로 한 칸 이동 = 연결 리스트 원소 삽입(add) 후, 인덱스 한칸 이동
                    iter.add(comman.charAt(2));
                    break;
                default:
                    break;
            }
        }

        // 3. 결과 출력
        for (Character chr : list) {
            bw.write(chr);
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
