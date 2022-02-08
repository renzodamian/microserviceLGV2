package rdjaramillo1.ms.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rdjaramillo1.ms.userservice.entity.User;
import rdjaramillo1.ms.userservice.model.Bike;
import rdjaramillo1.ms.userservice.model.Car;
import rdjaramillo1.ms.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //Lista de Usuarios
    @GetMapping
    public ResponseEntity<List<User>> getALl(){
        List<User> users = userService.getAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);

    }
    //Usuario especifico
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable ("id") int id){
        User user = userService.getUserById(id);
        if(user ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    //Guarda un usuario especifico
    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        User userNew = userService.save(user);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if (user == null)
            return  ResponseEntity.notFound().build();
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> geBikes(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if (user == null)
            return  ResponseEntity.notFound().build();
        List<Bike> bikes = userService.getBikes(userId);
        return ResponseEntity.ok(bikes);
    }
}
