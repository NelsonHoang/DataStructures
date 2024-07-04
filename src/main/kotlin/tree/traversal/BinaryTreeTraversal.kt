package tree.traversal

import tree.TreeNode

fun preorderTraversal(root: TreeNode?) : IntArray {
    val finalList = mutableListOf<Int>()

    fun dfs(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return

        list.add(node.value)
        node.left?.let { dfs(it, list) }
        node.right?.let { dfs(it, list) }
    }

    dfs(root, finalList)
    return finalList.toIntArray()
}

fun inorderTraversal(root: TreeNode?): IntArray {
    val finalList = mutableListOf<Int>()

    fun dfs(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return

        node.left?.let { dfs(it, list) }
        list.add(node.value)
        node.right?.let { dfs(it, list) }
    }

    dfs(root, finalList)
    return finalList.toIntArray()
}

fun postorderTraversal(root: TreeNode?): IntArray {
    val finalList = mutableListOf<Int>()

    fun dfs(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return

        node.left?.let { dfs(it, list) }
        node.right?.let { dfs(it, list) }
        list.add(node.value)
    }

    dfs(root, finalList)
    return finalList.toIntArray()
}