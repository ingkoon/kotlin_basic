fun main(){
    val result : Int = method1(10, "test")
    print(result)
}

fun method1(arg1 : Int, arg2 : String ): Int {
    var result : Int = 10
    result += arg1
    return result
}