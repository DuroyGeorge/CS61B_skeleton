import static org.junit.Assert.*;

import org.junit.Test;


public class TestArrayDequeGold {

    @Test
    public void test() {
        Integer maxTime = 500;
        ArrayDequeSolution<Integer> correction = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> failure = new StudentArrayDeque<>();
        StringBuilder msg= new StringBuilder();
        for (Integer i = 0; i < maxTime; i++) {
            int factor = StdRandom.uniform(0, 4);
            String temp;
            switch (factor) {
                case 0:
                    correction.addFirst(i);
                    failure.addFirst(i);
                    temp="addFirst(" + i + ")\n";
                    msg.append(temp);
                    assertEquals(msg.toString(),
                        correction.get(0), failure.get(0));
                    break;
                case 1:
                    correction.addLast(i);
                    failure.addLast(i);
                    temp="addLast(" + i + ")\n";
                    msg.append(temp);
                    assertEquals(msg.toString(),
                        correction.get(correction.size() - 1), failure.get(failure.size() - 1));
                    break;
                case 2:
                    if (!correction.isEmpty() && !failure.isEmpty()) {
                        msg.append("removeFirst()\n");
                        assertEquals(msg.toString(),
                            correction.removeFirst(), failure.removeFirst());
                    }
                    break;
                case 3:
                    if (!correction.isEmpty() && !failure.isEmpty()) {
                        msg.append("removeLast()\n");
                        assertEquals(msg.toString(),
                            correction.removeLast(), failure.removeLast());
                    }
                    break;
            }
        }

    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDequeGold.class);
    }
}
