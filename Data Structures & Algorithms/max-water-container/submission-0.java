class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        //initial brute force solution
        for(int i = 0; i < heights.length; i++) {
            for(int n = i+1; n < heights.length; n++) {
                int area = calcArea(heights[i], i, heights[n], n);
                if(area > max)
                    max = area;
            }
        }

        return max;
    }

    public int calcArea(int firstVal, int firstIndex, int secondVal, int secondIndex) {
        int height;
        if(firstVal <= secondVal)
            height = firstVal;
        else
            height = secondVal;

        int width = secondIndex - firstIndex;
        return height * width;
    }
}
