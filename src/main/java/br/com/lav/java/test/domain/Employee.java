package br.com.lav.java.test.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/***
 * Class Employee, POJO to bind JSON Rest response
 * @author laverson
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "salary", "manager", "gcm", "project", "role", "skill", "certification" })
public class Employee {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("salary")
	private String salary;
	@JsonProperty("manager")
	private String manager;
	@JsonProperty("gcm")
	private String gcm;
	@JsonProperty("project")
	private List<Project> project = null;
	@JsonProperty("role")
	private Role role;
	@JsonProperty("skill")
	private List<Skill> skill = null;
	@JsonProperty("certification")
	private List<String> certification = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("salary")
	public String getSalary() {
		return salary;
	}

	@JsonProperty("salary")
	public void setSalary(String salary) {
		this.salary = salary;
	}

	@JsonProperty("manager")
	public String getManager() {
		return manager;
	}

	@JsonProperty("manager")
	public void setManager(String manager) {
		this.manager = manager;
	}

	@JsonProperty("gcm")
	public String getGcm() {
		return gcm;
	}

	@JsonProperty("gcm")
	public void setGcm(String gcm) {
		this.gcm = gcm;
	}

	@JsonProperty("project")
	public List<Project> getProject() {
		return project;
	}

	@JsonProperty("project")
	public void setProject(List<Project> project) {
		this.project = project;
	}

	@JsonProperty("role")
	public Role getRole() {
		return role;
	}

	@JsonProperty("role")
	public void setRole(Role role) {
		this.role = role;
	}

	@JsonProperty("skill")
	public List<Skill> getSkill() {
		return skill;
	}

	@JsonProperty("skill")
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	@JsonProperty("certification")
	public List<String> getCertification() {
		return certification;
	}

	@JsonProperty("certification")
	public void setCertification(List<String> certification) {
		this.certification = certification;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}