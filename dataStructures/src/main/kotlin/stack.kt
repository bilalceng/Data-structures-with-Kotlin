import java.util.*
import javax.swing.text.Element


interface Stack<T>{
    fun push(element: T)
    fun pop():T?
}



 class MyStack<T: Any>():Stack<T> {
    private val storage = arrayListOf<T>()
     override fun pop(): T? {
         if(storage.size == 0){
             return null
         }
         return storage.removeAt(storage.size - 1)
     }
     override fun push(item: T) {
         storage.add(item)
     }
     override fun toString() = buildString {
        appendLine("-----TOP-----")
        storage.asReversed().forEach{
            appendLine("     $it")

        }
        appendLine("-------------")
    }


}

fun main(){
    "using stack" example {
        val stack = MyStack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)

        print(stack)

       var poppedValue =  stack.pop()

        poppedValue?.let {
            print("popped: $it")
        }
        println()
        println(stack)

    }
}