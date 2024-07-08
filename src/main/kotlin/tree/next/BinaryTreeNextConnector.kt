package tree.next

import tree.TreeNode

fun connectNextRightPointer(root: TreeNode?): TreeNode? {
    if (root == null) return null

    var current: TreeNode? = root
    var dummy = TreeNode(0) // Dummy node to keep track of the start of the next level
    var prev: TreeNode? = dummy

    while (current != null) {
        if (current.left != null) {
            prev?.next = current.left
            prev = current.left
        }
        if (current.right != null) {
            prev?.next = current.right
            prev = current.right
        }
        current = current.next // Move to the next node in the current level

        if (current == null) {
            // Move to the next level
            current = dummy.next
            dummy.next = null
            prev = dummy
        }
    }

    return root
}