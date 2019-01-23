import java.util.*;

public class Node {
  char ch;
  int freq;
  Node left, right;
  List<Integer> BR;

  public Node(char c, int f, Node l, Node r, ArrayList<Integer> k) {
    this.ch = c;
    this.freq = f;
    this.left = l;
    this.right = r;
    this.BR = new ArrayList<Integer>();
  }
  public Node() {
    this.ch = '\0';
    this.freq = 0;
    this.left = null;
    this.right = null;
  }

  public Node(Node another) {
    this.ch = another.ch;
    this.freq = another.freq;
    this.left = another.left;
    this.right = another.right;
  }

  boolean isLeaf() {
    return (left == null) && (right == null);
  }


}
