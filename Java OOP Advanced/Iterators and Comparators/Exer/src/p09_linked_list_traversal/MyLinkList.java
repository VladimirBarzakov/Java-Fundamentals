package p09_linked_list_traversal;

public class MyLinkList<T> implements Iterable<T>{

    private int size;
    private Node<T> head;
    private Node<T> tail;


    private final class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        private T getValue() {
            return this.value;
        }

        private Node<T> getNext() {
            return this.next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public MyLinkList() {
        this.size = 0;
    }

    public void add(T value){
        Node<T> node = new Node<>(value);
        if (this.size==0){
            this.head=node;
            this.tail=node;
        } else {
            this.tail.setNext(node);
            this.tail=node;
        }
        this.size++;
    }

    public boolean remove(T value){
        if (this.size==0){
            return false;
        }
        Node<T> parent = null;
        Node<T> node =this.head;
        while (true){
            if (node.getValue().equals(value)){
                if (this.size==1){
                    this.head=this.tail=null;
                } else{
                    if (node==this.head){
                        this.head=node.next;
                    } else if(node==this.tail){
                        this.tail=parent;
                    } else{
                        parent.setNext(node.next);
                    }
                }
                this.size--;
                return true;
            }
            if (node==this.tail){
                break;
            }
            parent=node;
            node=node.next;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator();
    }

    private final class Iterator implements java.util.Iterator<T> {
        private Node<T> node = head;

        @Override
        public boolean hasNext() {
            return this.node!=null;
        }

        @Override
        public T next() {
            T value = node.getValue();
            node=node.next;
            return value;
        }
    }
}
