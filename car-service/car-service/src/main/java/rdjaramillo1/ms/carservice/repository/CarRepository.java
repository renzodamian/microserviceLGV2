package rdjaramillo1.ms.carservice.repository;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rdjaramillo1.ms.carservice.entity.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByUserId(int userId);
}
