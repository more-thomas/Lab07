import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    @Test
    public void testAddFirst() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(3);

        LinkedList<Integer> expected = new LinkedList<Integer>();
        expected.addLast(3);
        expected.addLast(5);
        expected.addLast(10);

        assertEquals(true, expected.equals(list));
    }

    @Test
    public void testAddLast() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        LinkedList<Integer> expected = new LinkedList<Integer>();
        expected.addFirst(30);
        expected.addFirst(20);
        expected.addFirst(10);

        assertEquals(true, expected.equals(list));
    }

    @Test
    public void testAddFirstAndLast() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);

        LinkedList<Integer> expected = new LinkedList<Integer>();
        expected.addLast(5);
        expected.addLast(10);
        expected.addLast(20);

        assertEquals(true, expected.equals(list));
    }

    @Test
    public void testEquals() {
        LinkedList<Integer> first = new LinkedList<Integer>();
        LinkedList<Integer> second = new LinkedList<Integer>();

        //Two empty lists
        assertEquals(true, first.equals(second));

        first.addLast(10);
        second.addLast(10);

        //Same values
        assertEquals(true, first.equals(second));

        first.addLast(20);

        //Different lengths
        assertEquals(false, first.equals(second));
        assertEquals(false, second.equals(first));

        second.addLast(30);

        //Same length but different vals
        assertEquals(false, first.equals(second));

        //null
        assertEquals(false, first.equals(null));
    }

    @Test
    public void testEqualsOrder() {
        LinkedList<Integer> first = new LinkedList<Integer>();
        first.addLast(10);
        first.addLast(20);

        LinkedList<Integer> second = new LinkedList<Integer>();
        second.addLast(20);
        second.addLast(10);

        assertEquals(false, first.equals(second));
    }

    @Test
    public void testEqualsNullValues() {
        LinkedList<String> first = new LinkedList<String>();
        LinkedList<String> second = new LinkedList<String>();

        first.addLast(null);
        second.addLast(null);

        assertEquals(true, first.equals(second));

        LinkedList<String> third = new LinkedList<String>();
        third.addLast("hey");

        assertEquals(false, first.equals(third));
        assertEquals(false, third.equals(first));
    }
}