package rdjaramillo1.ms.bikeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rdjaramillo1.ms.bikeservice.entity.Bike;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {
    List<Bike> findByUserId(int userId);
}
