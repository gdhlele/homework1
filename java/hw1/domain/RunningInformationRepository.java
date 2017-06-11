package hw1.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



//@RepositoryRestResource(path = "runningInformation")
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long>{

    //@RestResource(path = "getInformation")
    //Page<RunningInformation> findByRunningId(@Param("runningId") Long id, Pageable pageable);

    //@RestResource(path = "get")
    //@Query(value = "select r.runningId, r.totalRunningTime, r.heartRate, r.healthWarningLevel, r.UserInfo " +
    //               "from RunningInformation r order by healthWarningLevel desc")
    @Query(value = "select r from RunningInformation r order by r.healthWarningLevel desc")
    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);

    //@RestResource(path = "delete")
    @Query(value = "delete from RunningInformation r where r.id = runningId")
    void deleteByRunningId(@Param("runningId") String runningId);
}
