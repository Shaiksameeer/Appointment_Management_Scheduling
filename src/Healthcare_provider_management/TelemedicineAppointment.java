package Healthcare_provider_management;

import java.util.Date;

public class TelemedicineAppointment extends Appointment {

    public TelemedicineAppointment(String appointmentId, String patientId, Date date, String details) {
        super(appointmentId, patientId, date, details);
    }

    public void startTelemedicineSession() {
        System.out.println("Starting telemedicine session for appointment ID " + getAppointmentId() + " with details: " + getDetails());
    }
}
