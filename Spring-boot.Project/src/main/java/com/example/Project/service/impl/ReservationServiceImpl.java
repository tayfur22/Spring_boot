package com.example.Project.service.impl;

import com.example.Project.annotation.CustomLog;
import com.example.Project.entity.Reservation;
import com.example.Project.entity.enums.ReservationStatus;
import com.example.Project.repository.ReservationRepository;
import com.example.Project.service.ReservationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getById(Long aLong) {
        return reservationRepository.findById(aLong);
    }

    @Override
    public Reservation save(Reservation entity) {
        return reservationRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        reservationRepository.deleteById(aLong);
    }

    @Override
    @CustomLog
    public List<Reservation> getReservationsWithinDateRange(LocalDate start, LocalDate end) {
        return reservationRepository.findReservationsWithinDateRange(start, end);
    }

    @Override
    @CustomLog
    public List<Reservation> findReservationsByStatus(ReservationStatus status) {
        return reservationRepository.findByStatus(status);
    }

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void removeExpiredReservations() {
        LocalDate today = LocalDate.now();
        reservationRepository.deleteByEndDateBefore(today);
    }
}
