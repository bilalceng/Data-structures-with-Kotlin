class TreeNode<T>(var value: T){

    val children = mutableListOf<TreeNode<T>>()

    fun add(child:TreeNode<T>): Boolean{
       return  children.add(child)

    }

    fun forEachDeptFirst(visit: Visitor<T>){
        visit(this)
        children.forEach{
            it.forEachDeptFirst(visit)
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

typealias Visitor<T> = (TreeNode<T>) -> Unit
fun main(){
    var tree = makeBeverageTree()
    tree.forEachDeptFirst {
        println("${it.value}")
    }


    }
