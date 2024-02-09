package org.launchcode.walkabout.data;

import org.launchcode.walkabout.models.Favorites;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends CrudRepository<Favorites, Integer> {

    //find a way to make sure users only see what they saved to their own favorites lists
    Favorites findByUsername(String username);
    Favorites findById(int id);


}
