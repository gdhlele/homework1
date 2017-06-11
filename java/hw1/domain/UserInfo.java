package hw1.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data

public class UserInfo {


    private String runningId;
    private String username;
    private String address;

    public UserInfo() {
        this.runningId = "";
    }

    public UserInfo(String runningId) {
        this.runningId = runningId;
    }

    public UserInfo(String runningId, String username, String address) {
        this.runningId = runningId;
        this.username = username;
        this.address = address;
    }
}
