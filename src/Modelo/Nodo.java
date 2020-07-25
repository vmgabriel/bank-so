package Modelo;


public class Nodo {
    
    private int info;//identificador
    private Usuario usu;//Datos
    private Nodo sig;//Referencia al siguiente

    public Nodo(int info, Usuario usu) {
        this.info = info;
        this.usu = usu;
    }
    
    public Nodo(){}

    public int getInfo() {
        return info;
    }

    public Usuario getUsu() {
        return usu;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}