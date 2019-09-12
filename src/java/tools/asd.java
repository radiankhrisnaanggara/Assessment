/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.BatchClassController;
import controllers.ParticipantController;
import icontrollers.IBatchClassController;
import java.util.List;
import models.BatchClass;
import org.hibernate.SessionFactory;

/**
 *
 * @author asus
 */
public class asd {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        IBatchClassController ibcc = new BatchClassController(factory);
        List<BatchClass> batchClasses = (List<BatchClass>) ibcc.getAll();
        for (BatchClass batchClasse : batchClasses) {
            System.out.println(batchClasse.getId());
        }
    }
}
