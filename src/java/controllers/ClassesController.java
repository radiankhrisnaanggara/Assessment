/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import models.Classes;
import org.hibernate.SessionFactory;
import icontrollers.IClassesController;

/**
 *
 * @author arman
 */
public class ClassesController implements IClassesController {
    private IGeneralDAO igd;

    public ClassesController(SessionFactory factory) {
        igd = new GeneralDAO<>(factory, Classes.class);
    }
    
    @Override
    public String save(Classes classes) {
        String result = "";
        try {
            if (igd.saveOrDelete(classes, true)) {
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
