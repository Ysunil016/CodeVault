package String;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Is Valid Parentheses " + isValid("({({[]})})[{({{([[{}]])}})}]{({}[()][()]{})}"));
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for(char charValue : str.toCharArray()){
            switch (charValue){
                case '{': stack.push('{'); break;
                case '(': stack.push('('); break;
                case '[': stack.push('['); break;
                case ']': if(stack.isEmpty() || stack.peek() != '[') return false; stack.pop(); break;
                case '}': if(stack.isEmpty() || stack.peek() != '{') return false; stack.pop(); break;
                case ')': if(stack.isEmpty() || stack.peek() != '(') return false; stack.pop(); break;
                default: break;
            }
        }
        return stack.isEmpty();
    }
}
