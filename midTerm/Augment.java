import java.util.*;
public class Augment {

   /* public int calcHeight(TreeNode root)
    {
        int height = 0;
        int rightHeight = 0;
        int leftHeight = 0;
        if(root == null)
        {
            return -1;
        }
        if(root.left != null)
        {
            leftHeight =  calcHeight(root.left);
        }
        if(root.right != null)
        {
            rightHeight = calcHeight(root.right);
        }
        return Math.max(rightHeight, leftHeight) + 1;
    }
    */

    public static int calcHeight(TreeNode root)
    {
        if (root == null){
            return 0;
        }
        return  Math.max(calcHeight(root.left), calcHeight(root.right)) + 1;
    }
    public static void augmentHeights(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        root.height = calcHeight(root);
        augmentHeights(root.left);
        augmentHeights(root.right);
    }
	public static void main(String [] args) {
		MyTree T = new MyTree();
		TreeNode root = T.getRoot();		// Get the root node of the tree.
        //root.height = calcHeight(root);
        //root.left.height = calcHeight(root.left);
	    //root.right.height = calcHeight(root.right);
	    augmentHeights(root);	
		// Printing the augmented information at the root, its left subtree and right subtree.
		System.out.println(root.height);
		System.out.println(root.left.height);
		System.out.println(root.right.height);
	}
}
