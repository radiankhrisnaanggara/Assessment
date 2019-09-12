/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IParticipantController;
import idaos.IGeneralDAO;
import java.util.List;
import models.Participant;
import org.hibernate.SessionFactory;

/**
 *
 * @author arman
 */
public class ParticipantController implements IParticipantController {

    private IGeneralDAO igd;

    public ParticipantController(SessionFactory factory) {
        igd = new GeneralDAO<>(factory, Participant.class);
    }

    @Override
    public List<Participant> getAll() {
        return igd.getAll();
    }
    
    @Override
    public Participant getById(String id){
        return (Participant) igd.getById(id);
    }

    @Override
    public String save(Participant participant) {
        String result = "";
        try {
            if (igd.saveOrDelete(participant, true)) {
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
