import java.util.ArrayList;

public class Simulation {

  private Terrain terrain;
  private TerrainAgent terrainagent;
  private ArrayList<Ressource> tabRessources;
  private ArrayList<Agent> tabAgents;

  private final int nbMaxRessources;
  private final int nbMaxAgents;
  private int cptRessources;
  private int cptAgents;
  private int nbLignes;
  private int nbColonnes;
  public static final int PERIODICITEMETEORITE = 5;
  public static final int NBMAXETAPES = 20;

  public boolean validite(int x, int y){
    return this.terrain.sontValides(x, y);
  }

  //constructeur avec parametres : n = nb de agents et m = nb de ressources
    public Simulation(int nblignes , int nbcolonnes, int n, int m){

    //verification des donnees
    if(nblignes>Terrain.NBLIGNESMAX){
      this.nbLignes = Terrain.NBLIGNESMAX;
    }else if(nblignes<0){
      this.nbLignes = 1;
    }else{
      this.nbLignes = nblignes;
    }
    if(nbcolonnes>Terrain.NBCOLONNESMAX){
      this.nbColonnes = Terrain.NBCOLONNESMAX;
    }else if(nblignes < 0){
      this.nbColonnes = 1;
    }else{
      this.nbColonnes = nbcolonnes;
    }

    //initialisations
    terrain = new Terrain(this.nbLignes, this.nbColonnes);
    terrainagent = new TerrainAgent(this.nbLignes, this.nbColonnes);
    tabRessources = new ArrayList<Ressource>();
    tabAgents = new ArrayList<Agent>();

    this.nbMaxRessources = m;
    this.nbMaxAgents = n;
    this.cptRessources = 0;
    this.cptAgents = 0;

    // remplissage des cases des ressources, on fait un for avec m ressources
    //on "tire" au sort une case du tableau au hasard, 
    //on verifie si elle est vide avec caseEstVide,
    // si oui on positionne la ressource avec setCase, sinon, on re-tire au sort une nouvelle case, jusqu'à avoir mis m ressources sur le terrain
    
    // 40 % des ressources sont des fougeres
    int cpt = 0, i, j;
    int nbFougeres, nbInsectes;
    while(cpt<(int)(m*0.4)){
        i = (int)(Math.random() * this.nbLignes);
        j = (int)(Math.random() * this.nbColonnes);
        while(terrain.caseEstVide(i,j)==false){
            i = (int)(Math.random() * this.nbLignes);
            j = (int)(Math.random() * this.nbColonnes);
        }
        Fougere tmp = new Fougere((int)(Math.random()*8)+2); //mettre des quantites aleatoires
        terrain.setCase(i,j,(Ressource)tmp);
        tabRessources.add(tmp);
        cpt++;
    }
    cptRessources += cpt;
    nbFougeres = cpt;

    cpt = 0;
    // 30 % des ressources sont des insectes
    while(cpt<(int)(m*0.3)){
        i = (int)(Math.random() * this.nbLignes);
        j = (int)(Math.random() * this.nbColonnes);
        while(!terrain.caseEstVide(i,j)==false){
            i = (int)(Math.random() * this.nbLignes);
            j = (int)(Math.random() * this.nbColonnes);
        }
        Insecte tmp = new Insecte((int)(Math.random()*5)+2); //mettre des quantites aleatoires
        terrain.setCase(i,j,(Ressource)tmp);
        tabRessources.add(tmp);
        cpt++;
    }
    cptRessources += cpt;
    nbInsectes = cpt;
    
    //le reste sont des Oiseaux
    cpt = 0;
    while(cpt<(n - nbFougeres - nbInsectes)){
        i = (int)(Math.random() * this.nbLignes);
        j = (int)(Math.random() * this.nbColonnes);
        while(terrain.caseEstVide(i,j)==false){
            i = (int)(Math.random() * this.nbLignes);
            j = (int)(Math.random() * this.nbColonnes);
        }
        Oiseau tmp = new Oiseau((int)(Math.random()*7)+2); //mettre des quantites aleatoires
        terrain.setCase(i,j,(Ressource)tmp);
        tabRessources.add(tmp);
        cpt++;
    }
    cptRessources += cpt;

    // On refait le processus pour les agents
    cpt = 0;
    int nbDiplodocus, nbPterodactyle, nbSilky;
    while(cpt<(int)(n*0.25)){
        i = (int)(Math.random() * this.nbLignes);
        j = (int)(Math.random() * this.nbColonnes);
        while(terrainagent.estVide(i,j)==false){
            i = (int)(Math.random() * this.nbLignes );
            j = (int)(Math.random() * this.nbColonnes );
        }
        Diplodocus tmp = new Diplodocus();
        terrainagent.setCase(i,j,(Agent)tmp); 
        tabAgents.add(tmp);
        cpt++;
    }
    nbDiplodocus = cpt;
    cptAgents += cpt;

    cpt = 0;
    while(cpt<(int)(n*0.25)){
        i = (int)(Math.random() * this.nbLignes);
        j = (int)(Math.random() * this.nbColonnes);
        while(terrainagent.estVide(i,j)==false){
            i = (int)(Math.random() * this.nbLignes);
            j = (int)(Math.random() * this.nbColonnes);
        }
        Pterodactyle tmp = new Pterodactyle();
        terrainagent.setCase(i,j,(Agent)tmp); 
        tabAgents.add(tmp);
        cpt++;
    }
    nbPterodactyle = cpt;
    cptAgents += cpt;
    
    cpt = 0;
    while(cpt<(int)(n*0.25)){
        i = (int)(Math.random() * this.nbLignes);
        j = (int)(Math.random() * this.nbColonnes);
        while(terrainagent.estVide(i,j)==false){
            i = (int)(Math.random() * this.nbLignes );
            j = (int)(Math.random() * this.nbColonnes );
        }
        Silky tmp = new Silky();
        terrainagent.setCase(i,j,(Agent)tmp); 
        tabAgents.add(tmp);
        cpt++;  
    }

    nbSilky = cpt;
    cptAgents += cpt;

    cpt = 0;
    while(cpt<(int)(n - nbDiplodocus - nbSilky - nbPterodactyle)){
        i = (int)(Math.random() * this.nbLignes);
        j = (int)(Math.random() * this.nbColonnes);
        while(terrainagent.estVide(i,j)==false){
            i = (int)(Math.random() * this.nbLignes);
            j = (int)(Math.random() * this.nbColonnes);
        }
        TRex tmp = new TRex();
        terrainagent.setCase(i,j,(Agent)tmp); //mettre des quantites aleatoires
        tabAgents.add(tmp);
        cpt++;
    }
    cptAgents += cpt;
}

    //constructeur avec 2 parametres
    public Simulation(int n, int m){
        this(Terrain.NBLIGNESMAX, Terrain.NBCOLONNESMAX, n, m);
    }

    //methode pour veilleir les dinosaures (les agents qui possedent cette methode)
    public void veillirTousAgents(){
        for(int i = 0; i<tabAgents.size();i++){
          if(tabAgents.get(i)!=null){
            if((tabAgents.get(i) instanceof Dinosaure)){
              ((Dinosaure)tabAgents.get(i)).vieillir();
            }
          }
        }
    }

    //methode pour veillir les ressources avec changement interne (les fourgeres et les oiseaux)
    public void veillirToutesRessources(){
        for(int i = 0; i<tabRessources.size();i++){
            if(tabRessources.get(i)!=null){
                if((tabRessources.get(i) instanceof Fougere)){
                    ((Fougere)tabRessources.get(i)).vieillir();
                }

                if((tabRessources.get(i) instanceof Oiseau)){
                    ((Oiseau)tabRessources.get(i)).vieillir();
                }
            }
        }
    }

    //suppresion d'un agent de l'array list
    public Agent remove(Agent ag){
        if(ag!=null){
            int i = tabAgents.indexOf(ag);
            if(i!=-1){
            this.cptAgents --;
            return tabAgents.remove(i);
            }
        }
        return null;
    }

    //suppresion d'une ressource de l'array list
    public Ressource remove(Ressource r){
        if(r!=null){
            int i = tabRessources.indexOf(r);
            if(i!=-1){
                this.cptRessources --;
                return tabRessources.remove(i);
            }
        }
        return null;
    }

    //affichage des ressources
    public String afficheToutesRessources(){
        String s = "";
        for(int i = 0; i<tabRessources.size();i++){
            if(tabRessources.get(i)!=null){
                s += tabRessources.get(i).toString() + "\n";
            }
        }
        return s;
    }

    //affichage des agents
    public String afficheTousAgents(){
        String s = "";
        for(int i = 0; i<tabAgents.size();i++){
            if(tabAgents.get(i)!=null){
                s += tabAgents.get(i).toString() + "\n";
            }
        }
        return s;
    }

  public void etape(){
    //affichage du terrain
    this.terrain.affiche(10);
    System.out.println(afficheToutesRessources());
    System.out.println(afficheTousAgents());
    //caracteristique du terrain
    for(int i = 0; i<tabAgents.size();i++){
        Agent monAgent = tabAgents.get(i);
        if(monAgent!=null){
          int xAgent = monAgent.getX();
          int yAgent = monAgent.getY();
          Ressource res = terrain.getCase(xAgent, yAgent);
          if(res!=null){
            if((monAgent instanceof Carnivore)&&(res instanceof Oiseau)){
              ((Dinosaure)monAgent).ajoutEnergie(res.getQuantite()*((Oiseau)res).getEnergie());
              terrain.videCase(xAgent, yAgent);
              remove(res);
            }
            else if((monAgent instanceof Carnivore)&&(res instanceof Insecte)){
              ((Dinosaure)monAgent).ajoutEnergie(res.getQuantite());
              terrain.videCase(xAgent, yAgent);
              remove(res);
            }
            else if((monAgent instanceof Herbivore)&&(res instanceof Fougere)){
              ((Dinosaure)monAgent).ajoutEnergie(res.getQuantite()*((Fougere)res).getEnergie());
              terrain.videCase(xAgent, yAgent);
              remove(res);
            }
          }
        }
      }

      veillirToutesRessources();
      veillirTousAgents();

      for(int i = 0; i<tabAgents.size();i++){
        Agent monAgent = tabAgents.get(i);
        if(monAgent!=null){
          if(((Dinosaure)monAgent).getEnergie()<=0){
            remove(monAgent);
          }
        }
      }

      for(int i = 0; i<tabRessources.size();i++){
        Ressource maRes = tabRessources.get(i);
        if(maRes!=null){
          if(maRes instanceof Oiseau){
            if(Math.random()<0.3){
              ((Oiseau)maRes).eclosion();
            }
          }
          if(maRes instanceof Fougere){
            if((((Fougere)maRes).getEnergie())<=0) remove(maRes);
          }

          else if(maRes instanceof Oiseau){
            if((((Oiseau)maRes).getEnergie())<=0) remove(maRes);
          }
        }
      }

      for(int i = 0; i<tabAgents.size();i++){
        Agent monAgent = tabAgents.get(i);
        if(monAgent!=null){
          int x = (int)((Math.random()*(terrainagent.getLignes())));
          int y = (int)((Math.random()*(terrainagent.getColonnes())));
          if(terrainagent.getCase(x, y)==null){
            terrainagent.setCase(x, y, monAgent);
          }
        }
      }
    }
  
  public void tombeMeteorite(Meteorite m){
    int x = m.getX();
    int y = m.getY();

    if(terrain.caseEstVide(x, y)==false){
      Ressource tmp = terrain.getCase(x, y);
      remove(tmp);
      terrain.videCase(x, y);
    }

    if(terrainagent.estVide(x, y)==false){
      Agent tmp = terrainagent.getCase(x, y);
      remove(tmp);
      terrainagent.videCase(x, y);
    }
  }
    //getter
    public int getNbLignes(){return this.nbLignes;}
    public int getColonnes(){return this.nbColonnes;}
}
