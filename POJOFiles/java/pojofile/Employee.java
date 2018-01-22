
package java.pojofile;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
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
    "field",
    "name",
    "company",
    "phone_number",
    "salary",
    "experience",
    "age",
    "email"
})
public class Employee {

    @JsonProperty("field")
    private Employee.Field field;
    @JsonProperty("name")
    private Object name;
    @JsonProperty("company")
    private String company;
    @JsonProperty("phone_number")
    private Integer phoneNumber;
    @JsonProperty("salary")
    private Integer salary;
    @JsonProperty("experience")
    private Integer experience;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("email")
    private String email;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("field")
    public Employee.Field getField() {
        return field;
    }

    @JsonProperty("field")
    public void setField(Employee.Field field) {
        this.field = field;
    }

    public Employee withField(Employee.Field field) {
        this.field = field;
        return this;
    }

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
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phone_number")
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee withPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @JsonProperty("salary")
    public Integer getSalary() {
        return salary;
    }

    @JsonProperty("salary")
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee withSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    @JsonProperty("experience")
    public Integer getExperience() {
        return experience;
    }

    @JsonProperty("experience")
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Employee withExperience(Integer experience) {
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

    @Generated("org.jsonschema2pojo")
    public static enum Field {

        DEVELOPEMENT("Developement"),
        TESTING("Testing"),
        TECH_SUPPORT("Tech-Support"),
        DESIGNER("Designer");
        private final String value;
        private static Map<String, Employee.Field> constants = new HashMap<String, Employee.Field>();

        static {
            for (Employee.Field c: Employee.Field.values()) {
                constants.put(c.value, c);
            }
        }

        private Field(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static Employee.Field fromValue(String value) {
            Employee.Field constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
