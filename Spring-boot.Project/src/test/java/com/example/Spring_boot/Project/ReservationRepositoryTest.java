package com.example.Spring_boot.Project;

import com.example.Project.entity.Reservation;
import com.example.Project.entity.enums.ReservationStatus;
import com.example.Project.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DataJpaTest
@ActiveProfiles("h2")
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void testFindByStatus(){

        Reservation reservation = new Reservation();
        reservation.setStatus(ReservationStatus.CONFIRMED);
        reservationRepository.save(reservation);

        List<Reservation> reservations = reservationRepository.findByStatus(ReservationStatus.CONFIRMED);

        assertNotNull(reservations);
        assertEquals(1, reservations.size());
    }

}
