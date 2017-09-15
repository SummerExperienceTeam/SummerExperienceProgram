import java.awt.List;

public class FilterDb {



public List<Student> getAllExperiences() throws Exception {
	List<Student> list = new ArrayList<>();
	
	Statement myStatment = null;
	ResultSet myResults = null;
	
	try {
		myStatment = myConn.createStatement();
		myResults = myStatment.executeQuery("select * from experiences");
		
		while (myResults.next()) {
			Experience tempExperience = convertRowToExperience(myResults);
			list.add(tempExperience);  
		}

		return list;		
	}
	finally {
		close(myStatment, myResults);
	}
}

public List<Student> searchEmployees(String lastName) throws Exception {
	List<Student> list = new ArrayList<>();

	PreparedStatement myStmt = null;
	ResultSet myResults = null;

	try {
		lastName += "%";
		myStmt = myConn.prepareStatement("select * from students where last_name like ?");
		
		myStmt.setString(1, lastName);
		
		myResults = myStmt.executeQuery();
		
		while (myResults.next()) {
			Experience tempExperience = convertRowToExperience(myResults);
			list.add(tempExperience);
		}
		
		return list;
	}
	finally {
		close(myStmt, myResults);
	}
}

private Experience convertRowToExperience(ResultSet myResults) throws SQLException {
	
	int id = myResults.getInt("id");
	String lastName = myResults.getString("last_name");
	String firstName = myResults.getString("first_name");
	String email = myResults.getString("email");
	BigDecimal salary = myResults.getBigDecimal("salary");
	
	Experience tempExperience = new Experience(id, lastName, firstName, email, salary);
	
	return tempExperience;
}
