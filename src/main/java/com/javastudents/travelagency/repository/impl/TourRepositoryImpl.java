package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.entity.TourCategory;
import com.javastudents.travelagency.entity.wrapper.TourWrapper;
import com.javastudents.travelagency.repository.TourRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
                            .tourId(rs.getInt("tour_id"))
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

        jdbcTemplate.update(query, tour.getName(), tour.getTourId());
    }

    @Override
    public void delete(int tourId) {
        @Language("MySQL")
        String query = "DELETE FROM tour WHERE tour_id = ?";

        jdbcTemplate.update(query, tourId);
    }

    @Override
    public List<Tour> list() {
        @Language("MySQL")
        String query = "SELECT * FROM tour";

        try {
            return jdbcTemplate.query(
                    query, new Object[]{},
                    (rs, rowNum) -> Tour.builder()
                            .tourId(rs.getInt("tour_id"))
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
    public List<TourWrapper> listWrapper() {
        @Language("MySQL")
        String query = "SELECT *, " +
                "tour.name as tour_name, " +
                "tour_category.name as tour_category_name " +
                "FROM tour " +
                "JOIN tour_category on tour.tour_category_id = tour_category.tour_category_id";

        try{
            return jdbcTemplate.query(query, new Object[]{},
                    (rs, rowNub) -> TourWrapper.builder()
                                .tourId(rs.getInt("tour_id"))
                                .name(rs.getString("name"))
                                .description(rs.getString("description"))
                                .price(rs.getBigDecimal("price"))
                                .tourCategory(TourCategory.builder()
                                                .id(rs.getInt("tour_category_id"))
                                                .name(rs.getString("name"))
                                                .build()
                                )
                                .build()
            );
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public TourWrapper readWrapper() {
        return null;
    }
}
