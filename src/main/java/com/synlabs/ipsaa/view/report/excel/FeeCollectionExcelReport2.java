package com.synlabs.ipsaa.view.report.excel;

import com.synlabs.ipsaa.entity.student.Student;
import com.synlabs.ipsaa.entity.student.StudentFeePaymentRecord;
import com.synlabs.ipsaa.entity.student.StudentFeePaymentRequest;
import com.synlabs.ipsaa.enums.PaymentStatus;
import com.synlabs.ipsaa.util.BigDecimalUtils;
import com.synlabs.ipsaa.util.FeeUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
// shubham
public class FeeCollectionExcelReport2
{
  private String admissionNumber = "";
  private String name            = "";
  private String id;
  private String centerName      = "";
  private String programName     = "";
  private String groupName       = "";
  private String feeDuration     = "";
  private String month           = "";
  private String quarter         = "";
  private int year;
  // extra
  private String txnid           ="";
  private String motherName      ="";
  private String FatherName      ="";
  private BigDecimal sgst=BigDecimal.ZERO;
  private BigDecimal gst=BigDecimal.ZERO;
  private BigDecimal igst=BigDecimal.ZERO;

  //private BigDecimal extraHours   = BigDecimal.ZERO;
  private String     paymentStatus = "";
  private String     paymentMode   = "";
  private BigDecimal raisedAmount  = BigDecimal.ZERO;
  private BigDecimal paidAmount    = BigDecimal.ZERO;
  private BigDecimal dueAmount     = BigDecimal.ZERO;
  private String     confirmed     = "";
  private StudentFeePaymentRequest slip;
  private int rowNum=0;

  public FeeCollectionExcelReport2(StudentFeePaymentRequest slip/*,BigDecimal extraHours*/)
  {
    this.slip=slip;
    Student student = slip.getStudent();

    admissionNumber = student.getAdmissionNumber();
    name = student.getName();
    id=student.getAdmissionNumber();
    sgst=slip.getSgst();
    gst=slip.getCgst();
    igst=slip.getIgst();
    centerName = student.getCenterName();
    programName = student.getProgramName();
    groupName = student.getGroupName();
    feeDuration = slip.getFeeDuration().toString();
    motherName=student.getMother().getFullName();
    FatherName=student.getFather().getFullName();
    month = FeeUtils.getMonthName(slip.getMonth());
    year = slip.getYear();
    quarter = FeeUtils.getFYQuarter(slip.getQuarter());
    raisedAmount = slip.getTotalFee();
    dueAmount = raisedAmount;

    paymentStatus = slip.getPaymentStatus().toString();
    // slip status is "Paid" or "PartiallyPaid"
    if (slip.getPaymentStatus() == PaymentStatus.Paid
        || slip.getPaymentStatus() == PaymentStatus.PartiallyPaid)
    {
      if (!CollectionUtils.isEmpty(slip.getPayments()))
      {
        paymentMode = slip.getPayments().get(0).getPaymentMode().toString();
      }
      paidAmount = slip.getPaidAmount();

      dueAmount = dueAmount.subtract(paidAmount);
      if (BigDecimalUtils.lessThen(dueAmount, new BigDecimal(5)))
      {
        dueAmount = BigDecimal.ZERO;
      }
    }

    if (slip.getPaymentStatus() == PaymentStatus.PartiallyPaid
        || slip.getPaymentStatus() == PaymentStatus.Paid)
    {
      boolean confirmed = true;
      for (StudentFeePaymentRecord payment : slip.getPayments())
      {
        if (payment.getConfirmed() == null || !payment.getConfirmed())
        {
          confirmed = false;
        }
      }
      this.confirmed = confirmed ? "Confirmed" : "Not Confirmed";

    }
  }

  public Sheet export(Sheet sheet, int rowNumber)
  {
    this.rowNum=rowNumber;
//    if(slip.getPayments().size()>=1)
//      this.rowNum++;

    for(StudentFeePaymentRecord record:slip.getPayments()){
      Row row = sheet.createRow(++this.rowNum);
      row.createCell(0, Cell.CELL_TYPE_STRING).setCellValue(this.rowNum-1);
      row.createCell(1, Cell.CELL_TYPE_STRING).setCellValue(id);
      row.createCell(2, Cell.CELL_TYPE_STRING).setCellValue(name);
      row.createCell(3, Cell.CELL_TYPE_STRING).setCellValue(centerName);
      row.createCell(4, Cell.CELL_TYPE_STRING).setCellValue(programName);
      row.createCell(5, Cell.CELL_TYPE_STRING).setCellValue(motherName);
      row.createCell(6, Cell.CELL_TYPE_STRING).setCellValue(FatherName);

      row.createCell(7, Cell.CELL_TYPE_STRING).setCellValue(raisedAmount.doubleValue());
      row.createCell(8, Cell.CELL_TYPE_NUMERIC).setCellValue(dueAmount.doubleValue());
      row.createCell(9, Cell.CELL_TYPE_STRING).setCellValue(paymentStatus);
      if(record.getTxnid()!=null)
        row.createCell(10, Cell.CELL_TYPE_STRING).setCellValue(record.getTxnid());
      row.createCell(11, Cell.CELL_TYPE_STRING).setCellValue(record.getPaymentDate().toString());
      row.createCell(12, Cell.CELL_TYPE_NUMERIC).setCellValue(record.getPaidAmount().doubleValue());
      this.paidAmount.add(new BigDecimal(record.getPaidAmount().doubleValue()));
      row.createCell(13, Cell.CELL_TYPE_STRING).setCellValue(record.getPaymentMode().name());
      row.createCell(14, Cell.CELL_TYPE_STRING).setCellValue(record.getConfirmed());
       }
    return sheet;
  }

  public static int createHeader(Sheet sheet, int rowNumber)
  {
    Row row = sheet.createRow(rowNumber);

    row.createCell(0, Cell.CELL_TYPE_STRING).setCellValue("S no.");
        row.createCell(1, Cell.CELL_TYPE_STRING).setCellValue("Addmision Id");
        row.createCell(2, Cell.CELL_TYPE_STRING).setCellValue("Student Name");
        row.createCell(3, Cell.CELL_TYPE_STRING).setCellValue("Center Name");
        row.createCell(4, Cell.CELL_TYPE_STRING).setCellValue("Program Name");
        row.createCell(5, Cell.CELL_TYPE_STRING).setCellValue("Mother Name");
    row.createCell(6, Cell.CELL_TYPE_STRING).setCellValue("Father Name");
    row.createCell(7, Cell.CELL_TYPE_STRING).setCellValue("Raised Amount");
    row.createCell(8, Cell.CELL_TYPE_STRING).setCellValue("Due Amount");
    row.createCell(9, Cell.CELL_TYPE_STRING).setCellValue("Payment Status");
    row.createCell(10, Cell.CELL_TYPE_STRING).setCellValue("TXN ID");
    row.createCell(11, Cell.CELL_TYPE_STRING).setCellValue("Payment Date");
    row.createCell(12, Cell.CELL_TYPE_STRING).setCellValue("Transaction Amount");
    row.createCell(13, Cell.CELL_TYPE_STRING).setCellValue("Payment Mode");
    row.createCell(14, Cell.CELL_TYPE_STRING).setCellValue("Confirmed");

    return rowNumber + 1;
  }

  public int getRowNum() {
    return rowNum;
  }

  public void setRowNum(int rowNum) {
    this.rowNum = rowNum;
  }

  public BigDecimal getRaisedAmount()
  {
    return raisedAmount;
  }

  public BigDecimal getPaidAmount()
  {
    return paidAmount;
  }

  public BigDecimal getDueAmount()
  {
    return dueAmount;
  }
}
