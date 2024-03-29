
// buildings are manly used to calculate the materials. if you build one only the materials are subtracted and added and there is no new object created in fact. 
// the buildings are: Forester, Clay Pit, Forge, Cottage, School, Church and Castle
/*Describing the buildings:
 * -) Forester: the forester is used to get more wood material, no special effects
 * -) Clay Pit: with the clay pit you get more clay, no special effects
 * -) Forge: the forge brings your village more iron, no special effects (maybe in next version mine needed to produced iron)
 * -) Cottage: a cottage contains people depending on level, people are also used to get you gold (people*plusGold) the the plus gold depends on the level of the castle
 * -) Castle: the building influences the amount of gold you get if there is a cottage built _________ ^ plusGold is defined by the level of the castle
 * -) School: the school is a unique building helping to decrease the time needed to train the people
 */

public class Buildings {

    private String name;

    // the costs of each material for constructing the building
    private int costsWood;
    private int costsClay;
    private int costsIron;
    private int costsGold;
    private int costsPeople;

    // the advantages of a building
    // plus gold is a special variable only used for the castle. it defines the amount of money you get if you build a new cottage
    private int plusWood;
    private int plusClay;
    private int plusIron;
    private int plusGold;
    private int plusPeople;

    // the maximum advantage is assigned to the value that makes the biggest plus, only used to calculate the rising of costs of materials that do not increase (eg. forester -> plusIron=0 -> increasing costsIron the maxPlus is used)
    private int maxPlus;

    // the number of buildings you built of that type
    private int amount;

    // special variables for buildings (if needed): School: special1 -> the multiplicator for the time needed to train people
    private int special1;
    private int special2;

    // default constructor (just for testing)
    public Buildings(){
        setName("Test");

        setCostsWood(10);
        setCostsClay(10);
        setCostsIron(10);
        setCostsGold(10);
        setCostsPeople(10);

        setPlusWood(20);
        setPlusClay(20);
        setPlusIron(20);
        setPlusGold(20);
        setPlusPeople(20);

        setMaxPlus(20);

        setSpecial1(5);
        setSpecial2(8);
    }

    // normal constructor with parameters
    public Buildings(String name, int costsWood, int costsClay, int costsIron, int costsGold, int costsPeople, int plusWood, int plusClay, int plusIron, int plusGold, int plusPeople, int special1, int special2){

        int max=0;

        setName(name);

        setCostsWood(costsWood);
        setCostsClay(costsClay);
        setCostsIron(costsIron);
        setCostsGold(costsGold);
        setCostsPeople(costsPeople);

        setPlusWood(plusWood);
        setPlusClay(plusClay);
        setPlusIron(plusIron);
        setPlusGold(plusGold);
        setPlusPeople(plusPeople);

        // find out the biggest plus    
        if(max<this.plusWood) max=this.plusWood;
        if(max<this.plusClay) max=this.plusClay;
        if(max<this.plusIron) max=this.plusIron;
        if(max<this.plusGold) max=this.plusGold;
        if(max<this.plusPeople) max=this.plusPeople;

        setMaxPlus(max);

        setAmount(1);

        setSpecial1(special1);
        setSpecial2(special2);
    }

    public int getSpecial2() {
        return special2;
    }

    public void setSpecial2(int special2) {
        this.special2 = special2;
    }

    public int getSpecial1() {
        return special1;
    }

    public void setSpecial1(int special1) {
        this.special1 = special1;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMaxPlus() {
        return maxPlus;
    }

    public void setMaxPlus(int maxPlus) {
        this.maxPlus = maxPlus;
    }

    public int getPlusPeople() {
        return plusPeople;
    }

    public void setPlusPeople(int plusPeople) {
        this.plusPeople = plusPeople;
    }

    public int getPlusGold() {
        return plusGold;
    }

    public void setPlusGold(int plusGold) {
        this.plusGold = plusGold;
    }

    public int getPlusIron() {
        return plusIron;
    }

    public void setPlusIron(int plusIron) {
        this.plusIron = plusIron;
    }

    public int getPlusClay() {
        return plusClay;
    }

    public void setPlusClay(int plusClay) {
        this.plusClay = plusClay;
    }

    public int getPlusWood() {
        return plusWood;
    }

    public void setPlusWood(int plusWood) {
        this.plusWood = plusWood;
    }

    public int getCostsPeople() {
        return costsPeople;
    }

    public void setCostsPeople(int costsPeople) {
        this.costsPeople = costsPeople;
    }

    public int getCostsGold() {
        return costsGold;
    }

    public void setCostsGold(int costsGold) {
        this.costsGold = costsGold;
    }

    public int getCostsIron() {
        return costsIron;
    }

    public void setCostsIron(int costsIron) {
        this.costsIron = costsIron;
    }

    public int getCostsClay() {
        return costsClay;
    }

    public void setCostsClay(int costsClay) {
        this.costsClay = costsClay;
    }

    public int getCostsWood() {
        return costsWood;
    }

    public void setCostsWood(int costsWood) {
        this.costsWood = costsWood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // used if people are trained (it takes a time until the building can be built)
    public void learningWait(int multiplicator){
        int time=multiplicator*this.costsPeople;
        try {
            Thread.sleep((long)time);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Error 303. Thread not available to sleep.");
        }
    }

    // method for level up of the user, increasing costs and plus
    public void levelUp(int oldLevel, int newLevel){
        // for costs
        this.costsWood=     (this.costsWood+this.maxPlus)/newLevel;
        this.costsClay=     (this.costsClay+this.maxPlus)/newLevel;
        this.costsIron=     (this.costsIron+this.maxPlus)/newLevel;
        this.costsGold=     (this.costsGold+this.maxPlus)/newLevel;
        this.costsPeople=   (this.costsPeople+this.maxPlus)/newLevel;

        // for plus
        if(this.plusWood!=0)    this.plusWood=this.plusWood+newLevel;
        if(this.plusClay!=0)    this.plusClay=this.plusClay+newLevel;
        if(this.plusIron!=0)    this.plusIron=this.plusIron+newLevel;
        if(this.plusGold!=0)    this.plusGold=this.plusGold+newLevel;
        if(this.plusPeople!=0)  this.plusPeople=this.plusPeople+newLevel;
    }

    // method is called if the user wants to build a new building, checked if enough materials available (if not return false), calculates the plus 
    // for unique buildings newBuild = a level up
    // plusGoldCastle is taken from the castle object to calculate the amount of gold added
    // schoolMultiplicator is taken from special1 of the School Object and is used to calculate the time needed to build something new/level up
    public void newBuild(int wood, int clay, int iron, int gold, int people, int schoolMultiplicator, int castleMultiplicator){

        if(wood-this.costsWood<0||clay-this.costsClay<0||iron-this.costsIron<0||gold-this.costsGold<0||people-this.costsPeople<0){
            System.out.println("You do not have enough resources."); 
            return;
        }

        wood=wood-this.costsWood;
        clay=clay-this.costsClay;
        iron=iron-this.costsIron;
        gold=gold-this.costsGold;
        people=people-this.costsPeople;

        System.out.println("Wait until the building is built.");

        learningWait(schoolMultiplicator);
        wood=wood+this.plusWood;
        clay=clay+this.plusClay;
        iron=iron+this.plusIron;
        if(this.name=="Cottage"){
            gold=gold+castleMultiplicator*this.plusPeople;
        }
        people=people+this.plusPeople;

        if(this.name=="School"){
            special1=special1-20;
        }

        this.amount++;

        User.materials[0]=wood;
        User.materials[1]=clay;
        User.materials[2]=iron;
        User.materials[3]=gold;
        User.materials[4]=people;

        CasePrintouts.resources();
        System.out.println("The building has been built.");
    }

    // method is used to get info about costs and plus of creating the building
    public void getInfo(){
        System.out.println("Costs:\nWood: "+this.costsWood+"\nClay: "+this.costsClay+"\nIron: "+this.costsIron+"\nGold: "+this.costsGold+"\nPeople: "+this.costsPeople);
        System.out.println("Plus:\nWood: "+this.plusWood+"\nClay: "+this.plusClay+"\nIron: "+this.plusIron+"\nGold: "+this.plusGold+"\nPeople: "+this.plusPeople);
        System.out.println("Amount: "+this.amount);
    }
}
