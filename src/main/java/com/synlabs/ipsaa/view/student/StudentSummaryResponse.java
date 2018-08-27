package com.synlabs.ipsaa.view.student;

import com.synlabs.ipsaa.entity.student.Student;
import com.synlabs.ipsaa.view.center.CenterSummaryResponse;
import com.synlabs.ipsaa.view.center.ProgramGroupResponse;
import com.synlabs.ipsaa.view.center.ProgramResponse;
import com.synlabs.ipsaa.view.common.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentSummaryResponse implements Response
{

  private Long id;

  private String fullName;
  private String firstName;
  private String lastName;

  private String admissionNumber;

  private ProgramResponse program;

  private ProgramGroupResponse group;

  private CenterSummaryResponse center;

  private Boolean corporate;

 //Avneet
  private Boolean formalSchool;

  private String schoolName;

  private Boolean active;

  private Date leavingDate;     //Done.

  private final DateFormat formatter = new SimpleDateFormat("hh:mm a");

  public StudentSummaryResponse() {}

  public StudentSummaryResponse(Student student)
  {
    this.id = mask(student.getId());
    this.admissionNumber = student.getAdmissionNumber();
    this.program = new ProgramResponse(student.getProgram());
    this.group = new ProgramGroupResponse(student.getGroup());
    this.fullName = student.getProfile().getFullName();
    this.firstName = student.getProfile().getFirstName();
    this.lastName = student.getProfile().getLastName();
    this.center = new CenterSummaryResponse(student.getCenter());
    this.corporate = student.isCorporate();
    this.formalSchool=student.isFormalSchool();
    this.schoolName=student.getSchoolName();
    this.active = student.isActive();
    this.leavingDate=student.isActive()? null:student.getProfile().getLeavingDate();

  }

  public Boolean getCorporate()
  {
    return corporate;
  }

  public Long getId()
  {
    return id;
  }

  public String getAdmissionNumber()
  {
    return admissionNumber;
  }

  public ProgramResponse getProgram()
  {
    return program;
  }

  public ProgramGroupResponse getGroup()
  {
    return group;
  }

  public String getFullName()
  {
    return fullName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public CenterSummaryResponse getCenter() { return center; }

  public Boolean getFormalSchool() { return formalSchool; }

  public String getSchoolName() { return schoolName; }

  public Date getLeavingDate() { return leavingDate; }

  public Boolean getActive() { return active; }


}
