package br.com.edamatec.controller;

import br.com.edamatec.dao.UsuarioDAO;
import br.com.edamatec.infra.UsuarioService;
import br.com.edamatec.view.ViewLogin;
import br.com.edamatec.view.ViewSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemController implements ActionListener {

    private ViewSystem viewSystem;

    public SystemController(ViewSystem viewSystem) {
        this.viewSystem = viewSystem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewSystem.getEditarButton()) {
            handleEditarButton();
        } else if (e.getSource() == viewSystem.getButton1()) {
            handleVoltarButton();
        } else if (e.getSource() == viewSystem.getExcluirContaButton()) {
            handleExcluirButton();
        }
    }

    private void handleEditarButton() {
        String email = viewSystem.getEmailField().getText();
        String telefone = viewSystem.getTelefoneField().getText();
        String nome = viewSystem.getIdField().getText();

        UsuarioService usuarioService = new UsuarioService();

        UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioService);

        if (!email.isEmpty() || !telefone.isEmpty()) {
            int escolha = JOptionPane.showConfirmDialog(viewSystem.getPanel(), "Tem certeza que deseja editar os dados?", "Confirmação de Edição", JOptionPane.YES_NO_OPTION);

            if (escolha == JOptionPane.YES_OPTION) {
                if (!email.isEmpty()) {

                    try {

                        usuarioDAO.editarEmail(email, nome);
                        viewSystem.getEmailFieldX().setText(viewSystem.getEmailField().getText());
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(viewSystem.panel, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }

                if (!telefone.isEmpty()) {
                    if (telefone.length() == 10 || telefone.length() == 11) {
                        usuarioDAO.editarTelefone(telefone, nome);
                        viewSystem.getTelefoneFieldX().setText(viewSystem.getTelefoneField().getText());
                    } else {
                        JOptionPane.showMessageDialog(viewSystem.getPanel(), "Telefone inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                    JOptionPane.showMessageDialog(viewSystem.getPanel(), "Edição finalizada!");
                    viewSystem.getEmailField().setText("");
                    viewSystem.getTelefoneField().setText("");


                }
            }
        }
    }

    private boolean isValidEmail(String email) {
        if (email.contains("@")) {
            return true;
        } else {
            return false;
        }
    }

    private void handleExcluirButton() {
        int escolha = JOptionPane.showConfirmDialog(viewSystem.getPanel(), "Tem certeza que deseja excluir sua conta?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
        if (escolha == JOptionPane.YES_OPTION) {

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.excluir(viewSystem.getIdField().getText());

            JOptionPane.showMessageDialog(viewSystem.getPanel(), "Conta excluída com sucesso!");

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(viewSystem.getPanel());
            frame.dispose();

            ViewLogin viewLogin = new ViewLogin();
            JFrame loginFrame = new JFrame("Página de Login");
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.getContentPane().add(viewLogin.panel);
            loginFrame.pack();
            loginFrame.setVisible(true);

        }
    }

    private void handleVoltarButton() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(viewSystem.getPanel());
        frame.dispose();

        ViewLogin viewLogin = new ViewLogin();
        JFrame loginFrame = new JFrame("Página de Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.getContentPane().add(viewLogin.panel);
        loginFrame.pack();

        loginFrame.setVisible(true);

    }

}