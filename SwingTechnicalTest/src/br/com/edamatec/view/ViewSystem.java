package br.com.edamatec.view;

import br.com.edamatec.controller.SystemController;
import br.com.edamatec.model.Usuario;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewSystem {
    public JPanel panel;
    private JButton editarButton;
    private JButton excluirContaButton;
    private JTextField emailField;
    private JTextField telefoneField;
    private JLabel idField;
    private JLabel emailFieldX;
    private JLabel telefoneFieldX;
    private JLabel cpfFieldX;
    private JButton button1;

    private final SystemController systemController = new SystemController(this);

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getEditarButton() {
        return editarButton;
    }

    public void setEditarButton(JButton editarButton) {
        this.editarButton = editarButton;
    }

    public JButton getExcluirContaButton() {
        return excluirContaButton;
    }

    public void setExcluirContaButton(JButton excluirContaButton) {
        this.excluirContaButton = excluirContaButton;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getTelefoneField() {
        return telefoneField;
    }

    public void setTelefoneField(JTextField telefoneField) {
        this.telefoneField = telefoneField;
    }

    public JLabel getIdField() {
        return idField;
    }

    public void setIdField(JLabel idField) {
        this.idField = idField;
    }

    public JLabel getEmailFieldX() {
        return emailFieldX;
    }

    public void setEmailFieldX(JLabel emailFieldX) {
        this.emailFieldX = emailFieldX;
    }

    public JLabel getTelefoneFieldX() {
        return telefoneFieldX;
    }

    public void setTelefoneFieldX(JLabel telefoneFieldX) {
        this.telefoneFieldX = telefoneFieldX;
    }

    public JLabel getCpfFieldX() {
        return cpfFieldX;
    }

    public void setCpfFieldX(JLabel cpfFieldX) {
        this.cpfFieldX = cpfFieldX;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public ViewSystem(Usuario usuario) {
        idField.setText(String.valueOf(usuario.getNome()));
        emailFieldX.setText(usuario.getEmail());
        telefoneFieldX.setText(usuario.getTelefone());
        cpfFieldX.setText(usuario.getCpf());

        telefoneField.addKeyListener(new KeyListener() {
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
                if (telefoneField.getText().length() > 11) {
                    String text = telefoneField.getText().substring(0, 11);
                    telefoneField.setText(text);
                }
            }
        });

        editarButton.addActionListener(systemController);
        excluirContaButton.addActionListener(systemController);
        button1.addActionListener(systemController);
    }

    }
