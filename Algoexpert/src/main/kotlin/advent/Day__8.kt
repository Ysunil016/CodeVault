package advent

import java.util.*

object Day__8 {
    @JvmStatic
    fun main(args: Array<String>) {
        var arrayList = mutableListOf<String>()
        var entrues = 0

        while (true) {
            val value = Day_8.scan.nextLine()
            if (value == "-1") break
            entrues++
            arrayList.add(value)
        }
        solve(arrayList)
    }

    fun solve(input: MutableList<String>) {
        val res = runProgram(input)
        print("Part 1: " + res.acc + ", ")
        var index = 0
        var run = true
        var old = ""
        var res2: Result
        do {
            var found = false
            while (!found && index < input.size) {
                val op = input[index]
                val opAndArgs = op.split(" ").toTypedArray()
                if (opAndArgs[0] == "nop") {
                    found = true
                    old = input[index]
                    input[index] = old.replace("nop", "jmp")
                } else if (opAndArgs[0] == "jmp") {
                    found = true
                    old = input[index]
                    input[index] = old.replace("jmp", "nop")
                } else {
                    index++
                }
            }
            res2 = runProgram(input)
            if (!res2.infinite) {
                run = false
            } else {
                input[index] = old
            }
            index++
        } while (run && index < input.size)
        print("Part 2: " + res2.acc + ", ")
    }

    fun runProgram(input: List<String>): Result {
        val toReturn = Result()
        var globalAcc = 0
        var pc = 0
        val visitedPCs: MutableList<Int> = ArrayList()
        var run = true
        while (run) {
            visitedPCs.add(pc)
            val op = input[pc]
            val opAndArgs = op.split(" ").toTypedArray()
            when (opAndArgs[0]) {
                "nop" -> pc++
                "acc" -> {
                    globalAcc += opAndArgs[1].toInt()
                    pc++
                }
                "jmp" -> pc += opAndArgs[1].toInt()
            }
            if (visitedPCs.contains(pc)) {
                run = false
                toReturn.infinite = true
                toReturn.acc = globalAcc
            } else if (pc >= input.size) {
                run = false
                toReturn.infinite = false
                toReturn.acc = globalAcc
            }
        }
        return toReturn
    }

    class Result {
        var infinite = false
        var acc = 0
    }
}