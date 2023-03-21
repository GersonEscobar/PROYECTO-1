package proyecto1;
import java.util.Stack;
/**
 *
 * @author Gerson
 */
public class Arbol {
    private Nodo raiz;
    private String expresion;

    public Arbol() {
        raiz = null;
        expresion = null;
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo addNodo(char exp) {
        Nodo nodo = new Nodo();
        nodo.setValor(exp);
        nodo.setDer(null);
        nodo.setIzq(null);
        return nodo;
    }

    public void GenerarArbol(String r) {      
        r = "(" + r;
        r += ")";
        this.expresion = r;
        this.raiz = GenerarArbol();
    }
    
    public Nodo GenerarArbol() {
        String r = this.expresion;
        Stack<Nodo> stN = new Stack<>();
        Stack<Character> stC = new Stack<>();
        Nodo temp, temp1, temp2;

        int[] p = new int[123];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;

        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '(') {
                stC.add(r.charAt(i));
            }
            else if (Character.isDigit(r.charAt(i))) {
                temp = addNodo(r.charAt(i));
                stN.add(temp);
            } else if (p[r.charAt(i)] > 0) {
                while (!stC.isEmpty() && stC.peek() != '(' && ((r.charAt(i) != '^' && p[stC.peek()] >= p[r.charAt(i)]) || (r.charAt(i) == '^' && p[stC.peek()] > p[r.charAt(i)]))) {
                    temp = addNodo(stC.peek());
                    stC.pop();
                    temp1 = stN.peek();
                    stN.pop();
                    temp2 = stN.peek();
                    stN.pop();
                    temp.setIzq(temp2);
                    temp.setDer(temp1);
                    stN.add(temp);
                }
            stC.push(r.charAt(i));
            } else if (r.charAt(i) == ')') {
                while (!stC.isEmpty() && stC.peek() != '(') {
                    temp = addNodo(stC.peek());
                    stC.pop();
                    temp1 = stN.peek();
                    stN.pop();
                    temp2 = stN.peek();
                    stN.pop();
                    temp.setIzq(temp2);
                    temp.setDer(temp1);
                    stN.add(temp);
                }
                stC.pop();
            }
        }
        temp = stN.peek();
        return temp;
    }

    public void imprimir() {
        System.out.println("Datos en Inorden ");
        InOrden(this.raiz);
        System.out.println("");
        System.out.println("Datos en Preorden ");
        PreOrden(this.raiz);
        System.out.println("");
        System.out.println("Datos en Postorden ");
        PostOrden(this.raiz);
        
    }

    private void PreOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.getValor() + " ");
            PreOrden(raiz.getIzq());
            PreOrden(raiz.getDer());
            
        }
    }


    private void InOrden(Nodo raiz) {
        if (raiz != null) {
            InOrden(raiz.getIzq());
            System.out.print(raiz.getValor() + " ");
            InOrden(raiz.getDer());
            
        }
    }


    private void PostOrden(Nodo raiz) {
        if (raiz != null) {
            PostOrden(raiz.getIzq());
            PostOrden(raiz.getDer());
            System.out.print(raiz.getValor() + " ");
            
        }
    }

    private void rPreOrden(StringBuilder sb, Nodo node) {
        if (node != null) {
            sb.append(node.getValor());
            sb.append("\n");
            rPreOrden(sb, node.getIzq());
            rPreOrden(sb, node.getDer());
        }
    }

    private void rPosOrden(StringBuilder sb, Nodo node) {
        if (node != null) {
            rPosOrden(sb, node.getIzq());
            rPosOrden(sb, node.getDer());
            sb.append(node.getValor());
            sb.append("\n");
        }
    }

    public void impArbol() {
        imprimirArbol(this.raiz);
    }

    private void imprimirArbol(Nodo raiz) {
        irArbol(raiz, 0);
    }

    private void irArbol(Nodo raiz, int separador) {
        int espacios = 2;    
        if (raiz == null) {return;}
        separador += espacios;
        irArbol(raiz.getDer(), separador);
        System.out.println("");
        for (int i = espacios; i < separador; i++) {
            System.out.print(" . ");
        }
        System.out.print(raiz.getValor());
        System.out.println("");
        irArbol(raiz.getIzq(), separador);
    }       
    
}
    


