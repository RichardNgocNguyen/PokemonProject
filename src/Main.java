import java.util.Random;
import java.util.Scanner;
import java.awt.Point;

class Main {
  public static void main(String[] args) {
    System.out.println("Prof. Oak: Hello trainer, what is your name?");
    String trainerName = CheckInput.getString();
    System.out.println("Great, nice to meet you, " + trainerName);
    System.out.println("Choose your first Pokemon:");
    System.out.println("1. Charmander\n2. Bulbasaur\n3. Squirtle");
    int pokemonChoice = CheckInput.getIntRange(1, 3);
    Pokemon f;
    if (pokemonChoice == 1) {
        f = new Charmander();
    } else if (pokemonChoice == 2) {
        f = new Bulbasaur();
    } else {
        f = new Squirtle();
    }
    Map map = new Map();
    int option = 0;
    int a = 0;
    map.loadMap(a);
    Trainer trainer = new Trainer(trainerName, f, map);      
    while (option !=5 ){
      if (trainer.getHp() <= 0) {
        System.out.println("Game Over");
        System.exit(0);
      }
      map = new Map();
      map.loadMap(a);
      map.reveal(trainer.getLocation());
      while (option !=5 ){
      if (trainer.getHp() <= 0) {
        System.out.println("Game Over");
        System.exit(0);
      }
        trainer.toString();
        String areamap = map.mapToString(trainer.getLocation());
        System.out.println(trainer.toString());
        System.out.println("Map:");
        System.out.print(areamap);
        option = mainMenu();
        if (option == 1) {
          trainer.goNorth();
          map.reveal(trainer.getLocation());
        }else if (option == 2) {
          trainer.goSouth();
          map.reveal(trainer.getLocation());
        }else if (option == 3) {
          trainer.goEast();
          map.reveal(trainer.getLocation());
        }else if (option == 4) {
          trainer.goWest();
          map.reveal(trainer.getLocation());
        }else if (option == 5) {
          break;
      }
        char area = map.getCharAtLoc(trainer.getLocation());
        if (area == 'n') {
          System.out.println("Nothing Found");
        }else if (area == 'i'){
          map.removeCharAtLoc(trainer.getLocation());
          int random_item = (int)(Math.random() * 2);
          if (random_item == 0){
            trainer.receivePotion();
          }else{
            trainer.receivePokeball();
          }
        }else if (area == 'w') {
          int numpoke1 = trainer.getNumPokemon();
          Pokemon wild = chooseRandomPokemon();
          trainerAttack(trainer, wild);
          if (trainer.getHp() <= 0){
            option = 5;
            break;
          }
          int numpoke2 = trainer.getNumPokemon();
          if(wild.getHp() <= 0 || numpoke2 > numpoke1){
            map.removeCharAtLoc(trainer.getLocation());
          }
        }else if (area == 'p'){
          map.removeCharAtLoc(trainer.getLocation());
          Random r = new Random();
          int randomString = (int) (Math.random() * 3);
          int damage = (int) (Math.random() * 5) + 1;
          trainer.takeDamage(damage); 
          if (randomString == 0) {
          System.out.println("Uh oh! This is a restricted area and Officer Jenny caught you!");
          System.out.println("Instead of paying for a ticket, you decided to take " + damage + " as a punishment."); 
          }
          else if (randomString == 1) {
            System.out.println("A kid was bored and decided to kick you. You took " + damage + " damage");

          }
          else if (randomString == 2) {
            System.out.println("A generous person gives you 10 coins!");
          trainer.receiveMoney(10);
          }
          if (trainer.getHp() <= 0){
            option = 5;
            break;
          }
        }else if (area == 'c'){
            System.out.println("You've entered the city. \nWhere would you like to go?");
            System.out.println("1. Store \n2. Pokemon Hospital");
            int choose = CheckInput.getIntRange(1, 2);
            if (choose == 1){
            store(trainer);
          }
          else {
            System.out.println("Hello! Welcome to the Pokemon Hospital!");
            System.out.println("I'll fix your poor pokemon up in a jiffy!");
            trainer.healAllPokemon();
            System.out.println("There you go! See you again soon.");
            System.out.println(trainer.toString());
          }
        }else if(area == 'f'){
          System.out.println("You've found the finish!");
          trainer.toString();
          a++;
          if (a == 3){
            a = 0;
          }
          break;
        }
      }
    }
  }

    /**
	 *  Method that gives user option of which direction to go to and returns that 
   *  selection as an int
	 * */
  public static int mainMenu() {
    System.out.println("Main Menu:");
    System.out.println("1. Go North");
    System.out.println("2. Go South");
    System.out.println("3. Go East");
    System.out.println("4. Go West");
    System.out.println("5. Quit");
    int menuOption = CheckInput.getIntRange(1, 5);
    return menuOption;
    }

    /**
	 *  Method that returns a random pokemon 
	 * */
  public static Pokemon chooseRandomPokemon() {
    int random = (int)(Math.random() * 6);
    Pokemon p;
    if (random == 0){
        p = new Bulbasaur();
    }else if (random == 1){
        p = new Oddish();
    }else if (random == 2){
        p = new Charmander();
    }else if (random == 3){
        p = new Ponyta();
    }else if (random == 4){
        p = new Squirtle();
    }else{
        p = new Staryu();
    }
    return p;
    }
  
    /**
	 *  Method that initiates pokemon battle; trainer has option to fight, use potion,
   *  use pokeball, or run away
   *  @param t takes in a trainer
   *  @param wild is a wild pokemon the trainer encounters in the wild 
	 * */
  public static void trainerAttack(Trainer t, Pokemon wild) {
      System.out.println("A wild " + wild.getName() + " has appeared.");
      do {
      if (t.getHp() <= 0) {
        System.out.println("Game Over");
        System.exit(0);
      }
      System.out.println(wild.toString());
      System.out.println("What do you want to do?");
      System.out.println("1. Fight");
      System.out.println("2. Use Potion");
      System.out.println("3. Throw Poke ball");
      System.out.println("4. Run away"); 
      int choice = CheckInput.getInt();
      if (choice == 1) {
        System.out.println(t.getPokemonList()); 
        System.out.println("Choose a Pokemon:");
        int pokemonIdx = CheckInput.getInt();
        Pokemon pokemonFighting = t.getPokemon(pokemonIdx);
        if (pokemonFighting.getHp() <= 0){
          int damage = (int) (Math.random() * 10) + 1;
          t.takeDamage(damage); 
          System.out.println("You took " + damage + " damage from " + wild.getName() + " for drawing a pokemon with 0 HP.");
          }
        else {
          System.out.println(pokemonFighting + " I choose you!");
          System.out.println(pokemonFighting.getAttackMenu());
          int basicOrSpecial = pokemonFighting.getNumAttackMenuItems();
          if (basicOrSpecial == 1) {
            System.out.println(pokemonFighting.getBasicMenu());
            int basicAttack = pokemonFighting.getNumBasicMenuItems();
            System.out.println(pokemonFighting.basicAttack(wild, basicAttack));
            if (wild.getHp() > 0) {
              System.out.println(wild.basicAttack(pokemonFighting, basicAttack));
            } 
            else if (wild.getHp() <= 0) {
              break; 
            }
          } 
          else if (basicOrSpecial == 2){
            System.out.println(pokemonFighting.getSpecialMenu());
            int specialAttack = pokemonFighting.getNumSpecialMenuItems();
            System.out.println(pokemonFighting.specialAttack(wild, specialAttack));
            if (wild.getHp() > 0) { 
            System.out.println(wild.basicAttack(pokemonFighting, specialAttack)); 
            }
            else if (wild.getHp() <= 0) {
              break; 
            }
          }
        }
      }
      else if (choice == 2) {
        System.out.println(t.getPokemonList()); 
        System.out.println("Which pokemon would you like to use a potion on?");
        int pokemonIdx = CheckInput.getInt();
        if (t.hasPotion()) {
            t.usePotion(pokemonIdx); 
            System.out.println("You healed " + t.getPokemon(pokemonIdx).getName());
            }
        else {
          System.out.println("You don't have any potions!");
        }
      }
      else if (choice == 3) {
        if (t.hasPokeball()) {
          boolean success = t.catchPokemon(wild); 
          if (success) {
            System.out.println("Shake... Shake... Shake...");
            System.out.println("You caught " + wild.getName() + "!");
            break;
          }
          else {
            System.out.println("You couldn't catch " + wild.getName() + " :(");
          }
        }
        else {
          System.out.println("You don't have any pokeballs!");
        }
      }
      else if (choice == 4) {
        int randomDirection = (int) (Math.random() * 4);
        if (randomDirection == 0) {
          t.goNorth();
          }
        else if (randomDirection == 1) {
          t.goSouth();
          }
        else if (randomDirection == 2) {
          t.goEast();
          }
        else if (randomDirection == 3) {
          t.goWest();
          }
        break;
          }
      }
      while (wild.getHp() > 0); 
    }  

  /* *
  * @param t takes in a trainer
  * Gives potions or Pokeballs in exchange for money
  * */
  public static void store(Trainer t){
    int storenum = 0;
    while (storenum != 3){
      System.out.println("Hello! What can I help you with?");
      System.out.println("1. Buy Potions - $5");
      System.out.println("2. Buy Poke Balls - $3");
      System.out.println("3. Exit");
      storenum = CheckInput.getInt();
      if (storenum == 1) {
        boolean spent1 = t.spendMoney(5);
        if (spent1) {
        t.receivePotion();
        System.out.println("Here's your potion.");
        }else{
        System.out.println("Insufficient Amount.");
        }
      }
      else if (storenum == 2){
        boolean spent2 = t.spendMoney(3);
        if (spent2) {
        t.receivePokeball();
        System.out.println("Here's your pokeball.");
        }else{
        System.out.println("Insufficient Amount.");
      }
    }
      else if (storenum == 3){
        System.out.println("Thank you, come again soon!");
      }

    }
  }
}
