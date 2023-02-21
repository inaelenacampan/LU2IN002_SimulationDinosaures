public class Silky extends DinosaureAvecAiles implements Carnivore{

    public Silky(){
        super(4, "gris", 80, 0.5, 20, true);
    }

    public String regime(){
        return "Je suis carnivore";
    }

    public void vieillir(){
        ajoutEnergie(-1);
    }
    
    //methode String toString()
    public String toString(){
        return "Silky : " + super.toString(); 
    }
}
