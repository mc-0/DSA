package patterns.monotonicstack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreatestElement {

    public int[] findNext(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                hm.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            hm.put(stack.pop(), -1);
        }

        for (int j = 0; j < nums1.length; j++) {
            answer[j] = hm.get(nums1[j]);
        }
        return answer;
    }
}