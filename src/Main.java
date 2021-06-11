import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        int[] valores = new int[0];
        try{
            File archivo = new File("ingresos.txt");

            Scanner contador = new Scanner(archivo); //ineficiente
            int renglones = 0;
            while(contador.hasNextLine()){
                renglones++;
                contador.nextLine();
            }
            contador.close();
            valores = new int[renglones];
            Scanner lector = new Scanner(archivo);
            int i = 0;
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String valorISK = (linea.split("\\t"))[2];
                valorISK = valorISK.replace(".","");
                valorISK = valorISK.substring(0, valorISK.length()-4);
                valores[i] = Integer.parseInt(valorISK);
                i++;
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        Ventana v1 = new Ventana(ImprimirSuma(valores));
        v1.setVisible(true);
    }

    public static int ImprimirSuma(int[] valores){
        int suma = 0;
        for (int i = 0; i < valores.length; i++) {
            suma += valores[i];
        }
        String valorSalida = String.valueOf(suma);
        System.out.println("Has generado: " + suma + " ISK" );
        System.out.println("Impuesto: " + (int)(suma*0.05) + " ISK" );
        return suma;
    }

    public static void Imprimir(int[] valores){
        for (int i = 0; i < valores.length; i++) {
            System.out.println(valores[i]);
        }
    }

}
