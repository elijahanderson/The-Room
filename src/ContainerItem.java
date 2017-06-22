import java.util.ArrayList;

public class ContainerItem extends Item {

   public ContainerItem(String n, String t, String d, int w)
   {
	   super(n, t, d, w);
	   name = n;
		type = t;
		description = d;
		weight = w;
   }
   
   ArrayList<Item> inventory = new ArrayList<Item>();
   
   public void addToInventory(Item item)
   {
      inventory.add(item);
      System.out.println(item.getName() + " added to "+ getName());
   }
   
   public void removeFromInventory(Item item)
   {
      inventory.remove(item);
      System.out.println(item.getName() + " removed from "+ getName());
   }
   
   public int numItems()
   {
      return inventory.size();
   }
   
   public boolean isIn(ContainerItem item)
   {
	   for(Item curr : item.inventory)
	   {
		   if (getName().equals(curr.getName()))
			   return true;
	   }
	   return false;
   }
   
   public String listItems()
   {
	   String temp = getName() + " Contains: ";
       for( Item curr : inventory)
	    {
			temp += "\n" + curr;
		}
      return temp;
   }
   
   public Item findItemUsingIndex(int index)
	{
		return inventory.get(index);
	}
	
	public Item findItemUsingName(String name)
	{
		for( Item curr : inventory)
		{
			if(curr.getName().equals(name))
				return curr;
		}
		return null;
	}
   
   @Override
   public String getDescription()
   {
	   String inv = "This Item contains " + numItems() + " items.\n";
      if(numItems() > 0)
	         inv += listItems();
	   else
		   return "Item is Empty";
      
         return inv;
   }
   

}
