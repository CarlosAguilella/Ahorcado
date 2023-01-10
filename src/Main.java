import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

class Ahorcado {

    String getRandomWord() {
        try {
            Scanner scanner = new Scanner(new File("spanish"));

            Random random = new Random();
            int numero = random.nextInt(86016);
            String palabra = "KAKA";
            for (int i = 0; i < numero; i++) {
                palabra = scanner.nextLine();
            }
            return palabra;
        } catch (FileNotFoundException e) {
            return "ahorcado";
        }
    }

    String generaGuiones(String palabra) {
        return "_".repeat(palabra.length());

    }

    char pedirLetra() {
        Scanner scanner = new Scanner(System.in);

        return scanner.next().charAt(0);
    }

    String actualizarGuiones(String palabra, String guiones, char letra) {
        String resultat = "";
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i)==letra){
                resultat += letra;
            } else {
                resultat += guiones.charAt(i);
            }
        }
        return resultat;
    }

    private String actualizarFallos(String fallos, String palabra, char letra) {
        if (palabra.indexOf(letra) == -1){
            return fallos + letra;
        }
        return fallos;
    }

    void play() {

        String palabra = getRandomWord();

        String guiones = generaGuiones(palabra);

        String fallos = "";

        System.out.println(palabra);
        System.out.println(guiones);




        for (;;) {


            char letra = pedirLetra();

            fallos = actualizarFallos(fallos, palabra, letra);

            guiones = actualizarGuiones(palabra, guiones, letra);

            System.out.println(guiones);
            System.out.println("FALLOS: "+fallos);

            if(guiones.equals(palabra)){
                System.out.println("FELICIDADES");
                break;
            }

        }





    }
}

public class Main {
    public static void main(String[] args) {
        new Ahorcado().play();
    }
}