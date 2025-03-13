package com.example.Project.service;

import com.example.Project.entity.Reservation;
import com.example.Project.entity.enums.ReservationStatus;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService extends BaseService<Reservation,Long>{

    List<Reservation> getReservationsWithinDateRange(LocalDate start, LocalDate end);
    List<Reservation> findReservationsByStatus(ReservationStatus status);
    void removeExpiredReservations();
}
