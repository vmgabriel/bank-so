package Vista;

import Controlador.EveIndex;
import Modelo.Fila;
import javax.swing.*;

public class Index extends JFrame{
    
    private JButton btnañadirgen,btnañadirdin,btnañadirtar,btniniciar;
    
    private JButton btnsacargen,btnsacardin,btnsacartar,btnsiguiente;
    
    private JList listgeneral, listdinner,listtarje;
    
    private JScrollPane jspgeneral,jspdinner,jsptarje;
    
    private JLabel lbltitulo,lblcliente;
    
    private JLabel lblfila1,lblfila2,lblfila3;
    
    private Fila fila1,fila2,fila3;

    public Index() {
        super("Simulacion Bancaria");
        setLayout(null);
        
        this.setBounds(0, 0, 800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        lbltitulo=new JLabel("Cajero");
        lbltitulo.setBounds(370,10,150,30);
        add(lbltitulo);
        
        lblcliente=new JLabel("Cliente");
        lblcliente.setBounds(370, 40, 150, 30);
        add(lblcliente);
        
        btnsiguiente=new JButton("Siguiente");
        btnsiguiente.setBounds(600, 40, 130, 100);
        add(btnsiguiente);
        
        fila1=new Fila(10000);
        for (int i=0;i<10;i++){
            fila1.insertar(i);
        }
        
        lblfila1=new JLabel("Fila General");
        lblfila1.setBounds(70,200,150,15);
        add(lblfila1);
        
        listgeneral=new JList();
        jspgeneral=new JScrollPane();
        listgeneral.setModel(new AbstractListModel() {
            
            String[] strings=fila1.MostrarTodos();

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int index) {
                return strings[index];
            }
        });
        jspgeneral.setViewportView(listgeneral);
        jspgeneral.setBounds(10, 220, 200, 200);
        add(jspgeneral);
        
        btnañadirgen=new JButton("Añadir");
        btnañadirgen.setBounds(10, 440, 200, 40);
        add(btnañadirgen);
        
        btnsacargen=new JButton("Sacar");
        btnsacargen.setBounds(10, 500, 200, 40);
        add(btnsacargen);
        
        fila2=new Fila(5000);
        for (int i=0;i<8;i++){
            fila2.insertar(i);
        }
        
        lblfila2=new JLabel("Fila Tarjeta");
        lblfila2.setBounds(330,200,150,15);
        add(lblfila2);
        
        listtarje=new JList();
        jsptarje=new JScrollPane();
        listtarje.setModel(new AbstractListModel() {
            
            String[] strings=fila2.MostrarTodos();

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int index) {
                return strings[index];
            }
        });
        jsptarje.setViewportView(listtarje);
        jsptarje.setBounds(280, 220, 200, 200);
        add(jsptarje);
        
        btnañadirtar=new JButton("Añadir");
        btnañadirtar.setBounds(280, 440, 200, 40);
        add(btnañadirtar);
        
        btnsacartar=new JButton("Sacar");
        btnsacartar.setBounds(280, 500, 200, 40);
        add(btnsacartar);
        
        fila3  = new Fila(1000);
        for (int i=0;i<4;i++){
            fila3.insertar(i);
        }
        
        lblfila3=new JLabel("Fila Dinners Club");
        lblfila3.setBounds(620,200,150,15);
        add(lblfila3);
        
        listdinner=new JList();
        jspdinner=new JScrollPane();
        listdinner.setModel(new AbstractListModel() {
            
            String[] strings=fila3.MostrarTodos();

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int index) {
                return strings[index];
            }
        });
        jspdinner.setViewportView(listdinner);
        jspdinner.setBounds(580, 220, 200, 200);
        add(jspdinner);
        
        btnañadirdin=new JButton("Añadir");
        btnañadirdin.setBounds(580, 440, 200, 40);
        add(btnañadirdin);
        
        btnsacardin=new JButton("Sacar");
        btnsacardin.setBounds(580, 500, 200, 40);
        add(btnsacardin);
        
        this.repaint();
        
        EveIndex inde=new EveIndex(this);
    }

    public JButton getBtnañadirgen() {
        return btnañadirgen;
    }

    public JButton getBtnañadirdin() {
        return btnañadirdin;
    }

    public JButton getBtnañadirtar() {
        return btnañadirtar;
    }

    public JButton getBtniniciar() {
        return btniniciar;
    }

    public JButton getBtnsacargen() {
        return btnsacargen;
    }

    public JButton getBtnsacardin() {
        return btnsacardin;
    }

    public JButton getBtnsacartar() {
        return btnsacartar;
    }

    public JButton getBtnsiguiente() {
        return btnsiguiente;
    }

    public Fila getFila1() {
        return fila1;
    }

    public Fila getFila2() {
        return fila2;
    }

    public Fila getFila3() {
        return fila3;
    }

    public JList getListgeneral() {
        return listgeneral;
    }

    public JList getListdinner() {
        return listdinner;
    }

    public JList getListtarje() {
        return listtarje;
    }

    public JLabel getLblcliente() {
        return lblcliente;
    }
}