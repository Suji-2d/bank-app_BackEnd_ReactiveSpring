package document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	private String id;
	
	private String name;
	private String userName;
	private String pasword;
	private String emailId;
	private String contactNo;
	private String	guardianType;
	private String  guardianName;
	private String  address;
	private String  gender;
	private String  maritalStatus;
	private String  dateOfBirth;
	private String  registrationDate;
	private String  accountType;
	private String  branchName;
	private String  citizenStatus;
	private double  initialDepositAmount;
	private String  idProofType;
	private String  idDocumentNo;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGuardianType() {
		return guardianType;
	}

	public void setGuardianType(String guardianType) {
		this.guardianType = guardianType;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCitizenStatus() {
		return citizenStatus;
	}

	public void setCitizenStatus(String citizenStatus) {
		this.citizenStatus = citizenStatus;
	}

	public double getInitialDepositAmount() {
		return initialDepositAmount;
	}

	public void setInitialDepositAmount(double initialDepositAmount) {
		this.initialDepositAmount = initialDepositAmount;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdDocumentNo() {
		return idDocumentNo;
	}

	public void setIdDocumentNo(String idDocumentNo) {
		this.idDocumentNo = idDocumentNo;
	}

	public Customer(String id, String name, String userName, String pasword, String emailId, String contactNo,
			String guardianType, String guardianName, String address, String gender, String maritalStatus,
			String dateOfBirth, String registrationDate, String accountType, String branchName, String citizenStatus,
			double initialDepositAmount, String idProofType, String idDocumentNo) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.pasword = pasword;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.guardianType = guardianType;
		this.guardianName = guardianName;
		this.address = address;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
		this.accountType = accountType;
		this.branchName = branchName;
		this.citizenStatus = citizenStatus;
		this.initialDepositAmount = initialDepositAmount;
		this.idProofType = idProofType;
		this.idDocumentNo = idDocumentNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", userName=" + userName + ", pasword=" + pasword
				+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", guardianType=" + guardianType
				+ ", guardianName=" + guardianName + ", address=" + address + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", dateOfBirth=" + dateOfBirth + ", registrationDate=" + registrationDate
				+ ", accountType=" + accountType + ", branchName=" + branchName + ", citizenStatus=" + citizenStatus
				+ ", initialDepositAmount=" + initialDepositAmount + ", idProofType=" + idProofType + ", idDocumentNo="
				+ idDocumentNo + "]";
	}
	
	

}
