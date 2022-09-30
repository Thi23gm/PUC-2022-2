import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class screen extends JFrame implements ActionListener {
    JTextField text, text2, text3;
    JFrame jframe = new JFrame();
    // contagem cnt;
    JTextField limite_superior;
    JTextField limite_inferior;
    JLabel jlabel3;
    JTextField conta;
    JLabel jlabel5;

    public screen() {
        this.setSize(680, 250);
        this.setTitle("Cálculo de Integrais");
        this.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        // this.getContentPane().setBackground(new Color(54, 54, 54));
        this.setResizable(false);
        ImageIcon integral_img = new ImageIcon("integral2.png");
        ///////////////
        jlabel5 = new JLabel("Resposta = ");

        jlabel5.setBackground(Color.red);
        jlabel5.setBounds(55, 150, 300, 30);
        jlabel5.setFont(new Font("Arial", Font.BOLD, 20));

        ///////////////
        jlabel3 = new JLabel();
        integral_img.setImage(integral_img.getImage().getScaledInstance(50, 50, 1));
        jlabel3.setIcon(integral_img);
        jlabel3.setForeground(Color.black);
        jlabel3.setBounds(30, 55, 370, 50);
        jlabel3.setFont(new Font("Arial", Font.BOLD, 20));
        ////////////////////////////////
        limite_superior = new JTextField();
        limite_superior.setBounds(75, 25, 30, 30);
        ////////////////////////////////
        limite_inferior = new JTextField();
        limite_inferior.setBounds(75, 105, 30, 30);
        /////////////////////////////////

        conta = new JTextField();
        conta.setBounds(90, 65, 300, 30);
        ////////////////////////////////
        JButton jbutton = new JButton();

        jbutton.setBounds(420, 50, 200, 60);
        jbutton.setText("Calcule");
        jbutton.setFont(new Font("Arial", Font.BOLD, 25));
        jbutton.addActionListener(this);
        ///////////////////////////////

        this.add(jlabel5);
        this.add(jbutton);
        this.add(conta);
        this.add(limite_superior);
        this.add(jlabel3);
        this.add(limite_inferior);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculo calc = new calculo(conta.getText(), limite_inferior.getText(), limite_superior.getText());
        jlabel5.setText("Resposta = " + String.valueOf(calc.getSomatorio()));

        this.setVisible(false);

        this.setVisible(true);
        System.out.println("Teste");

    }
}
