package enilibrary.EniLibrary.repositories;

import enilibrary.EniLibrary.Enum.Rolename;
import enilibrary.EniLibrary.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRolename(Rolename rolename);

}
