package org.jsp.onetomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni.dto.Hospital;

public class FetchHospital {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Hospital Id to print the hospital details");
		int id=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Hospital hospital=manager.find(Hospital.class, id);
		if(hospital!=null)
		{
			System.out.println(hospital);
		}
		else {
			System.err.println("Hospital Id: "+id+" Is Invalid");
		}
	}

}
