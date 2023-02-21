public abstract class Dinosaure extends Agent{
    private int nbPattes;
    private String couleur;
    private static int nbDino = 0;
    private double poids;
    private double taille;
    private int energie;

    //constructeur avec parametres
    public Dinosaure(int nbPattes, String couleur, double poids, double taille, int energie){
        super();
        nbDino++;
        this.energie = energie;
        this.nbPattes = nbPattes;
        this.couleur = couleur;
        this.poids = poids;
        this.taille = taille;
        this.energie = energie;
    }

    //methode abstract --> heritage par les classes filles
    public abstract void vieillir();

    //methode toString
    public String toString(){
        return super.toString() + "Dinosaure de " + this.nbPattes 
        + " pattes, de couleur " + this.couleur + "(poids: " + this.poids
        + " , taille : " + this.taille + " ENERGIE : " + this.energie;
    }

    //getter pour des variables
    public static int getNbDino(){return nbDino;}
    public int getEnergie(){return this.energie;}

    //setter pour modifier la valeur d'energie avec addition
    public void ajoutEnergie(int addition){this.energie += addition;}
}
