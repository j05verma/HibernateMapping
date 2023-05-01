package org.jsp.onetomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni.dto.Branch;

public class FetchBranch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the branch id to print the details");
		int id=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Branch branch=manager.find(Branch.class, id);
		if(branch!=null) {
			System.out.println(branch);
		}
		else {
			System.err.println("Branch Id"+id+" Is invalid");
		}
	}

}
