package client.model;

public class Player {
	String id;
    int score;
    Position topleft;
   
    
    public void player(String id, int score, Position topleft)
    {
       this.id=id;
       this.score=score;
       this.topleft=topleft;
      
    }

}
