package com.cellphone.dto;

import com.cellphone.entities.BaseEntities;
import com.cellphone.error.ResourceNotFoundException;
import lombok.Data;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;

@Data
public class BaseDTO {

    public static BaseDTO createDTOInstance(Class<?> clazzDTO) {
        try {
            return (BaseDTO) clazzDTO.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BaseDTO mapToBaseDTO(BaseEntities baseEntities, Class<?> clazzDTO, final Logger logger) {
        try {
            BaseDTO baseDTO = (BaseDTO) clazzDTO.newInstance();
            BeanUtils.copyProperties(baseEntities, baseDTO);
            return baseDTO;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            //todo: change exception type
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public static <T> T mapToEntities(BaseDTO baseDTO, Class<T> clazz, final Logger logger) {
        try {
            T entities = clazz.newInstance();
            BeanUtils.copyProperties(baseDTO, entities);
            return entities;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            //todo: change exception type
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

}
