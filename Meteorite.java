public class Meteorite extends Agent{
    private double poids;
    private double diametre;
    private int x;
    private int y;
    
    //constructeur avec parametres
    public Meteorite(double poids, double diametre){
        super();
        this.poids = poids;
        this.diametre = diametre;
        this.x = -1;
        this.y = -1;
    }

    public Meteorite clone(){
        Meteorite tmp =  new Meteorite(this.poids, this.diametre);
        tmp.x = this.getX();
        tmp.y = this.getY();
        return tmp;

    }
    
    public void attaqueMeteorite(int nbLignes, int nbColonnes){
        this.x = (int)(Math.random()*nbLignes);
        this.y = (int)(Math.random()*nbColonnes);
    }

    //methode toString()
    public String toString(){
        return super.toString() + "Meteorite - poids : " + String.format("%.3f",this.poids) 
        + " + diametre " + String.format("%.3f",this.diametre) + "(X = " + this.x + " ; Y = " + this.y + " )";
    }

    //getter pour les variables
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public double diametre(){return this.diametre;}
    public double poids(){return this.poids;}
}