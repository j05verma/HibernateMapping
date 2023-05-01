package org.jsp.onetomanyuni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni.dto.Branch;
import org.jsp.onetomanyuni.dto.Hospital;

public class SaveHospitalAndBranch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.err.println("1.Hospital Name \n2. GST No \n3. Founder Name");
		String Hname = sc.nextLine();
		String gst = sc.next();
		String founder = sc.next();
		Hospital hospital = new Hospital();
		hospital.setName(Hname);
		hospital.setGst(gst);
		hospital.setFounder(founder);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		List<Branch> branchs = new ArrayList<Branch>();
		hospital.setBranchs(branchs);
		while (true) {
			System.out.println("do you want more branch to add enter 1 otherwise no for 0 ");
			int st = sc.nextInt();
			if (st == 1) {
				System.err.println("1. Branch Name \n2. Email \n3. Phone ");
				String bname = sc.next();
				String email = sc.next();
				long phone = sc.nextLong();
				Branch branch = new Branch();
				branch.setName(bname);
				branch.setEmail(email);
				branch.setPhone(phone);
				hospital.getBranchs().add(branch);
				manager.persist(hospital);
				transaction.begin();
				transaction.commit();
			}
			if (st == 0) {
				break;
			}
		}

		System.out.println("Record Inserted");

	}

}
