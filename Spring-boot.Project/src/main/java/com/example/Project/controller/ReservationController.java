package com.example.Project.controller;

import com.example.Project.entity.Reservation;
import com.example.Project.entity.enums.ReservationStatus;
import com.example.Project.service.ReservationService;
import com.example.Project.service.impl.ReservationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Reservation>> getReservationsWithinDateRange(@RequestParam LocalDate strat, @RequestParam LocalDate end) {
        return ResponseEntity.ok(reservationService.getReservationsWithinDateRange(strat, end));
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        return ResponseEntity.ok((Reservation) reservationService.save(reservation));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        reservationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getById(@PathVariable("id") Long id) {
        return reservationService.getById(id);
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> findReservationsByStatus(@RequestParam ReservationStatus status) {
        return ResponseEntity.ok(reservationService.findReservationsByStatus(status));
    }
}
