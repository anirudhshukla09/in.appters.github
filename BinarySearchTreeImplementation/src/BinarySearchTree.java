
public class BinarySearchTree {
	
	
	/*
	 * Implemented Features:
	 * 1.Max,Min
	 * 2.MinDepth,MaxDepth
	 * 3.Tree traversal-In,Pre and Post Order
	 * 4.Diameter of Binary Tree
	 * 5.Search Node
	 * 6.Insert Node
	 */
	
	
	public static void main(String args[]){
		
		new BinarySearchTree().run();
	}
	
	public static class Node{
		
		int nodeValue;
		Node leftReference;
		Node rightReference;
		
	
	
		public Node(int val){
			
			this.nodeValue = val;
		}
	}//EofNode
	
	
	public void run() {
        Node rootnode = new Node(8);
        System.out.println("Building tree with rootvalue " + rootnode.nodeValue);
        System.out.println("================================");
        System.out.println("Create the Tree");
        insertNode(rootnode,3);
        insertNode(rootnode,10);
        insertNode(rootnode,1);
        insertNode(rootnode,6);
        insertNode(rootnode,7);
        insertNode(rootnode,4);
        insertNode(rootnode,13);
        insertNode(rootnode,14);
        System.out.println("Tree Created" );
        
        /*System.out.println("Traversing tree Preorder");
        System.out.println("===============================");
        printPreOrder(rootnode);
        
        System.out.println("Traversing tree Inorder");
        System.out.println("===============================");
        printInOrder(rootnode);
        
        System.out.println("Traversing tree Postorder");
        System.out.println("===============================");
        printPostOrder(rootnode);*/
        
        System.out.print("The max node is=");
        System.out.print(findMax(rootnode));
        
        System.out.print("The min node is=");
        System.out.print(findMin(rootnode));
        
        
        System.out.print("Diameter of BInary Tree=");
        System.out.print(diameterOfBinaryTree(rootnode));
        
	}
	
	
	//Method to add/insert node in BinaryTree
	public void insertNode(Node parentNode,int value){
	    
	       if(value<parentNode.nodeValue){
	           if(parentNode.leftReference!=null){
	             insertNode(parentNode.leftReference, value);
	            
	           }else{
	              parentNode.leftReference = new Node(value);
	           }
	       
	       }else if(value>parentNode.nodeValue){
	       
	         if(parentNode.rightReference != null){
	           insertNode(parentNode.rightReference, value);
	         
	         }
	         else{
	           
	             parentNode.rightReference = new Node(value);
	         }
	       
	       }
	    
	     }
	
	
	public void printPreOrder(Node node){
        if(node!=null){
        	System.out.print("  Traversed " + node.nodeValue);
        	printPreOrder(node.leftReference);  
        	printPreOrder(node.rightReference);
        }
    
    }
	
	
	public void printInOrder(Node node){
        if(node!=null){
           printInOrder(node.leftReference);
           System.out.print("  Traversed " + node.nodeValue); 
           printInOrder(node.rightReference);
        }
    
    }
	
	
	public void printPostOrder(Node node){
        if(node!=null){
           printPostOrder(node.leftReference);
           printPostOrder(node.rightReference);
           System.out.print("  Traversed " + node.nodeValue); 
        }
    
    }
	
	
	//find max node
	@SuppressWarnings("null")
	public int findMax(Node startNode)
	{
		if(startNode==null){
			return 0;
		}
		
		if(startNode.rightReference!=null){
			
			return findMax(startNode.rightReference);
		}
		return startNode.nodeValue;
		
		
	}	
	
	
	public int maxDepth(Node node){
	     
        if(node == null){
         return 0;
        }else{
         
            return 1+ Math.max(maxDepth(node.leftReference),maxDepth(node.rightReference));
        }
    
    }
    
    
    public int minDepth(Node node){
     
        if(node == null){
         return 0;
        }else{
         
            return 1+ Math.min(minDepth(node.leftReference),minDepth(node.rightReference));
        }
    
    }
	
	public int findMin(Node startNode){
		if(startNode==null){
			return 0;
		}
		if(startNode.leftReference!=null){
			return findMin(startNode.leftReference);
			
		}
		
		return startNode.nodeValue;
		
		
	}
	
 
    
    /**
     * Binary search
     * Complexity O(log(n))
     * @param data
     */
    public void search(Node parentNode,int value){
    
        
         if(parentNode == null)
             return;
         if(parentNode.nodeValue > value){
            search(parentNode.leftReference, value);
         
         } else if(parentNode.nodeValue < value){
            
             search(parentNode.rightReference, value);
            }
         else{
          System.out.print("Object Found");
          return;
         }
        //System.out.println("Not Found");
    }
    
	
	
    
    public int diameterOfBinaryTree(Node node)
    {
        if (node == null)
        {
            return 0;
        }
 
        int leftHeight = maxDepth(node.leftReference);
        int rightHeight = maxDepth(node.rightReference);
 
        int leftDiameter = diameterOfBinaryTree(node.leftReference);
        int rightDiameter = diameterOfBinaryTree(node.rightReference);
 
        return Math.max(leftHeight + rightHeight + 1,
            Math.max(leftDiameter, rightDiameter));
    }
	
	

}
/*
 * public class BinaryTreesImplementation {

    
   
    
   
    
    
    
    public boolean isBST(Node node)
    {
        //  true for empty tree
        if(node == null)
        {
            return true;
        }
 
        //  false if the max of the left is > than current data
        if(node.leftReference != null && maxValue(node.leftReference) > node.nodeValue)
        {
            return false;
        }
 
        System.out.println(node.nodeValue);
 
        //  false if the min of the right is <= than current data
        if(node.rightReference != null && minValue(node.rightReference) <= node.nodeValue)
        {
            return false;
        }
 
        System.out.println(node.nodeValue);
 
        //  false if, recursively, the left or right is not a BST
        if(!isBST(node.leftReference) || !isBST(node.rightReference))
        {
            return false;
        }
 
        //  passing all that, it's a BST
        return true;
    }
 
    public int maxValue(Node node)
    {
        while(node.rightReference != null)
        {
            node = node.rightReference;
        }
        return node.nodeValue;
    }
 
    public int minValue(Node node)
    {
        while(node.leftReference != null)
        {
            node = node.leftReference;
        }
        return node.nodeValue;
    }
    
  // public boolean isBST2(Node node)
    //{
     //   return (isBST2(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
    //}
   
 
   public boolean isBST2(Node node, int minValue, int maxValue)
    {
        //  True is its a empty tree
        if(node == null)
        {
            return true;
        }
 
        //  False if this node violates the BST property
        if(node.nodeValue< minValue || node.nodeValue> maxValue)
        {
            return false;
        }
 
        //  Otherwise check the subtree recursively
        //return (isBST(node.leftReference, minValue, node.nodeValue) && isBST(node.rightReference, node.nodeValue, maxValue));
    } */
    
    
    
    
    
    

    
 
