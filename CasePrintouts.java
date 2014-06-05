package game;
import java.util.*;

/**
 * the user is taken to this class if he types any command that has nothing to do with Help
 * @author Michael Bartl
 *
 */
public class CasePrintouts
{
	// all the methods here should hopefully be self-explaining

	public void getDate()
	{
		Date date =new Date();

		System.err.println (date);
	}

	public void buildHouse()
	{
		//check for resources
		System.out.println("A house has been built.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void buildForesterHouse()
	{
		//check for resources
		System.out.println("A forester house has been built.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void buildMine()
	{
		//check for resources
		System.out.println("A mine has been built.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void buildForge()
	{
		//check resources
		System.out.println("A forge has been built.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void buildClayPit()
	{
		//check resources
		System.out.println("A clay pit has been built.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void buildSchool()
	{
		//check resources
		System.out.println("A school has been built.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void buildChapel()
	{
		//check resources
		System.out.println("A chapel has been built.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void buildCastle()
	{
		//check resources
		System.out.println("A castle has been built.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void resources()
	{
		//check resources
		System.err.println("Resources: ");
	}

	public void goToHouse()
	{
		//buildings package
		System.out.println("You are now at the house. \nCitizens: \nCitizens with no job: ");
	}

	public void goToForesterHouse()
	{
		//buildings package
		System.out.println("You are now at the forester house.\nWood: \nForesters: ");
	}

	public void goToMine()
	{
		//buildings package
		System.out.println("You are now at the mine. \nStone: \nMiners:");
	}

	public void goToForge()
	{
		//buildings package
		System.out.println("You are now at the forge. \nIron: \nForgers");
	}

	public void goToClayPit()
	{
		//buildings package
		System.out.println("You are now at the clay pit. \nClay: \nPotters: ");
	}

	public void goToCastle()
	{
		//buildings package
		System.out.println("You are now at the castle.");
	}

	public void exit()
	{
		System.out.println("You exited the program. See you later alligator!");
	}

	public void buildings()
	{
		System.err.println("You have...forester houses. \nYou have...mines");
	}

	public void learnforester()
	{
		//check resources
		System.out.println("A citizen has learned forester.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void learnminer()
	{
		//check resources
		System.out.println("A citizen has learned miner.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void learnforge()
	{
		//check resources
		System.out.println("A citizen has learned forge.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void learnpotter()
	{
		//check resources
		System.out.println("A citizen has learned potter.");
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void electking()
	{
		//check resources		
		Scanner scanking = new Scanner (System.in);
		System.out.println(" Are you sure you want to elect a... as the new king? y/n \n");
        char choice=scanking.next().toCharArray()[0];
        
		switch (choice)
		{
		case 'y': System.out.println(" The citizens celebrate the new king!"); break;
		case 'n': System.out.println(" The king wasn´t elected."); break;
		default: System.out.println(" Please make a decision!"); break;
		}
		//or
		System.out.println("You don´t have enough resources.");
	}

	public void clear()
	{
		System.out.println("Your savegame will now be deleted.");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Just kidding ;)");
	}
	
	public void credits()
	{
		System.out.println("Game made by Michael Bartl, Jonas Neumair and Maximilian Meyer-M�lleringhof\n\nIdea by Michael Bartl, Jonas Neumair and Maximilian Meyer-M�lleringhof\n\n" +
						   "Texts by Michael Bartl, Jonas Neumair and Maximilian Meyer-M�lleringhof\n\n");
							
	}
}