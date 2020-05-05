package May.WorkOne;

public class FirstUniqueInString {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
	}

	public static int firstUniqChar(String s) {
        if(s==null || s.length()==0)
            return -1;
        
        int[] arr = new int[26];
        for(char x:s.toCharArray()){
            arr[x-'a'] += 1;
        }
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
