import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Ventana extends JFrame {
    int width;
    int height;
    int ISKGenerado = 0;
    public Ventana(int ISKGenerado){
        this.ISKGenerado = ISKGenerado;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int)size.getWidth();
        height = (int)size.getHeight();
        this.setSize(540,300);
        setLocationRelativeTo(null);
        //setBounds(width/5,height/5,(int)(width/1.5),(int)(height/1.5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculador impuestos");
        iniciarComponentes();
    }

    private void iniciarComponentes (){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(231, 231, 231));
        this.getContentPane().add(panel);

        JLabel ISKGENERADO = new JLabel();
        ISKGENERADO.setOpaque(true);
        //etiqueta.setForeground(Color.BLUE);
        ISKGENERADO.setBackground(Color.CYAN);
        String valorAMostrar = (NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format(ISKGenerado));
        valorAMostrar = valorAMostrar.substring(1, valorAMostrar.length()-3);
        System.out.println(valorAMostrar);
        ISKGENERADO.setText("Has generado: " + valorAMostrar + " ISK");
        ISKGENERADO.setBounds(10,10,500,100);
        ISKGENERADO.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        panel.add(ISKGENERADO);

        JLabel IMPUESTO = new JLabel();
        IMPUESTO.setOpaque(true);
        //etiqueta.setForeground(Color.BLUE);
        IMPUESTO.setBackground(Color.CYAN);

        String valorAMostrar2 = (NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format((int)(ISKGenerado*0.05)));
        valorAMostrar2 = valorAMostrar2.substring(1, valorAMostrar2.length()-3);

        IMPUESTO.setText("Debes pagar : " + valorAMostrar2 + " ISK (5%)");
        System.out.println(IMPUESTO.getWidth());
        IMPUESTO.setBounds(10,150,500,100);
        IMPUESTO.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        panel.add(IMPUESTO);




    }
}

