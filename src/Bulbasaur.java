public class Bulbasaur extends Pokemon implements Grass{

  /** Default Constructor
  **/
  public Bulbasaur() {
    super("Bulbasaur");
  }
  
  public int numSpecialMenuItems = 3;
  
  /**
	 * Overridden abstract method. 
   * Returns Bulbasaur's special menu 
	 * */
  @Override
  public String getSpecialMenu(){
    return "1. Vine Whip \n2. Razor leaf \n3. Solar Beam";
  }

	/**
	 * Overridden abstract method.
   * Returns Menu item as an int based on Bulbasaur's special menu
	 * */
  @Override
  public int getNumSpecialMenuItems(){
    int getNumSpecAttack = CheckInput.getInt();
    return getNumSpecAttack;
  }

	/**
	 * Returns string of special move to be done and conducts special attack 
   *  @param move is the special move done
   *  @param p is the pokemon the move is done on 
	 * */
  @Override
  public String specialAttack(Pokemon p, int move){
    String moveToDo = "";
    if (move == 1) {
      moveToDo = this.vineWhip(p);
    }
    else if (move == 2) {
      moveToDo = this.razorLeaf(p);
    }
    else if (move == 3) {
      moveToDo = this.solarBeam(p);
    }
    return moveToDo;
  }

	/**
	 * Conducts move 'Vine Whip' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String vineWhip(Pokemon p) {
    int damage = (int) (Math.random() * 3) + 1;
    if (p.getType() == 0) {
      damage *= battleTable[2][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[2][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[2][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by VINE WHIP and takes " + damage + " damage";
  }

	/**
	 * Conducts move 'Razor Leaf' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String razorLeaf(Pokemon p) {
    int damage = (int) (Math.random() * 3) + 2;
    if (p.getType() == 0) {
      damage *= battleTable[2][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[2][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[2][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by RAZOR LEAF and takes " + damage + " damage";
  }

	/**
	 *  Conducts move 'Solar Beam' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String solarBeam(Pokemon p) {
    int damage = (int) Math.random() * 6;
    if (p.getType() == 0) {
      damage *= battleTable[2][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[2][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[2][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by SOLAR BEAM and takes " + damage + " damage";
  }
}