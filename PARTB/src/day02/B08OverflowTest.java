package day02;

public class B08OverflowTest {

    public static void main(String[] args) {
        System.out.println("데이터 타입별 크기");
        System.out.println("int: " + Integer.SIZE + "비트, " + Integer.BYTES + "바이트");
        System.out.println("int: " + Integer.MIN_VALUE + "~ " + Integer.MAX_VALUE);
        // int: -2147483648~ 2147483647
        System.out.println("long: " + Long.SIZE + "비트, " + Long.BYTES + "바이트");
        System.out.println("long: " + Long.MIN_VALUE + "~ " + Long.MAX_VALUE);
        // long: -9223372036854775808~ 9223372036854775807

        int a = 2147483647;
        int b = a + 1;      // 표현의 범위가 넘어감(초과): overflow
        System.out.println("b=" + b);   // -2147483648. 기대값과 다릅니다.

        long c = a + 1L;         // a + 1 은 둘다 int이므로 int 계산, a + 1L 와 같이 적어도 하나는 long 데이터로 해야합니다.
        // 리터럴: Long 연산에 대해서는 숫자 뒤에 'L'을 붙인다.
        // 적어도 하나가 Long 이라면 Long 타입으로 연산한다.
        System.out.println("long c=" + c);

        System.out.println("Math.addExact(a,1L): " + Math.addExact(a, 1L)); 
        System.out.println("Math.addExact(a,1): " + Math.addExact(a, 1));   // 예외 발생
    }
}
