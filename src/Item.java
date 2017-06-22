//This is our Item class. Each item can have a name, type, description, and weight. The accessor, mutator, and 
//toString methods are here too.

public class Item {

	public String name;
	public String type;
	public String description;
	public int weight;
	
	public Item(String n, String t, String d, int w)
	{
		name = n;
		type = t;
		description = d;
		weight = w;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setName(String nName)
	{
		name = nName;
	}
	
	public void setType(String nType)
	{
		type = nType;
	}
	
	public void setDescription(String nDescription)
	{
		description = nDescription;
	}
	
	public void setWeight(int nWeight)
	{
		weight = nWeight;
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
	
	public boolean isIn(Location loc)
	   {
		   for(Item curr : loc.itemsInRoom)
		   {
			   if (getName().equals(curr.getName()))
				   return true;
		   }
		   return false;
	   }
	public String toString()
	{
		return "Item: " + name +
				"\nType: " + type +
				"\nDescription: " + description +
				"\nWeight: " + weight;
	}
	
	public boolean isLit(boolean isLit)
	{
		if(isLit == true)
			return true;
		return false;
	}
	
	public boolean isOiled(boolean isOiled)
	{
		if(isOiled == true)
			return true;
		return false;
	}
}