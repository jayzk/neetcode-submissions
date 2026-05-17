class Solution {
    public boolean isPalindrome(String s) {
        //remove all spaces, non-alphabetic, and uppercase
        String result = s.replace(" ", "");
        result = result.toLowerCase();
        result = result.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println(result);

        int start = 0;
        int end = result.length() - 1;

        while(start < end) {
            System.out.println("start: " + start + " end: " + end);
            if(result.charAt(start) != result.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
