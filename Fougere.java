public class Fougere extends Ressource{
    private int energie;
    // on introduit une energie personnalisee pour certaines ressources. 
    //Les agents additionnent leur energie a celle de la ressource * la quantite quand ils la mangent 
    //La fougere est un ressource avec etat interne qui change

    public Fougere(int quantite){
        super("Fougere", quantite);
        this.energie = 8;
    }

    //Methode pour pousser (viellir)
    public void vieillir(){
       this.energie = this.energie + 2;
    }

    //getter
    public int getEnergie(){
        return this.energie;
    }

    //methode to string
    public String toString(){
        return super.toString() + " ; energie = " + this.energie;
    }

}

