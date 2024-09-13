public interface Water {
  public String specialMenu = "1. Water Gun \n 2. Bubble Beam \n 3. Waterfall";

  public int numSpecialMenuItems = 3;

	/**
	 * waterGun interface declaration 
	 * */
  public String waterGun(Pokemon p);

	/**
	 * bubbleBeam interface declaration 
	 * */
  public String bubbleBeam(Pokemon p);
  
  /**
	 * waterFall interface declaration 
	 * */
  public String waterFall(Pokemon p);
}