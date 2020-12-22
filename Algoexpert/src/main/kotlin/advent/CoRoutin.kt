package advent

import kotlinx.coroutines.*

//
fun main() {
//    GlobalScope.launch {
//        crScope()
//    }
    rScope()
//    println("XX")
//    Thread.sleep(10000)
}

fun rScope() = runBlocking {
    println("I am working")
    launch {
        operationOne()
    }
    launch {
        operationTwo()
    }
    println("Done working.")
//    println("The multiplied result is ${opOne.await() * opTwo.await()}")
}

suspend fun crScope() = coroutineScope {
    println("I am working")
    launch {
        operationOne()
    }
    launch {
        operationTwo()
    }
    println("Done working.")
//    println("The multiplied result is ${opOne.await() * opTwo.await()}")
}


fun blocking() = runBlocking {
    println("I am working")
    val opOne = async { operationOne() }
    val opTwo = async { operationTwo() }
    opOne.await()
    opTwo.await()
    println("Done working.")
}

suspend fun operationOne():Int{
    var x = 2000
    var finalCount = 0
    while (x > 0) {
        println("One $x")
        x--
        delay(500)
        finalCount++
    }
    return finalCount
}
suspend fun operationTwo():Int{
    var x = 5000
    var finalCount = 0
    while (x > 0) {
        println("Two $x")
        delay(500)
        x--
        finalCount++
    }
    return finalCount
}

suspend fun concurrent(){
    coroutineScope {
        var x = launch {
            var x = 20
            while (x > 0) {
                println("One $x")
                delay(1000)
                x--
            }
        }
        var y = GlobalScope.launch {
            var x = 30
            while (x > 0) {
                println("Two $x")
                delay(1000)
                x--
            }
        }

        x.join()
        y.join()
    }

}
