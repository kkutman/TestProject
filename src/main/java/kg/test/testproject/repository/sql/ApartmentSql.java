package kg.test.testproject.repository.sql;

import kg.test.testproject.dto.response.ApartmentResponse;
import kg.test.testproject.entity.enums.Status;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ApartmentSql {
    private static final String SELECT_QUERY = """
            SELECT a.id               AS id,
                   al.name            AS location,
                   a.floor            AS floor,
                   a.apartment_number AS apartment_number,
                   a.date             AS date,
                   a.status           AS status,
                   a.price            AS price,
                   a.client_full_name AS full_name,
                   a.status_apartment as status_apartment
            FROM apartments a
                     JOIN apartment_location al on al.id = a.apartment_location_id
            """;

    public static List<ApartmentResponse> getAllApartment(Status status, Long locationId, JdbcTemplate jdbcTemplate) {
        String sql = SELECT_QUERY;
        if (locationId != null) sql += " WHERE al.id = " + locationId;
        if (status != null) sql += " AND a.status =  '" + status + "'";
        return jdbcTemplate.query(sql, (resultset, i) ->
                ApartmentResponse.builder()
                        .id(resultset.getLong("id"))
                        .locationName(resultset.getString("location"))
                        .floor(resultset.getInt("floor"))
                        .apartmentNumber(resultset.getInt("apartment_number"))
                        .date(resultset.getDate("date").toLocalDate())
                        .status(Status.valueOf(resultset.getString("status")))
                        .price(resultset.getBigDecimal("price"))
                        .clientName(resultset.getString("full_name"))
                        .apartmentStatus(resultset.getString("status_apartment"))
                        .build());
    }
}
