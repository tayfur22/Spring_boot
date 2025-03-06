package com.example.Project.controller;

import com.example.Project.entity.Reservation;
import com.example.Project.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/within-date-range")
    public List<Reservation> getReservationsWithinDateRange(@RequestParam LocalDate strat, @RequestParam LocalDate end) {
        return reservationService.getReservationsWithinDateRange(strat, end);
    }

    @PostMapping
    public Reservation createReservation(@Valid @RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
}
