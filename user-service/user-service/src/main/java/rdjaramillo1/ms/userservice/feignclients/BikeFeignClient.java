package rdjaramillo1.ms.userservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rdjaramillo1.ms.userservice.model.Bike;

import java.util.List;

@FeignClient(name = "bike-service", url = "http://localhost:8003/bike")
//@RequestMapping("/bike")
public interface BikeFeignClient {

    @PostMapping()
    Bike save (@RequestBody Bike bike);


    @GetMapping("/byuser/{userId}")
    List<Bike> getBikes(@PathVariable("userId") int userId);


}