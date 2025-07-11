package day03;

// String 클래스의 인스턴스 메소드
//                      ㄴ 생성된 객체를 대상으로 실행하며 객체의 값에 따라 결과가 다름
public class B11StringInstanceMethod {

    public static void main(String[] args) {
        
        String message = "hello";
        // String temp = new String("hello");       //
        // String temp2 = "hello";

        // message 문자열 객체의 인스턴스 메소드(자바스크립트,파이썬 등 거의 유사)
        message = "hello~ java!!";      // 문자열을 구성하는 문자의 위치. 0부터 시작
        System.out.println(message);    // message.toString() 실행

        // 각 메소드가 어떤 형식의 데이터를 리턴하는가?
        // ⚡⚡ 인스턴스 메소드 실행으로 원래 문자열 객체의 상태가 변하지 않습니다.
        //              ㄴ 리턴 타입이 String인 경우, 새로운 문자열이 만들어집니다.

        System.out.println(message.length());                                        // int:13 공백도 lenght에 포함(카운트 됨)
        System.out.println(message.charAt(4));                              // (특정 위치의 문자 하나를 반환)
        System.out.println(message.toUpperCase());                                // String(문자열의 모든 소문자를 대문자로 변환해줌)
        System.out.println(message.indexOf("java"));                            // int(자바 문자/문자열이 시작되는 위치를 찾아줌)
        System.out.println(message.startsWith("hello"));                    // boolean(문자열이 특정 문자열로 시작하는지 확인해줌)
        System.out.println(message.endsWith("java"));                       // boolean(문자열이 특정 문자열로 끝나는지 확인해줌)
        System.out.println(message.replace("","*"));            // String(문자열 안의 문자 또는 문자열을 교체)
        System.out.println(message.substring(1,4));             // String(중간에서 추출.마지막 인덱스는 포함되지 않음)
        System.out.println(message.substring(3));                       // String(3번부터 끝까지 추출)
        System.out.println(message.lastIndexOf(""));                            // int(마지막 공백의 위치)
        System.out.println(message.indexOf("*"));                              // int(마지막 공백의 위치). 없는 문자열이면 -1을 출력
        System.out.println(message.concat("??"));                               // String(두개의 문자열을 합칠때)
        System.out.println(message.equals("hello~ java"));                  // boolean()
        //                                                                              ㄴ>> 리턴값들
        // 주의: 자바는 문자열 같은지 비교할 때 == 사용하면 안됩니다. (이유: 참조값을 비교)  -> equlas를 사용하여 비교해야 함
        // message는 불변객체

        // 위의 메소드를 다른 값으로 실행 시켜 보세요.
        String test = "";
        System.out.println(test.isBlank());     // test.lenght() >0, 공백만 있으면 true
        System.out.println(test.isEmpty());     // 문자열의 길이가 0 일떄 true

        // 정규식 패턴을 검사: 예시) 핸드폰 번호 010 - 숫자4자리 - 숫자4자리
        // 숫자는 \d를 사용해서 표기 ** 따옴표 안에서 입력해야 한다면 역슬래시를 2개 사용해줘야 함
        // 공백은 "스페이스+s" 사용 
        String regex = "^010-\\d{4}-\\d{4} $";
        String hpnum = "010-3456-9999";          // 011-345-6666

        System.out.println(hpnum.matches(regex));        // true   
        System.out.println("011-345-6666".matches(regex));      // false
        System.out.println("01033456666".matches(regex));       // false
        // - 기호를 선택적 혹은 없거나 한번 나오게 하려면 "?"를 입력
        System.out.println("01033456666".matches("^010-?\\d{4}-?\\d{4} $"));   // true

        String name = "김땡땡";          // 이름은 한글만 허용
        // 순서는 없고, 가능한 문자를 [] 기호 안에 나열, 범위는 a-z 또는 A-Z
        regex = "^[가-힣]{2,5}$";    // "^[가-힣]+$";
        System.out.println(name.matches(regex));    // true
        System.out.println("john".matches(regex));  // false
        // 영문자 검사
        System.out.println("john".matches("^[a-zA-Z\\s]+$"));   // true


    }
}
