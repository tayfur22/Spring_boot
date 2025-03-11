package com.example.Project.service;

import com.example.Project.entity.Reservation;
import com.example.Project.entity.enums.ReservationStatus;
import com.example.Project.repository.ReservationRepository;
import com.example.Project.service.impl.BaseServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ReservationService extends BaseServiceImpl {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        super(reservationRepository);
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationsWithinDateRange(LocalDate start, LocalDate end) {
        return reservationRepository.findReservationsWithinDateRange(start, end);
    }

    public List<Reservation> findReservationsByStatus(ReservationStatus status) {
        return reservationRepository.findByStatus(status);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void removeExpiredReservations() {
        LocalDate today = LocalDate.now();
        reservationRepository.deleteByEndDateBefore(today);
    }
}
