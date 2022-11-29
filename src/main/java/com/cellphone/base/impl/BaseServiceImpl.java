package com.cellphone.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.cellphone.controller.CategoryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cellphone.base.BaseRepository;
import com.cellphone.base.BaseService;
import com.cellphone.common.PagingCommon;
import com.cellphone.dto.BaseDTO;
import com.cellphone.dto.FilterRequest;
import com.cellphone.entities.BaseEntities;
import com.cellphone.error.ResourceNotFoundException;

@Transactional
public abstract class BaseServiceImpl<T extends BaseEntities> implements BaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    private BaseRepository<T> baseRepository;

    private Class<T> clazz;

    private Class<?> clazzDTO;

    public BaseServiceImpl(BaseRepository<T> baseRepository, Class<T> clazz, Class<?> clazzDTO) {
        this.baseRepository = baseRepository;
        this.clazz = clazz;
        this.clazzDTO = clazzDTO;
    }

    @Override
    public void save(BaseDTO clazzDTO) {
        T entities = BaseDTO.mapToEntities(clazzDTO, clazz, LOGGER);
        baseRepository.save(entities);
    }

    @Override
    public void update(BaseDTO clazzDTO) {
        T entities = BaseDTO.mapToEntities(clazzDTO, clazz, LOGGER);
        baseRepository.save(entities);
    }

    @Override
    public void updateFlag(Long id, boolean deleteFlag) {
        T entities = findById(id);
        entities.setDisable(true);
        baseRepository.save(entities);
    }

    @Override
    public BaseDTO findBaseDTOById(Long entityId) {
        T entities = baseRepository.findById(entityId).orElseThrow(() -> new ResourceNotFoundException(clazz.getName()));
        return BaseDTO.mapToBaseDTO(entities, clazzDTO, LOGGER);
    }

    private T findById(Long entityId) {
        return baseRepository.findById(entityId).orElseThrow(() -> new ResourceNotFoundException(clazz.getName()));
    }


    @Override
    public Page<BaseDTO> search(FilterRequest filterRequest) {
        String className = ("V_" + clazz.getSimpleName()).toUpperCase();
        List<T> searchResults = baseRepository.search(filterRequest.getDataSearch(), className);
        return PagingCommon.pagingData(filterRequest, searchResults, clazzDTO);
    }

    @Override
    public List<BaseDTO> findAll() {
        List<T> baseEntities = baseRepository.findAll();
        List<BaseDTO> result = new ArrayList<>();
        for (T entities : baseEntities) {
            BaseDTO baseDTO = BaseDTO.mapToBaseDTO(entities, clazzDTO, LOGGER);
            result.add(baseDTO);
        }
        return result;
    }
    public class GetTypeParent {
    	protected String getGenericName() { 
    		return ((Class<T>) ((ParameterizedType) getClass() .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName(); } }

}
