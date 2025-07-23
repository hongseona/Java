package test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerApp {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        initProductList(list);
        System.out.println("---- 상품 관리 프로그램입니다. ----");  // 1번
        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 상품 추가    [R] 상품 삭제    [U] 가격 변경\n"
                +"[L] 전체 상품 목록  [S] 상품 조회   [E] 종료");
                String menu = System.console().readLine("선택 >>> ");
                try {
                    switch (menu.toUpperCase()) {
                        case "A":
                            addProduct(list);
                            break;
                        case "R":
                            int index = Integer.parseInt(
                            System.console().readLine("\t삭제할 인덱스 입력 >>>>> "));   //2번    
                            if (confirm("삭제")) {
                                Pruduct p = list.remove(index);     // 3번
                                System.out.println("\t삭제 데이터: " + p); 
                            }else {
                                System.out.println("\t삭제를 취소했습니다.");
                            }

                            break;
                        case "U":
                            index = Integer.parseInt(System.console().readLine("\t수정할 인덱스 입력 >>>> "));
                            index = Integer.parseInt(
                             System.console().readLine("\t판매 가격 입력 >>>>> "));   // 4번   
                            if (confirm("가격 변경")) {
                                list.get(index).setPrice(price);    // 5번
                                System.out.println("\t업데이트 결과: "+ list.get(index));    // 6번
                            }else {
                                System.out.println("\t가격 변경을 취소했습니다.");
                            }
                            break;
                        case "L":
                            System.out.println("\t\t상품 리스트");
                            for (int i=0; i<list.size(); i++)   // 7번
                                System.out.println("\t"+1+": "+list.get(1));
                            break;
                        case "S":
                            String find = System.console().readLine("\t찾는 상품 제목 단어 입력 >>>> ");  // 8번
                            for (int i=0; i< list.size(); i++) {
                                // 모르겠다모르겠어    // 9번
                                if(p.getTitle().contains(find)) {
                                    System.out.println("\t"+i+": "+p);
                                }
                            }
                            break;
                        case "E":
                           status = false;    // 10번
                            break;
                    
                        default :
                            System.out.println("잘못된 메뉴 선택입니다.");
                            break;
                    }   // switch end
                }
                System.out.println("숫자만 입력하세요.");   // 11번 모르겠다 ㅇ몰라
        }
    }   // while end

}   // main end

private static void initProductList(List<Product> list) {
    Product p1 = new Product(1212, "LG그램", 345600.0);
    Product p2 = new Product(2499, "LG스탠바이", 190100.0);
    Product p3 = new Product(1213, "삼성OLED", 554500.0);
    Product p4 = new Product(4546, "바디프랜드", 632000.0);
    // 12번
}

private static void addProduct(List<Product> list) {
    // 13번
    String title = System.console().readLine("\t상품 제목 입력 >>>>> ");
    double price = Double.parseDouble(System.console().readLine("\t상품 가격 입력 >>>>>"));
    if (confirm("상품 등록")) {
        Product p = new Product(id,title,price);
        //14번
        System.out.println("\t등록 확인: "+ p);
    }else {
        System.out.println("\t등록 취소 했습니다.");
    }
}
private static boolean confirm(String task) {
    String yn = System.console().readLine(task + "을(를) 실행할까요?(확인:엔터, 취소:N)");
    return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
}
