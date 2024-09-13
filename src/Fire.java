public interface Fire {
  public String specialMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";

  public int numSpecialMenuItems = 3;

	/**
	 * fireBlast interface declaration 
	 * */
  public String ember(Pokemon p);

	/**
	 * fireBlast interface declaration 
	 * */
  public String fireBlast(Pokemon p);
  
  	/**
	 * firePunch interface declaration 
	 * */
  public String firePunch(Pokemon p);
}