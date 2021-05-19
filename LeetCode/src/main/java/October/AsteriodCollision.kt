package October

import java.util.*

fun asteroidCollision(asteroids: IntArray): IntArray {
    if(asteroids.size <= 1) return asteroids;
    var stack = Stack<Int>();
    for(a in asteroids){
        if(a > 0){
            stack.push(a);
        }else{
            while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(a) > Math.abs(stack.peek()))
                stack.pop();
            if(stack.isEmpty() || stack.peek() <0){
                stack.push(a);
            }else if(stack.peek() == Math.abs(a)){
                stack.pop();
            }
        }
    }
    val output = IntArray(stack.size);
    var i=stack.size-1;
    while(!stack.isEmpty()){
        output[i] = stack.pop()
        i--
    }

    return output;
}