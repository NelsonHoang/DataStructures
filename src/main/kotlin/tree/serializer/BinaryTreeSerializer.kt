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