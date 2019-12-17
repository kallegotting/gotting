package Labb2;

public class TreeNode<E> {
    protected E data;
    protected TreeNode<E> next;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(){

    }

    public TreeNode(E data) {
        this.data = data;

    }
}
