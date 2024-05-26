package Administrative_Management;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.Date;

public class AdminManagerTest {
    private AdminManager adminManager;
    private Patient patient;
    private Provider provider;
    private Appointment appointment;

    @Before
    public void setUp() {
        adminManager = AdminManager.getInstance();
        patient = new Patient("P1", "John Doe");
        provider = new Provider("DR1", "Dr. Alice");
        appointment = new Appointment(patient, provider, new Date());
        adminManager.getAppointments().clear();
        adminManager.getProviders().clear();
    }

    @After
    public void tearDown() {
        adminManager.getAppointments().clear();
        adminManager.getProviders().clear();
    }

    @Test
    public void testSingletonInstance() {
        AdminManager anotherInstance = AdminManager.getInstance();
        assertSame("AdminManager should be a singleton", adminManager, anotherInstance);
    }

    @Test
    public void testAutomateAppointmentReminders() {
        adminManager.getAppointments().add(appointment);
        adminManager.setState(new ReminderState());
        try {
            adminManager.automateAppointmentReminders();
            assertTrue(true);
        } catch (Exception e) {
            fail("automateAppointmentReminders should not throw an exception");
        }
    }

    @Test
    public void testConductPerformanceEvaluations() {
        adminManager.getProviders().add(provider);
        adminManager.setState(new ReportState());
        try {
            adminManager.conductPerformanceEvaluations();
            assertNotNull("Performance review should not be null", provider.getPerformanceReview());
        } catch (Exception e) {
            fail("conductPerformanceEvaluations should not throw an exception");
        }
    }

    @Test
    public void testGenerateFinancialReports() {
        adminManager.setState(new ReportState());
        try {
            adminManager.generateFinancialReports();
            assertTrue(true);
        } catch (Exception e) {
            fail("generateFinancialReports should not throw an exception");
        }
    }



    @Test
    public void testAppointmentListInitialization() {
        assertNotNull("Appointment list should be initialized", adminManager.getAppointments());
    }

    @Test
    public void testProviderListInitialization() {
        assertNotNull("Provider list should be initialized", adminManager.getProviders());
    }

    @Test
    public void testAddAppointment() {
        adminManager.getAppointments().add(appointment);
        assertEquals("Appointment list size should be 1", 1, adminManager.getAppointments().size());
    }

    @Test
    public void testAddProvider() {
        adminManager.getProviders().add(provider);
        assertEquals("Provider list size should be 1", 1, adminManager.getProviders().size());
    }

    @Test
    public void testEmptyAppointmentList() {
        assertTrue("Appointment list should be empty initially", adminManager.getAppointments().isEmpty());
    }

    @Test
    public void testEmptyProviderList() {
        assertTrue("Provider list should be empty initially", adminManager.getProviders().isEmpty());
    }

    @Test
    public void testInvalidState() {
        adminManager.setState(null);
        try {
            adminManager.automateAppointmentReminders();
            fail("automateAppointmentReminders should throw NullPointerException");
        } catch (NullPointerException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testReminderStateBehavior() {
        adminManager.getAppointments().add(appointment);
        adminManager.setState(new ReminderState());
        try {
            adminManager.automateAppointmentReminders();
            assertTrue(true);
        } catch (Exception e) {
            fail("automateAppointmentReminders should not throw an exception");
        }
    }
}
