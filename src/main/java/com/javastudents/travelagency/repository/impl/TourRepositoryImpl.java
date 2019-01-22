package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.repository.TourRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TourRepositoryImpl implements TourRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TourRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Tour tour) {
        @Language("MySQL")
        String query = "INSERT INTO tour (name, description, price, tour_category_id) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                query,
                tour.getName(),
                tour.getDescription(),
                tour.getPrice(),
                tour.getTourCategoryId()
        );
    }

    @Override
    public Tour read(int turId) {
        @Language("MySQL")
        String query = "SELECT * FROM tour WHERE tour_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{turId},

                    (rs, rowNum) -> Tour.builder()
                            .id(rs.getInt("tour_id"))
                            .name(rs.getString("name"))
                            .description(rs.getString("description"))
                            .price(rs.getBigDecimal("price"))
                            .tourCategoryId(rs.getInt("tour_category_id"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Tour tour) {
        @Language("MySQL")
        String query = "UPDATE tour SET name = ? WHERE tour_id = ?";

        jdbcTemplate.update(query, tour.getName(), tour.getId());
    }

    @Override
    public void delete(int tourId) {
        @Language("MySQL")
        String query = "DELETE FROM tour WHERE tour_id = ?";

        jdbcTemplate.update(query, tourId);
    }
}
