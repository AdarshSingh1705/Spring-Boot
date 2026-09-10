package com.adarsh.transaction.repository;

import com.adarsh.transaction.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord, Long> {

}
