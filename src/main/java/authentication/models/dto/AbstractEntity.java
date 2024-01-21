package authentication.models.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

public class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    public int getId(){
        return id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AbstractEntity entity = (AbstractEntity) o;
//        return id == entity.id;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(){
//            return Objects.hash(id);
//        }
//
//    }

}
