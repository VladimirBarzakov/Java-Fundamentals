package p03;

public enum  CoffeeSize {
    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);
    private int ml;
    private int c;

    CoffeeSize(int ml, int c) {
        this.ml = ml;
        this.c = c;
    }

    public int getMl() {
        return this.ml;
    }

    public int getC() {
        return this.c;
    }

    @Override
    public String toString() {
        return super.toString().charAt(0)+super.toString().substring(1).toLowerCase();
    }
}
