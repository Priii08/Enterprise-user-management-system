package com.address.model.dto;

import java.util.List;

public class AddressRequest {
    private Long userId;
    private List<AddressRequestDto> addressRequestDtoList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<AddressRequestDto> getAddressRequestDtoList() {
        return addressRequestDtoList;
    }

    public void setAddressRequestDtoList(List<AddressRequestDto> addressRequestDtoList) {
        this.addressRequestDtoList = addressRequestDtoList;
    }
}
