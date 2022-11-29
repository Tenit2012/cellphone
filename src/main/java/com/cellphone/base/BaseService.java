package com.cellphone.base;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cellphone.dto.BaseDTO;
import com.cellphone.dto.FilterRequest;

public interface BaseService {

    void save(BaseDTO clazzDTO);

    void update(BaseDTO entities);

    void updateFlag(Long id, boolean deleteFlag);

    BaseDTO findBaseDTOById(Long entityId);

    Page<BaseDTO> search(FilterRequest filterRequest);

    List<BaseDTO> findAll();

}
