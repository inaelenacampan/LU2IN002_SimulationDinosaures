public class Oiseau extends Ressource{
    private boolean estOeuf;
    private int age;
    private int energie;

    //constructeur avec un parametre --> l'oeuf va se transformer dans un oiseau
    public Oiseau(int quantite){
        super("Oiseau", quantite);
        this.estOeuf = true;
        this.age = 0;
        this.energie = 5;
    }

    //methode pour la transformation en oiseau
    public void eclosion(){
        if(estOeuf){
            estOeuf = false;
            this.age++;
            energie = 30;
        }
    }
    
    public void vieillir(){
        if((estOeuf==false)&&(energie>=0)) {
            this.age++;
            this.energie -= 6;
        }
    }

    //methode toString()
    public String toString(){
        return super.toString() + " ; energie = " + this.energie;
    }

    //getter
    public int getAge(){return this.age;}
    public boolean getEtat(){return this.estOeuf;}
    public int getEnergie(){return this.energie;}

}
