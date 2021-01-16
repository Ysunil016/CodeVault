package easy

import java.util.*

fun main() {

    val timeBarrier11AM = {
        val cal = Calendar.getInstance()
        cal.set(cal.get(1),cal.get(2),cal.time.date,11,0,0)
        println(cal.toInstant())
        cal.toInstant()
    }
    println(timeBarrier11AM())
}