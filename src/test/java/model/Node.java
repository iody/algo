package model;

/*
  multi purpose node
 */
public class Node {
  public int val;
  public Node left;
  public Node next;
  public Node right;
  public Node parent;
  public Node[] children;

  public Node(int x) {
    val = x;
  }
}
