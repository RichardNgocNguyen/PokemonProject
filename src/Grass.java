public interface Grass {
  public String specialMenu = "1. Vine Whip \n 2. Razor Leaf \n 3. Solar Beam";

  public int numSpecialMenuItems = 3;

	/**
	 * vineWhip interface declaration 
	 * */
  public String vineWhip(Pokemon p);

	/**
	 * razorLeaf interface declaration 
	 * */
  public String razorLeaf(Pokemon p);
  
  	/**
	 * solarBeam interface declaration 
	 * */
  public String solarBeam(Pokemon p);
}