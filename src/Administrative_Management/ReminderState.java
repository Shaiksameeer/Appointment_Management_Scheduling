package Administrative_Management;

import java.util.List;

public class ReminderState implements AdminState {

    @Override
    public void automateAppointmentReminders(AdminManager manager) {
        List<Appointment> appointments = manager.getAppointments();
        for (Appointment appointment : appointments) {
            // Simulating sending reminder
            System.out.println("Sending reminder to patient: " + appointment.getPatient().getName() +
                    " for appointment on " + appointment.getDate());
        }
    }

    @Override
    public void conductPerformanceEvaluations(AdminManager manager) {
        System.out.println("Cannot conduct performance evaluations in ReminderState.");
    }

    @Override
    public void generateFinancialReports(AdminManager manager) {
        System.out.println("Cannot generate financial reports in ReminderState.");
    }

    @Override
    public void predictiveAnalyticsForResourcePlanning(AdminManager manager) {
        System.out.println("Cannot perform predictive analytics in ReminderState.");
    }

    @Override
    public void ensureRegulatoryCompliance(AdminManager manager) {
        System.out.println("Cannot ensure regulatory compliance in ReminderState.");
    }

    @Override
    public void streamlineAdministrativeWorkflows(AdminManager manager) {
        System.out.println("Cannot streamline administrative workflows in ReminderState.");
    }

    @Override
    public void optimizeResourceAllocation(AdminManager manager) {
        System.out.println("Cannot optimize resource allocation in ReminderState.");
    }

    @Override
    public void ensureDataSecurityAndPrivacy(AdminManager manager) {
        System.out.println("Cannot ensure data security and privacy in ReminderState.");
    }

    @Override
    public void trackStaffSchedules(AdminManager manager) {
        System.out.println("Cannot track staff schedules in ReminderState.");
    }
}
