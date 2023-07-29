import kotlin.math.min



/*
// smallest to  biggest version.
fun positiveIntegerSorting(list:List<Int>) {
    var currentCounter = 0
    var maxValue = Int.MAX_VALUE

    while(currentCounter < list.size){
        var currentValue = list.min()

        for(value in list){
            if (value > currentValue && value < maxValue){
                currentValue = value
            }
        }


        for(value in list){
            if(value == currentValue){
                println(value)
                currentCounter += 1
            }
        }

        maxValue = currentValue
    }


}
 */
fun positiveIntegerSorting(list:List<Int>) {
    var currentCounter = 0
    var minValue = -500

    while(currentCounter < list.size){
        var currentValue = list.max()

        for(value in list){
            if (value < currentValue && value > minValue){
                currentValue = value
            }
        }


        for(value in list){
            if(value == currentValue){
                println(value)
                currentCounter += 1
            }
        }

        minValue = currentValue
    }


}
fun main(){
    positiveIntegerSorting(listOf(2,1,3))
}