class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int start = low;
        int end = high;

        while (start <= end) {
            while (start <= high && arr[start] <= pivot) start++;
            while (arr[end] > pivot) end--;

            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        // Swap pivot into correct position
        int temp = arr[low];
        arr[low] = arr[end];
        arr[end] = temp;

        return end;
    }
}
