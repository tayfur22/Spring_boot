package com.example.Project.repository;

import com.example.Project.entity.Reservation;
import com.example.Project.entity.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends BaseRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE r.startDate >= :start AND r.endDate <= :end")
    List<Reservation> findReservationsWithinDateRange(@Param("start") LocalDate start, @Param("end") LocalDate end);

    void deleteByEndDateBefore(LocalDate today);
    List<Reservation> findByStatus(ReservationStatus status);
}

