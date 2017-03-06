package controllers;

class Node
{
    Node right, left;
   
    Item	   item;
    int        height;
 
    public Node()
    {
        left = null;
        right = null;
       
        item = null;
        height = 0;
    }
 
    public Node(Item item)
    {
 
        left = null;
        right = null;
        
        this.item = item;
        height = 0;
    }

@Override
	public String toString() {
		return item.getEnglish();
	}
	
	
	
	
}