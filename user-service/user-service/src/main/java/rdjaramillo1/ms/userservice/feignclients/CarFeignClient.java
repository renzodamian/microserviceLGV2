package rdjaramillo1.ms.userservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rdjaramillo1.ms.userservice.model.Car;

import java.util.List;

@FeignClient(name = "car-service", url = "http://localhost:8002/car")
//@RequestMapping("/car")
public interface CarFeignClient {

    @PostMapping()
    Car save (@RequestBody Car car);

    @GetMapping("/byuser/{userId}")
    List<Car> getCars(@PathVariable("userId") int userId);



}
