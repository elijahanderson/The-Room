import java.util.ArrayList;
import java.util.HashMap;

//This is our Location class. There are two String arguements for the name and description of the Location along with an
//ArrayList that stores the items in the room. There are accessor and mutator methods for the location in addition to
//methods that modify and access the ArrayList.

public class Location {

	private String name;
	private String description;
	ArrayList<Item> itemsInRoom = new ArrayList<Item>();
	HashMap<String,Location> map = new HashMap<String,Location>();

	
	public Location(String n, String d)
	{
		name = n;
		description = d;
	}
	
	public void setMap(String direction, Location location)
	{
		map.put(direction, location);
	}
	
	public Location switchLocations(String direction)
	{
		if(map.containsKey(direction))
		{
			System.out.println("You are now facing the " + direction + " side of the room.");
			return map.get(direction);
		}
		else
			return null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDesc()
	{
		return description;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setDesc(String d)
	{
		description = d;
	}
	
	public void listItems()
	{
		for( Item curr : itemsInRoom)
		{
			System.out.println(curr);
		}
	}
	
	public void addItem(Item item)
	{
		itemsInRoom.add(item);
	}
	
	public void removeItem(Item item)
	{
		itemsInRoom.remove(item);
	}
	
	public int numItems()
	{
		return itemsInRoom.size();
	}
	
	public int findIndexOfName(String name)
	{
		for(int i = 0; i < itemsInRoom.size()-1; i++)
		{
			if (itemsInRoom.get(i).equals(name))
				return i;
		}
		return -1;
	}

	
	public String findItemUsingIndex(int index)
	{
		return itemsInRoom.get(index).toString();
	}
	
	public Item findItemUsingName(String name)
	{
		for( Item curr : itemsInRoom)
		{
			if(curr.getName().equals(name))
				return curr;
		}
		return null;
	}

}