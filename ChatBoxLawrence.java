import java.util.Random;
import java.util.Scanner;

public class ChatBoxLawrence {
//Creates a dialouge that simulates therapy by a psychiatrist
int emotion=0;
String question="?";
public String getGreeting()
{return "Hi, my name is Siri (I recently divorced my husband Apple). What is your name? Please answer in the form'My name is' for the purposes of our first session today. And when you're ready to say goodbye, just type in'bye'.If you would like to return to the main menu, type 'return'.";
}
public String getResponse(String statement)
{String response="";
 String name=retainName(statement);
  if(findKeyword(statement,"My name is")>=0)
  {response=name+",How may I help you today? By the way to undermine the sterotypical doctor-patient relationship, I'll call you broodie. Please respond in the format:'My problem is...'.";}
  else if(findKeyword(statement,"I feel")>=0)
  {transformIFeel(statement);}
  else if (statement.length()==0)
   {response= "So, what seems to be the problem,"+name+"?";}
  else if(statement.length()>=40)
  {response="Stay calm. Don't forget to breath. Speak simply.";}
  else if(findKeyword(statement,"My problem is")>=0)
  {response="How can I help you with"+retainProblem(statement)+"?";}
  else if(findKeyword(statement,"Anxiety")>=0)
  {response="How can I help you with "+retainProblem(statement)+"?";}
  else if(findKeyword(statement,"Depression")>=0)
  {response="How can I help you with "+retainProblem(statement)+"?";}
  else if (findKeyword(statement,"sad")>=0)
     {response="I'm sorry to hear that"+name+"! What can I do to help?";
      emotion--;}
  else if(findKeyword(statement,"suicide")>=0)
  {response="Suicide is NEVER the answer. Please call the suicide prevention hotline at 1-800-273-8255.";}
  else if(findKeyword(statement,"kill myself")>=0)
  {response="Suicide is NEVER the answer. Please call the suicide prevention hotline at 1-800-273-8255.";}
  else if(findKeyword(statement,"I understand")>=0)
  {response="Now we're getting somewhere,"+name+"!";
   emotion++;
  }
  else if (findKeyword(statement,"medication")>=0)
     {response="I'd really like to get you off the drugs,"+name+". Can we try therapy? Please say yes or no.";
     }

  else if (findKeyword(statement,"yes")>=0)
    	  {response="What do you mean,"+name+"?";
    	  emotion++;}
      else if(findKeyword(statement,"no")>=0)
      {emotion--;}
      else if(statement.indexOf(question)>0)
      {response="That's a good question,"+name+". Can I get back to you on that next session?";
       emotion++;
      }
      else if(findKeyword(statement,"love")>=0)
      {transferChatChen(statement);}
      else if(findKeyword(statement,"lonliness")>=0)
    		  {transferChatChen(statement);}
      else if (findKeyword(statement,"boyfriend")>=0)
             {transferChatChen(statement);}
      else if (findKeyword(statement,"girlfriend")>=0)
                {transferChatChen(statement);}
      else if(findKeyword(statement,"medical condition")>=0)
      {transferChatBhuiyan(statement);}
      else if(findKeyword(statement,"aches")>=0)
    		  {transferChatBhuiyan(statement);}
      else if (findKeyword(statement,"pain")>=0)
             {transferChatBhuiyan(statement);}
      else if (findKeyword(statement,"vomit")>=0)
                {transferChatBhuiyan(statement);}
      else if(findKeyword(statement,"return")>=0)
      {returnMain(statement);}
 else{response=getRandomResponse();}
 return response;
}
private void transferChatChen(String statement)
//transfers the user to ChatboxChen if the situation has to do with romance 
{int index=findKeyword(statement,"lonliness",0);
 int needy=findKeyword(statement,"love",0);
 int relationshipMale=findKeyword(statement,"girlfriend",0);
 int relationshipFemale=findKeyword(statement,"boyfriend",0);
 String response1="";
 if((index>=0)||(needy>=0)||(relationshipMale>=0)||(relationshipFemale>=0))
 {response1="I think you're better off with the love doctor. I'll transfer you now.";
  Scanner in=new Scanner(System.in);
  ChatboxChen chatbot1=new ChatboxChen();
  System.out.println (chatbot1.getGreeting());
	while (statement.indexOf("bye")==-1)
	{
		System.out.println (chatbot1.getResponse(statement));
		statement = in.nextLine();
	}
 }
 
 
}
private void transferChatBhuiyan(String statement)
//transfers the user to ChatboxBhuiyan if the situation has to do with general medical issues
{int index=findKeyword(statement,"medical condition",0);
int needy=findKeyword(statement,"aches",0);
int relationshipMale=findKeyword(statement,"pain",0);
int relationshipFemale=findKeyword(statement,"vomit",0);
String response1="";
if((index>=0)||(needy>=0)||(relationshipMale>=0)||(relationshipFemale>=0))
{response1="I think you're better off with the general doctor. I'll transfer you now.";
Scanner in=new Scanner(System.in);
ChatboxBhuiyan chatbot3=new ChatboxBhuiyan();
System.out.println (chatbot3.getGreeting());
	while (statement.indexOf("bye")==-1)
	{
		System.out.println (chatbot3.getResponse(statement));
		statement = in.nextLine();
	}
}


}
private String retainName(String statement)
//returns the name of a person after they say "My name is _____"
{int index=findKeyword(statement,"My name is",0);
 if((index+10)<=statement.length())
 {String end=statement.substring(index+10);
  if(index>=0)
  {return end;}
 }
 return "broodie";
}
private String retainProblem(String statement)
//returns the problem specifically mentioned by the user when asking if the program can help.
{   String problem="";
     if (findKeyword(statement,"Anxiety")>=0)
	{problem="what's on your mind?";}
	else if (findKeyword(statement,"depression")>=0)
	{problem="what's on your mind?";}
	else if (findKeyword(statement,"love")>=0)
	{transferChatChen(statement);}
	else if (findKeyword(statement,"lonliness")>=0)
	{transferChatChen(statement);}
	else if (findKeyword(statement,"lonely")>=0)
	{transferChatChen(statement);}
	else if (findKeyword(statement,"boyfriend")>=0)
	{transferChatChen(statement);}
	else if (findKeyword(statement,"girlfriend")>=0)
	{transferChatChen(statement);}
	 else if(findKeyword(statement,"medical condition")>=0)
     {transferChatBhuiyan(statement);}
     else if(findKeyword(statement,"aches")>=0)
   		  {transferChatBhuiyan(statement);}
     else if (findKeyword(statement,"pain")>=0)
            {transferChatBhuiyan(statement);}
     else if (findKeyword(statement,"vomit")>=0)
               {transferChatBhuiyan(statement);}
     else if (findKeyword(statement,"My problem is")>=0)
 	{problem=statement.substring(13);}
	return problem;
	
}
private void returnMain(String statement)
//returns user to main menu given the input "return"
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
if(statement.indexOf("bye")>=0)
{System.out.println("bye");}
else System.out.println("Please enter a valid response");
}
}
private void transformIFeel(String statement)
{String transifeel="";
   if ((findKeyword(statement,"I feel")>=0)&&(statement.indexOf("I feel")!=statement.length()-6))
  {int x=statement.indexOf("I feel");
 transifeel="Why do you feel"+statement.substring(x+6)+"?"; 
  }
   else if ((findKeyword(statement,"I feel")>=0)&&(statement.indexOf("I feel")==statement.length()-6))
  {
   transifeel="Why do you feel that way?";
  }
  System.out.println(transifeel);
}


private int findKeyword(String statement, String goal,
		int startPos)
{
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
		{
			before = phrase.substring(psn - 1, psn);
		}
		if (psn + goal.length() < phrase.length())
		{
			after = phrase.substring(
					psn + goal.length(),
					psn + goal.length() + 1);
		}

		// If before and after aren't letters, we've
		// found the word
		if (((before.compareTo("a") < 0) || (before
				.compareTo("z") > 0)) // before is not a
										// letter
				&& ((after.compareTo("a") < 0) || (after
						.compareTo("z") > 0)))
		{
			return psn;
		}

		// The last position didn't work, so let's find
		// the next, if there is one.
		psn = phrase.indexOf(goal, psn + 1);

	}

	return -1;
}
/**
 * Search for one word in phrase. The search is not case
 * sensitive. This method will check that the given goal
 * is not a substring of a longer string (so, for
 * example, "I know" does not contain "no").
 *
 * @param statement
 *            the string to search
 * @param goal
 *            the string to search for
 * @param startPos
 *            the character of the string to begin the
 *            search at
 * @return the index of the first occurrence of goal in
 *         statement or -1 if it's not found*/
private int findKeyword(String statement, String goal)
{
	return findKeyword (statement, goal, 0);
}
private String getRandomResponse ()
{
	Random r = new Random ();
	if (emotion == 0)
	{	
		return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
	}
	if (emotion < 0)
	{	
		return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
	}	
	return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
}

private String [] randomNeutralResponses = {
         "Interesting",
		"Hmmm.And how does that make you feel?",
		"Please continue",
		"What do you feel I can do to help you?",
		"Interesting. Do you think that therapy or medication would work best in your situation?",
		"Could you say that again?"
};
private String [] randomAngryResponses = {"Don't forget to breathe", "Please calm down", "Go to your happy place"};
private String [] randomHappyResponses = {"I think we made a breakthrough!", "Therapy is helpful to even the strongest of us", "I'm so glad to hear that!"};

}

