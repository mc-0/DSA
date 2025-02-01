package patterns.modifiedbinarysearch;
// Time: O(logN)
//Space: O(1)
// 34. Find First and Last Position of Element in Sorted Array
public class NumberRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        result[0] = search(arr, key, false);
        if (result[0] != -1) // no need to search, if 'key' is not present in the input array
            result[1] = search(arr, key, true);
        return result;
    }

    // modified Binary Search
    private static int search(int[] arr, int key, boolean findMaxIndex) {
        int keyIndex = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { // key == arr[mid]
                keyIndex = mid;
                if (findMaxIndex)
                    start = mid + 1; // search ahead to find the last index of 'key'
                else
                    end = mid - 1; // search behind to find the first index of 'key'
            }
        }
        return keyIndex;
    }
}
