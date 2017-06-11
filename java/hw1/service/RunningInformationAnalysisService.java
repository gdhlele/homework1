package hw1.service;

import hw1.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;



public interface RunningInformationAnalysisService {

    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation);

    void deleteByRunningId(String runningId);

    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);

}
