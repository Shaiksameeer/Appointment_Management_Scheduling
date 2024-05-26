package Healthcare_provider_management;

import java.util.*;

public class HealthcareProvider {
    private String providerId;
    private String name;
    private String specialty;
    private List<Appointment> appointments;

    public HealthcareProvider(String providerId, String name, String specialty) {
        this.providerId = providerId;
        this.name = name;
        this.specialty = specialty;
        this.appointments = new ArrayList<>();
    }

    public String getProviderId() {
        return providerId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void displaySchedule() {
        System.out.println("Schedule for Dr. " + name + ":");
        for (Appointment appointment : appointments) {
            System.out.println("Appointment ID: " + appointment.getAppointmentId() + ", Date: " + appointment.getDate() + ", Details: " + appointment.getDetails());
        }
    }
}
