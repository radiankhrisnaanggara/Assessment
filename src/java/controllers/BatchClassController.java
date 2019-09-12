/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IBatchClassController;
import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.BatchClass;
import org.hibernate.SessionFactory;

/**
 *
 * @author arman
 */
public class BatchClassController implements IBatchClassController {
    private IGeneralDAO igd;

    public BatchClassController(SessionFactory factory) {
        igd = new GeneralDAO<>(factory, BatchClass.class);
    }
    
    @Override
    public String save(BatchClass batchClass) {
        String result = "";
        try {
            if (igd.saveOrDelete(batchClass, true)) {
                result = "Save Data Berhasil";
            } else {
                result = "Save Data Gagal";
            }
        } catch (Exception e) {
            result = "Save Data Gagal Error";
        }
        return result;
    }

    @Override
    public List<BatchClass> getAll() {
        return igd.getAll();
    }
}
