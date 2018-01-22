
package java.pojofile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Employee Details
 * <p>
 * validate the employee details it is correct or wrong
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "company",
    "phone_number",
    "salary",
    "experience",
    "age",
    "email"
})
public class Employee {

    @JsonProperty("name")
    private Object name;
    @JsonProperty("company")
    private String company;
    @JsonProperty("phone_number")
    private List<Object> phoneNumber = new ArrayList<Object>();
    @JsonProperty("salary")
    private Salary salary;
    @JsonProperty("experience")
    private Boolean experience;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("email")
    private String email;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public Object getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Object name) {
        this.name = name;
    }

    public Employee withName(Object name) {
        this.name = name;
        return this;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    public Employee withCompany(String company) {
        this.company = company;
        return this;
    }

    @JsonProperty("phone_number")
    public List<Object> getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phone_number")
    public void setPhoneNumber(List<Object> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee withPhoneNumber(List<Object> phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @JsonProperty("salary")
    public Salary getSalary() {
        return salary;
    }

    @JsonProperty("salary")
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Employee withSalary(Salary salary) {
        this.salary = salary;
        return this;
    }

    @JsonProperty("experience")
    public Boolean getExperience() {
        return experience;
    }

    @JsonProperty("experience")
    public void setExperience(Boolean experience) {
        this.experience = experience;
    }

    public Employee withExperience(Boolean experience) {
        this.experience = experience;
        return this;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee withAge(Integer age) {
        this.age = age;
        return this;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public Employee withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
