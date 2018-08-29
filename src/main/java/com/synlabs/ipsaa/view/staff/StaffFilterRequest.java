package com.synlabs.ipsaa.view.staff;

import com.synlabs.ipsaa.view.common.PageRequest;

/**
 * Created by itrs on 4/14/2017.
 */
public class StaffFilterRequest extends PageRequest
{
  private String employeeType;

  private Boolean active;

  private String centerCode;

  private String employerCode;

  private int month;
  private int year;

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public StaffFilterRequest()
  {
  }

  public String getCenterCode()
  {
    return centerCode;
  }

  public void setCenterCode(String centerCode)
  {
    this.centerCode = centerCode;
  }

  public Boolean getActive()
  {
    return active;
  }

  public void setActive(Boolean active)
  {
    this.active = active;
  }

  public StaffFilterRequest(String employeeType)
  {
    this.employeeType = employeeType;
  }

  public String getEmployeeType()
  {
    return employeeType;
  }

  public void setEmployeeType(String employeeType)
  {
    this.employeeType = employeeType;
  }

  public String getEmployerCode()
  {
    return employerCode;
  }

  public void setEmployerCode(String employerCode)
  {
    this.employerCode = employerCode;
  }
}
