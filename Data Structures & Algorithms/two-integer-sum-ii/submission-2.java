class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            int findNum = target - numbers[i];
            int result = binarySearch(numbers, findNum, i, numbers.length-1); //find pos of second num

            if(result != -1) {
                return new int[]{i+1, result+1};
            }
        }

        return new int[]{0, 0};
    }

    public int binarySearch(int[] numbers, int findNum, int start, int end) {
        // int start = 0;
        // int end = numbers.length - 1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(numbers[mid] == findNum) {
                return mid;
            } else if(numbers[mid] > findNum) { //search left
                end = mid-1;
            } else if(numbers[mid] < findNum) { //search right
                start = mid+1;
            }

            mid = (start + end) / 2;
        }

        return -1; //no result
    }
}
