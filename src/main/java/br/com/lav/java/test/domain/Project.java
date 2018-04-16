package br.com.lav.java.test.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/***
 * Project class POJO to bind JSON Rest response
 * @author laverson
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "valueOfProject", "dateBegin", "dateEnd", "customer" })
public class Project {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("valueOfProject")
	private String valueOfProject;
	@JsonProperty("dateBegin")
	private String dateBegin;
	@JsonProperty("dateEnd")
	private String dateEnd;
	@JsonProperty("customer")
	private String customer;
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

	@JsonProperty("valueOfProject")
	public String getValueOfProject() {
		return valueOfProject;
	}

	@JsonProperty("valueOfProject")
	public void setValueOfProject(String valueOfProject) {
		this.valueOfProject = valueOfProject;
	}

	@JsonProperty("dateBegin")
	public String getDateBegin() {
		return dateBegin;
	}

	@JsonProperty("dateBegin")
	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	@JsonProperty("dateEnd")
	public String getDateEnd() {
		return dateEnd;
	}

	@JsonProperty("dateEnd")
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	@JsonProperty("customer")
	public String getCustomer() {
		return customer;
	}

	@JsonProperty("customer")
	public void setCustomer(String customer) {
		this.customer = customer;
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

	
}