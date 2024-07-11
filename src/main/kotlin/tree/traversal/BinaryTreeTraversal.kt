package tree.traversal

import tree.TreeNode

fun preorderTraversal(root: TreeNode?): IntArray {
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

/**
 * @param p The first node in finding the LCA
 * @param q The second node in finding the LCA
 * @return The lowest common ancestor of [p] and [q]
 */
fun lowestCommonAncestor(
    root: TreeNode?,
    p: TreeNode?,
    q: TreeNode?
): TreeNode? {
    // The case where the LCA is the root
    if (root == null || p == root || q == root) return root

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    // We are at a node where it's possible to find p and q, thus it's the LCA
    if (left != null && right != null) return root

    // The case when either p or q is the LCA
    return left ?: right
}