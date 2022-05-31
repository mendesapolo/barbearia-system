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
public class Corte {
    
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private Categoria categoria;
    private Utilizador user;
    private Date createdAt;
    private boolean deleted;

    public Corte() {}

    public Corte(String nome, String descricao, double preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public Corte setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Corte setDescrcao(String descrcao) {
        this.descricao = descrcao;
        return this;
    }

    public double getPreco() {
        return preco;
    }

    public Corte setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Corte setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public Utilizador getUser() {
        return user;
    }

    public Corte setUser(Utilizador user) {
        this.user = user;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Corte setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Corte setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public int getId() {
        return id;
    }

    public Corte setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
}
