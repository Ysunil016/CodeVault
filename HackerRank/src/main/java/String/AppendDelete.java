package String;

public class AppendDelete {

    public static void main(String[] args) {
        System.out.println(appendAndDelete("hackerhappy","hackerrank",9));
    }

    static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;
        for(int i=0;i<Math.min(s.length(),t.length());i++){
            if(s.charAt(i)==t.charAt(i))
                commonLength++;
            else
                break;
        }

        int i = s.length() + t.length() - 2 * commonLength;
        if(i > k){
            return "No";
        }
        else if(i%2 == k%2){
            return "Yes";
        }
        else if(s.length()+t.length() - k < 0)
            return "Yes";
        else
        return "No";
    }
}
