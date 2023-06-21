package security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
