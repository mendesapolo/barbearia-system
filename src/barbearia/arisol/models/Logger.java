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
public class Logger {
    
    private int id;
    private int userId;
    private String nome;
    private Date createdAt;
    private boolean active;

    public Logger() {}

    public Logger(int userId, String nome, Date createdAt, boolean isActive) {
        this.userId = userId;
        this.nome = nome;
        this.createdAt = createdAt;
        this.active = isActive;
    }

    public int getId() {
        return id;
    }

    public Logger setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Logger setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Logger setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Logger setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Logger setActive(boolean active) {
        this.active = active;
        return this;
    }
    
}
