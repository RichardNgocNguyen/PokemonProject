public abstract class Entity {
   private String name;
   private int hp;
   private int maxHp;


	/**
	 * Constructor for entity that takes in a name and hp
	 * */
   public Entity(String n, int mHp) {
      this.name = n;
      this.hp = mHp;
      this.maxHp = mHp;
   }

	/**
	 * Returns entity's current hit points
	 * */
   public int getHp() {
      return this.hp;
   }

	/**
	 * Returns entity's max hit points
	 * */
   public int getMaxHp() {
      return this.maxHp;
   }

	/**
	 * Method that subtracts damage taken, d, from entity's current health 
   * @param d is the amount of damage done on entity
	 * */
   public void takeDamage(int d) {
      this.hp -= d;
      if (this.hp <= 0) {
        System.out.println(this.name + " was defeated!");
      }
   }

	/**
	 * Method that heals entity
	 * */
   public void heal() {
     this.hp = this.maxHp;
   }

	/**
	 * Method that returns entity's name
	 * */
   public String getName() {
     return this.name;
   }

	/**
	 * Method that returns entity's name and hp in format 'Name HP: hp/maxHp'
	 * */
   public String toString() {
     return this.name + " HP: " + this.hp + "/"+ this.maxHp;
   }
}