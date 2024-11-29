package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.enums.DeviceType;

import java.util.List;

@Repository
public interface DeviceRepository  extends JpaRepository<Device, Long> {

    boolean existsByBrandAndModel(String brand, String model);

    List<Device> findAllByDeviceTypeAndPriceLessThanEqualAndStorageGreaterThanEqualOrderByBrand( DeviceType deviceType, Double price, Integer storage);
}
