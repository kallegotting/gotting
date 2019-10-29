import java.util.Iterator;
import java.util.NoSuchElementException;

public class Kedja<E extends Comparable> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public Kedja(){
        first = null;
        last = null;
    }

    public int getSize(){
        return size;
    }

    public E getFirst(){
        if (first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public void addFirst(E data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;

        if (last == null){
            last = first;
        }
        size++;
    }

    public void removeFirst() {
        if(first == null){
            throw new NoSuchElementException();
        }
        first = first.next;
        size--;
    }


    public void addAt(int pos, E data) {
        if(pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException();
        }
        if(pos == 0) {
            addFirst(data);
        } else {
            Node nuvarande = first;
            for(int i = 1; i < pos; i++) {
                nuvarande = nuvarande.next;
            }
            Node temp = nuvarande.next;
            Node nyNod = new Node();
            nyNod.data = data;
            nuvarande.next = nyNod;
            nyNod.next = temp;
            size++;
        }
    }


    public void removeAt(int p) {
        if(p < 0 || p > size) {
            throw new IndexOutOfBoundsException();
        } else {
            if(p == 0) {
                removeFirst();
            } else {
                Node<E> tidigare = first;
                for(int i = 1; i < p; i++) {
                    tidigare = tidigare.next;
                }
                Node<E> nuvarande = tidigare.next;
                tidigare.next = nuvarande.next;
                size--;
            }
        }
    }


    public void addInOrder(E data) {
        Node<E> nyNod = new Node<>();
        nyNod.data = data;

        if (first == null || nyNod.data.compareTo(first.data) <= 0) {
            Node<E> temp = first;
            first = nyNod;
            nyNod.next = temp;
        } else {
            if (nyNod.data.compareTo(first.data) <= 0) {
                Node<E> temp = first;
                first = nyNod;
                nyNod.next = temp;
            } else {
                Node<E> previous = first;
                Node<E> current = first.next;
                while (previous.next != null && nyNod.data.compareTo(previous.next.data) > 0) {
                    previous = previous.next;
                    current = current.next;
                }
                previous.next = nyNod;
                nyNod.next = current;
            }
        }
        size++;
    }

    public void addLast(E data){
        Node newNode = new Node();
        newNode.data = data;
        if(last == null){
            first = last = newNode;
        }else {
            last.next = newNode;
            last = last.next;
        }
        size++;
    }

    public void removeLast(){
        if(size == 0){
            throw new IndexOutOfBoundsException();
        }else if (size == 1){
            first = last = null;
            size = 0;
        }else {
            Node<E> tidigare = first;
            for (int i = 0; i < size-2 ;i++){
                tidigare = tidigare.next;
            }
            last = tidigare;
            last.next = null;
            size--;
        }
    }

    public boolean contains(E s) {
        Node search = first;
        while(search != null) {
            if(search.data.equals(s)){
                return true;
            }
            search = search.next;
        }
        return false;
    }

    public int find(E s) {
        Node search = first;
        int pos = 0;
        while(search!=null) {
            if(search.data.equals(s)){
                return pos;
            }
            search = search.next;
            pos++;
        }
        return -1;
    }

    public E getAt(int pos) {
        if(pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> head = first;
        for(int i = 0; i < pos; i++) {
            head = head.next;
        }
        return head.data;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node<E> nuvarande;
        nuvarande = first;
        for(int i = 0; i < size; i++) {
            str.append(nuvarande.data);
            nuvarande = nuvarande.next;
            if(nuvarande != null) {
                str.append(", ");
            } else {
                str.append("]");
            }
        }
        return str.toString();
    }



    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{
        private Node<E> pekare = first;

        @Override
        public boolean hasNext() {
            return (pekare != null);
        }

        @Override
        public E next() {
            E data = pekare.data;
            pekare = pekare.next;

            return data;
        }
    }
}
