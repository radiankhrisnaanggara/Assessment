/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Employee;

/**
 *
 * @author asus
 */
public interface IEmployeeController {

    public List<Employee> getAll();

    public Employee getById(String id);

    public String save(String id, String first_name, String last_name, String email, String birth_place, String birth_date, String gender, String nationality, String photo, boolean is_delete);

    public String delete(String id);
}
