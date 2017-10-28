import java.util.Random;

public class ChatBoxLawrence {
//Creates a dialouge that simulates therapy by a psychiatrist
int emotion=0;
public String getGreeting()
{return "Hi, my name is Siri (I recently divorced my husband Apple). What is your name?";
}
public String getResponse(String statement)
{String response="";
 if (statement.length()==0)
{response= "So, what seems to be the problem?";
}
 if (findKeyword(statement,"sad")>=0)
		 {response="So how can you turn that situation into something positive?";}
 if (findKeyword(statement,"medication")>=0)
 {response="I'd really like to get you off the drugs. Can we try therapy?";}
 if(findKeyword(statement,"My name is")>=0)
 {retainName(statement);}
 return response;
}
private String retainName(String statement)
{int index=findKeyword(statement,"My name is",0);
 String end=statement.substring(index+10);
 return end+"How may I help you today?";
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

private String [] randomNeutralResponses = {"Interesting",
		"Hmmm.And how does that make you feel?",
		"Please continue",
		"What do you feel I can do to help you?",
		"Interesting. Do you think that therapy or medication would work best in your situation?",
		"Could you say that again?"
};
private String [] randomAngryResponses = {"Don't forget to breathe", "Please calm down", "Go to your happy place"};
private String [] randomHappyResponses = {"I think we made a breakthrough!", "Today is a good day", "I'm so glad to hear that!"};

}

