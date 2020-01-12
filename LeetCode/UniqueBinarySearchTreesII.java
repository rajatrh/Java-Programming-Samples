import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }


  public static void printTree(TreeNode t) {
      if (t == null) {
        return;
      }
      if(t.val == -1) {
        System.out.print(">*");
      } else {
        System.out.print(">" + t.val);
      }
      printTree(t.left);
      printTree(t.right);
    }
}


class Solution {
    public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new LinkedList<TreeNode>();
    }
    return generate_trees(1, n);
    }
    
    public LinkedList<TreeNode> generate_trees(int start, int end) {
      System.out.print("\n FUNC (START=" + start + " END=" + end  + ")");
    LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
    if (start > end) {
      all_trees.add(new TreeNode(-1));
      System.out.print("\n Base case reached");
      return all_trees;
    }

    // pick up a root
    for (int i = start; i <= end; i++) {
      System.out.print("\n ITERATION : " + i + " (START=" + start + " END=" + end  + ")");
      // all possible left subtrees if i is choosen to be a root
      LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

      // all possible right subtrees if i is choosen to be a root
      LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

      // connect left and right trees to the root i
      for (TreeNode l : left_trees) {
        for (TreeNode r : right_trees) {
          TreeNode current_tree = new TreeNode(i);
          current_tree.left = l;
          current_tree.right = r;
          all_trees.add(current_tree);
          for (TreeNode tn : all_trees) {
            System.out.print("\n CURRENT TREE (" + i + ")");
            TreeNode.printTree(tn);
            }
        }
      }
    }
    return all_trees;
  }
}

class UniqueBinarySearchTreesII {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Solution sol = new Solution();
    List<TreeNode> tNodes = sol.generateTrees(3);
    for (TreeNode tn : tNodes) {
       System.out.print("\n");
       TreeNode.printTree(tn);
    }
  }
}