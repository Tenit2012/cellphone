package com.cellphone.controller;

import com.cellphone.constant.ServiceMapping;
import com.cellphone.dto.BaseDTO;
import com.cellphone.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ServiceMapping.TYPES)
public class TypeController {

    final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public void create(BaseDTO type) {
        typeService.save(type);
    }

    @PutMapping
    public void update(BaseDTO type) {
        typeService.update(type);
    }

    @DeleteMapping(ServiceMapping.ID)
    public void delete(@PathVariable("id") Long id,
                       @RequestParam(value = "deleteFlag", required = false, defaultValue = "false") boolean deleteFlag) {
        typeService.updateFlag(id, deleteFlag);
    }

}
