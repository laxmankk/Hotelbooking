package com.upgrad.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;


    private LocalDateTime fromDate;

    private LocalDateTime toDate;
    private String aadharNumber;
    private int noOfRooms;
    private String roomNumbers;
    private int roomPrice;
    private int transactionId;

    private LocalDateTime bookedOn;
}