package Patient_Appointment_Management;
import java.util.Date;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private Date date;
    private String details;
     AppointmentState state;

    public Appointment(String appointmentId, String patientId, Date date, String details) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.date = date;
        this.details = details;
        this.state = new ScheduledState();
    }

    // Getters and Setters
    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setState(AppointmentState state) {
        this.state = state;
    }

    public void applyState() {
        state.handle(this);
    }
}
