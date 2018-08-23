package p06to07_strategy_pattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person one, Person two) {
        int comparator = Integer.compare(one.getName().length(),two.getName().length());
        if (comparator==0){
            comparator=one.getName().substring(0,1).toLowerCase()
                    .compareTo(two.getName().substring(0,1).toLowerCase());
        }
        return comparator;
    }
}
