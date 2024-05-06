/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.quintocrud;

import java.util.List;

/**
 *
 * @author emi
 */
public interface CrudRepository<T> {
    List<T> getAll();
    List<T> getByCourse(String curso, String paralelo);
    boolean create(T entity);
    boolean update(T entity);
    boolean delete(String id);
    
    
}
