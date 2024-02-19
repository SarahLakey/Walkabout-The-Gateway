package org.launchcode.walkabout.data;

//import org.jetbrains.annotations.NotNull;
import org.launchcode.walkabout.models.User;
import org.launchcode.walkabout.models.dto.UserJournal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends CrudRepository<UserJournal, String> {


}

