package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TourCategory;
import com.javastudents.travelagency.repository.TourCategoryRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourCategoryRepositoryImpl implements TourCategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TourCategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TourCategory tourCategory) {
        @Language("MySQL")
        String query = "INSERT INTO tour_category (name) VALUES (?)";

        jdbcTemplate.update(
                query,
                tourCategory.getName()
        );
    }

    @Override
    public TourCategory read(int tourCategoryId) {
        @Language("MySQL")
        String query = "SELECT * FROM tour_category WHERE tour_category_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{tourCategoryId},

                    (rs, rowNum) -> TourCategory.builder()
                            .id(rs.getInt("tour_category_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(TourCategory tourCategory) {
        @Language("MySQL")
        String query = "UPDATE tour_category SET name = ? WHERE tour_category_id = ?";

        jdbcTemplate.update(query, tourCategory.getName(), tourCategory.getId());
    }

    @Override
    public void delete(int tourCategoryId) {
        @Language("MySQL")
        String query = "DELETE FROM tour_category WHERE tour_category_id = ?";

        jdbcTemplate.update(query, tourCategoryId);
    }

    @Override
    public List<TourCategory> list() {

        @Language("MySQL")
        String query = "SELECT * FROM tour_category";

        try{
            return jdbcTemplate.query(query, new Object[]{},
                    (rs, rowNub) -> TourCategory.builder()
                            .id(rs.getInt("tour_category_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
