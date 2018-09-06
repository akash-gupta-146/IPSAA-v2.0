package com.synlabs.ipsaa.controller;

import com.synlabs.ipsaa.entity.attendance.StudentAttendance;
import com.synlabs.ipsaa.service.StudentAttendanceService;
import com.synlabs.ipsaa.view.attendance.StudentAttendanceRequest;
import com.synlabs.ipsaa.view.attendance.StudentAttendanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.synlabs.ipsaa.auth.IPSAAAuth.Privileges.STUDENT_CLOCKINOUT;
import static com.synlabs.ipsaa.auth.IPSAAAuth.Privileges.STUDENT_READ;

@RestController
@RequestMapping("/api/attendance/student/")
public class StudentAttendanceController
{

  @Autowired
  private StudentAttendanceService attendanceService;

  @GetMapping
  @Secured(STUDENT_READ)
  public List<StudentAttendanceResponse> list() {
    return attendanceService.studentAttendanceList().stream().map(StudentAttendanceResponse::new).collect(Collectors.toList());
  }

  @Secured(STUDENT_CLOCKINOUT)
  @PostMapping("clockin")
  public void clockin(@RequestBody StudentAttendanceRequest request) {
    attendanceService.clockIn(request);
  }

  @Secured(STUDENT_CLOCKINOUT)
  @PostMapping("clockout")
  public void clockout(@RequestBody StudentAttendanceRequest request) {
    attendanceService.clockout(request);
  }

  ///////////////////////////Avneet

  @Secured(STUDENT_READ)
  @GetMapping("present")
  public List<StudentAttendanceResponse> presentStudents(){
    return attendanceService.listOfPresentStudents().stream().map(StudentAttendanceResponse::new).collect(Collectors.toList());
  }

  @Secured(STUDENT_READ)
  @GetMapping("/corporate/{isCorporate}")
  public List<StudentAttendanceResponse> studentList(@PathVariable("isCorporate") boolean isCorporate){
    return attendanceService.listOfStudents(isCorporate).stream().map(StudentAttendanceResponse::new).collect(Collectors.toList());
  }
}
