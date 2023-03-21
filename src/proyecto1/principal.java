package proyecto1;
import java.io.DataInputStream;
import java.io.IOException;
/**
 *
 * @author Kevin
 */
public class principal {
      public static void main(String[] args) {

        String expresion = null;                
        System.out.print("Ingrese la expresion aritmetica: ");
        try{
            DataInputStream ingresar = new DataInputStream(System.in);
            expresion = ingresar.readLine();
        }catch (IOException e){            
            e.printStackTrace();
        }
        Arbol mensajero = new Arbol();
        mensajero.GenerarArbol(expresion);
        
        mensajero.imprimir();
          System.out.println("");
   
        System.out.println("Arbol de Expresion Aritmetica");
        mensajero.impArbol();
}
}
