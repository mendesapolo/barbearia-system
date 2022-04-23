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
public class Sistema {
    
    private int id;
    private String estabelecimento;
    private int taxaAgendamento;
    private boolean active;
    private Date createdAt;

    public Sistema() {}

    public Sistema(String estabelecimento, int taxaAgendamento) {
        this.estabelecimento = estabelecimento;
        this.taxaAgendamento = taxaAgendamento;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public Sistema setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
        return this;
    }

    public int getTaxaAgendamento() {
        return taxaAgendamento;
    }

    public Sistema setTaxaAgendamento(int taxaAgendamento) {
        this.taxaAgendamento = taxaAgendamento;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Sistema setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Sistema setActive(boolean activo) {
        this.active = activo;
        return this;
    }

    public int getId() {
        return id;
    }

    public Sistema setId(int id) {
        this.id = id;
        return this;
    }
    
}
