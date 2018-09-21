/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author torin
 */
public class Arbol {
    Nodo raiz;
    
    public Arbol(){
        this.raiz=null;
    }
    
    public void Insertar(int valor){
        Nodo n = new Nodo();
        n.valor=valor;        
        if(raiz==null){
            raiz=n;
        }else{
            Insertar(n,raiz,null);
        }
    }
    int peso;
    public void Insertar(Nodo actual, Nodo bye, Nodo padre) {     //ENVIO NODO,RAIZ,NULL   
        if (bye != null) {
            if (actual.valor < bye.valor) {//ISQUIERDA   
                Insertar(actual, bye.izq, bye);//ind  0
                bye.peso = bye.izq.peso + 1;
                if (bye.der != null) {
                    peso = bye.der.peso;
                } else {
                    peso = 0;
                }
                if (bye.izq.peso - peso > 1) {//ROTACION ALA DERECHA
                    if(bye.izq.izq!=null)peso=bye.izq.izq.peso;
                    else peso=0;
                    int peso2=0;
                    if(bye.izq.der!=null)peso2=bye.izq.der.peso;
                    else peso2=0;
                        if(peso2>peso){//derecho es mayor al izquierdo
                            int p=bye.izq.der.valor;
                            bye.izq.der.valor=bye.valor;
                            bye.valor=p;
                            Nodo aux=bye.der;
                            bye.der=bye.izq.der;
                            bye.izq.der=bye.der.izq;
                            bye.der.izq=bye.der.der;
                            bye.der.der=aux;
                            bye.peso=bye.der.peso+1;
                            bye.izq.peso=bye.peso-1;
                        }else{ 
                            if(padre!=null){
                             padre.izq=bye.izq;
                             bye.izq=bye.izq.der;
                             padre.izq.der=bye;
                             padre.izq.peso=padre.peso-1;
                             bye.peso=padre.izq.peso-1;
                            }else{
                                raiz=bye.izq;
                             bye.izq=raiz.der;
                             raiz.der=bye;
                             raiz.izq.peso=raiz.peso-1;
                             raiz.der.peso=raiz.peso-1;
                            }
                        }
                }
            } else {//DERECHA
                Insertar(actual, bye.der, bye);//ind 1
                bye.peso = bye.der.peso + 1;
                if (bye.izq != null) {
                    peso = bye.izq.peso;
                } else {
                    peso = 0;
                }
                if (peso - bye.der.peso < -1) {//ROTACION ALA IZQUIERDA
                    if(bye.der.der!=null)peso=bye.der.der.peso;
                    else peso=0;
                    int peso2=0;
                    if(bye.der.izq!=null)peso2=bye.der.izq.peso;
                    else peso2=0;
                        if(peso2>peso){//izquierdo es mayor al derecho
                            int p=bye.der.izq.valor;
                            bye.der.izq.valor=bye.valor;
                            bye.valor=p;
                            Nodo aux=bye.izq;
                            bye.izq=bye.der.izq;
                            bye.der.izq=bye.izq.der;
                            bye.izq.der=bye.izq.izq;
                            bye.izq.izq=aux;
                            bye.peso=bye.izq.peso+1;
                            bye.der.peso=bye.peso-1;
                        }else{
                            if(padre!=null){
                             padre.der=bye.der;
                             bye.der=bye.der.izq;
                             padre.der.izq=bye;
                             padre.der.peso=padre.peso-1;
                             bye.peso=padre.der.peso-1;
                            }else{
                                raiz=bye.der;
                             bye.der=raiz.izq;
                             raiz.izq=bye;
                             raiz.izq.peso=raiz.peso-1;
                             raiz.der.peso=raiz.peso-1;
                            }
                        }
                }
            }
        } else {
            if (actual.valor < padre.valor) {
                padre.izq = actual;
            } else {
                padre.der = actual;
            }
        }
    }

    
    
    
    public void Mostrar(){
        Queue <Nodo> cola=new LinkedList();
        if(raiz!=null){
        cola.add(raiz);
        while(cola.peek()!=null){
            if(cola.element().getIzq()!=null){
                cola.add(cola.element().getIzq());
            }
            if(cola.element().getDer()!=null){
                cola.add(cola.element().getDer());
            }
            System.out.print(cola.element().getValor()+"       "+cola.element().peso+" ");
            System.out.println("");
            cola.remove();
        }
        }else{
            System.out.println("ARBOL TALADO");
        }
    }
    
    public void Eliminar(int valor){
        if(raiz!=null){
           Eliminar(raiz,null,valor); 
        }else{
            System.out.println("ARBOL TALADO V:");
        }
    }
    
    public void Eliminar(Nodo actual,Nodo padre,int valor){
        if(valor<actual.valor){
            Eliminar(actual.izq,actual,valor);
        }
        if(valor>actual.valor){
            Eliminar(actual.der,actual,valor);
        }
        if(valor==actual.valor){
            if(actual.izq!=null){
                Nodo hijo=actual.izq;
                Nodo aux=hijo;
                if(aux!=null){
                    while(aux.der!=null){
                        hijo=aux;
                        aux=aux.der;
                    }
                    actual.valor=aux.valor;                    
                    if(aux!=hijo){
                    hijo.der=aux.izq;
                    }else{
                        actual.izq=hijo.izq;
                    }
                }
                
            }else {
                if(actual.der!=null){
                Nodo hijo=actual.der;
                Nodo aux=hijo;
                if(aux!=null){
                    while(aux.izq!=null){
                        hijo=aux;
                        aux=aux.izq;
                    }
                    actual.valor=aux.valor;                    
                    if(aux!=hijo){
                    hijo.izq=aux.der;
                    }else{
                        actual.der=hijo.der;
                    }
                }
                }else{
                    if(padre!=null){
                        if(padre.izq==actual){
                            padre.izq=actual.izq;
                        }else{
                            padre.der=actual.izq;
                        }
                    }else{
                        raiz=null;
                    }
                }
            }
            
        }
    }
}
