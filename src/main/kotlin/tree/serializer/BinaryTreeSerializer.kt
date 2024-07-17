package tree.serializer

import tree.TreeNode
import java.lang.StringBuilder

/**
 * @param root: The root of the binary tree
 *
 * @return A [String] representation of a binary tree
 */
fun serializeBinaryTree(root: TreeNode?): String {
    val sb = StringBuilder()

    fun traverseTree(node: TreeNode?) {
        if (node == null) {
            sb.append("#,")
            return
        }

        sb.append(node.value.toString())
        sb.append(",")
        traverseTree(node.left)
        traverseTree(node.right)
    }

    traverseTree(root)
    sb.deleteCharAt(sb.length -1)
    return sb.toString()
}

/**
 * @param str: String representation of a binary tree.
 *
 * @return A root of the reconstructed binary tree
 */
fun deserializeBinaryTree(str : String) : TreeNode? {
    val list = str.split(",").toMutableList()

    fun recurse(list : MutableList<String>) : TreeNode? {
        if (list.isEmpty()) return null

        if (list[0] == "#") {
            list.removeAt(0)
            return null
        }

        val node = TreeNode(list[0].toInt())
        list.removeAt(0)
        node.left = recurse(list)
        node.right = recurse(list)

        return node
    }

    return recurse(list)
}