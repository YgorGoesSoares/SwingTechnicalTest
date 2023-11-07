package br.com.edamatec.controller;

import br.com.edamatec.dao.UsuarioDAO;
import br.com.edamatec.infra.UsuarioService;
import br.com.edamatec.model.Usuario;
import br.com.edamatec.view.ViewCadastro;
import br.com.edamatec.view.ViewLogin;
import br.com.edamatec.view.ViewSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private ViewLogin viewLogin;

    public LoginController(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewLogin.getEntrarButton()) {
                handleEntrarButton();
        } else if (e.getSource() == viewLogin.getRegistreSeButton()) {
                handleRegistreButton();
            }

    }

        private void handleRegistreButton() {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(viewLogin.getPanel());
            frame.dispose();

            JFrame cadastroFrame = new JFrame("Cadastro de Usuário");
            ViewCadastro viewCadastro = new ViewCadastro();
            cadastroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cadastroFrame.getContentPane().add(viewCadastro.getPanel1());
            cadastroFrame.pack();
            cadastroFrame.setVisible(true);

        }

        private void handleEntrarButton() {
            String cpf = viewLogin.getCpfField().getText();
            String email = viewLogin.getEmailField().getText();

            UsuarioService usuarioService = new UsuarioService();
            UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioService);

            Usuario usuario = usuarioDAO.login(email, cpf);

            if (usuario != null) {
                JOptionPane.showMessageDialog(viewLogin.getPanel(), "Login realizado com sucesso!");

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(viewLogin.getPanel());
                frame.dispose();

                JFrame systemFrame = new JFrame("Sistema");
                ViewSystem viewSystem = new ViewSystem(usuario);
                systemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                systemFrame.getContentPane().add(viewSystem.panel);
                systemFrame.pack();
                systemFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(viewLogin.getPanel(), "Credenciais inválidas. Verifique os dados e tente novamente.");
            }

        }
        }