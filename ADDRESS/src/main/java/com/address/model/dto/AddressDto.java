package com.address.model.dto;

import com.address.model.enums.AddressType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AddressDto {
    private Long id;
    private Long userId;
    private String street;
    private String pinCode;
    private String city;
    private String country;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", street='" + street + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", addressType=" + addressType +
                '}';
    }

    public AddressDto() {

    }

    public AddressDto(Long id, Long userId, String street, String pinCode, String city, String country, AddressType addressType) {
        this.id = id;
        this.userId = userId;
        this.street = street;
        this.pinCode = pinCode;
        this.city = city;
        this.country = country;
        this.addressType = addressType;
    }

}
