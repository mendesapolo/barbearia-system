/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barbearia.arisol.interfaces;

import java.util.List;

/**
 *
 * @author António Apolo
 * @param <Type>
 */
public interface IDao<Type> {
    
    public void create(Type obj);
    public void update(Type obj);
    public boolean delete(Type obj);
    public List<Type> findAll();
    public Type findById(int id);
    
}
