class GameCharacter {
    String agentName;
    int agentHealth;

    //this is a Constuctor for GameCharacter class that have 2 parameters (Name and Health)
    public GameCharacter(String agentName, int agentHealth){
        this.agentName = agentName; //this.* is for fill the Attribute of agentName with parameter Name
        this.agentHealth = agentHealth;
    }

    public String getName(){
        return agentName; //getter is for take the Value of agentName, whenever you want to call the value of agentName, you can use getName
    }

    public int getHealth(){
        return agentHealth;
    }

    public void setName(String name){
        this.agentName = name;
    }

    public void setHealth(int health){
        this.agentHealth = health; //setter is to set the value of agentHealth, whenever you want to change the value of agentName, you can use setHealth
    }

    public void info(){
        System.out.println(agentName);
        System.out.println("HP: " + agentHealth);
    }

    public void attack(GameCharacter target){
        System.out.println(agentName + " Menyerang " + target.getName());
        System.out.println(" ");
    }
}
class Hero extends GameCharacter{
    int agentDamage;

    public Hero(String agentName, int agentHealth, int Damage){
        super(agentName, agentHealth); //super is for calling the attributes from parent class like agentName and agentHealth
        this.agentDamage = Damage;
    }

    public int getAgentDamage(){
        return agentDamage;
    }

    @Override //override is for overriding your method so that the methode from Parent class and Sub-class is different
    public void attack(GameCharacter target){
        System.out.println(getName() + " attacks " + target.getName() + " using Orbital Strike!"); //using getName to show the value "agentName"
        target.setHealth(target.getHealth() - getAgentDamage()); //using setHealth to change the Value of target Health
        setName("Brimstone1");
        target.info();
    }

    public void info(){
        System.out.println(getName() + " has health: " + getHealth());
    }
}
class Enemy extends GameCharacter{
    int agentDamage;

    public Enemy(String agentName, int agentHealth, int Damage){
        super(agentName, agentHealth);
        this.agentDamage = Damage;
    }

    public int getAgentDamage(){
        return agentDamage;
    }

    @Override
    public void attack(GameCharacter target){
        System.out.println(getName() + " attacks " + target.getName() + " using Snake bite!");
        target.setHealth(target.getHealth() - getAgentDamage());
        setName("Viper1");
        target.info();
    }

    public void info(){
        System.out.println(getName() + " has health: " + getHealth());
    }
}
public class Main {
    public static void main(String[] args){
        GameCharacter general = new GameCharacter("General", 100);
        Hero defender = new Hero("Brimstone", 150, 20);
        Enemy attacker = new Enemy("Viper", 200, 15);


        general.info();
        general.attack(attacker);

        defender.info();
        attacker.info();

        defender.attack(attacker);
        defender.attack(attacker);
        attacker.attack(defender);
        defender.attack(attacker);
    }
}