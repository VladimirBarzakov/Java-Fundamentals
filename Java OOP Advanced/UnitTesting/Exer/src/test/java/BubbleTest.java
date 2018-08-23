import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleTest {

    @Test
    public void sortMultipleElementsShouldWorkCorrectly() {
        List<Integer> unsortedCollection = Arrays.asList(5,4,3,2,1);
        Bubble.sort(unsortedCollection);
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        for (int i = 0; i < unsortedCollection.size(); i++) {
            Assert.assertEquals(expected.get(i),unsortedCollection.get(i));
        }
    }

    @Test
    public void sortSingleElementsShouldWorkCorrectly() {
        List<Integer> unsortedCollection = Collections.singletonList(1);
        Bubble.sort(unsortedCollection);
        List<Integer> expected = Collections.singletonList(1);
        for (int i = 0; i < unsortedCollection.size(); i++) {
            Assert.assertEquals(expected.get(i),unsortedCollection.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortOfNullListShodTrowException() {
        Bubble.sort(null);
    }
}