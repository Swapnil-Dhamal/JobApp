package com.swapnil.JobApp.service;

import com.swapnil.JobApp.entity.JobEntity;
import com.swapnil.JobApp.repo.JobRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class JobService {


    private JobRepo jobRepo;


    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }



    public JobEntity createJob(JobEntity jobEntity) {
        return jobRepo.save(jobEntity);

    }

    public Optional<JobEntity> getJob(Long id) {
        return jobRepo.findById(id);
    }

    public List<JobEntity> getAllJobs() {
        return jobRepo.findAll();
    }

    public JobEntity updateJob(Long id, JobEntity jobEntity) {

        JobEntity existingJob = jobRepo.findById(id)
                .orElseThrow(()-> new JobNotFoundException(id));

        existingJob.setPostProfile(jobEntity.getPostProfile());
        existingJob.setPostDesc(jobEntity.getPostDesc());
        existingJob.setReqExperience(jobEntity.getReqExperience());
        existingJob.setPostTechStack(jobEntity.getPostTechStack());
        jobRepo.save(existingJob);
        return existingJob;

    }

    public void deleteJob(Long id) {

        if(jobRepo.existsById(id)){
            jobRepo.deleteById(id);
        }

        else {
            throw new JobNotFoundException(id);
        }
    }


    private class JobNotFoundException extends IllegalArgumentException {
        public JobNotFoundException(Long id) {

            super("Job with "+id+" not found");
        }
    }
}
