package pu.fmi.webprogramming.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pu.fmi.webprogramming.model.Delivery;
import pu.fmi.webprogramming.model.enums.DeliveryStatusEnum;

import java.util.List;

public interface DeliveryJpaRepository extends JpaRepository<Delivery, Long> {

  List<Delivery> findByDeliveryStatus(DeliveryStatusEnum status, Pageable pageable);

  List<Delivery> findByCustomer_Id(Long customerId, Pageable pageable);

  List<Delivery> findByDeliveryStatusAndCustomer_Id(DeliveryStatusEnum status, Long customerId, Pageable pageable);
}
