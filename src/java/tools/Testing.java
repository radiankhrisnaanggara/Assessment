/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.GeneralDAO;
import java.util.List;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author asus
 */
public class Testing {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println(factory);
        List<Employee> asd = new GeneralDAO<>(factory, Employee.class).getAll();
        
    }
}
