package com.smarthealth.service.interfaces;

import com.smarthealth.model.Appointment;
import com.smarthealth.model.Patient;
import java.time.LocalDateTime;
import java.util.List;

public interface ReminderServiceInterface {

    void sendAppointmentReminder(Appointment appointment);

    void sendMedicineReminder(Patient patient, String medicineName, LocalDateTime time);

    List<String> getRemindersForPatient(Patient patient);

    boolean cancelReminder(int reminderId);
}

