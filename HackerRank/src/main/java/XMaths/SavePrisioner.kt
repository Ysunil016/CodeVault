package XMaths

fun main() {
    print(findTheSpot(3,7,3))
}

fun findTheSpot(n:Int,m:Int,s:Int):Int{
    val result = (s+ (m%n)-1)%n;
    return if(result==0) n else result;
}
