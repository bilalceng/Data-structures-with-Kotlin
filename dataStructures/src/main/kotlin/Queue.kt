interface  Queue <T>{
    val isEmpty: Boolean


    val count: Int
    fun dequeue():T?

    fun enqueue(item: T)

    fun peek():T?

}


class DoubleStackImp<T>():Queue<T>{
    val leftStack = MyStack<T>()
    val rightStack = MyStack<T>()
    override val isEmpty: Boolean
        get() = rightStack.isEmpty && leftStack.isEmpty
    override val count: Int
        get() = TODO("Not yet implemented")

    override fun dequeue(): T? {
        if (leftStack.isEmpty){
            transferElements()
        }
        return leftStack.pop()
    }

    override fun peek(): T? {
        if (leftStack.isEmpty){
            transferElements()
        }
        return leftStack.peek()
    }

    override fun enqueue(item: T) {
        rightStack.push(item)
    }
    private fun transferElements(){
        var nextElement = rightStack.pop()
        while (nextElement != null){
            leftStack.push(nextElement)
            nextElement = rightStack.pop()

        }
    }

    override fun toString(): String {
        return "Left stack: \n$leftStack \n Right stack: \n$rightStack"
    }
}

class QueueImp <T>(): Queue<T>{
    val Queue = mutableListOf<T>()
    override val isEmpty: Boolean
        get() = count == 0


    override val count: Int
        get() = Queue.size

    override fun dequeue(): T? {
        if(Queue.isEmpty()){
           return null
        }
        return Queue.removeAt(0)
    }

    override fun peek(): T? {
        return Queue.firstOrNull()
    }

    override fun enqueue(item: T) {
        Queue.add(item)
    }

    override fun toString(): String = buildString {
        appendLine("-----TOP-----")
        for (item in Queue){
            appendLine("$item")
        }
        appendLine("-------------")
    }

}

fun main(){

    "enqueue an dequeue" example {
        val myQueue = QueueImp<Int>()
        myQueue.enqueue(1)
        myQueue.enqueue(2)
        myQueue.enqueue(3)
        myQueue.enqueue(4)
        myQueue.enqueue(5)
        println(myQueue)
        val poppedValue = myQueue.dequeue()
        println("value: $poppedValue")
        println(myQueue)
    }

    "Queue with double stack" example {
        val queue = DoubleStackImp<Int>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        queue.enqueue(5)
        println(queue)
        queue.dequeue()
        queue.dequeue()
        queue.dequeue()
        println(queue)
    }

}