package com.navigoapp.Navigo.Repository;

import com.navigoapp.Navigo.Models.Vehicles;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicles, Long> {
    @Query(value = "SELECT * FROM navigo_db.vehicles WHERE vehicle_no = ?1",nativeQuery = true)
    List<Vehicles> searchVehicle(int vehicleNo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM navigo_db.vehicles WHERE vehicle_no = ?1",nativeQuery = true)
    public void deleteVehicle(int vehicleNo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE navigo_db.vehicles SET name = ?2, color = ?3, source = ?4, destination = ?5 WHERE vehicle_no = ?1", nativeQuery = true)
    void updateVehicle(int vehicleNo, String name, String color, String source, String destination);

}