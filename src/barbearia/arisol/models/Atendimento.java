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
public class Atendimento {
    
    private int id;
    private Date data;
    private double valor;
    private boolean agenda;
    private Utilizador user;
    private Corte corte;
    private Cliente cliente;
    private Agendamento agendamento;
    private Date createdAt;
    private boolean deleted;

    public Atendimento() {}

    public Atendimento(Date data, double valor, Utilizador user, Corte corte, Cliente cliente) {
        this.data = data;
        this.valor = valor;
        this.user = user;
        this.corte = corte;
        this.cliente = cliente;
        
        this.agenda = false;
        this.agendamento = null;
    }

    public Date getData() {
        return data;
    }

    public Atendimento setData(Date data) {
        this.data = data;
        return this;
    }

    public double getValor() {
        return valor;
    }

    public Atendimento setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public boolean isAgenda() {
        return agenda;
    }

    public Atendimento setAgenda(boolean isAgenda) {
        this.agenda = isAgenda;
        return this;
    }

    public Utilizador getUser() {
        return user;
    }

    public Atendimento setUser(Utilizador user) {
        this.user = user;
        return this;
    }

    public Corte getCorte() {
        return corte;
    }

    public Atendimento setCorte(Corte corte) {
        this.corte = corte;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Atendimento setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public Atendimento setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Atendimento setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Atendimento setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public int getId() {
        return id;
    }

    public Atendimento setId(int id) {
        this.id = id;
        return this;
    }
    
}
