package chap1;

public class BinarySearch {
    public static int rank(int[] arr, int key) {
        int low = 0;
        int hi = arr.length - 1;
        while(low < hi){
            int mid = (low + hi) / 2;
            if(arr[mid] < key) {
                low = mid;
            }else if(arr[mid] > key) {
                hi = mid;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6,7,10,23,33,45,50};
        int key = 10;
        System.out.println(rank(arr, key));
    }
}
