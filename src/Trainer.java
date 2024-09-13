import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;


public class Trainer extends Entity {
  private int money = 25;
  private int potions = 1;
  private int pokeballs = 5;
  private Point loc;
  private Map map;
  private ArrayList<Pokemon> pokemon = new ArrayList<>();

	/**
	 * Constructor for entity that takes in a name, initial starter pokemon and initial loaded map
	 * */
  public Trainer(String n, Pokemon p, Map m) {
    super(n,25);
    this.pokemon.add(p);
    this.map = m;
    this.loc = map.findStart();
    }

  

  
	/**
	 * Returns trainers current money as an int
	 * */
  public int getMoney() {
    return this.money;
  }

  
	/**
	 * Method that returns boolean whether or not trainer has enough money to spend
	 * */
  public boolean spendMoney(int amt) {
    if (amt > this.money) {
      return false;
    } else {
      this.money -= amt;
      return true;
    }
  }

  
	/**
	 * Method that adds money to trainers current amount 
	 * */
  public void receiveMoney(int amt) {
    this.money += amt;
  }

  
	/**
	 * Method that returns boolean whether or not trainer has a potion to use for pokemon
	 * */
  public boolean hasPotion() {
    if (this.potions > 0) {
      return true;
    }
    return false;
  }

  public void receivePotion() {
    this.potions += 1;
  }

  
	/**
	 * Method that allows trainer to use potion on a specified pokemon in their pokedex
	 * */
  public void usePotion(int PokeIndex) {
    this.potions -= 1;
    Pokemon n = pokemon.get(PokeIndex - 1);
    n.heal();
  }

  
	/**
	 * Method that returns boolean whether or not trainer has a pokeball to use
	 * */
  public boolean hasPokeball() {
    if (this.pokeballs > 0) {
      return true;
    }
    return false;
  }

  
	/**
	 * Method that adds a pokeball to trainer's current stack when found 
	 * */
  public void receivePokeball() {
    this.pokeballs += 1;
  }

  
  
	/**
	 * Method that returns boolean whether or not trainer catches pokemon based on HP
	 * */
  public boolean catchPokemon(Pokemon p) {
    double pokemonPercentHealth = (p.getHp() / p.getMaxHp()) * 100;
    int chanceOfCatch;
    Random r = new Random();
    int catchNumber = r.nextInt(100) + 1;
    if (pokemonPercentHealth <= 100 && pokemonPercentHealth > 75) {
      chanceOfCatch = 27;
    } else if (pokemonPercentHealth <= 75 && pokemonPercentHealth > 50) {
      chanceOfCatch = 36;
    } else if (pokemonPercentHealth <= 50 && pokemonPercentHealth > 25) {
      chanceOfCatch = 44;
    } else if (pokemonPercentHealth <= 25 && pokemonPercentHealth > 5) {
      chanceOfCatch = 51;
    } else {
      chanceOfCatch = 75;
    }
    if (catchNumber >= 1 && catchNumber <= chanceOfCatch) {
      pokemon.add(p);
      return true;
    } else {
      return false;
    }
  }

    
	/**
	 * Method that returns trainer's location as a point 
	 * */
  public Point getLocation(){
    return this.loc; 
  }

  
	/**
	 * Method that allows trainer to go north on map (if possible) and returns the character at that new location
	 * */
  public char goNorth(){  
    Point currentLocation = getLocation();
    int x = currentLocation.x - 1;
    int y = currentLocation.y;
    Point newLocation = new Point (x , y);
    if (x < 0) {
      System.out.println("Can't go there!");
      return 'x';
    }
    else {
      this.loc = newLocation;
      return map.getCharAtLoc(newLocation);
    }
  }

	/**
	 * Method that allows trainer to go south on map (if possible) and returns the character at that new location
	 * */
   public char goSouth(){
    Point currentLocation = getLocation();
    int x = currentLocation.x + 1;
    int y = currentLocation.y;

    Point newLocation = new Point (x , y);
    if (x >= 5){
      System.out.println("Can't go there!");
      return 'x';
    }
    else {
      this.loc = newLocation;
      return map.getCharAtLoc(newLocation);
    }
  }

	/**
	 * Method that allows trainer to go east on map (if possible) and returns the character at that new location
	 * */
   public char goEast(){
    Point currentLocation = getLocation();
    int x = currentLocation.x;
    int y = currentLocation.y + 1;
    Point newLocation = new Point (x , y);
    if (y >= 5){
      System.out.println("Can't go there!");
      return 'x';
    }else {
      this.loc = newLocation;
      return map.getCharAtLoc(newLocation);
    }
  }


	/**
	 * Method that allows trainer to go west on map (if possible) and returns the character at that new location
	 * */
   public char goWest(){
    Point currentLocation = getLocation();
    int x = currentLocation.x;
    int y = currentLocation.y - 1;
    Point newLocation = new Point (x , y);
    if (y < 0) {
      System.out.println("Can't go there!");
      return 'x';
    }
    else {
      this.loc = newLocation;
      return map.getCharAtLoc(newLocation);
    }
  }
  
	/**
	 * Method that returns number of pokemon based on the amount of pokemon in the ArrayList
	 * */
  public int getNumPokemon() {
    int counter = 0;
    for (Pokemon p : this.pokemon) {
      counter += 1;
    }
    return counter;
  }

	/**
	 * Method that heals all pokemon 
	 * */
  public void healAllPokemon() {
    for (Pokemon p : pokemon) {
      p.heal();
    }
  }

  
	/**
	 * Method that returns a spceific pokemon based on index given 
	 * */
  public Pokemon getPokemon(int index) {
    return pokemon.get(index - 1);
  }

  
	/**
	 * Method that displays all pokemon along with their hp/current hp as a string 
	 * */
  public String getPokemonList() {
    String pokemonList = "";
    int i = 1;
    for (Pokemon p : this.pokemon) {
      pokemonList += i + ". " +p.toString() + "\n";
      i++;
    }
    return pokemonList;
  }

  
	/**
	 * Method that displays trainer and all of their stats (hp, money, potions, poke balls, pokemon)
	 * */
   @Override 
  public String toString() {
    int counter = 0;
    String info = "";
    info += "\n" + this.getName() + " HP: " + this.getHp() + "/" + this.getMaxHp() + "\n" + "Money: " + this.getMoney()
        + "\n" + "Potions: " + this.potions + "\n" + "Poke Balls: " + this.pokeballs + "\n" + "Pokemon" + "\n"
        + "-------\n";
    for (Pokemon p : pokemon) {
      counter += 1;
      info += counter + ". " + p.getName() + " HP: " + p.getHp() + "/" + p.getMaxHp() + "\n";
    }
    // info += "Map:\n";
    // info += this.m.mapToString(this.loc);
    return info;
  }
}