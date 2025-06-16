package org.github.naveenerroju.products_service.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class FlashSales {

    @Id
    private ObjectId id;
    @Field("is_active")
    private Boolean isActive;
    @Field("flash_price")
    private Double flashPrice;
    @Field("start_time")
    private Date startTime;
    @Field("end_time")
    private Date endTime;
    @Field("max_qty_per_user")
    private Integer maxQtyPerUser;
    @Field("total_flash_stock")
    private Integer totalFlashStock;
    @Field("sold_flash_qty")
    private Integer soldFlashQty;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Double getFlashPrice() {
        return flashPrice;
    }

    public void setFlashPrice(Double flashPrice) {
        this.flashPrice = flashPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getMaxQtyPerUser() {
        return maxQtyPerUser;
    }

    public void setMaxQtyPerUser(Integer maxQtyPerUser) {
        this.maxQtyPerUser = maxQtyPerUser;
    }

    public Integer getTotalFlashStock() {
        return totalFlashStock;
    }

    public void setTotalFlashStock(Integer totalFlashStock) {
        this.totalFlashStock = totalFlashStock;
    }

    public Integer getSoldFlashQty() {
        return soldFlashQty;
    }

    public void setSoldFlashQty(Integer soldFlashQty) {
        this.soldFlashQty = soldFlashQty;
    }

}
