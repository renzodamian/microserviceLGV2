package rdjaramillo1.ms.bikeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rdjaramillo1.ms.bikeservice.entity.Bike;
import rdjaramillo1.ms.bikeservice.service.BikeService;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Autowired
    BikeService bikeService;

    //Lista de Bikes
    @GetMapping
    public ResponseEntity<List<Bike>> getALl(){
        List<Bike> bikes = bikeService.getAll();
        if(bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);

    }
    //Bike especifico
    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable ("id") int id){
        Bike bike = bikeService.getBikeById(id);
        if(bike ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bike);
    }

    //Guarda un bike especifico
    @PostMapping()
    public ResponseEntity<Bike> save(@RequestBody Bike bike){
        Bike bikeNew = bikeService.save(bike);
        return ResponseEntity.ok(bike);
    }

    //Lista de Bike
    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId")int userId){
        List<Bike> bikes = bikeService.byUserId(userId);
        if(bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);

    }

}
