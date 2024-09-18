package com.swapnil.JobApp.repo;


import com.swapnil.JobApp.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobEntity, Long> {
}
