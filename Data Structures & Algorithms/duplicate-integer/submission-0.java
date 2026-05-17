class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> n = new HashSet<Integer>();
        for(int i : nums) {
            System.out.println(i);
            if(n.contains(i)) {
                return true;
            } else {
                n.add(i);
            }
        }

        return false;
    }
}