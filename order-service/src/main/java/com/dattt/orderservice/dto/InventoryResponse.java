package com.dattt.orderservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
