public class TerrainAgent {
    private Agent[][] terrain;
    public static final int NBLIGNESMAX = Terrain.NBLIGNESMAX;
    public static final int NBCOLONNESMAX = Terrain.NBCOLONNESMAX;
    private int nbLignes;
    private int nbColonnes;

    //constructeur avec parametres (n = nbLignes, m = nbColonnes)
    public TerrainAgent(final int n, final int m){
        //verification des coordonees passees en parametres
        if (n > TerrainAgent.NBLIGNESMAX) {
            this.nbLignes = TerrainAgent.NBLIGNESMAX;
        }
        else if (n <= 0) {
            this.nbLignes = 1;
        }
        else {
            this.nbLignes = n;
        }
        if (m > TerrainAgent.NBCOLONNESMAX) {
            this.nbColonnes= TerrainAgent.NBCOLONNESMAX;
        }
        else if (m<= 0) {
            this.nbColonnes = 1;
        }
        else {
            this.nbColonnes = m;
        }
        this.terrain = new Agent[this.nbLignes][this.nbColonnes];
    }
    
    //constructeur sans parametres
    public TerrainAgent(){
        this(Terrain.NBLIGNESMAX, Terrain.NBCOLONNESMAX);
    }

    //Verification de la validite des coordonees
    public boolean sontValides(int x, int y){
        return (x<this.nbLignes)&&(y<this.nbColonnes);
    }

    //verification si le contenu d'une case est Vide ou pas
    public boolean estVide(int x, int y){
        if(sontValides(x, y)){
            return (this.terrain[x][y]==null);
        }
        return false;
    }

    //recuperation du contenu d'une case du terrain
    public Agent getCase(int x, int y){
        if(sontValides(x, y)){
            return terrain[x][y];
        }
        return null;
    }
    
    //modification du contenu d'une case --> appel a seDeplacer
    public boolean setCase(int x, int y, Agent ag) {
        if (this.sontValides(x, y)) {
            if (this.terrain[x][y] != null) {
                this.terrain[x][y].initialisation();
            }
            (this.terrain[x][y] = ag).seDeplacer(x, y);
            return true;
        }
        return false;
    }

    //modification du contenu d'une case du tableau (on va recuperer l'agent supprimer depuis le terrain)
    public Agent videCase(int x, int y) {
        if (this.sontValides(x, y) && this.terrain[x][y] != null) {
            Agent tmp = this.terrain[x][y];
            tmp.initialisation();
            this.terrain[x][y] = null;
            return tmp;
        }
        return null;
    }

    //getter pour les variables
    public int getLignes(){return this.nbLignes;}
    public int getColonnes(){return this.nbColonnes;}
}
