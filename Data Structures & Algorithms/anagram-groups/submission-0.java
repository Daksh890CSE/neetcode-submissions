class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        for(String str:strs){
            char[] charArr=str.toCharArray();
            Arrays.sort(charArr);
            String sorted=new String(charArr);
            hm.putIfAbsent(sorted,new ArrayList<>());
            hm.get(sorted).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}
