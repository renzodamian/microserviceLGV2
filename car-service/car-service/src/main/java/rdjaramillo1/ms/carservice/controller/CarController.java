package rdjaramillo1.ms.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rdjaramillo1.ms.carservice.entity.Car;
import rdjaramillo1.ms.carservice.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    //Lista de Carros
    @GetMapping
    public ResponseEntity<List<Car>> getALl(){
        List<Car> cars = carService.getAll();
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);

    }
    //Carro especifico
    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable ("id") int id){
        Car car = carService.getCarById(id);
        if(car ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }

    //Guarda un carro especifico
    @PostMapping()
    public ResponseEntity<Car> save(@RequestBody Car car){
        Car carNew = carService.save(car);
        return ResponseEntity.ok(car);
    }

    //Lista de Carros
    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId")int userId){
        List<Car> cars = carService.byUserId(userId);
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);

    }

}
