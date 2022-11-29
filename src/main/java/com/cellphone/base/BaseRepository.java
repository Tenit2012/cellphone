package com.cellphone.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.cellphone.entities.BaseEntities;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntities> extends JpaRepository<T, Long> {

	@Query(value = "CALL SP_SEARCH(:dataSearch, :viewName);", nativeQuery = true)
	List<T> search(String dataSearch, String viewName);
}
