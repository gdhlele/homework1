
package hw1.rest;

import hw1.domain.RunningInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import hw1.service.RunningInformationAnalysisService;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class RunningInformationRestController {

    private RunningInformationAnalysisService runningInformationAnalysisService;

    @Autowired
    public RunningInformationRestController(RunningInformationAnalysisService runningInformationAnalysisService) {
        this.runningInformationAnalysisService = runningInformationAnalysisService;
    }


    @RequestMapping(value = "uploadInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformation) {
        this.runningInformationAnalysisService.saveRunningInformation(runningInformation);
    }

    @RequestMapping(value = "deleteInfo/{runningId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String runningId) {
        this.runningInformationAnalysisService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "getRankedInfo", method = RequestMethod.GET)
    public Page<RunningInformation> get(@RequestParam(name = "page") int page){
        return this.runningInformationAnalysisService.findAllByOrderByHeartRateDesc(new PageRequest(page, 2));
    }

}
