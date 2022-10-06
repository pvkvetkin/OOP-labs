package Services;

import DTO.DefaultEmployeeDTO;
import Entities.DefaultEmployee;
import Infrastructure.IEmployeeService;
import Repositories.EmployeeRep;

import java.util.Map;

public class DefaultEmployeeService implements IEmployeeService {
    EmployeeRep<DefaultEmployee> rep = new EmployeeRep();

    public DefaultEmployeeService(EmployeeRep rep) {
        this.rep = rep;
    }

    public void addEmpoyee(DefaultEmployeeDTO employeeDTO) {
        DefaultEmployee employee = new DefaultEmployee(employeeDTO.getName());
        employee.setName(employeeDTO.getName());
        rep.addEmp(employee);
    }

    public Map<Integer, DefaultEmployee> getAll() {
        return rep.getAll();
    }
}
