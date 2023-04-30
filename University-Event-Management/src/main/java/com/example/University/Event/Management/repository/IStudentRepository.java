package com.example.University.Event.Management.repository;

import com.example.University.Event.Management.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<Student,Integer> {

    public List<Student> findByStudentId(Integer stockType);

    @Modifying
    @Query(value = "Delete from Student where student_id_id= :id",nativeQuery = true)
    public void deleteFromStudent(Integer id);

    @Modifying
    @Query(value = "update STUDENT set Department =:enumValue where STUDENT_ID_ID =:id",nativeQuery = true)
    public void modify(String enumValue, Integer id);


    @Modifying
    @Query(value = "select * from student",nativeQuery = true)
    List<Student> AllGet();

}
