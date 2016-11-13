package client.model;

public class Player {
	
	public final String name;
	public Position position;
	
	public long score = 0;
	
	public Player(String name, Position p) {
		this.name = name;   
		this.position = p;
	}
	/**
	 * Instantiation player's parameter
	 * @param name
	 * @param p
	 * @param score
	 */
	public Player(String name, Position p, long score) {
		this.name = name;
		this.position = p;        
		this.score = score;
	}
	
	@Override
	/** Check if equals for object like player
	 *  Check the position and name see if need to update
	 */
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Player) {
			Player p = (Player) obj;  
			
			return (name.equals(p.name) && position.equals(p.position));  
		}
		return false;
	}
	
	/**
	 * Send to sever to update player's new score and position if they changed
	 * @param p
	 */
	public void update(Player p) {
		if (p != null && p instanceof Player) {
			score = p.score;        
			position = p.position;			
		}
	}

}
