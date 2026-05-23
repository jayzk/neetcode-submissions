class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); //store character, current pos tuple
        int start = 0;
        int end = 0;
        int max = 0;

        while(end < s.length()) {
            char currentChar = s.charAt(end);

            if(map.containsKey(currentChar)) {
                //calculate new start pos after the duplicate char
                int newStart = map.get(currentChar) + 1;

                //prevent start pointer from going backwards
                if(newStart > start)
                    start = newStart;
            }

            //update max length
            int result = (end - start) + 1;
            if(result > max)
                max = result;

            map.put(currentChar, end);
            end++;
        }

        return max;
    }
}
