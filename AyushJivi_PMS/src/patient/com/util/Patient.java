package patient.com.util;

public class Patient {
	long patient_id;  
	String patient_name;  
	int patient_age;  
	long contact;  
	String patient_address;  
	String consulted_doctor;
	public long getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public int getPatient_age() {
		return patient_age;
	}
	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getPatient_address() {
		return patient_address;
	}
	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}
	public String getConsulted_doctor() {
		return consulted_doctor;
	}
	public void setConsulted_doctor(String consulted_doctor) {
		this.consulted_doctor = consulted_doctor;
	}
}
