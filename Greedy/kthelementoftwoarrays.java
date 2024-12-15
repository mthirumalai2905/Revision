class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length, m = b.length, i = 0, j = 0;
        while (i < n && j < m) {
            if (--k == 0) return a[i] < b[j] ? a[i++] : b[j++];
            if (a[i] < b[j]) i++;
            else j++;
        }
        return i < n ? a[i + k - 1] : b[j + k - 1];
    }
}
