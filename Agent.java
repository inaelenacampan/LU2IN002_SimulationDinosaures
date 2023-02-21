public abstract class Agent{
    private int x;
    private int y;
    private static int nbAgents;
    private final int id;

    //constructeur sans parametres
    public Agent(){
        this.x = -1;
        this.y = -1;
        nbAgents++;
        id = nbAgents;
    }
    
    //methode pour initialiser les coordonees en (-1,-1) -> en dehors du tableau
    public void initialisation(){
        this.x = -1;
        this.y = -1;
    }
    
    //calcul de la distance euclidienne
    public double distance(int x, int y){
        return Math.sqrt((x-this.x)*(x-this.x)+(y-this.y)*(y-this.y));
    }
    
    //modification des coordonees d'un agent (les tests sont effectues dans la classe TerrainAgent)
    public void seDeplacer(int newx, int newy){
        this.x = newx;
        this.y = newy;
    }
    
    //methode toString
    public String toString(){
        return "Agent " + this.id;
    }
    
    //verification des coordonnees x et y sur le terrain des agents
    public boolean coordPossibles(int x, int y){
        return ((x>=0)&&(x<TerrainAgent.NBLIGNESMAX))&&((y>=0)&&(y<TerrainAgent.NBCOLONNESMAX));
    }
    
    //getter sur differents variables de la classe et des instances
    public static int getNbAgents(){return nbAgents;}
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getId(){return this.id;}
}