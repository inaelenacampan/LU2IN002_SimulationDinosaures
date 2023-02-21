import java.util.InputMismatchException;

public class FormatException extends InputMismatchException{
    public FormatException(){
        super("Probleme de formatage (on attendais des entiers comme parametres)");
    }
}