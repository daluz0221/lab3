package com.udea.lab3LF.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.lab3LF.service.FlightService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.udea.lab3LF.exception.InvalidRating;
import com.udea.lab3LF.exception.ModelNotFoundException;
import com.udea.lab3LF.model.Flight;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/save")
    public long  save(@RequestBody Flight flight) throws InvalidRating {
        //TODO: process POST request
        if (flight.getRating() > 5) throw new InvalidRating("id should be less than or equal to 5");
        flightService.save(flight);
        return flight.getIdflight();        
    }

    @GetMapping("/listAll")
    public Iterable<Flight> listAllFlights() {
       return flightService.List();
    }

    @GetMapping("/list/{id}")
    public Flight listflightbyId(@PathVariable("id") int id) {
        Optional<Flight> flight = flightService.listId(id);
        if(flight.isPresent()){
             return flight.get();
        }

        throw new ModelNotFoundException("Id de Vuelo inválido");
    }


    
    @GetMapping("/topFlights")
    public ResponseEntity<List<Flight>> viewBestFlight(){
        List<Flight> list = flightService.viewBestFlight();
        return new ResponseEntity<List<Flight>>(list, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.update(flight);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable("id") long  id ){
        return flightService.delete(id);
    }

}
