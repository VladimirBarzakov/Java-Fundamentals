import javax.naming.OperationNotSupportedException;
import java.util.*;

public class PeopleDatabase {
    private Map<Long, Person> peopleByID;
    private Map<String, Person> peopleByUserName;
    private ArrayDeque<Long> lastAddedID;

    public PeopleDatabase() {
        this.peopleByID = new LinkedHashMap<>();
        this.peopleByUserName = new LinkedHashMap<>();
        this.lastAddedID = new ArrayDeque<>();
    }

    public void add(Person person) throws OperationNotSupportedException {
        if (person == null ||
                this.lastAddedID.size() == 16 ||
                person.getId() <= 0 || person.getUsername() == null ||
                person.getUsername().length() == 0 ||
                this.peopleByUserName.containsKey(person.getUsername()) ||
                this.peopleByID.containsKey(person.getId())) {
            throw new OperationNotSupportedException();
        }
        this.peopleByID.put(person.getId(), person);
        this.peopleByUserName.put(person.getUsername(), person);
        this.lastAddedID.addLast(person.getId());
    }

    public Person remove() throws OperationNotSupportedException {
        if (this.lastAddedID.size() == 0) {
            throw new OperationNotSupportedException();
        }
        Person person = this.peopleByID.remove(this.lastAddedID.removeLast());
        this.peopleByID.remove(person.getId());
        this.peopleByUserName.remove(person.getUsername());
        return person;
    }

    public Person findByUsername(String userName) throws OperationNotSupportedException {
        if (userName==null || !this.peopleByUserName.containsKey(userName)){
            throw new OperationNotSupportedException();
        }
        return this.peopleByUserName.get(userName);
    }

    public Person findById(Long id) throws OperationNotSupportedException {
        if (!this.peopleByID.containsKey(id)){
            throw new OperationNotSupportedException();
        }
        return this.peopleByID.get(id);
    }

    public Person[] fetch() {
        Person[] output = new Person[this.lastAddedID.size()];
        int cursor = 0;
        for (Person person:this.peopleByID.values()) {
            output[cursor++]=person;
        }
        return output;
    }
}
