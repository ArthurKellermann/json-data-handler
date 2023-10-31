package model.entities;

import java.util.ArrayList;
import java.util.List;

public class JsonData {
	private String name;
	private int age;
	private List<String> list;
	private City city;
	
	public JsonData() {
		list = new ArrayList<>();
		city = new City();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "| NAME: " + name + " | AGE: " + age + " | LIST: " + list + " | CITY: " + city + "|\n";
	}
	
	
}
