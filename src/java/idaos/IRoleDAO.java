/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.EmployeeRole;

/**
 *
 * @author asus
 */
public interface IRoleDAO {
    List<EmployeeRole> getByEmployee(String id);
}
