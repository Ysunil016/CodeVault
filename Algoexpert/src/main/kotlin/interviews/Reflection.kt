package interviews

fun main() {
    val parentReflection = ParentReflection()
    val method = parentReflection.javaClass.getMethod("reflect")
    method.invoke(parentReflection)
}

class ParentReflection {
    fun reflect(): Int {
        print("Reflected")
        return 169;
    }
}
