package Domain;

import DTO.DefaultEmployeeDTO;
import Services.DefaultEmployeeService;

public class DefaultEmployeeContoller {
    DefaultEmployeeService defaultEmployeeService;

    DefaultEmployeeContoller (DefaultEmployeeService defaultEmployeeService) {
        this.defaultEmployeeService = defaultEmployeeService;
    }

    void add(DefaultEmployeeViewModel defaultEmployeeViewModel) {
        defaultEmployeeService.addEmpoyee(new DefaultEmployeeDTO(defaultEmployeeViewModel.getName()));
    }

    public DefaultEmployeeService getDefaultEmployeeService() {
        return defaultEmployeeService;
    }
}
