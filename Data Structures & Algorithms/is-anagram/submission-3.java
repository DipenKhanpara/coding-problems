class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sa = new char[26];
        char[] ta = new char[26];
        for(char c : s.toCharArray()){
            sa[c-'a']++;
        }
        for(char c : t.toCharArray()){
            ta[c-'a']++;
        }
        return new String(sa).equals(new String(ta));
    }
}