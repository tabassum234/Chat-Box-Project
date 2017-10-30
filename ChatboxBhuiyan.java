import java.util.Random;

public class ChatboxBhuiyan 
// Dr. GoogleChatbot- takes your symptoms and returns either obvious or exaggerated diagnoses/ medication
{
int emotion=0
String Question=?
	public String getGreeting ()
	{
		return "Hi, I'm Dr.Bot, what seems to be the problem?"
	}
	public String getResponse(String statement) 
	{
	String response = "";
	if (statement.length == 0)
		response = "I can't help you if you don't want to help yourself."
	else if (findKeyword(statement, "hurts")>=0)
		response = "How long has it hurt?"
	else if (findKeyword(statement, "pain")>=0)
		response = "Have you tried ice?"
	else if (findKeyword(statement, "bleed")>=0)
		response = "I'll get you a bandaid."
	else if (findKeyword(statement, "ache")>=0)
		reponse = "Take some asperin."
	else if (findKeyword(statement, "feel")>=0)
		response = "It's cancer. You have 6 months to live"
	else if ((findKeyword(statement, "threw up")>=0) || (findKeyword(statement, "vomit")>=0) || (findKeyword(statement, "throwing up")>=0))
		response = "You're pregnant."
	else{response=getRandomResponse();}
	return response;
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
        "When did it start happening?",
		"Where does it hurt?",
		"What are your symptoms?",
		"Ouch.",
		"I could get you something for that.",
		"Tell me more.",
		"We're going to need to do some testing.",
		"That sounds painful.",
		"Stay hydrated.",
		"Get plenty of rest.",

};
private String [] randomAngryResponses = {"My cousin died from that.", "Why don't you just google it then.", "I'm sorry did you go to med school?", "Oh I'll take care of you alright."};
private String [] randomHappyResponses = {"Great, you'll get better in no time!", "You'll feel better soon.", "We'll take care of you."};

}



