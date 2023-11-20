package kg.test.testproject.repository;

import kg.test.testproject.dto.response.ManagerResponse;
import kg.test.testproject.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {
    @Query("SELECT new kg.test.testproject.dto.response.ManagerResponse(m.fullName, m.phoneNumber, ui.username, m.createdAt, COUNT(a)) " +
           "FROM Manager m " +
           "LEFT JOIN UserInfo ui ON m.id = ui.manager.id " +
           "LEFT JOIN Apartment a ON m.id = a.manager.id " +
           "GROUP BY m.fullName, m.phoneNumber, ui.username, m.createdAt")
    List<ManagerResponse> getAllManager();



}
