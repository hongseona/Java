package day02;

public class B07MyCalculatorTest {
    public static void main(String[] args) {

        int data1;
        int data2;

        String temp = System.console().readLine("첫 번째 값: ");    // temp 는 문자열
        data1 = Integer.valueOf(temp);      // data1은 정수라서 temp 문자열을 Integer.value 로 변환해야 함.
        String temp2 = System.console().readLine("두 번째 값: ");   // temp2 도 문자열
        data2 = Integer.valueOf(temp2);

        System.out.println("add:" + MyCalculator.add(data1, data2));
        System.out.println("sub:" + MyCalculator.sub(data1, data2));
        System.out.println("mul:" + MyCalculator.mul(data1, data2));
        System.out.println("div:" + MyCalculator.div(data1, data2));
    
        // 지금 연습한 MyCalculator 클래스와 유사한 기능의 자바 클래스 Math 가 있습니다.
        System.out.println(Math.addExact(data1, data2));
        System.out.println(Math.subtractExact(data1, data2));
        System.out.println(Math.multiplyExact(data1, data2));
        System.out.println("min:" + Math.min(data1, data2));
        System.out.println("max:" + Math.max(data1, data2));
    }
}

class MyCalculator {

    // 4개 메소드는 int 형으로 return 해야함

    static int add(int a, int b) {
        return a + b;
    }
    static int sub(int a, int b) {
        return a - b;
    }
    static int mul(int a, int b) {
        return a * b;
    }
    static int div(int a, int b) {
        if (b == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;   // b가 0이면 임의 값 0을 리턴
        }
        return b / a;       // b 가 0 이면 오류(Exception. 예외) 발생 
    }

}
