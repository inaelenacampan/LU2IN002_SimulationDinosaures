public class TRex extends DinosaureSansAiles implements Carnivore{
    //constructeur sans parametres
    public TRex(){
        super(4, "marron", 9000, 5,150, true);
    }

    public String regime(){
        return "Je suis carnivore";
    }

    public void vieillir(){
        ajoutEnergie(-15);
    }

    //methode String toString()
    public String toString(){
        return "T-Rex : " + super.toString();
    }
}
