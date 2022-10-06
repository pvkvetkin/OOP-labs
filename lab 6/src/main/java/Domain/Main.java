package Domain;

import Entities.DefaultEmployee;
import Repositories.EmployeeRep;
import Services.DefaultEmployeeService;

public class Main {
    public static void main(String[] args) {
        EmployeeRep<DefaultEmployee> rep
                = new EmployeeRep<DefaultEmployee>();
        DefaultEmployeeService defaultEmployeeService
                = new DefaultEmployeeService(rep);
        DefaultEmployeeContoller defaultEmployeeContoller
                = new DefaultEmployeeContoller(defaultEmployeeService);
        DefaultEmployeeViewModel defaultEmployeeViewModel = new DefaultEmployeeViewModel("123");
        defaultEmployeeContoller.add(defaultEmployeeViewModel);
        System.out.println(defaultEmployeeContoller.getDefaultEmployeeService().getAll().get(0).getName());
    }
}
