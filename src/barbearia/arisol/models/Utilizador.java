/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.models;

import java.util.Date;

/**
 *
 * @author António Apolo
 */
public class Utilizador {
    
    private int id;
    private String nome;
    private String telefone;
    private String password;
    private String username;
    private String identidade;
    private Date dataNascimento;
    private String type;
    private Date createdAt;
    private boolean activo;
    private boolean deleted;

    public Utilizador() {}

    public Utilizador(String nome, String telefone, String password, String username, String identidade, Date dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.password = password;
        this.username = username;
        this.identidade = identidade;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Utilizador setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Utilizador setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Utilizador setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Utilizador setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getIdentidade() {
        return identidade;
    }

    public Utilizador setIdentidade(String identidade) {
        this.identidade = identidade;
        return this;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Utilizador setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getType() {
        return type;
    }

    public Utilizador setType(String type) {
        this.type = type;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Utilizador setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public boolean isActivo() {
        return activo;
    }

    public Utilizador setActivo(boolean activo) {
        this.activo = activo;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Utilizador setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public int getId() {
        return id;
    }

    public Utilizador setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
}
