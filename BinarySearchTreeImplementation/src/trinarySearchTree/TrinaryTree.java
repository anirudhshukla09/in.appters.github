package trinarySearchTree;

public class TrinaryTree {
	
	


	    //Main function
	  public static void main(String[] args)
	  {
	      //Sample tree values rooted at 5
	      int Values[] = {6,4,6,8,3,5,7,19,2,3,18,19,20};

	      int len = Values.length;
	      
	      //Create Tree
	      TrinaryTree tree = new TrinaryTree();

	      //Populate tree
	      tree.Populate(Values, len);
	    

	  }

	  //Define a tree node
	  static class Node
	  {
	      //Left is less than node value
	      Node left;
	      //Middle is equal to node value
	      Node middle;
	      //Right is greater than node value
	      Node right;

	      //Node value
	      int value;

	      //Constructor
	      public Node(int value)
	      {
	          this.value = value;
	      }
	  }

	  //Populate method: receives an
	  //array of integers along with
	  //its size (n)
	  public void Populate(int A[], int n)
	  {
	      //Tree rooted at the first
	      //element of the array
	      Node root = new Node(A[0]);

	      //Insert values into the tree
	      for (int i = 1; i < n; i++)
	      {
	          Insert(root, A[i]);
	      }

	      //Print tree
	      Print(root);
	      System.out.println("Deleting");
	      Delete(root, 7);
	      System.out.println("After Deleting");
	      Print(root);
	  }

	  //Insert a node into the tree
	  public void Insert(Node node, int value)
	  {
	      //If the value to be inserted
	      //is less than node value then
	      //we either inserts it as the
	      //left child if it does not exist
	      //or recursively call the insert
	      //on the left child if it does exist
	      if (value < node.value)
	      {
	          //Left child exist
	          if (node.left != null)
	          {
	              Insert(node.left, value);
	          }
	          //Left child does not exist
	          //so create it
	          else
	          {
	              node.left = new Node(value);
	          }
	      }
	      //Same reasoning as above but for right
	      else if (value > node.value)
	      {
	          if (node.right != null)
	          {
	              Insert(node.right, value);
	          }
	          else
	          {
	              node.right = new Node(value);
	          }
	      }
	      //Same reasoning as above but for middle
	      else
	      {
	          if (node.middle != null)
	          {
	              Insert(node.middle, value);
	          }
	          else
	          {
	              node.middle = new Node(value);
	          }
	      }
	  }

	  public Node Delete(Node node, int value)
	  {
	      if (node.value > value)
	      {
	          node.left = Delete(node.left, value);
	      }
	      else if(node.value < value)
	      {
	          node.right = Delete(node.right, value);
	      }
	      else
	      {
	          if (node.middle != null)
	          {
	              node.middle = Delete(node.middle, value);
	          }
	          else if(node.right != null)
	          {
	              int min = minimum(node.right).value;
	              node.value = min;
	              node.right = Delete(node.right, min);
	          }
	          else
	          {
	              node = node.left;
	          }
	      }
	      return node;
	  }

	  protected Node minimum(Node node)
	  {
	      if(node != null)
	      {
	          while (node.left != null)
	          {
	              return minimum(node.left);
	          }
	      }

	      return node;
	  }

	  //Recursive method to print the
	  //whole tree
	  public void Print(Node root)
	  {
	      if (root != null)
	      {
	          System.out.println("Node value : " + root.value);
	          Print(root.left);
	          Print(root.middle);
	          Print(root.right);
	      }
	  }
	}


