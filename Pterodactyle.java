public class Pterodactyle extends DinosaureAvecAiles implements Voler, Carnivore{
    
    //constructeur sans parametres
    public Pterodactyle(){
        super(4, "blanc et noir", 150, 1.0, 25, false);
    }

    public String voler(){
        return "Je vole!";
    }
    public String regime(){
        return "Je suis carnivore";
    }
    public void vieillir(){
        ajoutEnergie(-2);
    }

    //methode String toString()
    public String toString(){
        return "Pterodactyle : " + super.toString();
    }
}