package org.launchcode.walkabout.data;

import org.launchcode.walkabout.models.MyUserJournals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends CrudRepository<MyUserJournals, String> {

}
