package hw1.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "RUNNING_ANALYSIS")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RunningInformation {

    @Id
    @GeneratedValue
    private Long id;

    //private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate = 0;
    private Date timestamp = new Date();

    public enum HealthWarningLevel {
        HIGH, NORMAL, LOW;
    }
    private HealthWarningLevel healthWarningLevel;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "runningId", column = @Column(name = "runningId")),
            @AttributeOverride(name = "username", column = @Column(name = "userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userAddress"))
    })
    private UserInfo userInfo;


    public RunningInformation() {
        this.userInfo = null;
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId) {
        //this.runningId = runningId;
        this.userInfo = new UserInfo(runningId);
    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getRunningId() {
        return this.userInfo == null ? null : this.userInfo.getRunningId();
    }
}
