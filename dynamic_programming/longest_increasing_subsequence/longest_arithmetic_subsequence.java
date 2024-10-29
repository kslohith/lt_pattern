class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][1000];
        int[][] deReverse = new int[nums.length][1000];
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], 1);
            Arrays.fill(deReverse[i], 1);
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j];
                if(diff >= 0){
                    dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1); 
                    if(dp[i][diff] > max){
                        max = dp[i][diff];
                    }
                }
            }
        }
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = nums.length-1; j > i; j--){
                int diff = nums[i] - nums[j];
                if(diff >= 0){
                    deReverse[i][diff] = Math.max(deReverse[i][diff], deReverse[j][diff] + 1); 
                    if(deReverse[i][diff] > max){
                        max = deReverse[i][diff];
                    }
                }
            }
        }
        return max;
    }
}

/* Similar to Longest Increasing subsequence but here we also need to store the difference as another parameter.
So we can use a 2d dp, where the first index is the index of the array and the second index stores the difference
observed at that index.
dp[i][j] -> stores the length of the longest increasing arithmetic subsequence ending at index i and having difference of j in all its elements.
Handle the edge cases
we see that the differences can be either positve or negative, we cant store negative values in an array,
so an easy way to handle this is to make sure all differences are postive, and we can do that by going
through the array in reverse order as well after going through the array from the front.
*/