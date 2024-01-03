package chap08.dto;

public class DepartmentDTO {
	private String department_name;
	
	public DepartmentDTO() {
		
	}

    public DepartmentDTO(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
