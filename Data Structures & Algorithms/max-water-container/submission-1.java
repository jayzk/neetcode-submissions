class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int first = 0;
        int second = heights.length-1;

        while(first < second) {
            int area = calcArea(heights[first], first, heights[second], second);
            if(area > max)
                max = area;

            //we always want to move the shortest wall, while width is shorten, there is a chance height will increase
            //moving the longest wall will shorten the width while keeping the same height, will not help with solution
            if(heights[first] <= heights[second])
                first++;
            else
                second--;
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
