/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;

/**
 *
 * @author arman
 */
public interface IGeneralDAO<T> {
    public List<T> getAll();
    public T getById(Object id);
    public boolean saveOrDelete(T t, boolean isSave);
}
