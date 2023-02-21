public abstract class DinosaureSansAiles extends Dinosaure{

    public boolean bipede;
    //constructeur avec parametres
    public DinosaureSansAiles(int nbPattes, String couleur, double poids, 
        double taille, int energie, boolean bipede){
        super(nbPattes, couleur, poids, taille, energie);
        this.bipede = bipede;
    }

    //methode toString()
    public String toString(){
        String s = super.toString() + "\nDinosaure sans ailes";
        if(this.bipede){
            s+=" bipede";
        }else{
            s+=" non-bipede";
        }
        return s;
    }
}
