class Solution {
    public boolean isPalindrome(String s) {
        String cleaned=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int end=cleaned.length()-1;
        for(int start=0;start<cleaned.length()/2;start++){
            if(cleaned.charAt(start)!= cleaned.charAt(end)){
                return false;
            }
            end--;
        }
        return true;
    }
}
