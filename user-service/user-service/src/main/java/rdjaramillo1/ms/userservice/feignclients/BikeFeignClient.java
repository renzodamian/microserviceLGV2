package rdjaramillo1.ms.userservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import rdjaramillo1.ms.userservice.model.Bike;

import java.util.List;

@FeignClient(name = "bike-service"/*, url = "http://localhost:8003/bike"*/)
@RequestMapping("/bike")
public interface BikeFeignClient {

    @PostMapping()
    Bike save (@RequestBody Bike bike);


    @GetMapping("/byuser/{userId}")
    @RequestMapping(method = RequestMethod.GET, value = "/bike")
    List<Bike> getBikes(@PathVariable("userId") int userId);


}