package com.project.urlshortener.dao;

import com.project.urlshortener.entity.UrlMapping;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlDao extends CrudRepository<UrlMapping, Long> {
    List<UrlMapping> findByShortKey(String shortKey);
}
