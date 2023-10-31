package application;

import model.entities.JsonData;
import model.entities.JsonReader;

public class Program {
	public static void main(String[] args) {
		JsonReader jr = new JsonReader();
		printPerson(jr, "./resources/person.json");
		printPeople(jr, "./resources/list.json");

	}

	public static void printPerson(JsonReader jr, String path) {
		JsonData jd = jr.readOneJson(path);

		System.out.println("Name: " + jd.getName());
		System.out.println("Age: " + jd.getAge());
		System.out.println("List: " + jd.getList());
		System.out.println("City: " + jd.getCity().getName() + ", " + jd.getCity().getState());
		System.out.println();
	}

	public static void printPeople(JsonReader jr, String path) {
		for (JsonData person : jr.readListJson(path)) {
			System.out.println("Name: " + person.getName());
			System.out.println("Age: " + person.getAge());
			System.out.println("List: " + person.getList());
			System.out.println("City: " + person.getCity().getName() + ", " + person.getCity().getState());
			System.out.println();
		}
	}
}
