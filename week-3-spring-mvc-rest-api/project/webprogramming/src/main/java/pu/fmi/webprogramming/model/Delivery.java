package pu.fmi.webprogramming.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import pu.fmi.webprogramming.model.enums.DeliveryStatusEnum;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Delivery {

  private Long id;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

  private Customer customer;

  private Courier courier;

  private Warehouse warehouse;

  private LocalDateTime deliveredAt;
  private DeliveryStatusEnum deliveryStatus;

  private LocalDateTime estimatedArrivalAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Courier getCourier() {
    return courier;
  }

  public void setCourier(Courier courier) {
    this.courier = courier;
  }

  public Warehouse getWarehouse() {
    return warehouse;
  }

  public void setWarehouse(Warehouse warehouse) {
    this.warehouse = warehouse;
  }

  public LocalDateTime getDeliveredAt() {
    return deliveredAt;
  }

  public void setDeliveredAt(LocalDateTime deliveredAt) {
    this.deliveredAt = deliveredAt;
  }

  public DeliveryStatusEnum getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(DeliveryStatusEnum deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public LocalDateTime getEstimatedArrivalAt() {
    return estimatedArrivalAt;
  }

  public void setEstimatedArrivalAt(LocalDateTime estimatedArrivalAt) {
    this.estimatedArrivalAt = estimatedArrivalAt;
  }
}
