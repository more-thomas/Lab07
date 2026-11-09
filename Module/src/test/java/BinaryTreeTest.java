import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testCountNodes() {
        BinaryTree<Integer> root = new BinaryTree<Integer>(10);
        BinaryTree<Integer> left = new BinaryTree<Integer>(5);
        BinaryTree<Integer> right = new BinaryTree<Integer>(20);

        root.left = left;
        root.right = right;

        assertEquals(3, BinaryTree.countNodes(root));
        assertEquals(0, BinaryTree.countNodes(null));
    }

    @Test
    public void testMirror() {
        BinaryTree<Integer> root = new BinaryTree<Integer>(10);
        BinaryTree<Integer> left = new BinaryTree<Integer>(5);
        BinaryTree<Integer> right = new BinaryTree<Integer>(20);

        root.left = left;
        root.right = right;
        left.right = new BinaryTree<Integer>(7);

        BinaryTree<Integer> result = BinaryTree.mirror(root);
        left = result.left;
        right = result.right;

        assertEquals(10, result.value.intValue());
        assertEquals(20, left.value.intValue());
        assertEquals(5, right.value.intValue());
        assertEquals(7, right.left.value.intValue());

        assertEquals(null, right.right);
        assertEquals(null, BinaryTree.mirror(null));
    }

    @Test
    public void testPreorder() {
        BinaryTree<Integer> root = new BinaryTree<Integer>(10);
        BinaryTree<Integer> left = new BinaryTree<Integer>(5);
        BinaryTree<Integer> right = new BinaryTree<Integer>(20);

        root.left = left;
        root.right = right;
        left.right = new BinaryTree<Integer>(7);

        LinkedList<Integer> expected = new LinkedList<Integer>();
        expected.addLast(10);
        expected.addLast(5);
        expected.addLast(7);
        expected.addLast(20);

        assertEquals(true, expected.equals(BinaryTree.preorder(root)));

        //empty
        LinkedList<Integer> empty = new LinkedList<Integer>();
        assertEquals(true, empty.equals(BinaryTree.preorder(null)));
    }

    @Test
    public void testFindPath() {
        BinaryTree<Integer> root = new BinaryTree<Integer>(10);
        BinaryTree<Integer> left = new BinaryTree<Integer>(5);
        BinaryTree<Integer> right = new BinaryTree<Integer>(20);

        root.left = left;
        root.right = right;
        left.right = new BinaryTree<Integer>(7);

        LinkedList<String> expected = new LinkedList<String>();
        expected.addLast("left");
        expected.addLast("right");
        expected.addLast("here");

        assertEquals(true, expected.equals(BinaryTree.findPath(root, 7)));

        LinkedList<String> rootPath = new LinkedList<String>();
        rootPath.addLast("here");

        assertEquals(true, rootPath.equals(BinaryTree.findPath(root, 10)));
        assertEquals(null, BinaryTree.findPath(root, 99));
        assertEquals(null, BinaryTree.findPath(null, 10));
    }
}
