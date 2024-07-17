package tree.serializer

import org.junit.jupiter.api.Test
import tree.TreeNode

class BinaryTreeSerializerTest {

    @Test
    fun serializeBinaryTreeNullTree() {
        assert(serializeBinaryTree(null) == "#")
    }

    @Test
    fun serializeBinaryTreeWith3Nodes() {
        assert(serializeBinaryTree(createTreeWith3Node()) == "1,2,#,#,3,#,#")
    }

    /**
     *        1
     *      /  \
     *    2     3
     */
    private fun createTreeWith3Node(): TreeNode {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        return root
    }

    @Test
    fun serializeBinaryTreeWith5Nodes() {
        assert(serializeBinaryTree(createTreeWith5Nodes()) == "1,2,3,#,#,#,4,#,5,#,#")
    }

    /**
     *        1
     *      /  \
     *    2     4
     *  /        \
     * 3          5
     */
    private fun createTreeWith5Nodes(): TreeNode {
        val root = TreeNode(1)
        val left = TreeNode(2)
        left.left = TreeNode(3)
        root.left = left
        val right = TreeNode(4)
        right.right = TreeNode(5)
        root.right = right
        return root
    }

    @Test
    fun deserializeNullBinaryTree() {
        val root = deserializeBinaryTree("#")
        assert(root == null)
    }

    @Test
    fun deserializeBinaryTreeWith3Nodes() {
        val root = deserializeBinaryTree("1,#,2,#,3")
        assert(root?.value == 1)
        assert(root?.left == null)
        assert(root?.right?.value == 2)
        assert(root?.right?.left == null)
        assert(root?.right?.right?.value == 3)
    }

    @Test
    fun deserializeBinaryTreeWith5Nodes() {
        val root = deserializeBinaryTree("1,2,3,#,#,4,#,#,5,#,#")
        assert(root?.value == 1)
        assert(root?.left?.value == 2)
        assert(root?.left?.left?.value == 3)
        assert(root?.left?.right?.value == 4)
        assert(root?.right?.value == 5)
        assert(root?.right?.left == null)
        assert(root?.right?.right == null)
    }
}