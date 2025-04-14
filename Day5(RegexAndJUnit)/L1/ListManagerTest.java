package junit_tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
    @Test
    public void testAddItem() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 4);
        assertEquals(4, ListManager.getLastElement(list));
    }

    @Test
    public void testRemoveItem() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 4);
        ListManager.addElement(list, 5);
        ListManager.removeElement(list, 4);
        assertEquals(1, ListManager.getSize(list));
        assertEquals(5, ListManager.getLastElement(list));
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 4);
        ListManager.addElement(list, 5);
        assertEquals(2, ListManager.getSize(list));
    }
}
