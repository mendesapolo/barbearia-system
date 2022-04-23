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
public class Cliente {
    
    private int id;
    private String nome;
    private String telefone;
    private String identidade;
    private boolean activo;
    private Utilizador user;
    private Date createdAt;
    private boolean deleted;

    public Cliente() {}

    public Cliente(String nome, String telefone, String identidade, boolean isActivo) {
        this.nome = nome;
        this.telefone = telefone;
        this.identidade = identidade;
        this.activo = isActivo;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getIdentidade() {
        return identidade;
    }

    public Cliente setIdentidade(String identidade) {
        this.identidade = identidade;
        return this;
    }

    public boolean isActivo() {
        return activo;
    }

    public Cliente setActivo(boolean isActivo) {
        this.activo = isActivo;
        return this;
    }

    public Utilizador getUser() {
        return user;
    }

    public Cliente setUser(Utilizador user) {
        this.user = user;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Cliente setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Cliente setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public int getId() {
        return id;
    }

    public Cliente setId(int id) {
        this.id = id;
        return this;
    }
    
}
