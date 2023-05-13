package ai.openfabric.api.controller;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("${node.api.path}/worker")
public class WorkerController {

    @Autowired
    public WorkerRepository workerRepository;


    @PostMapping(path = "/hello")
    public @ResponseBody String hello(@RequestBody String name) {
        return "Hello!" + name;
    }


    @GetMapping("/workers/{offset}/{pageSize}")
    public List<String> getWorkers(@PathVariable int offset, @PathVariable int pageSize) {
        List<String> workerList = new ArrayList<String>();
        workerRepository.findAll(PageRequest.of(offset, pageSize)).forEach(worker -> {
            workerList.add(worker.getName());
            });
        Collections.sort(workerList);
        return workerList;
        }

    @GetMapping("/{id}")
    public Worker getWorkerById(@PathVariable String id)
    {
        Worker tempWorker = workerRepository.findById(id).get();
        return tempWorker;
    }
    }



