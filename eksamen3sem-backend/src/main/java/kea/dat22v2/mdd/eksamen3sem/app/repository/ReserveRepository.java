package kea.dat22v2.mdd.eksamen3sem.app.repository;


import kea.dat22v2.mdd.eksamen3sem.app.entity.Attendee;
import kea.dat22v2.mdd.eksamen3sem.app.entity.EventAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<EventAttendee, Integer> {

    Integer countAllByEvent_Id(Integer id);
}
