package dasturlash.uz.service;

import dasturlash.uz.dto.StudentDTO;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO create(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());

        studentRepository.save(entity);
        dto.setId(entity.getId());

        return dto;
    }

    public StudentDTO saveAndFlush(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());

        studentRepository.saveAndFlush(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public void deleteAllByIdList(List<Integer> idList) {
        studentRepository.deleteAllByIdInBatch(idList);
    }

    public void deleteAllStudentList() {
        studentRepository.deleteAllInBatch();
    }

}
