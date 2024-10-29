class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        Map<Integer, Integer> hm = new HashMap<>();
        int max = 1;
        for(int i = 0; i < arr.length; i++){
            if(hm.containsKey(arr[i] - difference)){
                dp[i] = Math.max(dp[i], dp[hm.get(arr[i]-difference)]+1);
                if(dp[i] > max){
                    max = dp[i];
                }
            }
            hm.put(arr[i], i);
        }
        return max;
    }
}
/* Only difference from LIS is that instead of searching for the prev element, just store the elements in a hashmap
 * and for every element check if the element - difference exists in the hashmap and then update the dp array.
 */