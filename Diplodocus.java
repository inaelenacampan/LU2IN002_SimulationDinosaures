public class Diplodocus extends DinosaureSansAiles implements Herbivore{

    public Diplodocus(){
        super(4, "marron", 15000, 6.0, 100, false);
    }
    
    public String regime(){
        return "Je suis herbivore";
    }

    public void vieillir(){
        this.ajoutEnergie(-10);
    }
    //methode String toString()
    public String toString(){
        return "Diplodocus : " + super.toString();
    }
}
