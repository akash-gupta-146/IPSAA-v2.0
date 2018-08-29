<div>&nbsp;</div>

<table style="width: 100%" class="">
  <tbody>
  <tr>
    <td style="width: 180px;">Employee Code</td>
    <td style="width: 280px;">:&nbsp;&nbsp;${paySlip.eid}</td>
    <td style="width: 210px;">PAN</td>
    <td style="width: 350px;">:&nbsp;&nbsp;${paySlip.pan}</td>
  </tr>
  <tr>
    <td style="width: 180px;">Employee Name</td>
    <td style="width: 280px;">:&nbsp;&nbsp;${paySlip.empName}</td>
    <td style="width: 210px;">UAN</td>
    <td style="width: 350px;">:&nbsp;&nbsp;${paySlip.uan}</td>
  </tr>
  <tr>
    <td style="width: 180px;">Designation</td>
    <td style="width: 280px;">:&nbsp;&nbsp;${paySlip.empDesignation}</td>
    <td style="width: 210px;vertical-align: top;">PF Acc No.</td>
    <td style="width: 350px;vertical-align: top;">:&nbsp;&nbsp;${paySlip.pfan}</td>
  </tr>
  <tr>
    <td style="width: 180px;vertical-align: top;">Location</td>
    <td style="width: 280px;vertical-align: top;">:&nbsp;&nbsp;${paySlip.centerName}</td>
    <td style="width: 210px;">ESI Number</td>
    <td style="width: 350px;">:&nbsp;&nbsp;${paySlip.esin}</td>
  </tr>
  <tr>
    <td style="width: 210px;">Bank Acc. No.</td>
    <td style="width: 350px;">:&nbsp;&nbsp;${paySlip.ban}</td>
    <td style="width: 180px;">Date Of Joining</td>
    <td style="width: 280px;">:&nbsp;&nbsp;${paySlip.doj}</td>
  </tr>
  <tr>
    <td style="width: 210px;vertical-align: top;">Presents/Total</td>
    <td style="width: 210px;vertical-align: top;">:&nbsp;&nbsp;${paySlip.presents}/${paySlip.totalDays}</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  </tbody>
</table><#--Employee details table-->

<div>&nbsp;</div>

<table style="width: 100%;" class="border">
  <tbody>
  <tr>
    <td style="width: 237px;"><strong>Earnings</strong></td>
    <td style="width: 100px;"><strong>&nbsp;</strong></td>
    <td style="width: 195px;"><strong>Deductions</strong></td>
    <td style="width: 121px;">&nbsp;</td>
  </tr>
  <tr>
    <td style="width: 237px;">Basic Salary</td>
    <td style="width: 100px;">${paySlip.basic}</td>
    <td style="width: 195px;">Provident Fund</td>
    <td style="width: 121px;">${paySlip.pfe}</td>
  </tr>
  <tr>
    <td style="width: 237px;">House Rent Allowance</td>
    <td style="width: 100px;">${paySlip.hra}</td>
    <td style="width: 195px;">ESIC</td>
    <td style="width: 121px;">${paySlip.esi}</td>
  </tr>
  <tr>
    <td style="width: 237px;">Conveyance Allowance</td>
    <td style="width: 100px;">${paySlip.conveyance}</td>
    <td style="width: 195px;">Professional Tax</td>
<<<<<<< HEAD
    <td style="width: 121px;"><#if paySlip.professionalTax> ${paySlip.professionalTax} </#if> </td>
=======
    <td style="width: 121px;"><#if paySlip.professionalTax??>${paySlip.professionalTax}</#if></td>
>>>>>>> ea03804d55a92fd5a9d14b67a679fb1e53b79cb6
  </tr>
  <tr>
    <td style="width: 195px;">Special Allowance</td>
    <td style="width: 121px;">${paySlip.special}</td>
    <td style="width: 195px;">Other Deductions</td>
    <td style="width: 121px;">${paySlip.otherDeductions}</td>
  </tr>
  <tr>
    <td style="width: 237px;">Bonus</td>
    <td style="width: 100px;">${paySlip.bonus}</td>
    <td style="width: 237px;">TDS</td>
    <td style="width: 100px;">${paySlip.tds}</td>
  </tr>
  <tr>
    <td style="width: 237px;">Fixed Monthly Allowance</td>
<<<<<<< HEAD
    <td style="width: 100px;"><#if paySlip.extraMonthlyAllowance>${paySlip.extraMonthlyAllowance}</#if></td>
=======
    <td style="width: 100px;"><#if paySlip.extraMonthlyAllowance??>${paySlip.extraMonthlyAllowance}</#if></td>
>>>>>>> ea03804d55a92fd5a9d14b67a679fb1e53b79cb6
    <td style="width: 237px;">&nbsp;</td>
    <td style="width: 100px;">&nbsp;</td>
  </tr>
  <tr>
    <td style="width: 237px;">Other Allowance</td>
    <td style="width: 100px;">${paySlip.otherAllowances}</td>
    <td style="width: 237px;">&nbsp;</td>
    <td style="width: 100px;">&nbsp;</td>
  </tr>
  <tr>
    <td style="width: 237px;">Total Earning</td>
    <td style="width: 100px;">${paySlip.totalEarning}</td>
    <td style="width: 195px;">Total Deduction</td>
    <td style="width: 121px;">${paySlip.totalDeduction}</td>
  </tr>
  <tr>
    <td style="width: 237px;">&nbsp;</td>
    <td style="width: 100px;">&nbsp;</td>
    <td style="width: 195px;"><strong>NET Amount</strong></td>
    <td style="width: 121px;">${paySlip.netSalary}</td>
  </tr>
  </tbody>
</table>

<div>&nbsp;</div>

<table style="width: 100%;">
    <tbody>
        <tr>
            <td>Amount (in words):</td>
            <td></td>
        </tr>
        <tr>
            <td colspan="2">
                <strong>Indian Rupees </strong>
                <span style="padding: 0 15px;border-bottom: 1px solid">${amountWords}</span>
                <strong>Only</strong>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td style="text-align: right;">Authorized Signatory</td>
        </tr>
    </tbody>
</table>
