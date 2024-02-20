package org.launchcode.walkabout.data;

import org.launchcode.walkabout.models.Favorite;
import org.launchcode.walkabout.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends CrudRepository<Favorite, String> {


}
