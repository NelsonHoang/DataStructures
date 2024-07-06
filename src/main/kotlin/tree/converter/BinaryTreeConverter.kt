package tree.converter

import tree.TreeNode

fun reconstructBinaryTreeWithPreorderAndInorder(
    preorder: IntArray,
    inorder: IntArray
): TreeNode? {
    val inorderMap = HashMap<Int, Int>()
    var preIndex = 0
    inorder.forEachIndexed { index, value ->
        inorderMap[value] = index
    }

    fun buildTree(
        inLeft: Int,
        inRight: Int
    ): TreeNode? {
        if (inLeft > inRight) return null

        val nodeVal = preorder[preIndex++]
        val node = TreeNode(nodeVal)
        val index = inorderMap[nodeVal]

        index?.let {
            node.left = buildTree(inLeft = inLeft, inRight = it - 1)
            node.right = buildTree(inLeft = it + 1, inRight = inRight)
        }

        return node
    }

    return buildTree(inLeft = 0, inRight = preorder.size - 1)
}

fun reconstructBinaryTreeWithPostorderAndInorder(
    postorder: IntArray,
    inorder: IntArray
): TreeNode? {
    val inorderMap = HashMap<Int, Int>()
    var postIndex = postorder.size - 1
    inorder.forEachIndexed { index, value ->
        inorderMap[value] = index
    }

    fun buildTree(
        inLeft: Int,
        inRight: Int
    ): TreeNode? {
        if (inLeft > inRight) return null

        val nodeVal = postorder[postIndex]
        val node = TreeNode(nodeVal)
        val index = inorderMap.get(nodeVal)
        postIndex--

        index?.let {
            node.right = buildTree(
                inLeft = it + 1,
                inRight = inRight
            )
            node.left = buildTree(
                inLeft = inLeft,
                inRight = it - 1
            )
        }
        return node
    }
    return buildTree(inLeft = 0, inRight = inorder.size - 1)
}