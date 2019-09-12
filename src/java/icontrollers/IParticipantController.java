/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Participant;

/**
 *
 * @author arman
 */
public interface IParticipantController {
    public List<Participant> getAll();
    public String save(Participant participant);
}
