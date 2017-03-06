package controllers;

public class BalancedBinaryTree {




    public Node root;
 
    public BalancedBinaryTree()
    {
        root = null;
    }
 
    public boolean isEmpty()
    {
        return root == null;
    }
 
    public void clear()
    {
        root = null;
    }
 
    public void insert(Item item)
    {
        root = insert(item, root);
    }
 
    public int height(Node t)
    {
 
        return t == null ? -1 : t.height;
    }
 
    public int max(int leftheight, int rightheight)
    {
        return leftheight > rightheight ? leftheight : rightheight;
    }
 
   public Node insert(Item item, Node t)
    {
        if (t == null)
            t = new Node(item);
        else if (item.spanish.compareTo(t.item.spanish) <0)
        {
            t.left = insert(item, t.left);
            if (height(t.left) - height(t.right) == 2)
                if (item.spanish.compareTo(t.left.item.spanish)<0)
                    t = rotateWithLeftChild(t);
                else
                    t = doubleWithLeftChild(t);
        } else if (item.spanish.compareTo(t.item.spanish)>0)
        {
            t.right = insert(item, t.right);
            if (height(t.right) - height(t.left) == 2)
                if (item.spanish.compareTo(t.right.item.spanish)>0)
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
        } else
           
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }
 
    public Node rotateWithLeftChild(Node k2)
    {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }
 
    public Node rotateWithRightChild(Node k1)
    {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }
 
    public Node doubleWithLeftChild(Node k3)
    {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
 
    public Node doubleWithRightChild(Node k1)
    {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
 
    public int countNodes()
    {
        return countNodes(root);
    }
 
    public int countNodes(Node r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
 

    
  
    
 
    
    public String search(String value)
    {
      Node tree = root;
        
        while (root != null)
        {
            if (value.compareTo(tree.item.spanish) == 0)
            {
                
                System.out.println(tree.item.english.toString());
                return tree.toString();
            }
            else if (value.compareTo(tree.item.spanish) < 0)
            {
                tree = tree.left;
            }
            else if (value.compareTo(tree.item.spanish) > 0)
            {
                tree = tree.right;
            }
        }
        
        return null;
        
        
        
    }
    public void inorder()
    {
        inorder(root);
    }
 
    public void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.item + " ");
            inorder(r.right);
        }
    }
 
    public void preorder()
    {
 
        preorder(root);
    }
 
    public void preorder(Node r)
    {
        if (r != null)
        {
            System.out.print(r.item + " ");
            preorder(r.left);
            preorder(r.right);
        }
    }
 
    public void postorder()
    {
        postorder(root);
    }
 
    public void postorder(Node r)
    {
        if (r != null)
        {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.item + " ");
        }
    }

}