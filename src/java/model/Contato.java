package model;

import java.util.Calendar;

/**
 * @brief Classe Contato
 * @author Paulo Henrique
 * @date   criado em: 01/09/2023
 */
public class Contato {
    
    private int id;
    private String nome;
    private String endereco;
    private String email;
    private Calendar dataNascimento;

    public Contato(int id, String nome, String endereco, String email, Calendar dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    
    public Contato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
