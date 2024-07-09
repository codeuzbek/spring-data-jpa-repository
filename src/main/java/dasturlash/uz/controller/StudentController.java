package dasturlash.uz.controller;

import dasturlash.uz.dto.StudentDTO;
import dasturlash.uz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        StudentDTO result = studentService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/flush")
    public ResponseEntity<StudentDTO> createAndFlush(@RequestBody StudentDTO dto) {
        StudentDTO result = studentService.saveAndFlush(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/all")
    public ResponseEntity<Void> deleteAllByIdList(@RequestBody List<Integer> idList) {
        studentService.deleteAllByIdList(idList);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        studentService.deleteAllStudentList();
        return ResponseEntity.ok().build();
    }
}
