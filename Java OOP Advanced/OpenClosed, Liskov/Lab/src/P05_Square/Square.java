package P05_Square;

public class Square implements Shape {

    int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return this.side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return this.side*this.side;
    }
}
