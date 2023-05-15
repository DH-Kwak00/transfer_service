package com.example.kakao.evidence.repository;

import com.example.kakao.evidence.domain.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadYnRepository extends JpaRepository<Evidence, String>{


}
