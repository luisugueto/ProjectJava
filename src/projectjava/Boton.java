package projectjava;

import javax.swing.JButton;

public class Boton extends JButton
{
    private String BEText;
    
    public Boton (String s)
    {
        super(s);
    }
    public Boton ()
    {
        super();
    }
    public void setBEText (String s) { BEText = s; }
    public String getBEText () {return BEText;}
}
