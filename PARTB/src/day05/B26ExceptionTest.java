package day05;

import java.util.Arrays;

public class B26ExceptionTest {
    public static void main(String[] args) {
        B26ExceptionTest test = new B26ExceptionTest();

        try {
         test.inputNumber();        // 실행 중 오류가 생기면 catch 로 갑니다
            
        } catch (Exception e) {     // 예외 정보는 변수 e에 저장됩니다
            System.out.println("예외 발생: " + e.getMessage());
        }finally {
            // 정상 실행(try) 또는 비정상 실행(catch) 종료 후 정리 작업
            System.out.println("프로그램 종료합니다. 모든 자원을 해제합니다.");
            // XXXX.close()
        }
        // 0으로 나누는 예외 테스트
        test.divide(23, 10);
    }

    public void divide(int a, int b) {

    
    System.out.println(a / b);
}

    /*
     * 아래 3개의 메소드를 실행하면 Exception 이 발생합니다
     * 예외(Exception): 프로그램 실행이 비정상적인 상황을 만나서 프로그램이 비정상적 종료
     *          ㄴ 실행 중에 사용자의 잘못된 입력
     *          ㄴ 개발자가 예측 못한 상황 
     *          ㄴ 아래 3개의 예외는 실행 중에 발생하는 RuntimeException 종류
     *              (컴파일러가 예외 가능성을 모르는 예외. 컴파일러가 아는 예외는 빨간 밑줄로 표시됨)
     * 예외를 예상한다면 ... 개발자는 try{ }catch{ }finally{ } 구문 처리
     * 
     * ⚡Runtime 예외(컴파일러가 예측못한,모르는)는 try ~ catch(예외처리) 필수가 아님
     * ⚡Checked 예외(컴파일러가 예측한???)는 반드시 예외처리 해야 함.
     * 메소드 중에는 Checked 예외를 발생시키는 것들이 있습니다.
     * 특히 입출력 작업 메소드는 IOException 예외를 발생시킵니다
     * (대표적인 Checked 예외입니다)
     */
    public void inputNumber() {
        String temp = System.console().readLine("정수값 입력 >>> ");
        int num = Integer.parseInt(temp);  
        // 잘못된 문자(숫자 아닌것) 입력하면 java.lang.NumberFormatException (Exception: 예외) 
        // Integer.valueOf(temp) 도 실행가능
        System.out.println("입력값 + 1: " + (++num));
        // System.out.println("입력값 + 1: " + (num++));
    }


    public void indexException() {
        int[] nums = new int[5];
        nums[2] = 22;
        nums[5] = 55;   // java.lang.ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(nums));
    }

    public void nullPointer() {
        String message = null;  // message 변수에 참조되는 것이 없습니다.
        // 객체가 메소드 또는 속성 접근할 때, 객체가 null 이면 발생하는 예외
        System.out.println(message.toUpperCase());
        // java.lang.NullPointerException
    }
}
