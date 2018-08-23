import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class ListIteratorTest {
    private ListIterator<Integer> listIterator;

    @Before
    public void setUp() throws Exception {
        List<Integer> collection = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            collection.add(i);
        }
        this.listIterator= new ListIterator<>(collection);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorWithEmptyCollectionShouldThrowException() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>(null);
    }

    @Test
    public void hasNextOnPopulateCollectionShodReturnTrueAtStart() {
        Assert.assertTrue(this.listIterator.hasNext());
    }
    @Test
    public void hasNextOnCollectionShodReturnTrue() {
        for (int i = 0; i < 10; i++) {
            if (i==9){
                Assert.assertFalse(this.listIterator.hasNext());
            } else{
                Assert.assertTrue(this.listIterator.hasNext());
            }
            this.listIterator.move();
        }
    }

    @Test
    public void hasNextOnEmptyCollectionShodReturnFalse() throws OperationNotSupportedException {
        List<Integer> collection = new ArrayList<>();
        this.listIterator = new ListIterator<>(collection);
        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void move() {
        for (int i = 0; i < 10; i++) {
            if (i==9){
                Assert.assertFalse(this.listIterator.move());
            } else{
                Assert.assertTrue(this.listIterator.move());
            }
        }
    }

    @Test
    public void print() throws OperationNotSupportedException {
        int expected = 0;
        int actual = this.listIterator.print();
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void printOnEmptyCollectionShouldThrowException() throws OperationNotSupportedException {
        List<Integer> collection = new ArrayList<>();
        this.listIterator = new ListIterator<>(collection);
        this.listIterator.print();
    }
}