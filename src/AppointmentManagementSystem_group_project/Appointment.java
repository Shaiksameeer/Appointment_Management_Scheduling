package AppointmentManagementSystem_group_project;

import java.util.Date;

public class Appointment {
    private Patient patient;
    private Provider provider;
    private Date date;

    public Appointment(Patient patient, Provider provider, Date date) {
        this.patient = patient;
        this.provider = provider;
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public Provider getProvider() {
        return provider;
    }

    public Date getDate() {
        return date;
    }
}
