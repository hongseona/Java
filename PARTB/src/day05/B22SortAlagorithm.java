package day05;

import java.util.Arrays;

public class B22SortAlagorithm {
    public static void main(String[] args) {
    // 오름차순이라고 할때, 가장 작은 값을 순서대로 찾아서 앞에부터 놓기
    //	=> 선택 정렬이라고 함
    // 14, 36, 42, 15, 7, 9

    // i=0 부터 시작	j=i+1 ~5	         => i < j (비교)	거짓일때 값을 "교환"    
    // 첫번째: 7, 36, 42, 15, 14, 9

    // i=1부터 시작 	j=i+1 ~5 
    // 두번째: 7, 9, 42, 36, 15, 14

    // i=2부터 시작        j=i+2 ~5
    // 세번째: 7, 9, 14, 42, 36, 15

    // i=3부터 시작       j=i+3~5
    // 네번째: 7, 9, 14, 15, 42, 36

    // i=4부터 시작      j=i+4~5
    // 다섯번째: 7, 9, 14, 15, 36, 42

        int[] nums = {14, 36, 42, 15, 7, 9};

        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int temp;       //  변수의 값 교환을 위한 임시 변수
                if(nums[i]>nums[j]){
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
            System.out.println(String.format("i=%d %s", i, Arrays.toString(nums)));
        }

        // selectionSort 메소드 실행
        int[] nums2 = {88,45,23,78,56,99,84,55,78,34};
        selectionSort(nums2);
        System.out.println("num2 정렬 후: " + Arrays. toString(nums2));
    }

    private static void selectionSort(int[] arr){
    for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int temp;       //  변수의 값 교환을 위한 임시 변수
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            System.out.println(String.format("i=%d %s", i, Arrays.toString(arr)));
        }
    }
}

