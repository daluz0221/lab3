package com.udea.lab3LF.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.lab3LF.dao.IFlightDAO;
import com.udea.lab3LF.exception.FlightNotFoundException;
import com.udea.lab3LF.model.Flight;

@Service
public class FlightService {

    @Autowired
    private IFlightDAO dao;

    public Flight save(Flight f){
        return dao.save(f);
    }

    public String delete(long id){
        dao.deleteById(id);
        return "Flight deleted";
    }
    public Iterable<Flight> List(){
        return dao.findAll();
    }

    public Optional<Flight> listId(long id){
        return dao.findById(id);
    }

    public Flight update(Flight f){
        Flight existingFlight = dao.findById(f.getIdflight()).orElse(null);
        existingFlight.setNombreavion(f.getNombreavion());
        existingFlight.setNumerovuelo(f.getNumerovuelo());
        existingFlight.setOrigen(f.getOrigen());
        existingFlight.setDestino(f.getDestino());
        existingFlight.setRating(f.getRating());
        existingFlight.setPlanvuelo(f.getPlanvuelo());
        existingFlight.setCapacidad(f.getCapacidad());
        existingFlight.setCumplido(f.getCumplido());

        return dao.save(existingFlight);

    }

    public List<Flight> viewBestFlight() throws FlightNotFoundException {
        List<Flight> flights = dao.viewBestFlight();
        if (flights.size()>0) {
            return flights;
        } else {
            throw new FlightNotFoundException("No flight with rating >= 4 found");
        }
    }
    



}
