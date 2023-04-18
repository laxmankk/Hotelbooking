package com.upgrad.booking.controller;

import com.upgrad.booking.dto.BookingDTO;
import com.upgrad.booking.entity.Booking;
import com.upgrad.booking.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/booking_app/v1")
public class BookingController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookingService bookingService;

    @PostMapping(value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBooking(@RequestBody BookingDTO bookingDTO) {

        //convert booking dto into booking

        Booking newBooking = modelMapper.map(bookingDTO, Booking.class);
        Booking saveBooking = bookingService.bookRoom(newBooking);

        BookingDTO savedBookingDto = modelMapper.map(saveBooking, BookingDTO.class);

        return new ResponseEntity(savedBookingDto, HttpStatus.CREATED);

    }
}
