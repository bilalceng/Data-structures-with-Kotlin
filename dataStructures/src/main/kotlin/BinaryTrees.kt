class BinaryNode<T>(var value:T){
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null


    fun diagram(node: BinaryNode<T>?,
                top: String = "",
                root: String = "",
                bottom: String = ""): String{


        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
    override fun toString() = diagram(this)

    fun traverseInOrder(visit:Visitor<T>){
        leftChild?.traverseInOrder(visit)
        visit(value)

        rightChild?.traverseInOrder(visit)
    }

    fun traversePreorder(visit: Visitor<T>){
        visit(value)
        leftChild?.traversePreorder(visit)
        rightChild?.traversePreorder(visit)
    }


    fun traversePostOrder(visit: Visitor<T>){
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }
}

typealias Visitor<T> = (T) -> Unit

fun main(){
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    seven.rightChild = nine
    one.leftChild = zero
    one.rightChild = five
    nine.rightChild = eight

    val tree = seven

    println(tree)

    "traversing in order" example {
        tree.traverseInOrder {
            println(it)
        }
    }
    "traversing pre order" example {
        tree.traversePreorder {
            println(it)
        }
    }

    "traversing post order" example {
        tree.traversePostOrder {
            println(it)
        }
    }

}