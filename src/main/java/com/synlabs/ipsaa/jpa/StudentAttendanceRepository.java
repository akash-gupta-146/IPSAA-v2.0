package com.synlabs.ipsaa.jpa;

import com.synlabs.ipsaa.entity.attendance.StudentAttendance;
import com.synlabs.ipsaa.entity.center.Center;
import com.synlabs.ipsaa.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.Date;
import java.util.List;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Long> , QueryDslPredicateExecutor<StudentAttendance>
{

  int countByStudentAndAttendanceDate(Student student, Date date);

  StudentAttendance findByStudentAndAttendanceDate(Student student, Date date);
  List<StudentAttendance> findByStudentAndCreatedDateBetween(Student student,Date from, Date to);
  List<StudentAttendance> findByCenterAndAttendanceDateBetweenOrderByStudentAdmissionNumberAsc(Center center, Date from, Date to);


  //Avneet
  List<StudentAttendance> findByStudentInAndAttendanceDateOrderByIdAsc(List<Student> students,Date date);
  List<StudentAttendance> findByStudentCenterInAndStudentActiveTrueAndAttendanceDateAndCheckoutNotNull(List<Center> center,Date date);

}
