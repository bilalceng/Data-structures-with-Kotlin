import java.lang.IndexOutOfBoundsException

data class Node <T>(val value: T, var next: Node<T>? = null ){
    override fun toString(): String {
        return if(next != null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
    companion object {
        fun <T> createNode(value: T, next: Node<T>? = null): Node<T> {
            return Node(value, next)
        }
    }

}

class LinkedList<T> : Iterable<T>{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0




    private fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): Iterator<T> {
     return LinkedListIterator(this)
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "linked list is empty"
        } else {
            head.toString()
        }
    }


    fun push(value: T): LinkedList<T> {
        head = Node(value, next = head)

        if (tail == null) {
            tail = head
        }
        size++

        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
        return this
    }

    fun insertAt(index: Int, value: T) {
        var currentIndex = 0
        var currentNode = head

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        var newNode = Node.createNode(value)


        if (currentNode == tail) {
            append(value)
            return
        }

        newNode.next = currentNode?.next
        currentNode?.next = newNode

        size++
    }

    fun pop(): T? {
        var result: T? = null

        if (head == null && tail == null) {
            println("list is empty")
            return head?.value
        }

        if (!isEmpty()) {

            size--
            head = head?.next
            result = head?.value
            if (isEmpty()) {
                tail = null
            }

        }
        return result

    }

    fun removeLast(): T? {
        var tracker: Node<T>? = null
        var result: T? = null

        if (isEmpty()) {
            pop()
            return null
        }
        if (head?.next == null) {
            size--
            result = pop()
            return result
        }

        tracker = head

        while (true) {
            if (tracker?.next == tail) {

                result = tail?.value

                tail = tracker

                tail?.next = null

                size--

                return result
            }
            tracker = tracker?.next
        }

    }



    fun removeAt(index: Int) {
        var currentIndex: Int = 0
        var currentNode: Node<T>? = head
        var prevNode: Node<T>? = null
        if (isEmpty()) {
            pop()
            return
        }
        if (head?.next == null && index == 0) {
            pop()
            size--
            return
        }

        currentNode = head

        while (currentNode != null && currentIndex < index) {
            prevNode = currentNode
            currentNode = currentNode.next
            currentIndex++
        }
        if (prevNode?.next == tail) {
                tail  = prevNode
                tail?.next = null
                size--
                return

        }

        currentNode?.next = currentNode?.next?.next
        size--
        return

    }

    fun nodeAt(index: Int): Node<T>? {

        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

}

class LinkedListIterator<T>(private val linkedList: LinkedList<T>): Iterator<T>{

    private var index = 0
    private var lastNode: Node<T>? = null
    override fun hasNext(): Boolean {
        return linkedList.size > index
    }

    override fun next(): T {


        if(index >= linkedList.size) throw  IndexOutOfBoundsException()

        lastNode = if (index == 0) {
            linkedList.nodeAt(0)
        } else {
            lastNode?.next
        }
        index++
        println(index)
        return (lastNode?.value!!)
    }

}


fun main(){

    "creating and linking nodes" example {
        val node1 = Node<Int>(1)
        val node2 = Node<Int>(2)
        val node3 = Node<Int>(3)
        val node4 = Node<Int>(4)
        val node5 = Node<Int>(5)
        val node6 = Node<Int>(6)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6

        println(node1)
    }

    "push" example{

        val node1 = Node<Int>(1)
        val node2 = Node<Int>(2)
        val node3 = Node<Int>(3)

        var list = LinkedList<Node<Int>>()
        println(list)
        list.push(node1)
        list.push(node2)
        list.push(node3)
        println(list)
    }

    "fluent interface push" example{
        val node1 = Node<Int>(1)
        val node2 = Node<Int>(2)
        val node3 = Node<Int>(3)
        var list = LinkedList<Node<Int>>()
        println(list)
        list.push(node1).push(node2).push(node3)

        println(list)
    }

    "append" example{
        val node1 = Node("one")
        val node2 = Node("two")
        val node3 = Node("three")

        var linkedList = LinkedList<Node<String>>()
        linkedList.append(node1).append(node2).append(node3)
        println(linkedList)
    }

    "inserting certain position" example {
        var list = LinkedList<Node<Int>>()

        val node1 = Node<Int>(1)
        val node2 = Node<Int>(2)
        val node3 = Node<Int>(3)

        /*list.push(node1)
        list.push(node2)
        list.push(node3)*/

        for (i in 1..3){
            list.insertAt(0,Node.createNode(4*i))
        }

        println(list)

    }

    "pop" example{
        val list = LinkedList<Node<Int>>()
        val node1 = Node<Int>(1)
        val node2 = Node<Int>(2)
        val node3 = Node<Int>(3)
        list.push(node1).push(node2).push(node3)
        println(list)
        list.pop()
        list.pop()
        println(list)
    }

    "removeLast" example{
        val list = LinkedList<Node<Int>>()
        val node1 = Node<Int>(1)
        val node2 = Node<Int>(2)
        val node3 = Node<Int>(3)
        list.push(node1).push(node2).push(node3)
        println(list)
        list.removeLast()
        list.removeLast()

        println(list)
    }

    "removeAt" example{
        val list = LinkedList<Node<Int>>()
        val node1 = Node<Int>(1)
        val node2 = Node<Int>(2)
        val node3 = Node<Int>(3)
        list.push(node1).push(node2).push(node3)
        list.removeAt(0)
        println(list)
    }

    "iterating" example {
        val list = LinkedList<Node<Int>>()
        val node1 = Node<Int>(1)
        val node2 = Node<Int>(2)
        val node3 = Node<Int>(3)
        list.push(node1).push(node2).push(node3)

        for(item in list){
            println(item.value)
        }
    }


}

private infix fun String.example(function: () -> Unit) {
    println("----example of $this----")
    function.invoke()
}
