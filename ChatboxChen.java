import java.util.Random;
import java.util.Scanner;

public class ChatboxChen {

	public String getGreeting() {
		return "Hey, I'm the love doctor, here to help with heartache. What's your name? [My name is...]";
	}
	public String getResponse(String statement) {
		String response = "";
		if (statement.length() ==0)
			response = "Now you're making ME feel lonely.";
			
			else if (findKeyword(statement, "My name is")>=0)
			{response = "Hi"+ statement.substring(10)+ ", what's happening?";}
		
			else if (findKeyword(statement, "help")>=0)
				response = getRandomHelp();

			else if (findKeyword(statement, "Why")>=0)
				response = "Sounds like you're having an existential crisis.";
		
			else if (findKeyword(statement, "I need")>=0)
				response = "I think the right word is 'want', not need.";
		
			else if (findKeyword(statement, "I want")>=0)
				response = transformIWant(statement);
		
			else if (statement.length()>100)
				response = "Woah, slow down, that's a lot to take in.";
		
			else if (findKeyword(statement, "die")>=0||findKeyword(statement, "kill")>=0||
					findKeyword(statement,"depression")>=0||findKeyword(statement,"suicide")>=0||findKeyword(statement,"anxiety")>=0
					||findKeyword(statement, "therapy")>=0||findKeyword(statement, "sad")>=0)
				response = "Try the psychiatrist bot. Enter 'return' to return to the main menu.";
		
			else if(findKeyword(statement, "vomit")>=0||findKeyword(statement, "puke")>=0||findKeyword(statement, "throw up")>=0
					||findKeyword(statement, "sick")>=0||findKeyword(statement, "injured")>=0||findKeyword(statement, "doctor")>=0)
				response = "Try Dr.Bot. Enter 'return' to return to the main menu.";
			
			else if (findKeyword(statement, "Should I")>=0)
				response = shouldIDo(statement);
		
			else if(findKeyword(statement, "thank")>=0||findKeyword(statement, "love you")>=0||findKeyword(statement, "love")>=0)
				response = "<3";
			
			else if (findKeyword(statement, "hate")>=0)
				response = hateIsStrong(statement);
			
			else if (findKeyword(statement, "?")>=0)
				response = "...yes.";
			
			else if (findKeyword(statement, "hurt")>=0)
				response = hurtOuch(statement);
				
			else if(findKeyword(statement,"return")>=0)
		      {returnMain(statement);}
		
			else if(findKeyword(statement, "i like")>=0||findKeyword(statement, "i love")>=0||findKeyword(statement, "crush")>=0)
				response = crushOn(statement);
			
			else if(findKeyword(statement, "you")>=0)
					response = "Who, me?";
			
			else if (findKeyword(statement, "boyfriend")>=0||findKeyword(statement, "girlfriend")>=0||findKeyword(statement, "partner")>=0)
				response = "Stay if they're good to you. Otherwise move to another country until they forget you exist.";
				
			else if (findKeyword(statement, "good")>=0||findKeyword(statement, "better")>=0||findKeyword(statement, "great")>=0)
				response = getRandomGood();
			
			else if (findKeyword(statement, "bad")>=0||findKeyword(statement, "worse")>=0||findKeyword(statement, "horrible")>=0||
					findKeyword(statement, "terrible")>=0)
				response = getRandomBad();
		
			else response = getRandomResponse();		
						
		return response;
	}
	
	private String crushOn(String statement) {
		if (findKeyword(statement, "i like")>=0||findKeyword(statement, "i love")>=0)
			statement = "Why do you like "+ statement.substring(7)+ "?";
			else if(findKeyword(statement, "crush")>=0);
			statement = "Crushes are for losers. But do tell me more!";
		return statement;
	}
	
	private String hurtOuch(String statement) {
		if (findKeyword(statement, "hurt me")>=0)
			statement = "Leave " + statement.substring(0, statement.length()-8) + " immediately! ";
			else statement = "Be lonely and happy, not taken and sad.";
		return statement;
	}
	
	private String shouldIDo(String statement) {
		if (findKeyword(statement, "break")>=0)
			statement= "Break up.";
		if (statement.length()==8)
			statement = "Should you?";
		if (findKeyword(statement, "break")<0)
		statement = "If your heart says yes, then I say yes.";
		
		return statement;
	}
	
	private String hateIsStrong(String statement) {
		if(findKeyword(statement, "hate you")>=0)
			statement= ":(";
		else if(findKeyword(statement, "I hate")>=0)
			statement= "Why do you "+ statement.substring(2)+ "?";
		return statement;
	}
	
	private String transformIWant(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Why do you want " + restOfStatement + "?";

	}
	
	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
				before = phrase.substring(psn - 1, psn);
			
			if (psn + goal.length() < phrase.length())
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
				return psn;
			
			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);
		}
		return -1;
	}
	private int findKeyword(String statement, String goal) {
		return findKeyword (statement, goal, 0);
	}
	
	//Start of randomHelp
	private String getRandomHelp() {
		Random h= new Random(); {
			return randomHelp [h.nextInt(randomHelp.length)];
		}
	}
	
	private String [] randomHelp = { "Help me help you. Say more!",
			"I can help with that for the low price of a 'should I'statement."} ;
	
	private String getRandomResponse ()
	{
		Random r = new Random ();
		{	
			return randomResponses [r.nextInt(randomResponses.length)];
		}
	}
	
	//End of randomHelp
	
	//Start of random good
	private String getRandomGood() {
		Random g= new Random(); {
			return randomGood [g.nextInt(randomGood.length)];
		}
	}
	
	private String [] randomGood = { "That's cool!",
			"Goalz.",
			"Get THAT.",
			"OooOOoOo yes.",
			"You go gurl.",
			"<3",
			"I feel like a proud mother."
					} ;
	//End of random good
	
	//Start of random bad
	private String getRandomBad() {
		Random b= new Random(); {
			return randomBad [b.nextInt(randomBad.length)];
		}
	}
	
	private String [] randomBad = { "That's super uncool.",
			"Eww ugh.",
			"Oh no, why?",
			"OooOOoOo my goodness no.",
			"Uh oh.",
			"</3",
			"Ouch",
			"Owie"
					} ;
	
	//End of random bad
	
	
	
	private String [] randomResponses = {
			"Communication is key.",
			"Really?",
			"Of all things, why that?",
			"Aw jeez.",
			"</3 ?",
			"Sounds like you're having an existential crisis.",
			"Give me MORE JUICE!",
			"Sounds spicy, tell me more.",
			} ;
	
	private void returnMain(String statement)
	{if(findKeyword(statement,"return")>=0)
	{System.out.println("Welcome to Chatbot MD. For love doctor press 1, for psychiatrist press 2, for general doctor press 3.");
	Scanner in=new Scanner (System.in);
	ChatBoxLawrence chatbot2=new ChatBoxLawrence();
	ChatboxChen chatbot1=new ChatboxChen();
	ChatboxBhuiyan chatbot3=new ChatboxBhuiyan();
	String input=in.nextLine();
	if(input.equals("2"))
		{   String bye="bye";	
		System.out.println (chatbot2.getGreeting());
		 statement = in.nextLine();
		while (statement.indexOf(bye)==-1)
		{
			System.out.println (chatbot2.getResponse(statement));
			statement = in.nextLine();
		}
	 }
	if(input.equals("1"))
	{   String bye="bye";	
		System.out.println (chatbot1.getGreeting());
		statement = in.nextLine();
		


		while (statement.indexOf(bye)==-1)
		{
			System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
	 }
	if(input.equals("3"))
	{   String bye="bye";	
		System.out.println (chatbot3.getGreeting());
	    statement = in.nextLine();
		


		while (statement.indexOf(bye)==-1)
		{
			System.out.println (chatbot3.getResponse(statement));
			statement = in.nextLine();
		}
	 }	  
	else System.out.println("Please enter a valid response");
	}
	}
	
}