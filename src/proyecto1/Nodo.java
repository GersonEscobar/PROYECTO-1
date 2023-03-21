package proyecto1;

/**
 *
 * @author Gerson
 */
public class Nodo {

    private char valor;
    private Nodo izq,der,padre;
     
    /* Constructores */
    public Nodo(char valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }
        
    public Nodo() {        
        this.izq = null;
        this.der = null;
    } 

    public void setValor(char valor) {
        this.valor = valor;
    }
 
    public char getValor() {
        return valor;
    }
 
    public Nodo getIzq() {
        return izq;
    }
 
    public void setIzq(Nodo hojaIzquierda) {
        this.izq = hojaIzquierda;
    }
 
    public Nodo getDer() {
        return der;
    }
 
    public void setDer(Nodo hojaDerecha) {
        this.der = hojaDerecha;
    }   

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo nodoPadre) {
        this.padre= nodoPadre;
    }
    
    
}