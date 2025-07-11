package day03;

public class B16Static_InstanceQuiz {

    public static void main(String[] args) {
        Counter c1 = new Counter();
        System.out.println(Counter.getCount());     // 
        Counter c2 = new Counter();
        System.out.println(Counter.getCount());     // 
        Counter c3 = new Counter();
        System.out.println(Counter.getCount());     // 
        Counter c4 = new Counter();        
        System.out.println(Counter.getCount());     // 
        System.out.println(Counter.getCount());     // 

    }
}
/*
 * Counter.getCount() => 이 코드로 알 수 있는 내용은?
 *          getCount() 메소드는 1) static 이다.
 *                             2) () 안에 값이 없다. => 인자로 전달할 입력이 없다.
 */

 // 이 코드는 Count 객체가 몇 번 생성되었는지 알아내는 방법입니다.
 // --- static 이 저장되는 메모리 영역은 공유 영역입니다.
//  --- static 메소드는 static 변수 또는 메소드 
class Counter{
    private static int count = 0;
    private int num;    // Counter 객체의 필드. 인스턴스 변수

    public Counter(){
        // 생성자 메소드 - new 연산할 때 실행. 리턴이 없다. 반드시 클래스 이름과 똑같이 해야 함
        count++;
        num++;

    }
    // count 값을 리턴하는 getter 만들기 => 리턴 타입이 int
    public static int getCount(){       // 2) 인자로 선언하는 변수 없음.
        return count;

    }

    public int getNum(){
        return this.num;
    }
}
