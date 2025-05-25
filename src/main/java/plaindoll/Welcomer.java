package plaindoll;

public class Welcomer{
	public String sayWelcome() {
		return "Welcome home, good hunter. What is it your desire?";
	}
	public String sayFarewell() {
		return "Farewell, good hunter. May you find your worth in waking world.";
	}
	public String sayNeedGold(){
		return "Not enough gold";
	}
	public String saySome(){
		return "something in the way";
	}

	    // new method
    public String sayHunterReply() {
        String[] replies = {
            "Hunter, your skills are unmatched.",
            "The hunter always knows the path.",
            "Beware, hunter, the night is dark.",
            "Every hunter has their secret.",
            "Good hunter, your journey continues."
        };
        int index = (int) (Math.random() * replies.length);
        return replies[index];
    }
}
