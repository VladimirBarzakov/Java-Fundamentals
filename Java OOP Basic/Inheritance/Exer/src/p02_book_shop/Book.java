package p02_book_shop;

public class Book {

    private String title;
    private String author;
    private Double price;

    public Book(String author, String title, Double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public void setAuthor(String author) {
        String[] names = author.split("\\s+");
        if (names.length==2 && Character.isDigit(names[1].charAt(0))){
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    public void setTitle(String title) {
        if (title.length()<3){
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public void setPrice(Double price) {
        if (price<=0){
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}
