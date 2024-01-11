package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class ClearJson {
    @JsonProperty("list")
    private Map<String, List<Contact>> list;
    public Map<String, List<Contact>> getPerson() {
        return list;
    }
    public void setPerson(Map<String, List<Contact>> list) {
        this.list = list;
    }

    public static class Contact {
        @JsonProperty("firstName")
        private String firstName;

        @JsonProperty("lastName")
        private String lastName;

        @JsonProperty("gender")
        private String gender;

        @JsonProperty("age")
        private String age;

        @JsonProperty("number")
        private String phoneNum;

        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public String getGender() {
            return gender;
        }
        public void getGender(String gender) {
            this.gender = gender;
        }
        public String getAge() {
            return age;
        }
        public void getAge(String age) {
            this.age = age;
        }
        public String getPhoneNum() {
            return phoneNum;
        }
        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }
    }

}

