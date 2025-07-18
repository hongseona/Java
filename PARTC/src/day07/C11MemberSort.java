package day07;

import java.util.Arrays;

public class C11MemberSort {
    public static void main(String[] args) {
        int[] numbers = {7,9,5,8,3};
        String[] names = {"momo","nayeon","dahyeon","sana","apple"};

        Arrays.sort(numbers);
        System.out.println("numbers 정렬 후: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("numbers 정렬 후: " + Arrays.toString(numbers));

        Member[] members = new Member[4];
        members[0]=new Member("hana", 23);
        members[1]=new Member("mina", 29);
        members[2]=new Member("jena", 30);
        members[3]=new Member("vana", 19);

        Arrays.sort(members);   // ⚡⚡Comparable 인터페이스 사용(구현)한 객체의 배열만 sort() 가능함
        for(Member m: members)
            m.print();
}
}
