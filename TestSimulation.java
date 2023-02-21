import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class TestSimulation {
    public static void main(String[] args) throws InterruptedException{
        int etapes = Simulation.NBMAXETAPES;
        int periode = Simulation.PERIODICITEMETEORITE;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrer le nombre de lignes : ");
        try{
            int x = scanner.nextInt();
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Entrer le nombre de colonnes : ");
            int y = scanner2.nextInt();
            Simulation maSimulation = new Simulation(10, 5,20, 15);
            for(int i = 0; i<etapes; i++){
                System.out.println("\tETAPE : " + (i+1));
                if(i%periode==0){
                    Meteorite m = new Meteorite(Math.random()*500, Math.random()*10);
                    m.attaqueMeteorite(maSimulation.getNbLignes(), maSimulation.getColonnes());
                    System.out.println(m.toString());
                    maSimulation.tombeMeteorite(m);
                }
                maSimulation.etape();
                Thread.sleep(2000);
            } 
            }catch(FormatException e){
                System.out.println(e.toString());{

            }
        }
    }
}