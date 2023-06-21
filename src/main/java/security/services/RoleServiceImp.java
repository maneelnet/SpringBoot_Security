package security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.models.Role;
import security.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> rolesList() {
        return roleRepository.findAll();
    }

}
