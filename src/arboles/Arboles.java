/*ARBOL AVL TERMINADO PORFIN V:
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author torin
 */
public class Arboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Arbol a = new Arbol();
        System.out.println("valor   peso");
        a.Insertar(100);
        a.Insertar(50);
        a.Insertar(300);
        a.Insertar(25);
        a.Insertar(90);
        a.Insertar(250);
        a.Insertar(400);
        a.Insertar(15);
        a.Insertar(30);
        a.Insertar(80);
        a.Insertar(95);
        a.Insertar(500);
        a.Insertar(10);
        a.Insertar(70);
        a.Insertar(81);
        a.Insertar(93);
        a.Insertar(73);
//        a.Insertar(50);
//        a.Insertar(20);
//        a.Insertar(30);
        a.Mostrar();        
    }    
}
