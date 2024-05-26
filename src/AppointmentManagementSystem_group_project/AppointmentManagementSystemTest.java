package AppointmentManagementSystem_group_project;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.Date;

public class AppointmentManagementSystemTest {
    private AppointmentManagementSystem system;
    private Patient patient;
    private Provider provider;
    private Appointment appointment;

    @Before
    public void setUp() {
        system = AppointmentManagementSystem.getInstance();
        patient = new Patient("P1", "John Doe");
        provider = new Provider("DR1", "Dr. Alice");
        appointment = new Appointment(patient, provider, new Date());
        system.getAppointments().clear();
        system.getProviders().clear();
        system.getPatients().clear();
    }

    @After
    public void tearDown() {
        system.getAppointments().clear();
        system.getProviders().clear();
        system.getPatients().clear();
    }

    @Test
    public void testSingletonInstance() {
        AppointmentManagementSystem anotherInstance = AppointmentManagementSystem.getInstance();
        assertSame("System should be a singleton", system, anotherInstance);
    }

    @Test
    public void testAddPatient() {
        system.addPatient(patient);
        assertEquals("Patient list size should be 1", 1, system.getPatients().size());
    }

    @Test
    public void testAddProvider() {
        system.addProvider(provider);
        assertEquals("Provider list size should be 1", 1, system.getProviders().size());
    }

    @Test
    public void testScheduleAppointment() {
        system.scheduleAppointment(patient, provider, new Date());
        assertEquals("Appointment list size should be 1", 1, system.getAppointments().size());
    }

    @Test
    public void testAutomateAppointmentReminders() {
        system.addPatient(patient);
        system.addProvider(provider);
        system.scheduleAppointment(patient, provider, new Date());
        system.setState(new ReminderState());
        system.automateAppointmentReminders();
        assertTrue(true);
    }

    @Test
    public void testConductPerformanceEvaluations() {
        system.addProvider(provider);
        system.setState(new ReportState());
        system.conductPerformanceEvaluations();
        assertTrue(true);
    }

    @Test
    public void testGenerateFinancialReports() {
        system.setState(new ReportState());
        system.generateFinancialReports();
        assertTrue(true);
    }

    @Test
    public void testPredictiveAnalyticsForResourcePlanning() {
        system.setState(new AnalyticsState());
        system.predictiveAnalyticsForResourcePlanning();
        assertTrue(true);
    }

}
