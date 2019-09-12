/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IEmployeeController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Employee;
import models.Participant;
import org.hibernate.SessionFactory;

/**
 *
 * @author arman
 */
public class EmployeeController implements IEmployeeController {

    private IGeneralDAO igd;

    public EmployeeController(SessionFactory factory) {
        igd = new GeneralDAO<>(factory, Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        return igd.getAll();
    }
    
    @Override
    public Employee getById(String id){
        return (Employee) igd.getById(id);
    }

    @Override
    public String save(Employee employee) {
        String result = "";
        try {
            if (igd.saveOrDelete(employee, true)) {
                result = "Save Data Berhasil";
            } else {
                result = "Save Data Gagal";
            }
        } catch (Exception e) {
            result = "Save Data Gagal Error";
        }
        return result;
    }

}
