package com.make.pizza.api.service.impl;

import com.make.pizza.api.dto.BillDTO;
import com.make.pizza.api.dto.ItemBillDTO;
import com.make.pizza.api.dto.OrderDTO;
import com.make.pizza.api.dto.OrderItemDTO;
import com.make.pizza.api.exception.ObjectNotFoundException;
import com.make.pizza.api.persistence.entity.BillEntity;
import com.make.pizza.api.persistence.entity.ItemBill;
import com.make.pizza.api.persistence.entity.User;
import com.make.pizza.api.persistence.entity.pay.PayPalOrderEntity;
import com.make.pizza.api.persistence.repository.BillRepository;
import com.make.pizza.api.service.BillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    @Override
    public BillEntity save(OrderDTO order, PayPalOrderEntity payPalOrderEntity) {
        try {
            BillEntity billEntity = convertOrderDTOToBill(order, payPalOrderEntity);
            return billRepository.save(billEntity);
        } catch (Exception e) {
            log.error("Error al guardar la factura", e);
            throw new ObjectNotFoundException("Error al procesar la factura", e);
        }
    }

    @Override
    public List<BillDTO> getAllActive() {
        List<BillEntity> entities = billRepository.getByStateTrue();
        return castBillEntityToDTO(entities);
    }

    private List<BillDTO> castBillEntityToDTO(List<BillEntity> entities) {
        List<BillDTO> dtos = new ArrayList<>();
        for (BillEntity entity : entities) {
            dtos.add(castBillEntityToDTO(entity));
        }
        return dtos;
    }

    private BillDTO castBillEntityToDTO(BillEntity entity) {
        BillDTO dto = new BillDTO();
        dto.setId(entity.getId());
        dto.setDateBill(entity.getDateBill());
        dto.setTotal(entity.getTotal());
        dto.setFullNameClient(entity.getFullNameClient());
        dto.setLongitude(entity.getLongitude());
        dto.setLatitude(entity.getLatitude());
        dto.setAddressClient(entity.getAddressClient());
        dto.setItems(castItemBillEntityToDTO(entity.getItems()));
        return dto;
    }

    private List<ItemBillDTO> castItemBillEntityToDTO(List<ItemBill> items) {
        List<ItemBillDTO> dtos = new ArrayList<>();
        for (ItemBill entity: items) {
            dtos.add(castItemBillEntityToDTO(entity));
        }
        return dtos;
    }

    private ItemBillDTO castItemBillEntityToDTO(ItemBill entity) {
        ItemBillDTO dto = new ItemBillDTO();
        dto.setId(entity.getId());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        dto.setUnitValue(entity.getUnitValue());
        dto.setTotalValue(entity.getTotalValue());
        return dto;
    }

    private BillEntity convertOrderDTOToBill(OrderDTO orderDTO, PayPalOrderEntity payPalOrderEntity) {
        BillEntity entity = new BillEntity();
        entity.setDateBill(LocalDateTime.now());
        entity.setTotal(orderDTO.getTotal());
        entity.setPayPalOrder(payPalOrderEntity);
        entity.setFullNameClient(orderDTO.getUser().getName());
        entity.setUser(new User(orderDTO.getUser().getId()));
        entity.setLatitude(orderDTO.getLatitude());
        entity.setLongitude(orderDTO.getLongitude());
        entity.setAddressClient(orderDTO.getDirection());
        entity.setState(true);
        entity.setItems(processItems(orderDTO.getItems(), entity));
        return entity;
    }

    private List<ItemBill> processItems(List<OrderItemDTO> items, BillEntity billEntity) {
        List<ItemBill> itemsBills = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : items) {
            itemsBills.add(processItem(orderItemDTO, billEntity));
        }
        return itemsBills;
    }

    private ItemBill processItem(OrderItemDTO orderItemDTO, BillEntity billEntity) {
        ItemBill itemBill = new ItemBill();
        itemBill.setAmount(orderItemDTO.getAmount());
        itemBill.setDescription(orderItemDTO.getProduct().getName());
        itemBill.setUnitValue(orderItemDTO.getProduct().getPrice());
        itemBill.setTotalValue(orderItemDTO.getAmount() * orderItemDTO.getProduct().getPrice());
        itemBill.setBillEntity(billEntity);
        return itemBill;
    }
}
