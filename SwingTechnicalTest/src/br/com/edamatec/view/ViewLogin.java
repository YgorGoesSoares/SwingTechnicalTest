package br.com.edamatec.view;

import br.com.edamatec.controller.LoginController;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewLogin {

    private final LoginController loginController = new LoginController(this);

    public JPanel panel;
    private JTextField emailField;
    private JTextField cpfField;
    private JButton entrarButton;
    private JButton registreSeButton;
    private JLabel emailLabel;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
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

    public JButton getEntrarButton() {
        return entrarButton;
    }

    public void setEntrarButton(JButton entrarButton) {
        this.entrarButton = entrarButton;
    }

    public JButton getRegistreSeButton() {
        return registreSeButton;
    }

    public void setRegistreSeButton(JButton registreSeButton) {
        this.registreSeButton = registreSeButton;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JLabel getCpfLabel() {
        return cpfLabel;
    }

    public void setCpfLabel(JLabel cpfLabel) {
        this.cpfLabel = cpfLabel;
    }

    private JLabel cpfLabel;

        public ViewLogin() {
            registreSeButton.addActionListener(loginController);
            entrarButton.addActionListener(loginController);


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

        }



    }
