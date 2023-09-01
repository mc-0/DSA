package sorting;
// Builds on insertion sort, but starts by sorting fixed width gaps in the array (hth value)
// Gaps decrease on iteration, when reaching 1, typical insertion sort applies
// Worst case O(n^2) || Avg. O(n^3/2)
// In-Place, but not stable
public class ShellSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    int temp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = temp;
                }
            }
            h = h / 3;
        }
    }

}