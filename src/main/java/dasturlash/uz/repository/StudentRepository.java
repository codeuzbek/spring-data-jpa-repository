package dasturlash.uz.repository;

import dasturlash.uz.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
