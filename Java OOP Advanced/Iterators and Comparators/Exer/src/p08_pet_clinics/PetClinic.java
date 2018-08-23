package p08_pet_clinics;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class PetClinic {
    private Pet[] rooms;


    public PetClinic(int number) {
        this.setRooms(number);

    }

    public void setRooms(int number) {
        if (number%2==0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Pet[number];
    }

    public boolean addPet(Pet pet){
        AddIterator iterator= new AddIterator();
        AtomicBoolean isRoomEmpty = new AtomicBoolean(false);
        iterator.forEachRemaining(index->{
            if (this.rooms[index]==null && !isRoomEmpty.get()){
                this.rooms[index]=pet;
                isRoomEmpty.set(true);
            }});
        return isRoomEmpty.get();
    }

    public boolean hasEmptyRooms(){
        AddIterator iterator= new AddIterator();
        AtomicBoolean isRoomFree = new AtomicBoolean(false);
        iterator.forEachRemaining(index->{
            if (this.rooms[index]==null && !isRoomFree.get()){
                isRoomFree.set(true);
            }});
        return isRoomFree.get();
    }

    public boolean releasePet(){
        Iterator<Integer> iterator = new ReleaseIterator();
        while (iterator.hasNext()){
            int roomIndex = iterator.next();
            if (this.rooms[roomIndex]!=null){
                this.rooms[roomIndex]=null;
                return true;
            }
        }
        return false;
    }

    public void print(){
        for (Pet pet:this.rooms) {
            if (pet==null){
                System.out.println("Room empty");
            } else{
                System.out.println(pet.toString());
            }
        }
    }

    public void print(int roomNumber){
        if (roomNumber<=0 || roomNumber>this.rooms.length){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        Pet pet = this.rooms[roomNumber-1];
        if (pet==null){
            System.out.println("Room empty");
        } else{
            System.out.println(pet.toString());
        }
    }



    private final class AddIterator implements Iterator<Integer>{

        private int centreRoom= rooms.length/2;
        private int offset=0;
        @Override
        public boolean hasNext() {
            return this.centreRoom+this.offset<rooms.length;
        }

        @Override
        public Integer next() {
            return this.centreRoom-offset;
        }

        public Integer nextRight() {
            return this.centreRoom+offset;
        }

        @Override
        public void forEachRemaining(Consumer<? super Integer> action) {
            Objects.requireNonNull(action);
            while (this.hasNext()){
                    if (this.offset==0){
                        action.accept(next());
                    } else{
                        action.accept(next());
                        action.accept(nextRight());
                    }
                    this.offset++;
            }
        }
    }

    private final class ReleaseIterator implements Iterator<Integer>{

        private int centreRoom= rooms.length/2;
        int count =0;
        @Override
        public boolean hasNext() {
            return this.count<rooms.length;
        }

        @Override
        public Integer next() {
            return (centreRoom+count++)%rooms.length;
        }
    }
}
