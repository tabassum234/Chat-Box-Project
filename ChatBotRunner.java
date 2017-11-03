import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Mr. Levin
 * @version September 2017
 */
public class ChatBotRunner
{
	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{System.out.println("Welcome to Chatbot MD. For love doctor press 1, for psychiatrist press 2, for general doctor press 3.");
	  Scanner in=new Scanner (System.in);
	  ChatBoxLawrence chatbot2=new ChatBoxLawrence();
	  ChatboxChen chatbot1=new ChatboxChen();
	  ChatboxBhuiyan chatbot3=new ChatboxBhuiyan();
	  String input=in.nextLine();
	  if(input.equals("2"))
		{   String bye="bye";	
		System.out.println (chatbot2.getGreeting());
		String statement = in.nextLine();
		while (statement.indexOf(bye)==-1)
		{
			System.out.println (chatbot2.getResponse(statement));
			statement = in.nextLine();
		}
	   }
	  if(input.equals("1"))
	  {   String bye="bye";	
		System.out.println (chatbot1.getGreeting());
		String statement = in.nextLine();
		


		while (statement.indexOf(bye)==-1)
		{
			System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
	   }
	  if(input.equals("3"))
	  {   String bye="bye";	
		System.out.println (chatbot3.getGreeting());
		String statement = in.nextLine();
		


		while (statement.indexOf(bye)==-1)
		{
			System.out.println (chatbot3.getResponse(statement));
			statement = in.nextLine();
		}
	  }
	   	 
	  if(input.indexOf("bye")>=0) 
	  {System.out.println("bye");}
	  else {System.out.println("I think our time is up for today. Enjoy the rest of your day. Bye!");}
	  }
}


