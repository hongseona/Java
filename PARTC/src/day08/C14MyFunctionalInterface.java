package day08;

public class C14MyFunctionalInterface {
    public static void main(String[] args) {
        // ITestA 인터페이스 구현한 익명 클래스 정의
        ITestA ta = new ITestA() {
            @Override
            public void testa(String message) {
                System.out.println("testa: "+message);
            }
        };

        ta.testa("오늘은 신나는 금요일!!");

        ITestA ta2 = (message) -> System.out.println("testa: "+ message);
        // 인자의 타입 생략하고 (message) 작성 가능(오류 안나요)
        ta2.testa("굿바이~~");
        // ta2.testa(34);      // 오류: 인자 타입은 선언된 String 으로 해야함

        ITestC tc = new ITestC() {
            @Override
            public int testc(int a,int b) {
                // a =11;
                // b =22;
            }
        };
        ITestC tc2 = (a,b) -> a*b;  // return a*b; 명령 1개일 때는 return 생략 가능  
        int result = tc2.testc(11, 34);
        System.out.println("testc 실행 결과: "+result);

        ITestC tC3 = (a,b) -> {
            a+=11;
            b+=22;
            return a*b;

        };
        result = tc3.testc(11,34);
        System.out.println("tc3 실행 결과: "+result);
    }
}
/*
 * 자바의 인터페이스 중에는 인자(개수), 리턴값의 유무 등등에 따라
 * 다양한 형식의 인터페이스가 있음 : Consumer, Supplier, Function 등등
 * 특징: 추상메소드가 딱 1개만 있고, 정의되어있음. 이것을 다른 프로그래밍 언어의 함수처럼 사용
 * 
 * 함수형 인터페이스를 익명 클래스로 구현할때 람다식(자바스크립트에서 람다는 화삼표함수)을 주로 사용함
 * 
 *
 */
interface ITestA {
    void testa(String message);     // 인자 0, 리턴 X: Consumer(소비자)
}

interface ITestB {
    int testb();            // 인자 X, 리턴 0: Supplier (공급자)
}

interface ITestC {
    int testc(int a, int b);        // 인자 0, 리턴 0: Function(함수)
}