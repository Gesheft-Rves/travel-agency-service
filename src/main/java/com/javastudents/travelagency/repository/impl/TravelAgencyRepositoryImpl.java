package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TravelAgencyRepositoryImpl implements TravelAgencyRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TravelAgencyRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(TravelAgency travelAgency) {
        @Language("MySQL")
        String query = "INSERT INTO travel_agency (abbreviated_name, address, phone_number, site, email_address) VALUES (?,?,?,?,?)";

        jdbcTemplate.update(
                query,
                travelAgency.getAbbreviatedName(),
                travelAgency.getAddress(),
                travelAgency.getPhoneNumber(),
                travelAgency.getSite(),
                travelAgency.getEmailAddress()
        );
    }

    @Override
    public TravelAgency read(int travelAgencyId) {
        @Language("MySQL")
        String query = "SELECT * FROM travel_agency WHERE travel_agency_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{travelAgencyId},

                    (rs, rowNum) -> TravelAgency.builder()
                            .id(rs.getInt("travel_agency_id"))
                            .abbreviatedName(rs.getString("abbreviated_name"))
                            .address(rs.getString("address"))
                            .phoneNumber(rs.getString("phone_number"))
                            .site(rs.getString("site"))
                            .emailAddress(rs.getString("email_address"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(TravelAgency travelAgency) {
        @Language("MySQL")
        String query = "UPDATE travel_agency SET abbreviated_name = ?, address = ?, phone_number = ?, site = ?, email_address = ? WHERE travel_agency_id = ?";

        jdbcTemplate.update(
                query,
                travelAgency.getAbbreviatedName(),
                travelAgency.getAddress(),
                travelAgency.getPhoneNumber(),
                travelAgency.getSite(),
                travelAgency.getAddress(),
                travelAgency.getId()
        );
    }

    @Override
    public void delete(int travelAgencyId) {
        @Language("MySQL")
        String query = "DELETE FROM travel_agency WHERE travel_agency_id = ?";

        jdbcTemplate.update(query, travelAgencyId);
    }
}
