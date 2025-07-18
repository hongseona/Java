package day06;

public class C05ShapeParent {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(10, 20, 30, 40);
        s1.setColor("red");
        s1.draw();

        Shape s2 = new Triangle(7, 7, 10, 15);
        s2.setColor("blue");
        s2.draw();

        Shape s3 = new Circle(5, 6, 20,20);
        s3.setColor("green");
        s3.draw();

        // 부모 클래스로 객체 생성 가능
        Shape s4 = new Shape();
        // 너무 추상적인 객체 => 부모클래스는 객체 생성 못함

        // 자식클래스는 다른 객체를 만듭니다. 이 다른 객체를 부모 타입으로 참조했을때
        // 실제 객체의 타입 검사(객체 타입을 묻는 연산): instanceof 연산자

         System.out.println("rect instanceof Rectangle: " + (s1 instanceof Rectangle));
         System.out.println("rect instanceof Triangle: " + (s1 instanceof Triangle));
         System.out.println("rect instanceof Circle: " + (s1 instanceof Circle));

         // 사용할 모든 도형을 배열 자료구조에 저장하기 (예시)
         Shape[] shapes = new Shape[]{s1,s2,null,s3,null};  // 맨처음 초기화할때만 {s1,s2,null,s3,null} 가능
        //  shapes[0] = s1;

        // 모든 도형 중에 'Circle' 만 반지름을 지정해서 그리기: Circle 클래스는 radius 정의
        for(Shape sh : shapes) {        // sh = shapes[i] (i 값은 자동으로 증가)
            if(sh instanceof Circle) {
                System.out.println("원(circle) 입니다." + sh.toString());
                // setRedius 를 실행하기 위해 Circle 타입으로 캐스팅 해야합니다.
                // sh.setRadius() 는 객체는 Circle 타입이지만 현재 참조는 부모 타입이므로 실행 못함
                Circle temp = (Circle) sh; // 부모타입 변수를 자식타입으로 참조 x.
                temp.setRadius(40);
                temp.draw();

            }else{
                System.out.println("기타 도형 입니다." + sh.toString());
            }

        }
        // shapes를 다시 새로운 배열로 대입할떄는 반드시 shapes = new Shape[]{s1,s2,null,s3,null}
    }
}

class Shape {
    // 속성
    private int posX, posY;
    private int width;
    private int height;
    private String color;
    private int id;
    private static int count = 0;   // 도형 각자에 고유 번호 부여

    // 기본 생성자
    public Shape() {
        count++;    // 도형 생성될때마다 번호 증가 목적
        this.id = count;    // count 값을 id에 저장
        this.color = "black";
    }

    // 커스텀 생성자
    public Shape(int posX, int posY, int width, int height) {
        this();     // 기본 생성자를 불러옴
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public String getColor() {
        return color;
    }
    public int getId() {
        return id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // 기능
    public void move(int offsetX, int offsetY) {
        this.posX += offsetX;
        this.posY += offsetY;
    }
    public void resize(int offsetW, int offsetH) {
        this.width += offsetW;
        this.height += offsetH;
    }
    public double calcArea() {
        return 0;
    }
    public void draw() {
        System.out.println("도형 ID:" + id);
        System.out.println("위치: " + posX + "," + posY);
        System.out.println("크기: " + width + "x" + height);
        System.out.println("색상: " + color);
    }
}
// 사각형 자식클래스(사각형 넓이: 가로 * 세로)
class Rectangle extends Shape {
    public Rectangle(int posX, int posY, int width, int height) {
        super(posX, posY, width,height);
    }
    @Override
    public double calcArea() {
        return getWidth() * getHeight();
    }
    @Override
    public void draw() {
        super.draw();
        System.out.println("도형: 사각형");
        System.out.println("넓이: " + calcArea());
    }
}
// 삼각형 자식클래스(삼각형 넓이: (밑변 * 높이)/2)
class Triangle extends Shape {
    public Triangle(int posX, int posY, int width, int height) {
        super(posX, posY, width,height);    // 부모 클래스의 커스텀 생성자 호출
                                            // 인자의 형신, 개수는 일치
                                            // 위 식에서 super는 생략 불가
    }
    @Override
    public double calcArea() {
        return (getWidth() * getHeight()/2.0);  // 소수점까지 정확하게 나누려고 2.0 사용
    }
    @Override
    public void draw() {
        super.draw();
        System.out.println("도형: 삼각형");
        System.out.println("넓이: " + calcArea());
    }

}
// 원 자식클래스(원 넓이: π * 반지름의 제곱)
class Circle extends Shape {
    private int radius;

    public Circle(int posX, int posY, int width, int height) {
        super(posX, posY, width,height);
    }
    @Override
    public double calcArea() {
        double radius = getWidth()/2.0;     // width==height==diameter(원의지름). radius 구하기 위해 2.0으로 나눗셈
        return Math.PI * radius * radius;   // radius: 반지름
    }
    @Override
    public void draw() {
        super.draw();
        System.out.println("도형: 원");
        System.out.println("넓이: " + calcArea());
    }

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

}

