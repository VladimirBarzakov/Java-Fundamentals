import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() throws Exception {
        this.database=new Database();
    }

    @Test
    public void testIfConstructorInstantiateCorrectSizeOfArray(){
        int actualSize=0;
        try {
            Class database = Class.forName("Database");
            Field elements = database.getDeclaredField("elements");
            elements.setAccessible(true);
            Integer[] array = (Integer[]) elements.get(this.database);
            actualSize=array.length;
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Wrong number of elements",16,actualSize);
    }

    @Test
    public void add() {
        int actual=0;
        try {
            this.database.add(1);
            Class database = Class.forName("Database");
            Field elements = database.getDeclaredField("elements");
            elements.setAccessible(true);
            Integer[] array = (Integer[]) elements.get(this.database);
            actual=array[0];
        } catch (OperationNotSupportedException |
                IllegalAccessException |
                NoSuchFieldException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(1,actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addToFullDataBase() throws OperationNotSupportedException {
        for (int i = 0; i < 16; i++) {
            try {
                this.database.add(1);
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
        this.database.add(1);
    }

    @Test
    public void remove() throws OperationNotSupportedException {
        for (int i = 0; i <= 5; i++) {
            this.database.add(i);
        }
        int actual = this.database.remove();
        Assert.assertEquals("Wrong element",5,actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDatabase() throws OperationNotSupportedException {
        this.database.remove();
    }

    @Test
    public void fetch() throws OperationNotSupportedException {
        Integer[] expected = new Integer[16];
        for (int i = 0; i < 16; i++) {
            this.database.add(i);
            expected[i]=i;
        }
        Integer[] actual = this.database.fetch();
        for (int i = 0; i < 16; i++) {
            Assert.assertEquals(expected[i],actual[i]);
        }
    }
}