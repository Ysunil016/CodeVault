package medium

import java.util.*

class BalancedBrackets {

    fun isBalancedBrackets(str:String):Boolean{
        var stack = Stack<Char>()
        for(char in str){
            if(char == '{'){
                stack.add('{')
            }else if(char == '('){
                stack.add('(')
            }else if(char == '['){
                stack.add('[')
            }
            if(char == '}'){
                if(stack.isEmpty()) return false
                var top = stack.peek()
                if(top == '{') stack.pop() else return false
            }else if(char == ')'){
                if(stack.isEmpty()) return false
                var top = stack.peek()
                if(top == '(') stack.pop() else return false
            }else if(char == ']'){
                if(stack.isEmpty()) return false
                var top = stack.peek()
                if(top == '[') stack.pop() else return false
            }
        }
        if(!stack.isEmpty()) return false

        return true
    }

}