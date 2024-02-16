package org.launchcode.walkabout.data;

import org.launchcode.walkabout.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);
    Role findById(int id);

}
