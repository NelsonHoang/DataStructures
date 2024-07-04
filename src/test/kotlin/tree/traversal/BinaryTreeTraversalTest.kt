package tree.traversal

import org.junit.jupiter.api.Test
import tree.TreeNode

class BinaryTreeTraversalTest {

    @Test
    fun preorderTraversal() {
        val root = constructSampleTree()
        assert(
            preorderTraversal(root).contentEquals(
                intArrayOf(
                    3, 9, 20, 15, 7
                )
            )
        )
    }

    @Test
    fun inorderTraversal() {
        val root = constructSampleTree()
        assert(
            inorderTraversal(root).contentEquals(
                intArrayOf(
                    9, 3, 15, 20, 7
                )
            )
        )
    }

    @Test
    fun postorderTraversal() {
        val root = constructSampleTree()
        assert(
            postorderTraversal(root).contentEquals(
                intArrayOf(
                    9, 15, 7, 20, 3
                )
            )
        )
    }

    /**
     *        3
     *      /  \
     *    9     20
     *         /  \
     *        15   7
     */
    private fun constructSampleTree(): TreeNode {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        val rightNode = TreeNode(20)
        root.right = rightNode
        rightNode.left = TreeNode(15)
        rightNode.right = TreeNode(7)
        return root
    }
}