class TreeNode<T>(var value: T){

    private val children = mutableListOf<TreeNode<T>>()

    fun add(child:TreeNode<T>): Boolean{
       return  children.add(child)

    }

    fun forEachDeptFirst(visit: (TreeNode<T>) -> Unit){
        visit(this)
        children.forEach{
            it.forEachDeptFirst(visit)
        }
    }

    fun leveledTraversal(visit:(TreeNode<T>) -> Unit){
        visit(this)
        val queue = QueueImp<TreeNode<T>>()
        children.forEach{
            queue.enqueue(it)
        }
        var node = queue.dequeue()
        while (node != null){
            visit(node)
            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }

    }

    fun search(value: T): TreeNode<T>?{
        var result: TreeNode<T>? = null
        leveledTraversal {
            if(it.value == value){
                result = it
            }

        }
        return result
    }


    fun printEachLevel(){
        val queue : QueueImp<TreeNode<T>> = QueueImp()
        var levelElementCount  = 0
        queue.enqueue(this)

        while (queue.isEmpty.not()){
            levelElementCount = queue.count

            while (levelElementCount > 0){
                var node = queue.dequeue()
                node?.let { treeNode ->
                    print(" " + treeNode.value + " ")
                    treeNode.children.forEach {
                        queue.enqueue(it)
                    }
                }?: break
                levelElementCount--
                }
            println()
            }
        }
    }


fun makeBeverageTree(): TreeNode<String> {

    val tree = TreeNode("Beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")


    tree.add(hot)
    tree.add(cold)
    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)
    cold.add(soda)
    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}





fun main(){
    "depth first traversal" example {
        val tree = makeBeverageTree()
        tree.forEachDeptFirst {
            println(it.value)
        }
    }

    "level order traversal" example {
        val tree = makeBeverageTree()
        tree.leveledTraversal {
            println(it.value)
        }
    }


    "searching" example {
        val tree = makeBeverageTree()
        val result = tree.search("coffee")
        println(result?.value)
    }


    "printing level by level" example {
        val tree = makeBeverageTree()
        tree.printEachLevel()
    }

    }
