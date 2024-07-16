package tree.serializer

import org.junit.jupiter.api.Test
import tree.TreeNode

class BinaryTreeSerializerTest {

    @Test
    fun serializeBinaryTreeNullTree() {
        assert(serializeBinaryTree(null) == "#")
    }

    /**
     *        1
     *      /  \
     *    2     3
     */
    @Test
    fun serializeBinaryTreeWith3Nodes() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        assert(serializeBinaryTree(root) == "1,2,#,#,3,#,#")
    }

    /**
     *        1
     *      /  \
     *    2     4
     *  /        \
     * 3          5
     */
    @Test
    fun serializeBinaryTreeWith5Nodes() {
        val root = TreeNode(1)
        val left = TreeNode(2)
        left.left = TreeNode(3)
        root.left = left
        val right = TreeNode(4)
        right.right = TreeNode(5)
        root.right = right
        assert(serializeBinaryTree(root) == "1,2,3,#,#,#,4,#,5,#,#")
    }
}