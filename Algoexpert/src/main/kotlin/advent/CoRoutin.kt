package advent

import kotlinx.coroutines.*

//
fun main() {
    runBlocking {
        println("I am working")
        val opOne = async { operationOne() }
        val opTwo = async { operationTwo() }
        println("Done working.")
        println("The multiplied result is ${opOne.await() * opTwo.await()}")
    }
}

suspend fun operationOne():Int{
    var x = 20
    var finalCount = 0
    while (x > 0) {
        println("One $x")
        delay(1000)
        x--
        finalCount++
    }
    return finalCount
}
suspend fun operationTwo():Int{
    var x = 50
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
