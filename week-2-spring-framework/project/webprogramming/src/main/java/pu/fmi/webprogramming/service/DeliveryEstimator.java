package pu.fmi.webprogramming.service;

import org.springframework.stereotype.Component;
import pu.fmi.webprogramming.model.Delivery;

import java.time.LocalDateTime;

@Component
public class DeliveryEstimator {

  public LocalDateTime estimateArrivalTime(Delivery delivery) {
      int days = delivery.getCustomer().getCity().equals(delivery.getWarehouse().getCity()) ? 1 : 3;
      if (delivery.getCourier() == null) {
          days += 2;
      }
      return delivery.getCreatedAt().plusDays(days);

  }
}
