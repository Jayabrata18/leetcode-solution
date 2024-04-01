class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length; // If array length is 2 or less, no duplicates need to be removed
        }
        
        int k = 2; // Pointer to keep track of the index where the next non-duplicate element should be placed
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i]; // Place non-duplicate element at index k and increment k
            }
        }
        
        return k;
    }
}