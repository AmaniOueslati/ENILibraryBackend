package enilibrary.EniLibrary.repositories;

import ch.qos.logback.core.joran.action.Action;
import enilibrary.EniLibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);


    @Query(value = "select * from user u where u.username like :cle%" , nativeQuery = true)
    public List<User> getUsersStartWSC(@Param("cle") String ch);

    @Query(value = "select iduser from userrole ur where ur.idrole=1", nativeQuery = true)
    public List<Long> listiduserfromidrole();

    @Query(value = "select iduser from userrole ur where ur.idrole=?1", nativeQuery = true)
    public List<Long> listiduserfromidrole(Long idrole);

    @Query(value = "select * from user u, userrole ur where u.iduser=ur.iduser and ur.idrole=?1", nativeQuery = true)
    public List<User> listuserfromidrole(Long idrole);

    boolean existsByEmail(String email);

}
