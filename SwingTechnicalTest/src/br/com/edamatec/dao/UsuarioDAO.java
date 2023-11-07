package br.com.edamatec.dao;

import br.com.edamatec.factory.ConnectionFactory;
import br.com.edamatec.infra.UsuarioService;
import br.com.edamatec.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UsuarioDAO {

    private UsuarioService usuarioService;

    public UsuarioDAO() {

    }

    public UsuarioDAO(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void save(Usuario usuario) {
        if (!usuarioService.isValidCPF(usuario.getCpf())) {
            throw new IllegalArgumentException("CPF inválido.");
        }

        if (!usuarioService.isValidEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (!usuarioService.isValidTelefone(usuario.getTelefone())) {
            throw new IllegalArgumentException("Telefone inválido. Digite somente números!");
        }

        if (!usuarioService.isValidNome(usuario.getNome())) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }

        String sql = "INSERT INTO usuarios(nome, telefone, email, cpf) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.criandoConexao();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getTelefone());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getCpf());

            pstm.execute();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro com o banco de dados! Lamentamos o transtorno. Contate o administrador do sistema.");
        }
    }

    public Usuario login(String email, String cpf) {
        String sql = "SELECT * FROM usuarios WHERE cpf = ? AND email = ?";

    try (Connection conn = ConnectionFactory.criandoConexao();
         PreparedStatement pstm = conn.prepareStatement(sql)) {
        pstm.setString(1, cpf);
        pstm.setString(2, email);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String telefone = resultSet.getString("telefone");
            return new Usuario(telefone, email, cpf, nome);

        } else {
            return null;
        }
    } catch (SQLException | ClassNotFoundException ex) {
        throw new RuntimeException("Erro com o banco de dados! Lamentamos o transtorno. Contate o administrador!");
    }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM usuarios WHERE nome = ?";

        try (Connection conn = ConnectionFactory.criandoConexao();
        PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, nome);
            pstm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro com o banco de dados! Contate o administrador.");
        }
    }

    public void editarEmail(String email, String nome) {
        String sql = "UPDATE usuarios SET email = ? WHERE nome = ?";

        if (!usuarioService.isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        try (Connection conn = ConnectionFactory.criandoConexao();
        PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, email);
            pstm.setString(2, nome);
            pstm.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro com o banco de dados! Contate o administrador.");
        }
    }

    public void editarTelefone(String telefone, String nome) {
        String sql = "UPDATE usuarios SET telefone = ? WHERE nome = ?";
        try (Connection conn = ConnectionFactory.criandoConexao();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, telefone);
            pstm.setString(2, nome);
            pstm.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro com o banco de dados! Contate o administrador.");
        }
    }

}
