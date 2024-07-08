package tree.next

import org.junit.jupiter.api.Test
import tree.TreeNode

class BinaryTreeNextConnectorTest {

    @Test
    fun connectNextRightPointer() {
        val root = connectNextRightPointer(constructSampleTree())
        verifySampleTreeNextNodes(root)
    }

    /**
     *        1
     *      /  \
     *    2     3
     *  /  \      \
     * 4    5      7
     */
    private fun constructSampleTree() : TreeNode {
        val root = TreeNode(1)
        val left = TreeNode(2)
        left.left = TreeNode(4)
        left.right = TreeNode(5)
        root.left = left
        val right = TreeNode(3)
        right.right = TreeNode(7)
        root.right = right

        return root
    }

    private fun verifySampleTreeNextNodes(root: TreeNode?) {
        assert(root?.next == null)
        val leftNode = root?.left
        assert(leftNode?.next?.value == 3)
        assert(leftNode?.left?.next?.value == 5)
        assert(leftNode?.right?.next?.value == 7)

        val rightNode = root?.right
        assert(rightNode?.next?.value == null)
        assert(rightNode?.right?.next?.value == null)
    }
}