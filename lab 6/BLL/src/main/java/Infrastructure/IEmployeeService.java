package Infrastructure;

import DTO.DefaultEmployeeDTO;
import Entities.DefaultEmployee;

import java.util.ArrayList;

public interface IEmployeeService {
    void addEmpoyee(DefaultEmployeeDTO employeeDTO);
}
