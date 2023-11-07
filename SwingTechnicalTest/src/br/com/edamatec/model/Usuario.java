package br.com.edamatec.model;

public class Usuario {
    private String telefone;
    private String email;
    private String cpf;
    private String nome;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario(String telefone, String email, String cpf, String nome) {
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
    }
}
