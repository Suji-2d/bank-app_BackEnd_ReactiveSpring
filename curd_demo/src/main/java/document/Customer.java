package document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	
	@Indexed(unique=true)
	private String userName;
	
	private String password;
	
	//@Indexed(name="userName",unique=true)
	private String emailId;
	
	//@Indexed(name="userName",unique=true)
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
	private String  citizenShip;
	private double  initialDepositAmount;
	private String  idProofType;
	private String  idDocumentNo;
		

}
