package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> list = new BuggyAList<>();
        list.addLast(4);
        assertEquals(4, (int) list.removeLast());
        list.addLast(5);
        assertEquals(5, (int) list.removeLast());
        list.addLast(6);
        assertEquals(6, (int) list.removeLast());
    }

    @Test
    public void randomizedTest() {
        BuggyAList<Integer> L = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
            } else if (L.size() > 0) {
                assertEquals(L.getLast(), L.removeLast());
            }
        }
    }
}
