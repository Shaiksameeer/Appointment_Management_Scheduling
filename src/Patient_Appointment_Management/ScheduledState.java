package Patient_Appointment_Management;
public class ScheduledState implements AppointmentState {
    @Override
    public void handle(Appointment appointment) {
        System.out.println("Appointment is scheduled.");
    }
}