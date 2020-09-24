package September;

public class StringDifference {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","abcde"));
    }

    public static char findTheDifference(String s, String t) {
        int expect = 0;
        int i=0;
        for(i=0;i<s.length();i++){
            expect ^= t.charAt(i);
            expect ^= s.charAt(i);
        }
        expect ^= t.charAt(i);
        return (char) expect;
    }

}
