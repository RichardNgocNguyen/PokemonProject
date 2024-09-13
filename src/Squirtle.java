public class Squirtle extends Pokemon implements Water {

  /** Default Constructor
  **/
  public Squirtle() {
    super("Squirtle");
  }

  public int numSpecialMenuItems = 3;
  
  /**
	 * Overridden abstract method. 
   * Returns Squirtle's special menu 
	 * */
  @Override
  public String getSpecialMenu(){
    return "1. Water Gun \n2. Bubble Beam \n3. Waterfall";
  }

	/**
	 * Overridden abstract method.
   * Returns Menu item as an int based on Squirtle's special menu
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
      moveToDo = this.waterGun(p);
    }
    else if (move == 2) {
      moveToDo = this.bubbleBeam(p);
    }
    else if (move == 3) {
      moveToDo = this.waterFall(p);
    }
    return moveToDo;
  }

	/**
	 * Conducts move 'waterGun' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String waterGun(Pokemon p) {
    int damage = (int) (Math.random() * 4) + 2;
    if (p.getType() == 0) {
      damage *= battleTable[1][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[1][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[1][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by WATER GUN and takes " + damage + " damage";
  }

	/**
	 * Conducts move 'bubbleBeam' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String bubbleBeam(Pokemon p) {
    int damage = (int) (Math.random() * 3) + 1;
    if (p.getType() == 0) {
      damage *= battleTable[1][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[1][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[1][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by BUBBLE BEAM and takes " + damage + " damage";
  }

	/**
	 * Conducts move 'waterFall' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String waterFall(Pokemon p) {
    int damage = (int) (Math.random() * 4) + 1;
    if (p.getType() == 0) {
      damage *= battleTable[1][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[1][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[1][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by WATER FALL and takes " + damage + " damage";
  }
}