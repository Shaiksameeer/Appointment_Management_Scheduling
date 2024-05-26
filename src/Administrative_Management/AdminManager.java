package Administrative_Management;

import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private static AdminManager instance;
    private AdminState state;

    private List<Appointment> appointments;
    private List<Provider> providers;
    private List<FinancialReport> financialReports;

    private AdminManager() {
        this.state = new ReminderState();
        this.appointments = new ArrayList<>();
        this.providers = new ArrayList<>();
        this.financialReports = new ArrayList<>();
    }

    public static synchronized AdminManager getInstance() {
        if (instance == null) {
            instance = new AdminManager();
        }
        return instance;
    }

    public void setState(AdminState state) {
        this.state = state;
    }

    public void automateAppointmentReminders() {
        state.automateAppointmentReminders(this);
    }

    public void conductPerformanceEvaluations() {
        state.conductPerformanceEvaluations(this);
    }

    public void generateFinancialReports() {
        state.generateFinancialReports(this);
    }

    public void predictiveAnalyticsForResourcePlanning() {
        state.predictiveAnalyticsForResourcePlanning(this);
    }

    public void ensureRegulatoryCompliance() {
        state.ensureRegulatoryCompliance(this);
    }

    public void streamlineAdministrativeWorkflows() {
        state.streamlineAdministrativeWorkflows(this);
    }

    public void optimizeResourceAllocation() {
        state.optimizeResourceAllocation(this);
    }

    public void trackStaffSchedules() {
        state.trackStaffSchedules(this);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public List<FinancialReport> getFinancialReports() {
        return financialReports;
    }
}