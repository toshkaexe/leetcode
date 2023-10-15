package leetcode.demo;

import java.util.PriorityQueue;

public class LargestEmelemt {


    /*  Given an integer array nums and an integer k,
      return the kth largest element in the array.
      Note that it is the kth largest element in the sorted order, not the kth distinct element.
      Can you solve it without sorting?
      */
    public int findKthLargest(int[] nums, int k) {
        // Create a min heap (priority queue) with a capacity of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();

    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 43,5, 6, 4};
        int k = 2;
        LargestEmelemt solution = new LargestEmelemt();
        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
}
