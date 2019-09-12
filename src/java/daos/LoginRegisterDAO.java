/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILoginRegisterDAO;
import models.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author asus
 */
public class LoginRegisterDAO implements ILoginRegisterDAO{
    
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private Query query;
    
    public LoginRegisterDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Account getByEmail(String email) {
        Account account = new Account();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            query = session.createQuery("FROM Account WHERE employee.email=:email");
            query.setParameter("email", email);
            account = (Account) query.uniqueResult();
        } catch (Exception e) {
            e.getStackTrace();
            if (transaction !=null) {
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return account;
    }
    
}
