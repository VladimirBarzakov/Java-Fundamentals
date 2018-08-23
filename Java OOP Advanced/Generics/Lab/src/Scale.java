public class Scale<T extends Comparable> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier(){
        int comparator = this.left.compareTo(this.right);
        if (comparator==0){
            return null;
        } else if (comparator<0){
            return this.right;
        } else{
            return this.right;
        }
    }
}
