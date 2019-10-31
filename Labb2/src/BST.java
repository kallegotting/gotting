import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST<E extends Comparable> implements Iterable<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
        root = null;
    }

    public int getSize() {
        return size;
    }

    public void add(E s) {
        if (root == null) {
            root = new TreeNode<E>(s);
        } else {
            TreeNode parent = null;
            TreeNode current = root;

            while (current != null) {
                if (s.compareTo((E) current.data) < 0) {
                    parent = current;
                    current = current.left;
                } else if (s.compareTo((E) current.data) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return;
                }
            }

            if (s.compareTo((E) parent.data) < 0) {
                parent.left = new TreeNode<>(s);
            } else {
                parent.right = new TreeNode<>(s);
            }

        }
        size++;
    }

        public E min(){
        return min(root);
    }

    private E min(TreeNode<E> treeNode){
        if (treeNode.left == null)
            return treeNode.data;
        return min(treeNode.left);
    }


    public E max(){
        return max(root);
    }

    private E max(TreeNode<E> treeNode){
        if (treeNode.right == null)
            return treeNode.data;
        return max(treeNode.right);
    }

    public boolean find(E s) {
        TreeNode search = root;
        int pos = 0;
        while (search != null) {
            if (search.data.equals(s)) {
                return true;
            }
            search = search.next;
            pos++;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new BinaryListIterator();
    }

    private class BinaryListIterator implements Iterator<E> {
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;

        public BinaryListIterator(){
            inorder();
        }

        private void inorder(){
            inorder(root);
        }

        private void inorder(TreeNode root){
            if (root == null){
                return;
            }else {
                inorder(root.left);
                list.add((E) root.data);
                inorder(root.right);
            }
        }

        @Override
        public boolean hasNext() {
            if (current < list.size()){
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            E data = list.get(current);
            current++;
            return data;
        }

    }

}
