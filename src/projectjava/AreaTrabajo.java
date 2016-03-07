package spev;

import model.Ciclo;
import controller.Controlador;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.event.ChangeEvent;
import model.Carnot;
import model.DB;
import model.RankineIdealRecalentamiento;
import model.RankineIdealSimple;
import model.RankineReal;
import model.RankineRegenerativo;

public class AreaTrabajo extends JTabbedPane
{
    private static volatile AreaTrabajo instance = null;
    Controlador controlador;
    Cursor pt;
    
    public final int MAX_CICLOS = 10;
    
    public final Ciclo[] ciclos;
    public int cicloActual;
    public int nCiclos;
    
    DB datos;
    
    AreaTrabajo (Controlador controlador)
    {
        super();
        setName("AT");
        
        this.controlador = controlador;
        addMouseListener(controlador);
        addMouseMotionListener(controlador);
        changeListener();
        
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        setTabPlacement(JTabbedPane.TOP);
        
        cicloActual = -1;
        ciclos = new Ciclo[10];
        nCiclos = 0;
        
        datos = DB.getInstance();
        instance = this;
    }
         
    public Ciclo nuevoCiclo(String tipo, String nombre) {
        Ciclo n = getNuevoCiclo(tipo);
        n.setNombre(nombre);
        n.setBackground(Colores.area_trabajo);
        n.setName("PA");
        
        cicloActual++;
        ciclos[nCiclos] = n;
        nCiclos++;
        if (cicloActual == 0 ){
            controlador.toggleComponents();
        }
        
        addTab(cicloActual+". "+n.getNombre(), n);
        setTabComponentAt(cicloActual, new ButtonTabComponent(this));
        setSelectedIndex(cicloActual); 
        
        controlador.insertLog("Nuevo ciclo.");
        return n;
    }
    
    public void eliminarCiclo (int i) {
        removeTabAt(i);
        nCiclos--;
        
        if (nCiclos > -1) {
            for (int j = i; j < MAX_CICLOS ; j++) {
                if (j < nCiclos) {
                    ciclos[j] = ciclos[j+1];
                    setTitleAt(j, cicloActual+". "+ciclos[j].getNombre());
                }
                else ciclos[j] = null;
            }
            cicloActual = getSelectedIndex();
            setSelectedIndex(cicloActual);
        }
        controlador.insertLog("Eliminando ciclo.");        
    }
    
    public void cerrarTodo () {
        for (int i=cicloActual; i>-1; i--)
            eliminarCiclo(i);
    }
    
    public Ciclo getCicloActual () {
        if (cicloActual>-1) {
            return ciclos[cicloActual];
        }
        else return null;
    }
    public int getNumCiclos () { return nCiclos; }
    
    private Ciclo getNuevoCiclo (String tipo) {
        switch (tipo) {
            case "Carnot": return new Carnot();
            case "Rankine Ideal Simple": return new RankineIdealSimple();
            case "Rankine Ideal con Recalentamiento": return new RankineIdealRecalentamiento();
            case "Rankine Real": return new RankineReal();
            case "Rankine Regenerativo": return new RankineRegenerativo();
            default: System.out.println("Ciclo no especificado");
                return null;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            Image fondo;
            fondo = controlador.crearImagen("/images/inicio.png", "Fondo Inicial").getImage();
            int x, y, w, h;
            w = fondo.getWidth(null);
            h = fondo.getHeight(null);
            x = (this.getWidth()/2)-(w/2);
            y = (this.getHeight()/2)-(h/2);
            g.drawImage(fondo, x, y, w, h, this);
            
    }
    
    public final void changeListener() {
        addChangeListener((ChangeEvent changeEvent1) ->
        {
            cicloActual = getSelectedIndex();
            
            if (cicloActual > -1) {
                Ciclo c = getCicloActual();
                controlador.setEstado(c.getTipo() + " - " + c.getNombre() + " - " + c.getEstado());
                controlador.setHistorial(c.getLog().toString());
                controlador.setEstadoValores("h2 (MPa): "+c.getEntrada("h2"));
                controlador.insertLog("Cambio de panel de ciclo.");
            }
            else
                controlador.toggleComponents();
        });
    }
    
    public Ciclo getCiclo(int i) {
        Ciclo c = null;

        if (  getNumCiclos() > 0 && cicloActual != -1 &&
              i < getNumCiclos()-1 && i > -1 )
            c = ciclos[i];
        return c;
    }
    
    public Ciclo[] getCiclos () {
        return ciclos;
    }
    
    public void actualizar() {
        //repaint();
        int i=0;
        for (Ciclo c : ciclos) {
            this.setTitleAt(i, (++i)+". "+c.getName());
            //c.repaint();
        }
    }

    public static synchronized AreaTrabajo getInstance() {
        if (instance == null) instance = new AreaTrabajo(Controlador.getInstance());
        return instance;
    }
}

    