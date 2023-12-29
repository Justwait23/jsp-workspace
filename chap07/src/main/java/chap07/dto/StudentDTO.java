package chap07.dto;

public class StudentDTO {

	private Integer student_id;
	private String student_name;
	private String student_major;
	private Integer admission;
	private Integer phone_number;
	private String email;
	
	
	public StudentDTO(Integer student_id, String student_name, String student_major, Integer admission,
			Integer phone_number, String email) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_major = student_major;
		this.admission = admission;
		this.phone_number = phone_number;
		this.email = email;
	}
	
	public String getDivRow() {
		return String.format("<div>%d</div>"
				+ "<div>%s</div>"
				+ "<div>%s</div>"
				+ "<div>%d</div>"
				+ "<div>%d</div>"
				+ "<div>%s</div>", student_id, student_name, student_major, admission, phone_number, email);
	}

	public Integer getStudent_id() {
		return student_id;
	}


	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}


	public String getStudent_name() {
		return student_name;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public String getStudent_major() {
		return student_major;
	}


	public void setStudent_major(String student_major) {
		this.student_major = student_major;
	}


	public Integer getAdmission() {
		return admission;
	}


	public void setAdmission(Integer admission) {
		this.admission = admission;
	}


	public Integer getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(Integer phone_number) {
		this.phone_number = phone_number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

