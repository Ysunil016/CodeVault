package October;

import java.util.Stack;

public class RemoveDupliacteLetter {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] used = new boolean[26];
        int l = s.length();
        for (int i=0;i<l;i++) lastIndex[s.charAt(i) - 'a'] = i;
        Stack<Character> stack = new Stack();
        for (int i=0;i<l;i++)
        {
            if (stack.isEmpty())
            {
                stack.push(s.charAt(i));
                used[s.charAt(i) - 'a'] = true;
            }
            else{
                while (!stack.isEmpty() && s.charAt(i) < stack.peek() && i < lastIndex[stack.peek()-'a'] && !used[s.charAt(i) -'a'])
                {
                    used[stack.peek()-'a'] = false;
                    stack.pop();
                }
                if (!used[s.charAt(i) - 'a'])
                {
                    stack.push(s.charAt(i));
                    used[s.charAt(i) - 'a'] = true;
                }
            }
        }
        StringBuilder b = new StringBuilder();
        int k = stack.size();
        for (int i=0;i<k;i++)
        {
            b.append(stack.pop());
        }
        return b.reverse().toString();
    }


}
