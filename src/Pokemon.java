import java.util.Random;

public abstract class Pokemon extends Entity {
  public static final double [][] battleTable = {{1,.5,2},{2,1,.5},{.5,2,1}};
  
  public Pokemon(String n){
    super(n,25);
  }

  	/**
	 * getSpecialMenu abstract declaration 
	 * */
  public abstract String getSpecialMenu();

	/**
	 * getNumSpecialMenuItems abstract declaration 
	 * */
  public abstract int getNumSpecialMenuItems();

	/**
	 * specialAttack abstract declaration 
	 * */
  public abstract String specialAttack(Pokemon p, int move);
  
	/**
	 * Returns basic attack moves as a string
	 * */
  public String getBasicMenu(){
    return "1. Slam \n2. Tackle \n3. Punch";
  }

	/**
	 * Returns user's basic menu move as an int 
	 * */
  public int getNumBasicMenuItems(){
    int numBasicMenu = CheckInput.getInt();
    return numBasicMenu;
  }
   
	/**
	 *  Conducts basic attack on pokemon in battle
   *  @param move is the special move done
   *  @param p is the pokemon the move is done on 
	 * */
  public String basicAttack(Pokemon p, int move){
    String moveToDo = "";
    if (move == 1) {
      moveToDo = this.slam(p);
    }
    else if (move == 2) {
      moveToDo = this.tackle(p);
    }
    else if (move == 3) {
      moveToDo = this.punch(p);
    }
    return moveToDo;
  }

	/**
	 *  Returns basic attack and special attack menu options as a string
	 * */
  public String getAttackMenu(){
    return "1. Basic Attack \n2. Special Attack";
  }

	/**
	 *  Conducts basic attack on pokemon in battle
   * Returns user's basic menu move as an int 
	 * */
  public int getNumAttackMenuItems(){
    int getNumAttack = CheckInput.getInt();
    return getNumAttack;
  }

	/**
	 * Method that does slam move and subtracts damage and returns string
   *  @param p is the pokemon the move is done on 
	 * */
  public String slam(Pokemon p) {
    Random r = new Random();
    int damage = r.nextInt(5);
    p.takeDamage(damage);
    return p.getName() + " gets SLAMMED and takes " + damage + " damage";
  }

	/**
	 * Method that does tackle move and subtracts damage and returns string
   *  @param p is the pokemon the move is done on 
	 * */
  public String tackle(Pokemon p) {
    int damage = (int) (Math.random() * 2) + 2;
    p.takeDamage(damage);
    return p.getName() + " gets TACKLED and takes " + damage + " damage";
  }

	/**
	 * Method that does punch move and subtracts damage and returns string
   *  @param p is the pokemon the move is done on 
	 * */
  public String punch(Pokemon p) {
    int damage = (int) (Math.random() * 4) + 1;
    p.takeDamage(damage);
    return p.getName() + " gets PUNCHED and takes " + damage + " damage";
  }

	/**
	 * Returns type as int based on Pokemons type (fire/water/grass)
	 * */
  public int getType(){
    int type = 0;
    if (this instanceof Fire) {
        type = 0;
    }
    else if (this instanceof Water) {
        type = 1;
    }
    else if (this instanceof Grass) {
        type = 2;
    }
    return type;
  }
}