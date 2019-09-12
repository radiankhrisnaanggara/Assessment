/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeRoleDAO;
import idaos.IRoleDAO;
import java.util.List;
import models.EmployeeRole;
import org.hibernate.SessionFactory;

/**
 *
 * @author asus
 */
public class EmployeeRoleController {

    private SessionFactory factory;
    private IRoleDAO irdao;
    
    public EmployeeRoleController(SessionFactory factory) {
        irdao = new EmployeeRoleDAO(factory);
    }
    
    public List<EmployeeRole> getById(String id){
        return irdao.getByEmployee(id);
    }
    
}
