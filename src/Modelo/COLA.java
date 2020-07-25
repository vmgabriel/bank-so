package Modelo;

public interface COLA {
    
    boolean vacia ();
    void insertar (int info);
    void eliminar(int ref);
    String[] MostrarTodos();
    int cantidad();
    int ultimonumero();
    String turno();
}