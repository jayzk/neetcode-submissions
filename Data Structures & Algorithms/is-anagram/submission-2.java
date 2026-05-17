class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> dict = new HashMap<>();

        for(char c : s.toCharArray()) {
            Integer currentVal = dict.get(c);
            if(currentVal == null) {
                dict.put(c, 1);
            } else {
                dict.put(c, currentVal + 1);
            }
        }

        for(char c : t.toCharArray()) {
            Integer currentVal = dict.get(c);
            if(currentVal == null || currentVal < 0) {
                return false;
            } else {
                dict.put(c, currentVal - 1);
            }
        }

        for(int i : dict.values()) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}
