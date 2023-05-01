package org.jsp.onetomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni.dto.Branch;
import org.jsp.onetomanyuni.dto.Hospital;

public class FetchBranchByHospitalId {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Hospital Id to print the branch details");
		int hid=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Hospital hospital=manager.find(Hospital.class, hid);
		if(hospital!=null) {
			List<Branch> branchs=hospital.getBranchs();
			for(Branch b: branchs)
			{
				System.out.println(b);
			}
		}
		else {
			System.err.println("Invalid Hospital ID");
		}
	}

}
