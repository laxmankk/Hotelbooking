package com.upgrad.booking.service;

import com.upgrad.booking.entity.Booking;
import com.upgrad.booking.repository.BookingRepository;
import com.upgrad.booking.util.BookingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking bookRoom(Booking booking) {
        booking.setRoomPrice(1000* BookingUtil.getNumberofDays(booking.getFromDate(), booking.getToDate())*booking.getNoOfRooms());
        booking.setRoomNumbers(String.join(",", BookingUtil.getRandomNumbers(booking.getNoOfRooms())));
        booking.setBookedOn(LocalDateTime.now());
        return bookingRepository.save(booking);
    }


}
