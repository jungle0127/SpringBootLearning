package com.ps.enumdemo.controller;

import com.ps.enumdemo.model.GenderEnum;
import com.ps.enumdemo.model.PersonDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/enum")
public class EnumParameterController {
    @PostMapping("/")
    public String getName(@RequestBody PersonDto dto){
        GenderEnum genderEnum = dto.getGenderEnum();
        return String.format("getValue:%d, name:%s, ordinal: %d",genderEnum.getValue(),genderEnum.name(),genderEnum.ordinal());
    }
}
