interface Stack<T>{
    val count:Int

    fun push(element: T)
    fun pop():T?

    fun peek(): T?


}



  class MyStack<T>():Stack<T> {
    private val storage = arrayListOf<T>()
      override val count: Int
          get() = storage.size

        val isEmpty: Boolean
            get() = count == 0

      override fun pop(): T? {
         if(isEmpty){
             return null
         }
         return storage.removeAt(storage.size - 1)
     }

     override fun peek(): T? {
         return storage.lastOrNull()
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

      companion object{
          fun <T> create(list: Iterable<T>): MyStack<T>{
                val stack = MyStack<T>()
              for (item in list){
                  stack.push(item)
              }
              return stack
          }
      }


}

fun <T> createStack(vararg elements:T): MyStack<T>{
    return MyStack.create(elements.toList())
}

fun String.isParaBalanced():Boolean{
    val stack = MyStack<Char>()

    for(character in this ){
        when(character){
            '(' -> stack.push(character)
            ')' -> if(stack.isEmpty){
                return false
            }else{
                stack.pop()
            }
        }
    }
    return stack.isEmpty
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



    "create companıon function" example {
        val list  = listOf("A","B","C","D","E","F")
        val stack = MyStack.create(list)
        println(stack)
    }


    "create free functıon" example {
        val stack = createStack<Int>(1,2,3,4,545,667,7)
        println(stack)
    }
    "controlling balanced parenthesis" example {
        val word = "(((((bilaa))))nait)"
        var result = word.isParaBalanced()
        println(result)
    }

}