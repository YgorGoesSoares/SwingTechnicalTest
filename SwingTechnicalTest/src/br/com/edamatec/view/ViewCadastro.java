package br.com.edamatec.view;
import br.com.edamatec.controller.CadastroController;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewCadastro  {
    private JPanel panel1;
    private JTextField telefoneField;
    private JTextField emailField;
    private JTextField cpfField;
    private JTextField nomeField;
    private JCheckBox aceitoOsTermosDeCheckBox;
    private JButton cadastrarButton;
    private JButton inicioButton;

    private final CadastroController cadastroController = new CadastroController(this);



    public ViewCadastro() {


        cadastrarButton.addActionListener(cadastroController.getCadastrarListener());
        inicioButton.addActionListener(cadastroController.getInicioListener());


       cpfField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String cpf = cpfField.getText().replaceAll("[^0-9]", "");

                if (cpf.length() > 11) {
                    cpf = cpf.substring(0, 11);
                }

                if (cpf.length() >= 3) {
                    cpf = cpf.substring(0, 3) + "." + cpf.substring(3);
                }
                if (cpf.length() >= 7) {
                    cpf = cpf.substring(0, 7) + "." + cpf.substring(7);
                }
                if (cpf.length() >= 11) {
                    cpf = cpf.substring(0, 11) + "-" + cpf.substring(11);
                }

                cpfField.setText(cpf);
            }

        });

        telefoneField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (telefoneField.getText().length() > 11) {
                    String text = telefoneField.getText().substring(0, 11);
                    telefoneField.setText(text);
            }}
        });
    }



    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getTelefoneField() {
        return telefoneField;
    }

    public void setTelefoneField(JTextField telefoneField) {
        this.telefoneField = telefoneField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public void setCpfField(JTextField cpfField) {
        this.cpfField = cpfField;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public void setNomeField(JTextField nomeField) {
        this.nomeField = nomeField;
    }

    public JCheckBox getAceitoOsTermosDeCheckBox() {
        return aceitoOsTermosDeCheckBox;
    }

    public void setAceitoOsTermosDeCheckBox(JCheckBox aceitoOsTermosDeCheckBox) {
        this.aceitoOsTermosDeCheckBox = aceitoOsTermosDeCheckBox;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public void setCadastrarButton(JButton cadastrarButton) {
        this.cadastrarButton = cadastrarButton;
    }

    public JButton getInicioButton() {
        return inicioButton;
    }

    public void setInicioButton(JButton inícioButton) {
        this.inicioButton = inícioButton;
    }
}
