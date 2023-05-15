package com.example.kakao.evidence.domain;

import com.example.kakao.user_Info.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Evidence {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    private String file_path;

    @CreatedDate
    private LocalDateTime createDate;

    @Builder
    public Evidence(User user, String file_path){
        this.user = user;
        this.file_path = file_path;
    }

}
