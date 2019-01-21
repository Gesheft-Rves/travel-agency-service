package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TourScheduleRepositoryImpl implements TourScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TourScheduleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TourSchedule tourSchedule) {
        @Language("MySQL")
        String query = "INSERT INTO tour_schedule (tour_id, starting_date_time, ending_date_time, transport_id) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                query,
                tourSchedule.getTourId(),
                tourSchedule.getStartingDateTime(),
                tourSchedule.getEndingDateTime(),
                tourSchedule.getTransportId()
        );
    }

    @Override
    public TourSchedule read(int tourScheduleId) {
        @Language("MySQL")
        String query = "SELECT * FROM tour_schedule WHERE tour_schedule_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{tourScheduleId},

                    (rs, rowNum) -> TourSchedule.builder()
                            .id(rs.getInt("tour_schedule_id"))
                            .tourId(rs.getInt("tour_id"))
                            .startingDateTime(rs.getTimestamp("starting_date_time"))
                            .endingDateTime(rs.getTimestamp("ending_date_time"))
                            .transportId(rs.getInt("transport_id"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(TourSchedule tourSchedule) {
        @Language("MySQL")
        String query = "UPDATE tour_schedule SET tour_id = ?, starting_date_time = ?, ending_date_time = ?, transport_id = ? WHERE tour_id = ?";

        jdbcTemplate.update(
                query,
                tourSchedule.getTourId(),
                tourSchedule.getStartingDateTime(),
                tourSchedule.getEndingDateTime(),
                tourSchedule.getTransportId(),
                tourSchedule.getId()
        );
    }

    @Override
    public void delete(int tourScheduleId) {
        @Language("MySQL")
        String query = "DELETE FROM tour_schedule WHERE tour_schedule_id = ?";

        jdbcTemplate.update(query, tourScheduleId);
    }
}
