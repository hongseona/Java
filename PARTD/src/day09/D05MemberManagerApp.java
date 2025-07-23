package day09;

import java.util.ArrayList;
import java.util.List;

public class D05MemberManagerApp {
    public static void main(String[] args) {
  
        List<Member> list = new ArrayList<>();
        // list 초기화 메소드 실행
        initMemberList(list);   // list 변수 참조값 전달
        System.out.println("회원 관리 프로그램입니다.");
        boolean status = true;
        while (status) {  // status: 반복실행을 제어하는 boolean 변수. 계속 실행할지 종료할지 결정하는 스위치 역할
          // while: 조건이 참인 동안 반복해서 코드 블록을 실행하게 하는 제어문
          System.out.println("\n작업 메뉴를 선택하세요.");
          System.out.println("[A] 회원 추가  [R] 회원 삭제   [U] 회원 포인트 변경" +
            "\n[S] 회원 목록   [N] 이름 조회   [E] 종료");
          // "\n 은 줄바꿈(이스케이프 언어)"  
          String menu = System.console().readLine("선택 >>> ");
        
          switch (menu.toUpperCase()) {
            case "A":
              addMember(list); // id, 이름 입력. point는 기본값 100
              break;
            case "N":
              String find = System.console().readLine("\t조회할 이름 입력 >>> ");
              for(int i=0; i <list.size(); i++){
                if(list.get(i).getName().contains(find)){   // 순서대로 인덱스 i의 데이터를 가져와서 gettet 이름 값이 contains(find)
                    System.out.println("\t"+i+": "+ list.get(i));
                    // contains(): 어떤 값이 String(문자열),Set/List등 (컬렉션) 안에 포함되어 있는지를 boolean값으로 검사하는 메서드
                }
              }  
              break;
            case "R":
                int index = Integer.parseInt(
                  System.console().readLine("삭제할 인덱스 입력 >>>>"));
                if(confirm("회원 삭제")) {
                    Member m = list.remove(index);      // 리턴값은 삭제한 index 위치의 데이터
                    System.out.println("\t삭제 데이터 확인: "+ m);
                }else {
                    System.out.println("\t삭제 취소합니다.");
                }
                  break;
            case "U":
              index = Integer.parseInt(
                  System.console().readLine("수정할 인덱스 입력 >>>>"));
                double point = Double.parseDouble(System.console().readLine("\t포인트 입력"));
                if(confirm("포인트 변경")) {
                    list.get(index).setPoint(point);
                    // ✅ index 의 객체를 가져와서 (Member타입) setter로 point 값 변경
                    System.out.println("\t업데이트 결과: " + list.get(index));
                }else{
                        
                }
                  break;
            case "S":
        
                  break;
            case "E":
              status = false;
                  break;
            default:
              System.out.println("잘못된 메뉴 선택입니다.");
                  break;
            }
        }
          
    }

    // 프로그램 실행할떄 마다 4개의 객체를 리스트에 저장하고 시작(목적: list 초기화)
    // 메소드 인자는 main 메소드의 ArrayList 객체의 주소를 저장(객체의 주소를 공유)
        private static void initMemberList(List<Member> list) {
        Member m1 = new Member(1,"김땡떙",135.4);
        Member m2 = new Member(2,"반하나",126.4);
        Member m3 = new Member(3,"최사과",104.2);
        Member m4 = new Member(4,"박모모",95.6);
        

        // 불변 객체 리스트가 메소드의 인자로 모든 요소를 가변 객체 list에 추가
        list.addAll(List.of(m1,m2,m3,m4));
        }

          private static void addMember(List<Member> list) {
            int id = Integer.parseInt(System.console().readLine("\t고객 id 입력 >>> "));
            String name = System.console().readLine("\t고객 이름 입력 >>> ");
            if (confirm("회원 등록")) {
              Member m = new Member(id, name, 100);
              list.add(m);
              System.out.println("\t등록회원 : " + m);
            } else {
              System.out.println("\t등록 작업을 취소하였습니다.");
            }
          }
        
          // 추가,삭제, 변경 작업 반영할 때 확인 받는 메시지 출력 메소드
          private static boolean confirm(String task) {
            String yn = System.console().readLine(task + " 을(를) 실행할까요?(확인:엔터, 취소:N) ");
            // 엔터를 누르면 참 리턴
            return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
          }
        
}


