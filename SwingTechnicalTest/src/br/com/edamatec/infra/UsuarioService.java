package br.com.edamatec.infra;

public class UsuarioService {

    public boolean isValidCPF(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    public boolean isValidEmail(String email) {
        return email.matches(".+@.+\\..{3,}");
    }

    public boolean isValidTelefone(String telefone) {
        return telefone.matches("\\d{10}|\\d{11}");
    }

    public boolean isValidNome(String nome) {
        return !nome.trim().isEmpty();
    }

}
