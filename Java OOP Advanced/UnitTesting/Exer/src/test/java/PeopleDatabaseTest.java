import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.Assert.*;

public class PeopleDatabaseTest {

    private PeopleDatabase database;
    @Before
    public void setUp() throws Exception {
        this.database=new PeopleDatabase();
    }

    @Test
    public void addMultiplePersons() throws OperationNotSupportedException {
        Person[] expected = new Person[16];
        for (int i = 0; i < 16; i++) {
            Person person = new Person(i+1,"Test"+i);
            this.database.add(person);
            expected[i]=person;
        }
        Person[] actual = new Person[16];
        try {
            Class database = Class.forName("PeopleDatabase");
            Field field = database.getDeclaredField("peopleByID");
            field.setAccessible(true);
            Map<Long, Person> mapById = (Map<Long, Person>) field.get(this.database);
            field.setAccessible(false);
            int counter =0;
            for (Person person:mapById.values()) {
                actual[counter++]=person;
            }
        } catch (ClassNotFoundException |
                IllegalAccessException |
                NoSuchFieldException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 16; i++) {
            Assert.assertEquals("Person did not match", expected[i],actual[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithSameIdShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < 2; i++) {
            Person person = new Person(1,"Test"+i);
            this.database.add(person);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithSameUserNameShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < 2; i++) {
            Person person = new Person(i+1,"Test");
            this.database.add(person);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithNegativeIdShouldThrowException() throws OperationNotSupportedException {
        Person person = new Person(-1,"Test");
        this.database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithNullUserNameShouldThrowException() throws OperationNotSupportedException {
        Person person = new Person(1,null);
        this.database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMoreThan16PersonsShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < 17; i++) {
            Person person = new Person(i=1,"Test"+i);
            this.database.add(person);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeOnEmptyDatabaseShouldThrowException() throws OperationNotSupportedException {
        this.database.remove();
    }

    @Test
    public void remove() throws OperationNotSupportedException {
        Person expected = null;
        for (int i = 0; i < 16; i++) {
            Person person = new Person(i+1,"Test"+i);
            this.database.add(person);
            if (i==15){
                expected=person;
            }
        }
        Person actual = this.database.remove();
        Assert.assertEquals("Wrong person", expected, actual);
    }

    @Test
    public void findByUsername() throws OperationNotSupportedException {
        Person expected = null;
        for (int i = 0; i < 16; i++) {
            Person person = new Person(i+1,"Test"+i);
            if (i==5){
                expected = person;
            }
            try {
                this.database.add(person);
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
        Person actual = this.database.findByUsername("Test"+5);
        Assert.assertEquals("Wrong Person",expected,actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByNonExistingUsernameShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < 16; i++) {
            Person person = new Person(i+1,"Test"+i);
            try {
                this.database.add(person);
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
        Person person = this.database.findByUsername("Alabala");
    }

    @Test
    public void findById() throws OperationNotSupportedException {
        Person expected = null;
        for (int i = 0; i < 10; i++) {
            Person person = new Person(i+1,"Test"+i);
            if (i==5){
                expected=person;
            }
            try {
                this.database.add(person);
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
        Person actual = this.database.findById(6L);
        Assert.assertEquals("Wrong Person",expected,actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByNonExistingIDShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < 10; i++) {
            Person person = new Person(i+1,"Test"+i);
            try {
                this.database.add(person);
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
        Person person = this.database.findById(20L);
    }

    @Test
    public void fetch() {
        Person[] expected = new Person[10];
        for (int i = 0; i < 10; i++) {
            Person person = new Person(i+1,"Test"+i);
            expected[i]=person;
            try {
                this.database.add(person);
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
        Person[] actual = this.database.fetch();
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals("Wrong Person",expected[i],actual[i]);
        }
    }
}