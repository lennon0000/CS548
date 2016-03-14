package edu.stevens.cs548.clinic.test;

public class subString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://ec2-54-68-175-158.us-west-2.compute.amazonaws.com:8080/ClinicRestWebService/resources/patient/51";
		String[] u = url.split("patient/"); 
		
		System.out.println(u[1]);
	}

}
