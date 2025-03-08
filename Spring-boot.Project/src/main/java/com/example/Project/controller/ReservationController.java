package com.example.Project.controller;

import com.example.Project.entity.Reservation;
import com.example.Project.entity.enums.ReservationStatus;
import com.example.Project.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/within-date-range")
    public List<Reservation> getReservationsWithinDateRange(@RequestParam LocalDate strat, @RequestParam LocalDate end) {
        return reservationService.getReservationsWithinDateRange(strat, end);
    }

    @PostMapping
    public Reservation createReservation(@Valid @RequestBody Reservation reservation) {
        return (Reservation) reservationService.save(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    @PostMapping
    public Reservation create(@Valid @RequestBody Reservation reservation) {
        return (Reservation) reservationService.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        reservationService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getById(@PathVariable("id") Long id) {
        return reservationService.getById(id);
    }

    @GetMapping("/reservations")
    public List<Reservation> findReservationsByStatus(@RequestParam ReservationStatus status) {
        return reservationService.findReservationsByStatus(status);
    }
}
