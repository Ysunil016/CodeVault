package September;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("S", new ArrayList<>()));
    }

    private static HashMap<String,Boolean> memo;
    public static boolean wordBreak(String s, List<String> wordDict) {
        memo=new HashMap<>();
        memo.put("",true);
        return recur(s,wordDict);
    }
    private static boolean recur(String s, List<String> dictionary){
        if(memo.containsKey(s)) return memo.get(s);
        boolean res=false;
        for(String word: dictionary){
            if(s.startsWith(word)){
                if(recur(s.substring(word.length()),dictionary)){
                    res=true;
                    break;
                }
            }
        }
        memo.put(s,res);
        return res;
    }
}
