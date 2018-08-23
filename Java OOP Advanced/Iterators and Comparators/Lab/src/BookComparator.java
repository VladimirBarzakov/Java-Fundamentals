import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book bookOne, Book bookTwo) {
        int comparator = bookOne.getTitle().compareTo(bookTwo.getTitle());
        if (comparator==0){
            comparator=bookOne.getYear()-bookTwo.getYear();
        }
        return comparator;
    }
}
