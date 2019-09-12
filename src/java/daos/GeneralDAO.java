/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IGeneralDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author arman
 */
public class GeneralDAO<T> implements IGeneralDAO<T> {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private T table;

    public GeneralDAO(SessionFactory factory, Class<T> table) {
        try {
            this.factory = factory;
            this.table = table.newInstance();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        List<T> t = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM " + table.getClass().getSimpleName());
            t = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return t;
    }

    @Override
    public T getById(Object id) {
        T t = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            
            Query query = session.createQuery("FROM " + table.getClass().getSimpleName() + " WHERE id = :id");
            query.setParameter("id", id);
            t = (T) query.uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return t;
    }

    @Override
    public boolean saveOrDelete(T t, boolean isSave) {
        boolean result = true;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            
            if (isSave) { //update
                session.saveOrUpdate(t);
            } else { //delete
                session.delete(t);
            }
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

}
