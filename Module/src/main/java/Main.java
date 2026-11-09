//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // add six to a number
    public static int addSix(int a){
        return a + 6;
    }

    static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<Integer>(10);
        root.left = new BinaryTree<Integer>(5);
        root.right = new BinaryTree<Integer>(20);
    }
}
