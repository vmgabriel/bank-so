package Controlador;

import Vista.Index;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.ListModel;

public class EveIndex implements ActionListener{
    
    private Index in;

    public EveIndex(Index in) {
        this.in=in;
        this.in.getBtnañadirdin().addActionListener(this);
        this.in.getBtnañadirgen().addActionListener(this);
        this.in.getBtnañadirtar().addActionListener(this);
        this.in.getBtnsacardin().addActionListener(this);
        this.in.getBtnsacargen().addActionListener(this);
        this.in.getBtnsacartar().addActionListener(this);
        this.in.getBtnsiguiente().addActionListener(this);
    }
    
    private ListModel generar(String[] nova){
        ListModel modelo=new javax.swing.AbstractListModel() {
            String[] strings = nova;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public Object getElementAt(int i) { return strings[i]; }
        };
        return modelo;
    }
    
    private int sacarindex(JList lista){
        return lista.getSelectedIndex();
    }
    
    private void pintar(){
        this.in.repaint();
    }
    
    private void prioridad(){
        if (!this.in.getFila3().vacia()){
            this.in.getLblcliente().setText(this.in.getFila3().turno());
            this.in.getListdinner().setModel(generar(this.in.getFila3().MostrarTodos()));
            pintar();
        }
        else if (!this.in.getFila2().vacia()){
            this.in.getLblcliente().setText(this.in.getFila2().turno());
            this.in.getListtarje().setModel(generar(this.in.getFila2().MostrarTodos()));
            pintar();
        }
        else if (!this.in.getFila1().vacia()){
            this.in.getLblcliente().setText(this.in.getFila1().turno());
            this.in.getListgeneral().setModel(generar(this.in.getFila1().MostrarTodos()));
            pintar();
        }
        else{
            this.in.getLblcliente().setText("No hay Nadie");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==this.in.getBtnañadirdin()){
            this.in.getFila3().insertar(this.in.getFila3().ultimonumero()+1);
            this.in.getListdinner().setModel(generar(this.in.getFila3().MostrarTodos()));
            pintar();
        }
        if (source==this.in.getBtnañadirgen()){
            this.in.getFila1().insertar(this.in.getFila1().ultimonumero()+1);
            this.in.getListgeneral().setModel(generar(this.in.getFila1().MostrarTodos()));
            pintar();
        }
        if (source==this.in.getBtnañadirtar()){
            this.in.getFila2().insertar(this.in.getFila2().ultimonumero()+1);
            this.in.getListtarje().setModel(generar(this.in.getFila2().MostrarTodos()));
            pintar();
        }
        if (source==this.in.getBtnsacardin()){
            this.in.getFila3().eliminar(sacarindex(this.in.getListdinner()));
            this.in.getListdinner().setModel(generar(this.in.getFila3().MostrarTodos()));
            pintar();
        }
        if (source==this.in.getBtnsacargen()){
            this.in.getFila1().eliminar(sacarindex(this.in.getListgeneral()));
            this.in.getListgeneral().setModel(generar(this.in.getFila1().MostrarTodos()));
            pintar();
        }
        if (source==this.in.getBtnsacartar()){
            this.in.getFila2().eliminar(sacarindex(this.in.getListtarje()));
            this.in.getListtarje().setModel(generar(this.in.getFila2().MostrarTodos()));
            pintar();
        }
        if (source==this.in.getBtnsiguiente()){
            prioridad();
        }
    }    
}