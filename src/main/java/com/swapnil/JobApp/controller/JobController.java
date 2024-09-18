package com.swapnil.JobApp.controller;

import com.swapnil.JobApp.entity.JobEntity;
import com.swapnil.JobApp.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/addJob")
    public ResponseEntity<JobEntity> addJob(@RequestBody JobEntity jobEntity){
        var job=jobService.createJob(jobEntity);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/getJob/{id}")
    public ResponseEntity<Optional<JobEntity>> getJob(@PathVariable("id") Long id){
        var job=jobService.getJob(id);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<JobEntity>> getAllJobs(){
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JobEntity> updateJob(@PathVariable("id") Long id, @RequestBody JobEntity jobEntity){
        var job=jobService.updateJob(id, jobEntity);
        return ResponseEntity.ok(job);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable("id") Long id){
        jobService.deleteJob(id);
    }

}
