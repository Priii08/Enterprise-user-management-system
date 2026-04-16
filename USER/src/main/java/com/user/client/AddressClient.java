package com.user.client;

import com.user.model.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ADDRESS")
public interface AddressClient {

    @GetMapping("/addresses/userId/{userId}")
    List<AddressDto> getAddressByUserId(@PathVariable("userId") Long userId);

}
