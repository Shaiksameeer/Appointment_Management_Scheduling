package AppointmentManagementSystem_group_project;


import java.util.List;

public class ReminderState implements SystemState {
    @Override
    public void handleRequest() {
        // For demonstration purposes, this could simply call sendReminders with a sample list
        System.out.println("ReminderState: Handling request for sending reminders.");
    }

    public void sendReminders(List<Appointment> appointments) {
        for (Appointment appointment : appointments) {
            // Here, we simulate sending a reminder to the patient
            System.out.println("Sending reminder for appointment with patient " + appointment.getPatient().getName()
                + " on " + appointment.getDate());
        }
    }
}
