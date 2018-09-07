package com.synlabs.ipsaa.view.staff;

import com.synlabs.ipsaa.entity.staff.EmployeeProfile;
import com.synlabs.ipsaa.enums.AddressType;
import com.synlabs.ipsaa.enums.Gender;
import com.synlabs.ipsaa.view.common.AddressRequest;
import com.synlabs.ipsaa.view.common.Request;

import java.util.Date;

/**
 * Created by itrs on 4/13/2017.
 */
public class StaffProfileRequest implements Request
{
  private String imagePath;
  private Gender gender;

  private Date doj;
  private Date dob;
  private Date dol;

  private String pan;
  private String uan;
  private String pfan;
  private String esin;
  private String pran;
  private String ban;
  // shubham
  private String  ifscCode;
  private String bankName;
  private String branchName;
  private String holderName;

  private AddressRequest address;
  private AddressRequest permanentAddress;

  /////Avneet
  private String fatherName;
  private String husbandName;



  public EmployeeProfile toEntity(EmployeeProfile employeeProfile)
  {

    if (employeeProfile == null)
    {
      employeeProfile = new EmployeeProfile();
    }
    employeeProfile.setImagePath(imagePath);
    employeeProfile.setDob(dob == null ? new Date() : dob);
    employeeProfile.setDoj(doj == null ? new Date() : doj);
    employeeProfile.setDol(dol);
    employeeProfile.setGender(gender);

    employeeProfile.setPan(pan);
    employeeProfile.setUan(uan);
    employeeProfile.setPfan(pfan);
    employeeProfile.setEsin(esin);
    employeeProfile.setPran(pran);
    employeeProfile.setBan(ban);
    // shubham
    employeeProfile.setIfscCode(ifscCode);
    employeeProfile.setBranchName(branchName);
    employeeProfile.setHolderName(holderName);
    employeeProfile.setBankName(bankName);

    /////Avneet
    employeeProfile.setHusbandName(husbandName);
    employeeProfile.setFatherName(fatherName);
    if (address != null)
    {
      employeeProfile.setAddress(address.toEntity());
      employeeProfile.getAddress().setAddressType(AddressType.Home);
    }

    if (permanentAddress != null)
    {
      employeeProfile.setPermanentAddress(permanentAddress.toEntity());
      employeeProfile.getPermanentAddress().setAddressType(AddressType.Permanent);
    }

    return employeeProfile;
  }

  public String getBan()
  {
    return ban;
  }

  public void setBan(String ban)
  {
    this.ban = ban;
  }

  public EmployeeProfile toEntity()
  {
    return toEntity(new EmployeeProfile());
  }

  public String getPan()
  {
    return pan;
  }

  public void setPan(String pan)
  {
    this.pan = pan;
  }

  public String getUan()
  {
    return uan;
  }

  public void setUan(String uan)
  {
    this.uan = uan;
  }

  public String getPfan()
  {
    return pfan;
  }

  public void setPfan(String pfan)
  {
    this.pfan = pfan;
  }

  public String getEsin()
  {
    return esin;
  }

  public void setEsin(String esin)
  {
    this.esin = esin;
  }

  public String getPran()
  {
    return pran;
  }

  public void setPran(String pran)
  {
    this.pran = pran;
  }

  public String getImagePath()
  {
    return imagePath;
  }

  public void setImagePath(String imagePath)
  {
    this.imagePath = imagePath;
  }

  public Date getDoj()
  {
    return doj;
  }

  public void setDoj(Date doj)
  {
    this.doj = doj;
  }

  public Date getDob()
  {
    return dob;
  }

  public void setDob(Date dob)
  {
    this.dob = dob;
  }

  public Date getDol()
  {
    return dol;
  }

  public void setDol(Date dol)
  {
    this.dol = dol;
  }

  public Gender getGender()
  {
    return gender;
  }

  public void setGender(Gender gender)
  {
    this.gender = gender;
  }

  public AddressRequest getAddress()
  {
    return address;
  }

  public void setAddress(AddressRequest address)
  {
    this.address = address;
  }

  public AddressRequest getPermanentAddress()
  {
    return permanentAddress;
  }

  public void setPermanentAddress(AddressRequest permanentAddress)
  {
    this.permanentAddress = permanentAddress;
  }
  // shubham

  public String getIfscCode() {
    return ifscCode;
  }

  public void setIfscCode(String ifscCode) {
    this.ifscCode = ifscCode;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public String getFatherName() { return fatherName; }

  public void setFatherName(String fatherName) { this.fatherName = fatherName; }

  public String getHusbandName() { return husbandName; }

  public void setHusbandName(String husbandName) { this.husbandName = husbandName; }

}
