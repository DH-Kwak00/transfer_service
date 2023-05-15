package com.example.kakao.transferList.repository;

import com.example.kakao.transferList.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
