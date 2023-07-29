
fun binarySearch(list: List<Int>, target: Int): Int{
    var left = 0
    var right = list.size - 1

    while(left <= right){
        var middle = (left + right) / 2
        when{
            list[middle] == target -> return middle
            list[middle] < target -> left = middle + 1
            else -> right = middle - 1
        }
    }
    return -1
}




fun main(args: Array<String>) {

    val binaryList = listOf(1,3,4,5,6,7,8,9,23)
    var target = 23
    var label = "**********\n"
    label += "the $target is at the position:  ${binarySearch(binaryList, target) + 1}"
    label += "\n**********"

    if (binarySearch(binaryList ,target) == -1){
        println("there is no element that you are looking for!!")
    }else{
        println(label)
    }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}