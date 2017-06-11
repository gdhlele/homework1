package hw1.service;

import hw1.domain.RunningInformation;
import hw1.domain.RunningInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class RunningInformationAnalysisServiceImpl implements RunningInformationAnalysisService{

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationAnalysisServiceImpl(RunningInformationRepository runningInformationRepository) {
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation) {

        for (RunningInformation info: runningInformation) {
            info.setHeartRate((int)(Math.random()*140 + 60));

            if (info.getHeartRate() > 120) {
                info.setHealthWarningLevel(RunningInformation.HealthWarningLevel.HIGH);
            }
            else if (info.getHeartRate() > 75) {
                info.setHealthWarningLevel(RunningInformation.HealthWarningLevel.NORMAL);
            }
            else {
                info.setHealthWarningLevel(RunningInformation.HealthWarningLevel.LOW);
            }
        }
        return this.runningInformationRepository.save(runningInformation);
    }

    @Override
    public void deleteByRunningId(String runningId) {

        this.runningInformationRepository.deleteByRunningId(runningId);
    }

    @Override
    public Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable) {
        return this.runningInformationRepository.findAllByOrderByHeartRateDesc(pageable);
    }
}
