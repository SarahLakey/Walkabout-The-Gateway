package org.launchcode.walkabout.data;

import org.launchcode.walkabout.models.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends CrudRepository<Favorite, Integer> {

    //find a way to make sure users only see what they saved to their own favorites lists
    Favorite findByUsername(String username);
    Favorite findById(int id);


}
