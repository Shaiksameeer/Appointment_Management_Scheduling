package Patient_Appointment_Management;
public class RescheduledState implements AppointmentState {
    @Override
    public void handle(Appointment appointment) {
        System.out.println("Appointment is rescheduled.");
    }
}