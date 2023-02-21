public class TestSimulation2 {
    public static void main(String[] args){
        int etapes = Simulation.NBMAXETAPES;
        int periode = Simulation.PERIODICITEMETEORITE;
        Simulation maSimulation = new Simulation(5, 5,10, 3);
        for(int i = 0; i<4; i++){
            System.out.println("\tETAPE : " + (i+1));
            if(i%periode==0){
                Meteorite m = new Meteorite(Math.random()*500, Math.random()*10);
                m.attaqueMeteorite(maSimulation.getNbLignes(), maSimulation.getColonnes());
                System.out.println(m.toString());
                maSimulation.tombeMeteorite(m);
            }
            maSimulation.etape();
            } 
        }
}