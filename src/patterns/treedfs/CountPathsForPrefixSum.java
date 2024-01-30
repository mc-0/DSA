package patterns.treedfs;

import datastructures.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CountPathsForPrefixSum {

    //Time: O(n)
    //Space: O(n)
    public static int countPaths(TreeNode root, int targetSum) {
        // A map that stores the number of times a prefix sum has occurred so far.
        Map<Integer, Integer> map = new HashMap<>();

        return countPathsPrefixSum(root, targetSum, map, 0);
    }

    public static int countPathsPrefixSum(TreeNode node, int targetSum, Map<Integer, Integer> map,
                                          Integer currentPathSum) {
        if (node == null)
            return 0;

        // The number of paths that have the required sum.
        int pathCount = 0;

        // 'currentPathSum' is the prefix sum, i.e., sum of all node values from the root to
        // the current node.
        currentPathSum += node.val;

        // This is the base case. If the current sum is equal to the target sum, we have
        // found a path from root to the current node having the required sum. Hence, we
        // increment the path count by 1.
        if (targetSum == currentPathSum)
            pathCount++;

        // 'currentPathSum' is the path sum from root to the current node. If within
        // this path, there is a valid solution, then there must be an 'oldPathSum' such that:
        // => currentPathSum - oldPathSum = targetSum
        // => currentPathSum - targetSum = oldPathSum
        // Hence, we can search such an 'oldPathSum' in the map from the key
        // 'currentPathSum - targetSum'.
        pathCount += map.getOrDefault(currentPathSum - targetSum, 0);

        // This is the key step in the algorithm. We are storing the number of times the
        // prefix sum `currentPathSum` has occurred so far.
        map.put(currentPathSum, map.getOrDefault(currentPathSum, 0) + 1);

        // Counting the number of paths from the left and right subtrees.
        pathCount += countPathsPrefixSum(node.left, targetSum, map, currentPathSum);
        pathCount += countPathsPrefixSum(node.right, targetSum, map, currentPathSum);

        // Removing the current path sum from the map for backtracking.
        // 'currentPathSum' is the prefix sum up to the current node. When we go back
        // (i.e., backtrack), then the current node is no more a part of the path, hence, w
        // e should remove its prefix sum from the map.
        map.put(currentPathSum, map.getOrDefault(currentPathSum, 1) - 1);

        return pathCount;
    }
}
