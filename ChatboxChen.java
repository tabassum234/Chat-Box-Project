import java.util.Random;

public class ChatboxChen {

	public String getGreeting() {
		return "Hey, I'm your relationship bot, here to curb your lonliness. What's your name?";
	}
	public String getResponse(String statement) {
		String response = "";
		if (statement.length() ==0)
			response = "Now you're making ME feel lonely.";
		else if (findKeyword(statement, "My name is")>=0)
			{response = "Hi"+ statement.substring(10)+ ", what's poppin?";}
			else if (findKeyword(statement, "help ")>=0)
				response = "Of course" +statement.substring(10)+". That's why you're here, that's why I'm here.";
			else if (findKeyword(statement, "Why")>=0||(findKeyword(statement, "why")>=0))
				response = "Sounds like you're having an existential crisis. Let loose!";
			else if (findKeyword(statement, "I need")>=0)
				response = "I think the right word is 'want', not need.";
			else if (statement.length()>100)
				response = "Woah, slow down, that's a lot to take in.";
			else if (findKeyword(statement, "die")>=0)
				response = "This may not be the right bot for you.";
			//else random response
						
						
		return response;
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
	private String getRandomResponse ()
	{
		Random r = new Random ();
		{	
			return randomResponses [r.nextInt(randomResponses.length)];
		}
	}
	private String [] randomResponses = {"Uh oh.",
			"Communication is key!",
			"Do you really think so?",
			"Of all things, why that?",
			"Aw jeez.",
			"Go for it.",
			"<3",
			"</3"
			} ;
}

