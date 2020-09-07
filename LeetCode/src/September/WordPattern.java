package September;

import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abab","Sunil Yadav Sunil Yadav"));
	}
	
	public static boolean wordPattern(String pattern, String str) {
        String[] args = str.split(" ");
        if(args.length != pattern.length())
            return false;
        
        HashMap<String,Integer> A = new HashMap<>();
        HashMap<Character,Integer> B = new HashMap<>();
        
        for(Integer i=0;i<pattern.length();i++){
            if(A.put(args[i],i) != B.put(pattern.charAt(i),i))
                return false;
        }
        
        return true;
    }

}
