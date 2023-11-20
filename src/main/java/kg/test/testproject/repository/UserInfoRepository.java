package kg.test.testproject.repository;

import kg.test.testproject.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    Optional<UserInfo>findByUsername(String username);
    boolean existsByUsername(String username);
}
