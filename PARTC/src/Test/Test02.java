package Test;

public class Test02 {

}
/*
 * Java_문제_5.md
 * 
 * 문1
 * -> 4번
 * 
 * 문2
 * -> 3번
 * 설명: ① 인터페이스의 변수는 자동으로 public static final이다 -> 이 과정으로 상수가 됨
 * 
 * 문3
 * -> 1번
 * 설명: default 메소드는 꼭 재정의할 필요 없음
 * public class Test {
    public static void main(String[] args) {
    // 익명 클래스로 인터페이스 구현. 익명 클래스로 객체 생성
        Flyable bird = new Flyable(){
        };
        bird.fly();
    }
 * 
 * 문4
 * -> 3번
 * 설명: 인터페이스(interface)에서는 public만 가능
 * 설명: class E extends A, B { } -> 클래스는 다중상속할 수 없음
 * 
 * 문5
 * -> 4번
 * 
 * 문6
 * -> class 키워드 앞에, 그리고 2개의 추상메소드 선언 void 앞에 abstract 키워드 생성 필요
 * 
 * 문7
 * -> default -> 반드시 재정의 하지 않아도 되는 메소드(일반적인 접근권한 default 와는 다른 의미임)
 * 
 * 문8
 * -> void read(), Writable
 * 
 * 문9
 * -> 3번
 * 설명: ① compareTo() 메서드는 boolean 타입을 반환한다(x) -> 참거짓이 아닌, -1,0,1 값으로 반환됨
 * 설명: ✅ 참고. 래퍼클래스에 두 값 비교를 하는 static 메소드가 있습니다 -> compare
 * 
 * 문10
 * -> 4번 -> ✅ 참고. 마커인터페이스: 인터페이스 내부에 상수도 메소드도 없는 인터페이스를 말함
 * 확인: 깊은복사와 얕은복사의 정의와 차이 확인해두기
 *  public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
 * 설명: Object의 clone()은 protected 이며 자식인 Person 이 접근 권한 변경함. 더 개방적인 public으로 변경 가능
 *  -> (protected를 public 으로) . 단, 반대로는 안됨.
 * 
 * 문11
 * ->
 * 
 * 문12
 * -> deep copy는 참조값 속성일 떄, 참조값을 복사하지 않고 객체 자체를 생성하여 복사
 *    shallow copy는             , 참조값(주소)를 복사합니다 -> 일발적인 clone() 의 동작
 * 
 * 문13
 * ->왼쪽 위부터. o,x,o
 * 
 * 문14
 * -> o,x,o
 * 
 *  
 * 
 */