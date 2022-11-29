package com.cellphone.common;

import com.cellphone.dto.BaseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;

import com.cellphone.constant.Constant;
import com.cellphone.dto.FilterRequest;

import java.util.ArrayList;
import java.util.List;

public class PagingCommon {

	public static Pageable getPageable(int pageIndex, int pageSize) {
		pageIndex = pageIndex > 0 ? pageIndex - 1 : Constant.PAGE_INDEX;
		pageSize = pageSize > 0 ? pageSize : Constant.PAGE_SIZE;
		return PageRequest.of(pageIndex, pageSize, Sort.by("updatedAt").descending());
	}

	public static Pageable getPageable(FilterRequest filterRequest) {
		int pageIndex = filterRequest.getPageIndex();
		int pageSize = filterRequest.getPageSize();
		return getPageable(pageIndex, pageSize);
	}

	public static <T> Page<BaseDTO> pagingData(FilterRequest filterRequest, List<T> searchResults, Class<?> clazzDTO){
		Pageable pageable = PagingCommon.getPageable(filterRequest);
		int pageSizeData = 0;
		int resultSize = searchResults.size();
		int begin = (filterRequest.getPageIndex() - 1) * filterRequest.getPageSize();
		List<BaseDTO> result = new ArrayList<>();

		for (int i = begin; i < resultSize; i++) {
			if (pageSizeData == filterRequest.getPageSize()) {
				break;
			}
			T entities = searchResults.get(i);
			BaseDTO baseDTO = BaseDTO.createDTOInstance(clazzDTO);
			if (baseDTO == null) {
				throw new NullPointerException();
			}
			BeanUtils.copyProperties(entities, baseDTO);
			result.add(baseDTO);
			pageSizeData++;
		}
		return new PageImpl<>(result, pageable, searchResults.size());
	}

}
