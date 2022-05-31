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
public class Agendamento {
    
    private int id;
    private Date data;
    private double valor;
    private boolean cancelado;
    private Cliente cliente;
    private Corte corte;
    private Date createdAt;
    private boolean atendido;
    private boolean deleted;

    public Agendamento() {}

    public Agendamento(Date data, double valor, Cliente cliente, Corte corte) {
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.corte = corte;
        this.cancelado = false;
    }

    public Date getData() {
        return data;
    }

    public Agendamento setData(Date data) {
        this.data = data;
        return this;
    }

    public double getValor() {
        return valor;
    }

    public Agendamento setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public Agendamento setCancelado(boolean isCancelado) {
        this.cancelado = isCancelado;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Agendamento setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Corte getCorte() {
        return corte;
    }

    public Agendamento setCorte(Corte corte) {
        this.corte = corte;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Agendamento setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public Agendamento setAtendido(boolean atendido) {
        this.atendido = atendido;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Agendamento setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public int getId() {
        return id;
    }

    public Agendamento setId(int id) {
        this.id = id;
        return this;
    }
    
}
