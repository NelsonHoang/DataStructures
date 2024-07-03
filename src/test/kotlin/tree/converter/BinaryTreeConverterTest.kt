package tree.converter

import org.junit.jupiter.api.Test
import tree.TreeNode

class BinaryTreeConverterTest {
    @Test
    /**
     *        3
     *      /  \
     *    9     20
     *         /  \
     *        15   7
     */
    fun reconstructBinaryTreeWithPostOrder() {
        val root = reconstructBinaryTreeWithPostOrder(
            postorder = intArrayOf(9, 15, 7, 20, 3),
            inorder = intArrayOf(9, 3, 15, 20, 7)
        )

        verifyTree(root)
    }

    private fun verifyTree(root: TreeNode?) {
        assert(root?.value == 3)
        assert(root?.left?.value == 9)
        val rightNode = root?.right
        assert(rightNode?.value == 20)
        assert(rightNode?.left?.value == 15)
        assert(rightNode?.right?.value == 7)
    }
}