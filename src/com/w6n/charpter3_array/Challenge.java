package com.w6n.charpter3_array;

public class Challenge {
    public static void main(String[] args) {
        int[] arr = {0,0,0, 2, 2,2,2,2,5,6,6,6};
        int len = remove(arr);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+",");
        }
    }

    public static int remove(int[] arr) {
        if (arr == null) return -1;
        if (arr.length <= 1) return arr.length;
        int slow = 0;
        int fast = 0;
        while (fast < arr.length){

            if(fast+1 == arr.length || arr[fast] != arr[fast+1]){
                arr[slow++] = arr[fast++];
            }else if(arr[fast] == arr[fast+1]){
                int t = arr[fast];
                while (fast < arr.length && arr[fast] == t){
                    fast++;
                }
            }
        }
        return slow;
    }
}
