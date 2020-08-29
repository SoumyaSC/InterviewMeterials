package Algorithms;

public class BinarySearch {
    public int binarySearchReturnIndex(int[] arr, int target, int begIndex, int endIndex){
        int index = -1;

        //SO exception, if you dont wrtite this if cond.
        if(endIndex>=begIndex) {
            //Step 1: Find middle
            int mid = (begIndex + endIndex) / 2;

            //Step 2: return index if target is there in mid
            if (target == arr[mid]) {
                return mid;
            } else {
                //Step 3: if target>mid value, search right; it is crucial to write mid+1 and mid-1 below, otherwise Stack Overflow Error
                if (target >= arr[mid]) {
                    index = binarySearchReturnIndex(arr, target, mid + 1, endIndex);
                }
                //Step 4: search left
                else {
                    index = binarySearchReturnIndex(arr, target, begIndex, mid - 1);
                }
            }
        }
        return index;
    }
}
class BinarySearchDriver{
    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 40, 51, 60, 90};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearchReturnIndex(arr, 900, 0, arr.length-1);
        System.out.println(index);
    }
}
