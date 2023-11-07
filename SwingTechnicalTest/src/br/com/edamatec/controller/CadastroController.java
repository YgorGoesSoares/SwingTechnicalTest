package br.com.edamatec.controller;

import br.com.edamatec.dao.UsuarioDAO;
import br.com.edamatec.infra.UsuarioService;
import br.com.edamatec.model.Usuario;
import br.com.edamatec.view.ViewCadastro;
import br.com.edamatec.view.ViewLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroController {


    private ViewCadastro viewCadastro;

    public ActionListener getCadastrarListener() {
        return cadastrarListener;
    }

    public void setCadastrarListener(ActionListener cadastrarListener) {
        this.cadastrarListener = cadastrarListener;
    }

    public ActionListener getInicioListener() {
        return inicioListener;
    }

    public void setInicioListener(ActionListener inicioListener) {
        this.inicioListener = inicioListener;
    }

    private ActionListener cadastrarListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleCadastroBotao();
        }
    };

    private ActionListener inicioListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleInicioBotao();
        }
    };
    public CadastroController(ViewCadastro viewCadastro) {
        this.viewCadastro = viewCadastro;
    }



    public void handleInicioBotao() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(viewCadastro.getPanel1());
        frame.dispose();

        ViewLogin viewLogin = new ViewLogin();
        JFrame loginFrame = new JFrame("Página de Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.getContentPane().add(viewLogin.panel);
        loginFrame.pack();

        loginFrame.setVisible(true);
    }

    public void handleCadastroBotao() {
        viewCadastro.getCadastrarButton().setEnabled(false);
        String nome = viewCadastro.getNomeField().getText();
        String telefone = viewCadastro.getTelefoneField().getText();
        String email = viewCadastro.getEmailField().getText();
        String cpf = viewCadastro.getCpfField().getText();

        Usuario usuario = new Usuario(telefone, email, cpf, nome);

        UsuarioService usuarioService = new UsuarioService();
        UsuarioDAO usuarioDAO = new UsuarioDAO(usuarioService);

        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(viewCadastro.getPanel1(), "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            viewCadastro.getCadastrarButton().setEnabled(true);

            return;
        }

        if (!viewCadastro.getAceitoOsTermosDeCheckBox().isSelected()) {
            JOptionPane.showMessageDialog(viewCadastro.getPanel1(), "Você deve aceitar os termos de uso para se registrar.", "Erro", JOptionPane.ERROR_MESSAGE);
            viewCadastro.getCadastrarButton().setEnabled(true);

            return;
        }

        try {
            usuarioDAO.save(usuario);
            JOptionPane.showMessageDialog(viewCadastro.getPanel1(), "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(viewCadastro.getPanel1(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            viewCadastro.getCadastrarButton().setEnabled(true);

        }
    }


}
