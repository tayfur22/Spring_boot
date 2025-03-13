//package com.example.Spring_boot.Project;
//
//import com.example.Project.entity.Reservation;
//import com.example.Project.entity.enums.ReservationStatus;
//import com.example.Project.service.ReservationService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@SpringBootTest
//public class ReservationServiceTest {
//
//    @Autowired
//    private ReservationService reservationService;
//
//    @Test
//    public void testGetReservationsWithinDateRange() {
//        LocalDate start = LocalDate.of(2025, 3, 1);
//        LocalDate end = LocalDate.of(2025, 3, 31);
//
//        // Method çağırılır və log yazılmalıdır
//        List<Reservation> reservations = reservationService.getReservationsWithinDateRange(start, end);
//        System.out.println(reservations);  // Consola nə baş verdiyini görmək üçün
//    }
//
//    @Test
//    public void testFindReservationsByStatus() {
//        ReservationStatus status = ReservationStatus.PENDING;
//
//        // Method çağırılır və log yazılmalıdır
//        List<Reservation> reservations = reservationService.findReservationsByStatus(status);
//        System.out.println(reservations);  // Consola nə baş verdiyini görmək üçün
//    }
//}