public abstract class DinosaureAvecAiles extends Dinosaure{
    
    private boolean avecPlumes;
    
    //constructeur avec parametres
    public DinosaureAvecAiles(int nbPattes, String couleur, double poids, double taille, int energie,
        boolean avecPlumes){
        super(nbPattes, couleur, poids, taille, energie);
        this.avecPlumes = avecPlumes;
    }
    
    //methode toString()
    public String toString(){
        String s = super.toString() + "\nDinosaure avec ailes";
        if(this.avecPlumes){
            s+=" avec";
        }else{
            s+=" sans";
        }
        s+= " plumes";
        return s;
    }
}
