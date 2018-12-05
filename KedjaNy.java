package Labb2;



import java.util.Iterator;
import java.util.NoSuchElementException;


    public class KedjaNy<E extends Comparable> implements Iterable<E> {
        private Node<E> huvud;
        private Node<E> svans;
        private int size = 0;

        public KedjaNy()
        {
            huvud = null;
            svans = null;
        }

        public E getHuvud(){
            if(huvud == null){
                throw new NoSuchElementException();
            }
            return huvud.data;
        }

        public void addFirst(E data){
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = huvud;
            huvud = newNode;

            if(svans == null){
                svans = huvud;
            }
            size++;
        }

        public void addlast(E data){
            Node newNode = new Node();
            newNode.data = data;
            if(svans == null){
                huvud = svans = newNode;
            }else {
                svans.next = newNode;
                svans = svans.next;
            }
            size++;
        }



        public int getSize() {
            return size;
        }

        public void removeLast(){
            if(size == 0){
                throw new IndexOutOfBoundsException();
            }else if (size == 1){
                huvud = svans = null;
                size = 0;
            }else {
                Node<E> tidigare = huvud;
                for (int i = 0; i < size-2 ;i++){
                    tidigare = tidigare.next;
                }
                svans = tidigare;
                svans.next = null;
                size--;
            }
        }

        public void removeAt(int a){
            if (a < 0 || a > size){
                throw new IndexOutOfBoundsException();
            }else {
                if (a == 0){
                    removeFirst();
                }else {
                    Node<E>tidigare = huvud;

                    for(int i = 1 ;i < a ;i++){
                        tidigare=tidigare.next;
                    }
                    Node<E>nuvarande = tidigare.next;
                    tidigare.next = nuvarande.next;
                    size--;
                }
            }
        }

        public void addInOrder(E data){

            if (huvud == null) {
                addFirst(data);
            }
            E b = getHuvud();
            Node nuvarande = huvud;
            //huvud = huvud.next;

            if(data.compareTo(b) < 0){
                addFirst(data);

            }else{
                while (nuvarande.next != null){

                    if(data.compareTo(b) > 0){
                        nuvarande = nuvarande.next;

                    }else if(data.compareTo(b) < 0){

                    }

                }
            }
        }

        public void addAt(int pos,E data){
            if(pos < 0 || pos > size){
                throw new IndexOutOfBoundsException();
            }
            if(pos == 0){
                addFirst(data);
            }else{
                Node<E> nuvarande= huvud;

                for(int i = 1; i < pos; i++){
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

        public boolean contains(E a){
            Node<E>search = huvud;
            while (search != null){
                if (search.data.equals(a)){
                    return true;
                }
                search = search.next;
            }
            return false;
        }

        public E getAt(int pos){
            if(pos < 0 || pos >= size){
                throw new IndexOutOfBoundsException();
            }
            Node<E>returNod = huvud;

            for (int i = 0; i < pos ; i++){
                returNod = returNod.next;
            }
            return returNod.data;
        }

        public void removeFirst(){
            if(huvud == null){
                throw new NoSuchElementException();
            }
            huvud = huvud.next;
        }

        public Iterator<E> iterator(){
            return new LankadListaIterator();}

        private class LankadListaIterator implements Iterator<E> {
            private Node<E> pekare = huvud;

            public boolean hasNext(){
                return (pekare != null);
            }

            public E next(){
                E data = pekare.data;
                pekare = pekare.next;
                return data;
            }
        }
    }

