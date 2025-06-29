import java.util.Scanner;
class Node
{
    int key;
    Node left,right;
    public Node(int item)
    {
        key=item;
        left=right=null;
    }
}
class BinaryTree
{
    Node root;
    BinaryTree() 
    {
        root = null;
    }
    // Method to insert a new node into the tree
    void insert(int key) 
    {
        root = insertRec(root, key);
    }
    // A recursive utility function to insert a new key in BST
    Node insertRec(Node root, int key) 
    {
        if (root == null) 
        {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    // Method for inorder traversal of the tree
    void inorder() 
    {
        inorderRec(root);
    }
    // Method for preorder traversal of the tree
    void preorder() 
    {
        preorderRec(root);
    }
    // Method for postorder traversal of the tree
    void postorder() 
    {
        postorderRec(root);
    }
    // A recursive utility function to perform inorder traversal
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    // A recursive utility function to perform preorder traversal
    void preorderRec(Node root)
    {
        if (root != null)
        {
            System.out.println(root.key + " ");
            preorderRec(root.left);            
            preorderRec(root.right);
        }
    }
    // A recursive utility function to perform postorder traversal
    void postorderRec(Node root)
    {
        if (root != null)
        {            
            postorderRec(root.left);            
            postorderRec(root.right);
            System.out.println(root.key + " ");
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        // Inserting elements into the tree
        System.out.println("Enter number of nodes in Binary Tree");
        int node=sc.nextInt();
        for(int i=0;i<node;i++)
        {
            System.out.println("Enter number to be added");
            int k=sc.nextInt();
            tree.insert(k);
        }
        // Printing inorder traversal of the constructed tree
        System.out.println("Inorder traversal of the binary tree:");
        tree.inorder();
        System.out.println("Preorder traversal of the binary tree:");
        tree.preorder();
        System.out.println("Postorder traversal of the binary tree:");
        tree.postorder();
    }
}