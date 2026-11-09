public class BinaryTree<T> {
    T value;
    BinaryTree<T> left;
    BinaryTree<T> right;

    public BinaryTree(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    // Return the number of nodes in the tree
    public static <T> int countNodes(BinaryTree<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Return a mirrored copy with left and right swapped
    public static <T> BinaryTree<T> mirror(BinaryTree<T> root) {
        if (root == null) {
            return null;
        }

        BinaryTree<T> result = new BinaryTree<T>(root.value);

        result.left = mirror(root.right);
        result.right = mirror(root.left);

        return result;
    }

    // Return the tree's values in root, left, right order
    public static <T> LinkedList<T> preorder(BinaryTree<T> root) {
        LinkedList<T> result = new LinkedList<T>();
        fillPreorder(root, result);
        return result;
    }

    // Add values to the linked list in preorder
    private static <T> void fillPreorder(
            BinaryTree<T> root, LinkedList<T> result) {

        if (root != null) {
            result.addLast(root.value);
            fillPreorder(root.left, result);
            fillPreorder(root.right, result);
        }
    }

    // Returns directions to the targe and returns null if the target is not found
    public static <T> LinkedList<String> findPath(BinaryTree<T> root, T target) {
        if (root == null) {
            return null;
        }

        if (root.value.equals(target)) {
            LinkedList<String> path = new LinkedList<String>();
            path.addFirst("here");
            return path;
        }

        LinkedList<String> path = findPath(root.left, target);

        if (path != null) {
            path.addFirst("left");
            return path;
        }

        path = findPath(root.right, target);

        if (path != null) {
            path.addFirst("right");
            return path;
        }
        return null;
    }
}
