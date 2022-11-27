package com.dattt.inventoryservice.service;

import com.dattt.inventoryservice.dto.InventoryResponse;
import com.dattt.inventoryservice.model.Inventory;
import com.dattt.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly=true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCodes){
        log.info("Wait Started");
        Thread.sleep(10000);
        log.info("Wait Ended");
        List<InventoryResponse> inventoryResponseList =  inventoryRepository.findBySkuCodeIn(skuCodes).stream()
                .map(it -> new InventoryResponse()
                        .setSkuCode(it.getSkuCode())
                        .setInStock(it.getQuantity() > 0)).toList();
        return inventoryResponseList;
    }


}
