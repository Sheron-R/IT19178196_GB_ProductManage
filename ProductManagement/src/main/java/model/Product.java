package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Product {

	private Connection connect()
	 {
	 
		Connection con = null;
	
	try{
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    //Provide the correct details: DBServer/DBName-----------
	    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
	    
	 }catch (Exception e){
		 e.printStackTrace();}
	     return con;
	 } 
	
	//INSERT PRODUCT---------------------------
	public String insertProduct(String proname , String procode, String proqty ,String prodesc,String propri, String proavail)
	 {
	 
		String output = "";
	 
		try{
	 
			Connection con = connect();
	
			if (con == null){
				return "Error while connecting to the database for inserting.";
				}
	 
			// Create a prepared statement
	
			String query = " INSERT INTO `product`(`PID`, `productname`, `productcode`, `productquantity`, `productdescription`, `productprice`, `productavailable`)  VALUES  (?, ?, ?,?, ?, ?,?)";
	 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
	        // binding values
	        preparedStmt.setInt(1, 0);
	        preparedStmt.setString(2, proname);
	        preparedStmt.setString(3,procode );
	        preparedStmt.setString(4, proqty);
	        preparedStmt.setString(5, prodesc);
	        preparedStmt.setString(6, propri);
	        preparedStmt.setString(7, proavail);
	        
	     // execute the statement
	        
	        preparedStmt.execute(); 
	        con.close(); 
	        
	        String newProducts = readProducts(); 
	        output = "{\"status\":\"success\", \"data\": \"" + newProducts + "\"}"; 
	        } 
	        catch (Exception e) 
	        { 
	        	output = "{\"status\":\"error\", \"data\": \"Error while inserting the product\"}"; 
	        	System.err.println(e.getMessage()); 
	        } 
	        return output; 
	        } 
	
	//READ PRODUCT----------------------------------
	public String readProducts(){
	 
		String output = "";
	 
		try{
	
			Connection con = connect();
	 
			if (con == null){
				return "Error while connecting to the database for reading."; }
	 
			// Prepare the html table to be displayed
	
			output = "<table border='1'><tr><th>Product Name</th><th>Product Code</th>" +
	                "<th>Product Quantity</th>" +
	                "<th>Product Description</th>" +
	                "<th>Product Price</th>" +
	                "<th>Product Availability</th><th>Update</th><th>Remove</th></tr>";

	 
			String query = "SELECT * from product ";
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        // iterate through the rows in the result set
	            while (rs.next())
	            {
	            String PID= Integer.toString(rs.getInt("PID"));
	        	String productname = rs.getString("productname");
	            String productcode = rs.getString("productcode");
	            String productquantity = rs.getString("productquantity");
	            String productdescription = rs.getString("productdescription");
	            String productprice = rs.getString("productprice");
	            String productavailable = rs.getString("productavailable");
	            
	            
	            // Add into the html table
	
	            output += "<tr><td><input id='hidProductIDUpdate' name='hidProductIDUpdate' type='hidden' value='" + PID + "'>"
	            		 + productname + "</td>";
	            output += "<td>" + productcode + "</td>";
	            output += "<td>" + productquantity + "</td>";
	            output += "<td>" + productdescription + "</td>";
	            output += "<td>" + productprice + "</td>";
	            output += "<td>" + productavailable + "</td>";
	
	            // buttons
	            output += "<td><input name='btnUpdate' type='button' value='Update' "
	            		+ "class='btnUpdate btn btn-secondary' data-productid='" + PID + "'></td>"
	            		+ "<td><input name='btnRemove' type='button' value='Remove' "
	            		+ "class='btnRemove btn btn-danger' data-productid='" + PID + "'></td></tr>";
	            		} 
	        
	 
	        con.close();
	        // Complete the html table
	        output += "</table>";
	 
		}catch (Exception e){
	 
			output = "Error while reading the products.";
	        System.err.println(e.getMessage());
	 
		}
	
		return output;
	 } 
	
		
	//DELETE PRODUCT------------------------------------
	public String deleteProduct(String PID){
	 
		String output = "";
	
		try {
	 
			Connection con = connect();
	
			if (con == null){
				return "Error while connecting to the database for deleting.";
				}
	
			 // create a prepared statement
	         String query = "DELETE FROM `product` WHERE `PID`=?";
	         PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	         // binding values
	         preparedStmt.setInt(1, Integer.parseInt(PID));
	 
	         // execute the statement
	         preparedStmt.execute();
	         con.close();
	         
	         String newProducts = readProducts(); 
	         output = "{\"status\":\"success\", \"data\": \"" + 
	         newProducts + "\"}";
	         
		}catch (Exception e){
			
	 
			output = "{\"status\":\"error\", \"data\" \"Error while deleting the product\"}"; 
					 System.err.println(e.getMessage()); 
	
		}
	
		return output;
	 }
	
	//UPDATE PRODUCT----------------------------
		public String updateProduct(String PID , String proname , String procode, String proqty ,String prodesc,String propri ,String proavail){
		 
			String output = "";
		 
			try{
		 
				Connection con = connect();
		 
				if (con == null){
					return "Error while connecting to the database for updating.";
					}
		 
				// create a prepared statement
		        String query = "UPDATE `product` SET `productname`=?,`productcode`=?,`productquantity`=?,`productdescription`=?,`productprice`=?, `productavailable`=?WHERE `PID`=?";
		        PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		        // binding values
		        preparedStmt.setString(1, proname);
		        preparedStmt.setString(2, procode);
		        preparedStmt.setString(3, proqty);
		        preparedStmt.setString(4, prodesc);
		        preparedStmt.setString(5, propri);
		        preparedStmt.setString(6, proavail);
		        preparedStmt.setInt(7, Integer.parseInt(PID));
		
		        // execute the statement
		        preparedStmt.execute();
		        con.close();
		        
		        String newProducts = readProducts(); 
		        output = "{\"status\":\"success\", \"data\": \"" + 
		        newProducts + "\"}";
		        
			}catch (Exception e){
		 
				output = "{\"status\":\"error\", \"data\":\"Error while updating the product\"}"; 
						 System.err.println(e.getMessage()); 
		 
			}
		
			return output;
		 } 


}