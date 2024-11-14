
class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low < high){
            int pi = partition(arr, low, high);
            
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        int pi = arr[low];
        int start = low;
        int end = high;
        
        while(start < end){
            while(start < high && arr[start] <= pi){
                start++;
            }
            while(end > low && arr[end] > pi){
                end--;
            }
            if(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        
        arr[low] = arr[end];
        arr[end] = pi;
        
        return end;
    }
}
