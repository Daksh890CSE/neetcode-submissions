class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString=new StringBuilder();
        for(String str:strs){
            encodedString.append(str.length()).append("#").append(str);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedString=new ArrayList<>();

        int i=0;
        while(i<str.length()){
            int seppos=str.indexOf('#',i);
            int len= Integer.parseInt(str.substring(i,seppos));
            i=seppos+1;
            decodedString.add(str.substring(i,i+len));
            i=i+len;
        }

        return decodedString;
    }
}
