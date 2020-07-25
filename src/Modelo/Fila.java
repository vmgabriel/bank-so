package Modelo;

import Controlador.Ejecucion;
import javax.swing.Timer;

public class Fila implements COLA{

    private Nodo raiz,fondo;
    
    private Timer tiempo;
    
    private Ejecucion ej;
    
    public Fila(int a){
        raiz=null;
        fondo=null;
        ej=new Ejecucion();
        tiempo=new Timer(a,ej);
        tiempo.start();
    }
    
    @Override
    public boolean vacia (){
        return this.raiz == null;
    }
    
    @Override
    public void insertar (int info)
    {
        Nombres n=new Nombres();
        Nodo nuevo;
        nuevo = new Nodo ();
        nuevo.setInfo(info);
        nuevo.setUsu(new Usuario(n.generarnombre()));
        nuevo.setSig(null);
        if (vacia ()) {
            this.raiz = nuevo;
            this.fondo = nuevo;
        }
        else {
            this.fondo.setSig(nuevo); //el fondo del siguiente enlace
            this.fondo = nuevo; //el fondo general de el nodo
        }
    }
    
    @Override
    public void eliminar(int ref){
        Nodo reco=raiz;
        Nodo ant=null;
        if (!vacia()){
            while(reco!=null){
                if (reco.getInfo()==ref){
                    if (this.raiz==reco && this.fondo==reco){
                        this.raiz=null;
                        this.fondo=null;
                    }
                    else{
                        if (reco == this.raiz && reco != this.fondo){
                            this.raiz=this.raiz.getSig();
                        }
                        if (reco != this.fondo && reco != this.raiz){
                            ant.setSig(reco.getSig());
                        }
                        else if (reco == this.fondo && reco!=this.raiz){
                            ant.setSig(null);
                            this.fondo=ant;
                        }   
                    }
                }
                ant=reco;
                reco=reco.getSig();
            }
            ordenar();
        }
    }

    @Override
    public String[] MostrarTodos() {
        Nodo reco=raiz;
        String [] dan=new String[100];
        int ite=0;
        while (reco!=null) {
            dan[ite]=reco.getUsu().getNombre();
            reco=reco.getSig();
            ite++;
        }
        return dan;
    }
    
    @Override
    public int cantidad() {
        Nodo temp=this.raiz;
        int nat=0;
        while(temp!=null){
            temp=temp.getSig();
            nat++;
        }
        return nat;
    }

    @Override
    public int ultimonumero() {
        return this.fondo.getInfo();
    }
    
    private void ordenar() {
        Nodo reco=this.raiz;
        int it=0;
        if (!vacia()){
            while(reco!=null){
                reco.setInfo(it);
                reco=reco.getSig();
                it++;
            }
        }
    }

    @Override
    public String turno() {
        String nom =this.raiz.getUsu().getNombre();
        this.raiz=this.raiz.getSig();
        ordenar();
        return nom;
    }    
}