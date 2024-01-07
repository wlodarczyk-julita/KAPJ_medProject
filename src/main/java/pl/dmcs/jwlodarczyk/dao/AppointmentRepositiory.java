//package pl.dmcs.jwlodarczyk.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import pl.dmcs.jwlodarczyk.domain.Appointment;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//@Repository
//@Transactional
//public interface AppointmentRepositiory extends JpaRepository<Appointment, Long> {
//    List<Appointment> findAllAppointments();
//    Optional<Appointment> findByAppointmentID(long AppointmentID);
//    void deleteByAppointmentID(long AppointmentID);
//}
