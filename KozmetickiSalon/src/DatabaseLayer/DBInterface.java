/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import java.util.List;

/**
 *
 * @author milic
 */
public interface DBInterface<T> {
    public List<T> getAll();
    public List<T> getAll(String condition);
    public boolean add(T t);
    // update
    public boolean edit(T t);
    public boolean delete(T t);
    public T getById(int id);
}
