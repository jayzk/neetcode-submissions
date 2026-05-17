class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> result = new ArrayList<>(); //dynamic array of int triplets

        Arrays.sort(nums); //sort array for binary search

        for(int i = 0; i < nums.length; i++) {
            for(int n = i+1; n < nums.length; n++) {
                int findNum = target - nums[i] - nums[n];
                int pos = binarySearch(nums, findNum, i, n); //find pos of third num

                //valid triplet found
                if(pos != -1) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[n]);
                    triplet.add(nums[pos]);

                    //sort triplet to help with detecting duplicates
                    triplet.sort(null);
                    if(!result.contains(triplet))
                        result.add(triplet);
                }
            }
        }

        return result;
    }

    //modified binary search to skip first and second indices
    public int binarySearch(int[] numbers, int findNum, int first, int second) {
        int start = 0;
        int end = numbers.length - 1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(numbers[mid] == findNum && mid != first && mid != second) { //ensure we do not return the first / second indice
                return mid;
            } else if(numbers[mid] >= findNum) { //search left
                end = mid-1;
            } else if(numbers[mid] <= findNum) { //search right
                start = mid+1;
            }

            mid = (start + end) / 2;
        }

        return -1; //no result
    }
}
