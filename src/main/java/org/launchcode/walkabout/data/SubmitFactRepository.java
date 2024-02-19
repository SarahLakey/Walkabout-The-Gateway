package org.launchcode.walkabout.data;

import org.launchcode.walkabout.models.SubmitFact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmitFactRepository extends CrudRepository<SubmitFact, String> {

}
