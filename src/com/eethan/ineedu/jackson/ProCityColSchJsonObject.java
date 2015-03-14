package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.City;
import com.eethan.ineedu.databasebeans.College;
import com.eethan.ineedu.databasebeans.Province;
import com.eethan.ineedu.databasebeans.School;

public class ProCityColSchJsonObject {

	public ProCityColSchJsonObject(){}
	
	public ProCityColSchJsonObject(List<Province> provinces, List<City> cities,
			List<College> colleges, List<School> schools) {
		super();
		this.provinces = provinces;
		this.cities = cities;
		this.colleges = colleges;
		this.schools = schools;
	}
	private List<Province> provinces;
	private List<City> cities;
	private List<College> colleges;
	private List<School> schools;
	public List<Province> getProvinces() {
		return provinces;
	}
	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<College> getColleges() {
		return colleges;
	}
	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}
	public List<School> getSchools() {
		return schools;
	}
	public void setSchools(List<School> schools) {
		this.schools = schools;
	}
}
