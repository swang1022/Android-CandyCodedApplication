///***
// * 862. Shortest Subarray with Sum at Least K
// * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
// *
// * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
// *
// * If there is no non-empty subarray with sum at least K, return -1.
// *
// *
// * Example 1:
// *
// * Input: A = [1], K = 1
// * Output: 1
// *
// *
// * Example 2:
// *
// * Input: A = [1,2], K = 4
// * Output: -1
// *
// *
// * Example 3:
// *
// * Input: A = [2,-1,2], K = 3
// * Output: 3
// *
// *
// * Note:
// *
// * 1 <= A.length <= 50000
// * -10 ^ 5 <= A[i] <= 10 ^ 5
// * 1 <= K <= 10 ^ 9
// */
//
//class Solution {
//    public int shortestSubarray(int[] A, int K) {
//        return withSliding(A, K);
//    }
//
//    public int withSliding(int[] A, int K) {
//
//        int len = A.length;
//        long[] prefixSum = new long[len + 1];
//
//        prefixSum[0] = 0;
//        for (int i = 0; i < len; i++) {
//            prefixSum[i + 1] = prefixSum[i] + A[i];
//        }
//
//        Deque<Integer> minQ = new ArrayDeque<>();
//        int minSubLen = len + 1;
//
//        for (int i = 0; i < len + 1; i++) {
//            long currSum = prefixSum[i];
//            while (!minQ.isEmpty() && currSum - prefixSum[minQ.peek()] >= K) {
//                int index = minQ.poll();
//                minSubLen = Math.min(minSubLen, i - index);
//            }
//
//            while (!minQ.isEmpty() && currSum  <= prefixSum[minQ.peekLast()]) {
//                minQ.pollLast();
//            }
//
//            minQ.offer(i);
//        }
//
//        return minSubLen == len + 1 ? -1 : minSubLen;
//    }
//}