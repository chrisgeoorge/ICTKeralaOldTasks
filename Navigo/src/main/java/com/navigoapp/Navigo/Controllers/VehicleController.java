package com.navigoapp.Navigo.Controllers;

import com.navigoapp.Navigo.Models.Vehicles;
import com.navigoapp.Navigo.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping("/addBus")
    public ResponseEntity<Map<String, String>> addBus(@RequestBody Vehicles vehicles){
        Vehicles vehiclesObj = vehicleRepository.save(vehicles);
        Map<String, String> response = new HashMap<>();
        response.put("Status", "Success");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/view-all-vehicles")
    public ResponseEntity<List<Vehicles>> viewAllVehicles(){
        List<Vehicles> vehicles = vehicleRepository.findAll();
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping("/search-vehicles")
    public ResponseEntity<List<Vehicles>> searchVehicles(@RequestBody Vehicles vehicles){
        List<Vehicles> vehicle = vehicleRepository.searchVehicle(vehicles.vehicleNo);
        return ResponseEntity.ok(vehicle);
    }

    @DeleteMapping("/delete-vehicle")
    public ResponseEntity<Map<String, String>> deleteVehicle(@RequestBody Vehicles vehicles) {
        try {
            vehicleRepository.deleteVehicle(vehicles.vehicleNo);
            return ResponseEntity.ok(Map.of("Status", "Success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("Status", "Failed"));
        }
    }

    @PostMapping("/update-vehicles")
    public ResponseEntity<Map<String, String>> updateVehicle(@RequestBody Vehicles vehicles){
        try{
            vehicleRepository.updateVehicle(vehicles.vehicleNo, vehicles.name, vehicles.color, vehicles.source, vehicles.destination);
            Map<String , String> response = new HashMap<>();
            response.put("Status","Success");
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return (ResponseEntity<Map<String, String>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
