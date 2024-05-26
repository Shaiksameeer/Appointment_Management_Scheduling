package Patient_Appointment_Management;
import org.junit.*;
import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentManagerTest {
    private AppointmentManager manager;
    private Patient testPatient;
    private String testPatientId = "1";
    private String testAppointmentId = "101";
    private Date testDate;

    @Before
    public void setUp() throws Exception {
        manager = AppointmentManager.getInstance();
        testPatient = new Patient(testPatientId, "John Doe", "john@example.com");
        manager.registerPatient(testPatient);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        testDate = sdf.parse("2024-06-20 10:00");
    }

    @After
    public void tearDown() throws Exception {
        // Reset the singleton instance for the next test
        manager = null;
        AppointmentManager.getInstance().patients.clear();
        AppointmentManager.getInstance().appointments.clear();
    }

    @Test
    public void testRegisterPatient() {
        Patient patient = new Patient("2", "Jane Doe", "jane@example.com");
        manager.registerPatient(patient);
        assertEquals("Jane Doe", manager.patients.get("2").getName());
    }

    @Test
    public void testScheduleAppointment() {
        manager.scheduleAppointment(testAppointmentId, testPatientId, testDate, "Routine Checkup");
        Appointment appointment = manager.appointments.get(testAppointmentId);
        assertNotNull(appointment);
        assertEquals("Routine Checkup", appointment.getDetails());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScheduleAppointmentWithInvalidPatient() {
        manager.scheduleAppointment(testAppointmentId, "invalidId", testDate, "Routine Checkup");
    }

    @Test
    public void testCancelAppointment() {
        manager.scheduleAppointment(testAppointmentId, testPatientId, testDate, "Routine Checkup");
        manager.cancelAppointment(testAppointmentId);
        assertNull(manager.appointments.get(testAppointmentId));
    }

  

    @Test
    public void testRescheduleAppointment() {
        manager.scheduleAppointment(testAppointmentId, testPatientId, testDate, "Routine Checkup");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date newDate = null;
        try {
            newDate = sdf.parse("2024-06-22 10:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        manager.rescheduleAppointment(testAppointmentId, newDate);
        Appointment appointment = manager.appointments.get(testAppointmentId);
        assertEquals(newDate, appointment.getDate());
    }

    @Test
    public void testViewAppointmentHistory() {
        manager.scheduleAppointment(testAppointmentId, testPatientId, testDate, "Routine Checkup");
        System.out.println("Appointment History for Patient ID: " + testPatientId);
        manager.viewAppointmentHistory(testPatientId);
    }

    @Test
    public void testSendAppointmentReminders() {
        manager.scheduleAppointment(testAppointmentId, testPatientId, testDate, "Routine Checkup");
        System.out.println("Sending Appointment Reminders...");
        manager.sendAppointmentReminders();
    }

    @Test
    public void testSingletonInstance() {
        AppointmentManager anotherInstance = AppointmentManager.getInstance();
        assertSame(manager, anotherInstance);
    }

    @Test
    public void testPatientDetails() {
        assertEquals("John Doe", testPatient.getName());
        assertEquals("john@example.com", testPatient.getEmail());
    }

  @Test
    public void testAppointmentState() {
        Appointment appointment = new Appointment(testAppointmentId, testPatientId, testDate, "Routine Checkup");
        appointment.setState(new ScheduledState());
        appointment.applyState();
        assertEquals(ScheduledState.class, appointment.state.getClass());
    }

    @Test
    public void testAppointmentStateChange() {
        Appointment appointment = new Appointment(testAppointmentId, testPatientId, testDate, "Routine Checkup");
        appointment.setState(new CancelledState());
        appointment.applyState();
        assertEquals(CancelledState.class, appointment.state.getClass());
    }

    @Test
    public void testMultiplePatients() {
        Patient patient1 = new Patient("2", "Jane Smith", "jane@example.com");
        manager.registerPatient(patient1);
        Patient patient2 = new Patient("3", "Mike Brown", "mike@example.com");
        manager.registerPatient(patient2);
        assertNotSame(patient1.getId(), patient2.getId());
    }
}

   
