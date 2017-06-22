
import java.util.Scanner;

//This is our Driver class. In it is the main method that will create and define all the items in the room.
//It also defines the location and gives the player a charge. The player can type in commands and examine, take, or use 
//items.

//Authors: Mason, Eli, Trey, and Adam
//Updated: 10/27/16

public class Driver {
	static ContainerItem inventory = new ContainerItem("Inventory", "Container Item", "This is Your Inventory", 0);

	public static void main(String[] args) {
		boolean isLit = false;
		boolean isOiled = false;
		// Creates items in The Room
		Item hole = new Item("Hole", "Entrance/Exit",
				"A hole in the ceiling of the room. You must find a way to exit the room through it", 0);

		ContainerItem bookshelf = new ContainerItem("Bookshelf", "Wood",
				"A large, easily destroyed bookshelf containing an expansive assortment of different books. None of them seem useful to you.",
				200);

		Item hammer = new Item("Hammer", "Tool",
				"A hammer on top of the bookshelf - used for constructing and destructing", 3);

		Item stepstool = new Item("Stepstool", "Tool", "A stool used for stepping on", 10);

		Item lantern = new Item("Lantern", "Tool",
				"An oil lantern. When lit, will allow the player to see all objects in the room.", 5);
		Item lighter = new Item("Lighter", "Tool", "A lighter. It can light things.", 1);
		
		Item nails = new Item("Nails", "Tool",
				"A box of nails. Useful when a hammer is present.", 5);
Item key = new Item("Key", "Key Item",
				"A small, rusted key", 0);

		Item lock = new Item("Lock", "Tool", "A rusty lock barring you from the outside.", 2);

		Item oil = new Item("Oil", "Tool",
				"An old can of oil, there's just a tiny bit left inside.", 5);
		Item glass = new Item("Glass", "Tool", "A shard of glass. Looks pretty sharp.", 1);
		Item rope = new Item("Rope", "Location Item", "A rope that has been attatched skillfully to secure point in the room. It has something attatched to the other end hanging above the cieling.", 1);
		ContainerItem chest = new ContainerItem("Chest", "container",
				"A small chest, looks like it was being kept away from someone.",
				20);
		ContainerItem desk = new ContainerItem("Desk", "container",
				"A singular old desk. I probably used something like that in middle school.",
				50);

		// Set new location
		Location north = new Location("North", "The north side of the room.");
		Location south = new Location("South", "The south side of the room.");
		Location east = new Location("East", "The eastern side of the room.");
		Location west = new Location("West", "The western side of the room.");
		Location north2 = new Location("North", "The north side of the room.");
		Location south2 = new Location("South", "The south side of the room.");
		Location east2 = new Location("East", "The eastern side of the room.");
		Location west2 = new Location("West", "The western side of the room.");

		Location currLocation = north;

		north.addItem(hole);
		north.addItem(lighter);
		north.addItem(lantern);
		
		south.addItem(bookshelf);
		south.addItem(hammer);

		east.addItem(stepstool);
		
		west.addItem(nails);
		
		north2.addItem(desk); 
		south2.addItem(lock);
		east2.addItem(glass);
		west2.addItem(rope);
		chest.addToInventory(oil);
		desk.addToInventory(key);
		
		north.setMap("west", west);
		north.setMap("south", south);
		north.setMap("east", east);

		south.setMap("west", west);
		south.setMap("north", north);
		south.setMap("east", east);

		east.setMap("west", west);
		east.setMap("south", south);
		east.setMap("north", north);

		west.setMap("north", north);
		west.setMap("south", south);
		west.setMap("east", east);
		
		north2.setMap("west", west2);
		north2.setMap("south", south2);
		north2.setMap("east", east2);

		south2.setMap("west", west2);
		south2.setMap("north", north2);
		south2.setMap("east", east2);

		east2.setMap("west", west2);
		east2.setMap("south", south2);
		east2.setMap("north", north2);

		west2.setMap("north", north2);
		west2.setMap("south", south2);
		west2.setMap("east", east2);

		// Reads input
		Scanner userIn = new Scanner(System.in);
		System.out.println("********  THE ROOM  ********"
				 + "\nYou wake up with a large headache in a dark room. What do you do?\n(Type 'help' for commands)");
		String answer = "";

		while (!answer.equals("quit")) {
			answer = userIn.nextLine();
			answer.trim();
			String[] answers1 = new String[4];
			String[] answers2 = answer.split(" ");

			for (int i = 0; i < answers2.length; i++) {
				answers1[i] = answers2[i];
			}

			for (int j = 0; j < answers1.length; j++) {
				if (answers1[j] == null)
					answers1[j] = "h";
			}
			// it would be useful to have use cases, but only when we have more
			// methods
			switch (answers1[0]) {
			case "room2":
				currLocation = north2;
				isLit = true;
				break;
			case "look":
				if (lantern.isLit(isLit) == true) {
					if (currLocation == north) {
						System.out.println(north.getDesc());
						System.out.println("Items in the room: ");
						north.listItems();
					} else if (currLocation == south) {
						System.out.println(south.getDesc());
						System.out.println("Items in the room: ");
						south.listItems();
					} else if (currLocation == east) {
						System.out.println(east.getDesc());
						System.out.println("Items in the room: ");
						east.listItems();
					} else if (currLocation == west) {
						System.out.println(west.getDesc());
						System.out.println("Items in the room: ");
						west.listItems();
					} else if (currLocation == north2) {
						System.out.println(north2.getDesc());
						System.out.println("Items in the room: ");
						north2.listItems();
					} else if (currLocation == south2) {
						System.out.println(south2.getDesc());
						System.out.println("Items in the room: ");
						south2.listItems();
					} else if (currLocation == east2) {
						System.out.println(east2.getDesc());
						System.out.println("Items in the room: ");
						east2.listItems();
					} else if (currLocation == west2) {
						System.out.println(west2.getDesc());
						System.out.println("Items in the room: ");
						west2.listItems();
					} 
					
					
				} else
					System.out.println(
							"It is pitch black! In the north sector, there is conveniently a lighter and lantern right where you woke up. "
									+ "\nA light shines through a hole in the ceiling above you.");
				break;
			case "help":
				System.out.println(
						"Use commands to make your way through the room.\nType 'look' to see where you are and what is around."
								+ "\nType 'examine Name' to examine an item, \n"
								+ "Type 'look' to see where you are and what is around, \n"
								+ "Type 'take Item' to take an item, \n"
								+ "Type 'put Item in Item' to put an item in another item, \n"
								+ "Type 'take Item from Item' to take an item from another item, \n"
								+ "Type 'inventory' to examine your inventory, \n"
								+ "Type 'drop Item' to drop an item in your current location, \n"
								+ "Type 'go DIRECTION' to face a different side of the room,\n"
								+ "Type 'use Item on Item' to activate something,"
								+ "and type 'quit' to end the game. Enjoy! ");
				break;
			case "inventory":
				System.out.println(inventory.listItems());
				break;
			case "go":
				switch (answers1[1]) {
				case "north":
					if (currLocation == north)
						System.out.println("You cannot do that.");
					else if (currLocation == west)
						currLocation = west.switchLocations("north");
					else if (currLocation == east)
						currLocation = east.switchLocations("north");
					else if (currLocation == south)
						currLocation = south.switchLocations("north");
					else if (currLocation == north2)
						System.out.println("You cannot do that.");
					else if (currLocation == west2)
						currLocation = west2.switchLocations("north");
					else if (currLocation == east2)
						currLocation = east2.switchLocations("north");
					else if (currLocation == south2)
						currLocation = south2.switchLocations("north");
					break;
				case "south":
					if (currLocation == south)
						System.out.println("You cannot do that.");
					else if (currLocation == west)
						currLocation = west.switchLocations("south");
					else if (currLocation == east)
						currLocation = east.switchLocations("south");
					else if (currLocation == north)
						currLocation = north.switchLocations("south");
					if (currLocation == south2)
						System.out.println("You cannot do that.");
					else if (currLocation == west2)
						currLocation = west2.switchLocations("south");
					else if (currLocation == east2)
						currLocation = east2.switchLocations("south");
					else if (currLocation == north2)
						currLocation = north2.switchLocations("south");
					break;
				case "east":
					if (currLocation == east)
						System.out.println("You cannot do that.");
					else if (currLocation == west)
						currLocation = west.switchLocations("east");
					else if (currLocation == south)
						currLocation = south.switchLocations("east");
					else if (currLocation == north)
						currLocation = north.switchLocations("east");
					else if (currLocation == east2)
						System.out.println("You cannot do that.");
					else if (currLocation == west2)
						currLocation = west2.switchLocations("east");
					else if (currLocation == south2)
						currLocation = south2.switchLocations("east");
					else if (currLocation == north2)
						currLocation = north2.switchLocations("east");
					break;
				case "west":
					if (currLocation == west)
						System.out.println("You cannot do that.");
					else if (currLocation == east)
						currLocation = east.switchLocations("west");
					else if (currLocation == south)
						currLocation = south.switchLocations("west");
					else if (currLocation == north)
						currLocation = north.switchLocations("west");
					else if (currLocation == west2)
						System.out.println("You cannot do that.");
					else if (currLocation == east2)
						currLocation = east2.switchLocations("west");
					else if (currLocation == south2)
						currLocation = south2.switchLocations("west");
					else if (currLocation == north2)
						currLocation = north2.switchLocations("west");
					break;
				default:
					System.out.println("I'm sorry, I do not understand your command.");
					break;
				}
				break;
			case "put":
				switch (answers1[2]) {
				case "in":
					switch (answers1[3]) {
					case "Bookshelf":
						if (bookshelf.isIn(currLocation))
						{
						switch (answers1[1]) {
						case "Bookshelf":
							System.out.println("You cannot do that.");
							break;
						case "Hammer":
							if (!hammer.isIn(bookshelf) && hammer.isIn(inventory)) {
								bookshelf.addToInventory(hammer);
								inventory.removeFromInventory(hammer);
								break;
							} else {
								System.out.println("You cannot do that.");
							}
							break;
						case "Stepstool":
							if (!stepstool.isIn(bookshelf) && stepstool.isIn(inventory)) {
								bookshelf.addToInventory(stepstool);
								inventory.removeFromInventory(stepstool);
								break;
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lantern":
							if (!lantern.isIn(bookshelf) && lantern.isIn(inventory)) {
								bookshelf.addToInventory(lantern);
								inventory.removeFromInventory(lantern);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						case "Nails":
							if (!nails.isIn(bookshelf) && nails.isIn(inventory)) {
								bookshelf.addToInventory(nails);
								inventory.removeFromInventory(nails);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						case "Lighter":
							if (!lighter.isIn(bookshelf) && lighter.isIn(inventory)) {
								bookshelf.addToInventory(lighter);
								inventory.removeFromInventory(lighter);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						default:
							System.out.println("I'm sorry, but I can't understand your command.");
							break;
						}
						break;
					}
						else
							System.out.println("There is no bookshelf nearby.");
						break;
					case "Chest":
						if (chest.isIn(currLocation))
						{
						switch (answers1[1]) {
						case "Chest":
							System.out.println("You cannot do that.");
							break;
						case "Hammer":
							if (!hammer.isIn(bookshelf) && hammer.isIn(inventory)) {
								bookshelf.addToInventory(hammer);
								inventory.removeFromInventory(hammer);
								break;
							} else {
								System.out.println("You cannot do that.");
							}
							break;
						case "Stepstool":
							if (!stepstool.isIn(bookshelf) && stepstool.isIn(inventory)) {
								bookshelf.addToInventory(stepstool);
								inventory.removeFromInventory(stepstool);
								break;
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lantern":
							if (!lantern.isIn(bookshelf) && lantern.isIn(inventory)) {
								bookshelf.addToInventory(lantern);
								inventory.removeFromInventory(lantern);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						case "Nails":
							if (!nails.isIn(bookshelf) && nails.isIn(inventory)) {
								bookshelf.addToInventory(nails);
								inventory.removeFromInventory(nails);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						case "Lighter":
							if (!lighter.isIn(bookshelf) && lighter.isIn(inventory)) {
								bookshelf.addToInventory(lighter);
								inventory.removeFromInventory(lighter);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						default:
							System.out.println("I'm sorry, but I can't understand your command.");
							break;
						}
						break;
					}
						else
							System.out.println("There is no chest nearby.");
						break;
		
					case "Desk":
						if (desk.isIn(currLocation))
						{
						switch (answers1[1]) {
						case "Desk":
							System.out.println("You cannot do that.");
							break;
						case "Hammer":
							if (!hammer.isIn(bookshelf) && hammer.isIn(inventory)) {
								desk.addToInventory(hammer);
								inventory.removeFromInventory(hammer);
								break;
							} else {
								System.out.println("You cannot do that.");
							}
							break;
						case "Stepstool":
							if (!stepstool.isIn(bookshelf) && stepstool.isIn(inventory)) {
								desk.addToInventory(stepstool);
								inventory.removeFromInventory(stepstool);
								break;
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lantern":
							if (!lantern.isIn(bookshelf) && lantern.isIn(inventory)) {
								desk.addToInventory(lantern);
								inventory.removeFromInventory(lantern);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						case "Nails":
							if (!nails.isIn(bookshelf) && nails.isIn(inventory)) {
								desk.addToInventory(nails);
								inventory.removeFromInventory(nails);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						case "Lighter":
							if (!lighter.isIn(bookshelf) && lighter.isIn(inventory)) {
								desk.addToInventory(lighter);
								inventory.removeFromInventory(lighter);
								break;
							} 
							else
								System.out.println("You cannot do that.");
							break;
						default:
							System.out.println("I'm sorry, but I can't understand your command.");
							break;
						}
						break;
						
					}
						else
							System.out.println("There is no desk nearby.");
						break;
					default:
						System.out.println("I'm sorry, I do not understand your command.");
						break;
					}
					break;
					
				default:
					System.out.println("I'm sorry, I do not understand your command.");
					break;
				}
				break;
			
			case "take":
				switch (answers1[2]) {
				case "from":
					switch (answers1[3]) {
					case "Chest":
						if (chest.isIn(currLocation))
						{
						switch (answers1[1]) {
						case "Chest":
							System.out.println("You cannot do that.");
							break;
						case "Hammer":
							if (hammer.isIn(chest) && !hammer.isIn(inventory)) {
								chest.removeFromInventory(hammer);
								inventory.addToInventory(hammer);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Key":
							if (key.isIn(chest) && !key.isIn(inventory)) {
								chest.removeFromInventory(key);
								inventory.addToInventory(key);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Glass":
							if (glass.isIn(chest) && !glass.isIn(inventory)) {
								chest.removeFromInventory(glass);
								inventory.addToInventory(glass);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Oil":
							if (oil.isIn(chest) && !oil.isIn(inventory)) {
								chest.removeFromInventory(oil);
								inventory.addToInventory(oil);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Stepstool":
							if (stepstool.isIn(chest) && !stepstool.isIn(inventory)) {
								chest.removeFromInventory(stepstool);
								inventory.addToInventory(stepstool);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lantern":
							if (lantern.isIn(chest) && !lantern.isIn(inventory)) {
								chest.removeFromInventory(lantern);
								inventory.addToInventory(lantern);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lighter":
							if (lighter.isIn(chest) && !lighter.isIn(inventory)) {
								chest.removeFromInventory(lighter);
								inventory.addToInventory(lighter);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Nails":
							if (nails.isIn(chest) && !nails.isIn(inventory)) {
								chest.removeFromInventory(nails);
								inventory.addToInventory(nails);
							} else
								System.out.println("You cannot do that.");
							break;
						
						default:
							System.out.println("I'm sorry, but I can't understand your command.");
							break;
						}
						}
						else
						{
							System.out.println("There is no chest near you.");
						}
						break;
					case "Desk":
						if (desk.isIn(currLocation))
						{
						switch (answers1[1]) {
						case "Desk":
							System.out.println("You cannot do that.");
							break;
						case "Hammer":
							if (hammer.isIn(desk) && !hammer.isIn(inventory)) {
								desk.removeFromInventory(hammer);
								inventory.addToInventory(hammer);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Stepstool":
							if (stepstool.isIn(desk) && !stepstool.isIn(inventory)) {
								desk.removeFromInventory(stepstool);
								inventory.addToInventory(stepstool);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Key":
							if (key.isIn(desk) && !key.isIn(inventory)) {
								desk.removeFromInventory(key);
								inventory.addToInventory(key);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Glass":
							if (glass.isIn(desk) && !glass.isIn(inventory)) {
								desk.removeFromInventory(glass);
								inventory.addToInventory(glass);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Oil":
							if (oil.isIn(desk) && !oil.isIn(inventory)) {
								desk.removeFromInventory(oil);
								inventory.addToInventory(oil);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lantern":
							if (lantern.isIn(desk) && !lantern.isIn(inventory)) {
								desk.removeFromInventory(lantern);
								inventory.addToInventory(lantern);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lighter":
							if (lighter.isIn(desk) && !lighter.isIn(inventory)) {
								desk.removeFromInventory(lighter);
								inventory.addToInventory(lighter);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Nails":
							if (nails.isIn(desk) && !nails.isIn(inventory)) {
								desk.removeFromInventory(nails);
								inventory.addToInventory(nails);
							} else
								System.out.println("You cannot do that.");
							break;
						
						default:
							System.out.println("I'm sorry, but I can't understand your command.");
							break;
							
						}
						}
						else
						{
							System.out.println("There is no desk near you.");
						}
					break;
					case "Bookshelf":
						if (bookshelf.isIn(currLocation))
						{
						switch (answers1[1]) {
						case "Bookshelf":
							System.out.println("You cannot do that.");
							break;
						case "Hammer":
							if (hammer.isIn(bookshelf) && !hammer.isIn(inventory)) {
								bookshelf.removeFromInventory(hammer);
								inventory.addToInventory(hammer);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Stepstool":
							if (stepstool.isIn(bookshelf) && !stepstool.isIn(inventory)) {
								bookshelf.removeFromInventory(stepstool);
								inventory.addToInventory(stepstool);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Key":
							if (key.isIn(chest) && !key.isIn(inventory)) {
								chest.removeFromInventory(key);
								inventory.addToInventory(key);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Glass":
							if (glass.isIn(chest) && !glass.isIn(inventory)) {
								chest.removeFromInventory(glass);
								inventory.addToInventory(glass);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Oil":
							if (oil.isIn(chest) && !oil.isIn(inventory)) {
								chest.removeFromInventory(oil);
								inventory.addToInventory(oil);
								break;
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lantern":
							if (lantern.isIn(bookshelf) && !lantern.isIn(inventory)) {
								bookshelf.removeFromInventory(lantern);
								inventory.addToInventory(lantern);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Lighter":
							if (lighter.isIn(bookshelf) && !lighter.isIn(inventory)) {
								bookshelf.removeFromInventory(lighter);
								inventory.addToInventory(lighter);
							} else
								System.out.println("You cannot do that.");
							break;
						case "Nails":
							if (nails.isIn(bookshelf) && !nails.isIn(inventory)) {
								bookshelf.removeFromInventory(nails);
								inventory.addToInventory(nails);
							} else
								System.out.println("You cannot do that.");
							break;
						
						default:
							System.out.println("I'm sorry, but I can't understand your command.");
							break;
							
						}
						}
						else
						{
							System.out.println("There is no bookshelf near you.");
						}
						break;
						}
				default:
					
					break;
				}
				
				switch (answers1[1]) {
				case "Hole":
					System.out.println("You cannot take this item");
					break;
				case "Bookshelf":
					System.out.println("You cannot take this item");
					break;
				case "Hammer":
					if (hammer.isIn(currLocation)) {
						if(stepstool.isIn(currLocation))
						{
							inventory.addToInventory(hammer);
							currLocation.removeItem(hammer);
						}
						else
							System.out.println("The hammer cannot be reached!" 
									+ "\nPerhaps there is a tool that can be dropped in this sector that could help you...");
						break;
					}
					break;

				case "Stepstool":
					if (stepstool.isIn(currLocation)) {
						inventory.addToInventory(stepstool);
						currLocation.removeItem(stepstool);
						break;
					}
					break;
				case "Oil":
					if (oil.isIn(currLocation)) {
						inventory.addToInventory(oil);
						currLocation.removeItem(oil);
						break;
					}
					break;
				case "Glass":
					if (glass.isIn(currLocation)) {
						inventory.addToInventory(glass);
						currLocation.removeItem(glass);
						break;
					}
					break;
				case "Key":
					if (key.isIn(currLocation)) {
						inventory.addToInventory(key);
						currLocation.removeItem(key);
						break;
					}
					break;
				case "Chest":
					System.out.println("You cannot do that.");
					break;
				case "Lock":
					System.out.println("The lock is attatched to the door. You are unable to take it.");
					break;
				case "Rope":
					System.out.println("The rope is tightly secured by a complex knot, you are unable to take it.");
					break;
				case "Desk":
					System.out.println("You cannot do that.");
					break;
				case "Lantern":
					if (lantern.isIn(currLocation)) {
						inventory.addToInventory(lantern);
						currLocation.removeItem(lantern);
						break;
					}
					break;
				case "Lighter":
					if (lighter.isIn(currLocation)) {
						inventory.addToInventory(lighter);
						currLocation.removeItem(lighter);
						break;
					}
					break;
				case "Nails":
					if (nails.isIn(currLocation)) {
						inventory.addToInventory(nails);
						currLocation.removeItem(nails);
						break;
					}
					break;

				default:
					System.out.println("I'm sorry, but I can't understand your command.");
					break;
				}
				break;

			case "drop":
				switch (answers1[1]) {
				case "Hole":
					System.out.println("You cannot take this item");
					break;
				case "Oil":
					if (oil.isIn(inventory)) {
						inventory.removeFromInventory(oil);
						currLocation.addItem(oil);
					}
					break;
				case "Desk":
					if (desk.isIn(inventory)) {
						inventory.removeFromInventory(desk);
						currLocation.addItem(desk);
					}
					break;
				case "Key":
					if (key.isIn(inventory)) {
						inventory.removeFromInventory(key);
						currLocation.addItem(key);
					}
					break;
				case "Glass":
					if (glass.isIn(inventory)) {
						inventory.removeFromInventory(glass);
						currLocation.addItem(glass);
					}
					break;
				case "Lock":
					if (lock.isIn(inventory)) {
						inventory.removeFromInventory(lock);
						currLocation.addItem(lock);
					}
					break;
				case "Chest":
					if (chest.isIn(inventory)) {
						inventory.removeFromInventory(chest);
						currLocation.addItem(chest);
					}
					break;
				case "Rope":
					if (rope.isIn(inventory)) {
						inventory.removeFromInventory(rope);
						currLocation.addItem(rope);
					}
					break;
				case "Bookshelf":
					if (bookshelf.isIn(inventory)) {
						inventory.removeFromInventory(bookshelf);
						currLocation.addItem(bookshelf);
					}
					break;
				case "Hammer":
					if (hammer.isIn(inventory)) {
						inventory.removeFromInventory(hammer);
						currLocation.addItem(hammer);
					}
					break;
				case "Stepstool":
					if (stepstool.isIn(inventory)) {
						inventory.removeFromInventory(stepstool);
						currLocation.addItem(stepstool);
					}
					break;
				case "Lantern":
					if (lantern.isIn(inventory)) {
						inventory.removeFromInventory(lantern);
						currLocation.addItem(lantern);
					}
					break;
				case "Lighter":
					if (lighter.isIn(inventory)) {
						inventory.removeFromInventory(lighter);
						currLocation.addItem(lighter);
					}
					break;
				case "Nails":
					if (nails.isIn(inventory)) {
						inventory.removeFromInventory(nails);
						currLocation.addItem(nails);
					}
					break;
				default:
					System.out.println("I'm sorry, but I can't understand your command.");
					break;
				}
				break;

			case "use":
				switch (answers1[1]) {
				case "Lighter":
					switch (answers1[2]) {
					case "on":
						switch (answers1[3]) {
						case "Lantern":
							if (lantern.isIn(inventory)) {
								isLit = true;
								System.out.println("The lantern has been lit!");
								break;
							}
							break;
						default:
							System.out.println("Sorry, but one or both of those is not in your inventory");
							break;
						}
					default:
					break;
					}
				break;
				case "Hammer":
					switch (answers1[2]) {
					case "on":
						switch (answers1[3]) {
						case "Bookshelf":
							if (hammer.isIn(inventory))
							{
								System.out.println("You broke the bookshelf down to several pieces of wood.");
								Item wood = new Item("Wood", "Several pieces of wood. Can be used to craft something.", "Tool", 20);
								inventory.addToInventory(wood);
								south.removeItem(bookshelf);
							}
							break;
						case "Wood":
							if(hammer.isIn(inventory) && nails.isIn(inventory))
							{
								System.out.println("You built a ladder out of the pieces of wood.");
								Item ladder = new Item("Ladder", "A ladder.", "Tool", 20);
								inventory.addToInventory(ladder);
								inventory.removeFromInventory(nails);
							}
						default: break;
						}
						break;
					}
					break;
				case "Ladder":
					switch (answers1[2]) {
					case "on":
						switch(answers1[3]) {
						case "Hole":
							if(currLocation == north)
							{
								System.out.println("You used the ladder on the hole. You climb out the hole, only to discover"
									+ " \nthat you are in another mysterious room!");
								currLocation = north2;
							}
							else
								System.out.println("You are not near the hole.");
						}
					}
					break;
				case "Glass":
					switch (answers1[2]) {
					case "on": 
						switch(answers1[3]) {
						case "Rope":
							if (glass.isIn(inventory))
							{
							rope.setDescription("A rope that has been cut, but is still secured onto the wall and the chest.");
							west2.addItem(chest);
							System.out.println("You cut the rope and a chest falls from the ceiling.");
							}
							else
								System.out.println("You have nothing to cut the rope with.");
							break;
						}
						
						break;
					}
				
				case "Key":
					switch (answers1[2]) {
					case "on": 
						switch(answers1[3]) {
						case "Lock":
							if (isOiled)
							{
								System.out.println("You open the lock and push open the doors. A bright light overpowers your vision."
										+ "\nYou gasp and open your eyes. You are lying in your bed, awoken from that strange dream.");
								answer = "quit";
							}
							else
								System.out.println("The key fits, but the lock is so rusted it will not turn.");	
						}
					
						break;
					}
					default:
					break;
				case "Oil":
					switch (answers1[2]) {
					case "on":
						switch(answers1[3]) {
						case "Lock":
							if(oil.isIn(inventory))
							{
								System.out.println("You oiled the lock, making it possible to unlock the door.");
								isOiled = true;
							}
							else
								System.out.println("You have no oil.");
						break;
						default: break;
						}
					}
				}
				break;
			case "examine":
				switch (answers1[1]) {
				case "Hole":
					if (hole.isIn(currLocation))
						System.out.println(hole.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Bookshelf":
					if (bookshelf.isIn(currLocation))
						System.out.println(bookshelf.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Hammer":
					if (hammer.isIn(currLocation))
						System.out.println(hammer.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Stepstool":
					if (stepstool.isIn(currLocation))
						System.out.println(stepstool.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Lantern":
					if (lantern.isIn(currLocation))
						System.out.println(lantern.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Lighter":
					if (lighter.isIn(currLocation))
						System.out.println(lighter.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Key":
					if (key.isIn(currLocation))
						System.out.println(key.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Lock":
					if (lock.isIn(currLocation))
						System.out.println(lock.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Glass":
					if (glass.isIn(currLocation))
						System.out.println(glass.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Chest":
					if (chest.isIn(currLocation))
						System.out.println(chest.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Desk":
					if (desk.isIn(currLocation))
						System.out.println(desk.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Rope":
					if (rope.isIn(currLocation))
						System.out.println(rope.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Oil":
					if (oil.isIn(currLocation))
						System.out.println(oil.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				case "Nails":
					if (nails.isIn(currLocation))
						System.out.println(nails.getDescription());
					else
						System.out.println("That item is not in this sector.");
					break;
				default:
					System.out.println("I'm sorry, but I can't understand your command.");
					break;
				}
				break;
			case "quit":
				System.out.println("Thanks for playing!");
				break;
			default:
				System.out.println("I'm sorry, but I can't understand your command.");

			}
		}
		
		
		userIn.close();
	}
}
