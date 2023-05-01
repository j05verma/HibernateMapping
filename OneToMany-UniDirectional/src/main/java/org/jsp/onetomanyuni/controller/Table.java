package org.jsp.onetomanyuni.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Table {
public static void main(String[] args) {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	System.out.println(factory);
}
}
