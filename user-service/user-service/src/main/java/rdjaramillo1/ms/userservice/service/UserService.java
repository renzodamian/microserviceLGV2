package rdjaramillo1.ms.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rdjaramillo1.ms.userservice.entity.User;
import rdjaramillo1.ms.userservice.model.Bike;
import rdjaramillo1.ms.userservice.model.Car;
import rdjaramillo1.ms.userservice.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        User userNew = userRepository.save(user);
        return  userNew;
    }

    public List<Car> getCars (int userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byuser/"+userId,List.class);
        return  cars;
    }

    public List<Bike> getBikes (int userId){
        List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/byuser/"+userId,List.class);
        return  bikes;
    }
}
