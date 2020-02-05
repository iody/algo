package tree;

import model.Node;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
  List<Integer> res = new ArrayList<>();

  public void preorder(Node root, int level) {

    if (root == null) return;
    if (res.size() <= level) res.add(root.val);
    else res.set(level, root.val);

    preorder(root.left, level + 1);
    preorder(root.right, level + 1);
  }

  public List<Integer> rightSideView(Node root) {
    preorder(root, 0);
    return res;
  }
}
