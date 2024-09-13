public class Ponyta extends Pokemon implements Fire {

  /** Default Constructor
  **/
  public Ponyta() {
    super("Ponyta");
  }

  public int numSpecialMenuItems = 3;
  
  /**
	 * Overridden abstract method. 
   * Returns Bulbasaur's special menu 
	 * */
  @Override
  public String getSpecialMenu(){
    return "1. Ember \n2. Fire Blast \n3. Fire Punch";
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
      moveToDo = this.ember(p);
    }
    else if (move == 2) {
      moveToDo = this.fireBlast(p);
    }
    else if (move == 3) {
      moveToDo = this.firePunch(p);
    }
    return moveToDo;
  }

	/**
	 * Conducts move 'Ember' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String ember(Pokemon p) {
    int damage = (int) (Math.random() * 5);
    if (p.getType() == 0) {
      damage *= battleTable[0][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[0][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[0][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by EMBER and takes " + damage + " damage";
  }

	/**
	 * Conducts move 'fireBlast' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String fireBlast(Pokemon p) {
    int damage = (int) (Math.random() * 4) + 2;
    if (p.getType() == 0) {
      damage *= battleTable[0][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[0][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[0][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by FIRE BLAST and takes " + damage + " damage";
  }

	/**
	 * Conducts move 'firePunch' and adjusts damage according to battleTable. A string is then returned of the move done and damage.
   *  @param p is the pokemon the move is done on 
	 * */
  public String firePunch(Pokemon p) {
    int damage = (int) (Math.random() * 4) + 1;
    if (p.getType() == 0) {
      damage *= battleTable[0][0];
    }
      else if (p.getType() == 1) {
      damage *= battleTable[0][1];
    }
      else if (p.getType() == 2) {
      damage *= battleTable[0][2];
    }
    p.takeDamage(damage);
    return p.getName() + " gets hit by FIRE PUNCH and takes " + damage + " damage";
  }
}  