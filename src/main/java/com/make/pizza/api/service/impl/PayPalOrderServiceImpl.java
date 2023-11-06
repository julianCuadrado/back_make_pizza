package com.make.pizza.api.service.impl;

import com.make.pizza.api.dto.pay.*;
import com.make.pizza.api.exception.ObjectNotFoundException;
import com.make.pizza.api.persistence.entity.pay.*;
import com.make.pizza.api.persistence.repository.PayPalOrderRepository;
import com.make.pizza.api.service.PayPalOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class PayPalOrderServiceImpl implements PayPalOrderService {

    private final PayPalOrderRepository payPalOrderRepository;

    @Override
    public PayPalOrderEntity save(PayPalOrder payPalOrder) {
        try {
            PayPalOrderEntity entity = payPalOrderRepository.save(Objects.requireNonNull(castPayPalOrderDTOToEntity(payPalOrder)));
            return entity;
        } catch (Exception e) {
            log.error("Error al guardar la informacion del pago", e);
            throw new ObjectNotFoundException("Error al guardar la información del pago", e);
        }
    }

    public static PayPalOrderEntity castPayPalOrderDTOToEntity(PayPalOrder dto) {
        if(Objects.isNull(dto)) return null;
        PayPalOrderEntity entity = new PayPalOrderEntity();
        entity.setId(dto.getId());
        entity.setIntent(dto.getIntent());
        entity.setStatus(dto.getStatus());
        entity.setCreateTime(dto.getCreateTime());
        entity.setUpdateTime(dto.getUpdateTime());
        entity.setPurchaseUnits(castPurchaseDTOToEntity(dto.getPurchaseUnits(), entity));
        entity.setPayer(castToPayerDTOToEntity(dto.getPayer()));
        entity.setLinks(castLinkDTOToEntity(dto.getLinks(), entity));
        return entity;
    }

    public static List<LinkEntity> castLinkDTOToEntity(List<Link> links, PayPalOrderEntity payPalOrderEntity) {
        List<LinkEntity> entities = new ArrayList<>();
        for (Link linkDTO : links) {
            entities.add(castLinkDTOToEntity(linkDTO, payPalOrderEntity));
        }
        return entities;
    }

    public static LinkEntity castLinkDTOToEntity(Link dto, PayPalOrderEntity payPalOrderEntity) {
        LinkEntity entity = new LinkEntity();
        entity.setHref(dto.getHref());
        entity.setRel(dto.getRel());
        entity.setMethod(dto.getMethod());
        entity.setPayPalOrder(payPalOrderEntity);
        return entity;
    }

    public static PayerEntity castToPayerDTOToEntity(Payer dto) {
        PayerEntity entity = new PayerEntity();
        entity.setPayerId(dto.getPayerId());
        entity.setName(castNameDTOToEntity(dto.getName()));
        entity.setEmailAddress(dto.getEmailAddress());
        if(Objects.nonNull(dto.getAddress())) {
            entity.setCountryCode(dto.getAddress().getCountryCode());
        }
        return entity;
    }

    private static NameEntity castNameDTOToEntity(Name dto) {
        NameEntity entity = new NameEntity();
        entity.setGivenName(dto.getGivenName());
        entity.setSurname(dto.getSurname());
        return entity;
    }

    public static List<PurchaseUnitEntity> castPurchaseDTOToEntity(List<PurchaseUnit> purchaseUnits, PayPalOrderEntity payPalOrderEntity) {
        List<PurchaseUnitEntity> entities = new ArrayList<>();
        for (PurchaseUnit dto : purchaseUnits) {
            entities.add(castPurchaseDTOToEntity(dto, payPalOrderEntity));
        }
        return entities;
    }

    public static PurchaseUnitEntity castPurchaseDTOToEntity(PurchaseUnit dto, PayPalOrderEntity payPalOrderEntity) {
        PurchaseUnitEntity entity = new PurchaseUnitEntity();
        entity.setReferenceId(dto.getReferenceId());
        entity.setAmount(castAmountDTOToEntity(dto.getAmount()));
        entity.setPayee(castPayeeDTOToEntity(dto.getPayee()));
        entity.setShipping(castShippingDTOToEntity(dto.getShipping()));
        entity.setPayments(castPaymentsDTOToEntity(dto.getPayments()));
        entity.setPayPalOrder(payPalOrderEntity);
        return  entity;
    }

    private static PaymentsEntity castPaymentsDTOToEntity(Payments dto) {
        PaymentsEntity entity = new PaymentsEntity();
        entity.setCaptures(castCapturesDTOEntity(dto.getCaptures(), entity));
        return entity;
    }

    private static ShippingEntity castShippingDTOToEntity(Shipping dto) {
        ShippingEntity entity = new ShippingEntity();
        entity.setFullName(dto.getName().getFullName());
        entity.setAddress(castAddressDTOToEntity(dto.getAddress()));
        return entity;
    }

    private static PayeeEntity castPayeeDTOToEntity(Payee dto) {
        PayeeEntity entity = new PayeeEntity();
        entity.setMerchantId(dto.getMerchantId());
        entity.setEmailAddress(dto.getEmailAddress());
        return entity;
    }

    private static AmountEntity castAmountDTOToEntity(Amount dto) {
        AmountEntity entity = new AmountEntity();
        entity.setCurrencyCode(dto.getCurrencyCode());
        entity.setValue(dto.getValue());
        return entity;
    }

    private static List<CaptureEntity> castCapturesDTOEntity(List<Capture> dtos, PaymentsEntity paymentsEntity) {
        List<CaptureEntity> entities = new ArrayList<>();
        for (Capture dto : dtos) {
            entities.add(castCapturesDTOEntity(dto, paymentsEntity));
        }
        return entities;
    }

    private static CaptureEntity castCapturesDTOEntity(Capture dto, PaymentsEntity paymentsEntity) {
        CaptureEntity entity = new CaptureEntity();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setAmount(castAmountDTOToEntity(dto.getAmount()));
        entity.setFinalCapture(dto.isFinalCapture());
        entity.setSellerProtection(castSellerProtectionDTOToEntity(dto.getSellerProtection()));
        entity.setCreateTime(dto.getCreateTime());
        entity.setUpdateTime(dto.getUpdateTime());
        entity.setPayments(paymentsEntity);
        return entity;
    }

    private static SellerProtectionEntity castSellerProtectionDTOToEntity(SellerProtection dto) {
        SellerProtectionEntity entity = new SellerProtectionEntity();
        entity.setStatus(dto.getStatus());
        entity.setDisputeCategories(dto.getDisputeCategories());
        return entity;
    }

    private static AddressEntity castAddressDTOToEntity(Address dto) {
        AddressEntity entity = new AddressEntity();
        entity.setAddressLine1(dto.getAddressLine1());
        entity.setAdminArea2(dto.getAdminArea2());
        entity.setAdminArea1(dto.getAdminArea1());
        entity.setPostalCode(dto.getPostalCode());
        entity.setCountryCode(dto.getCountryCode());
        return entity;
    }
}
