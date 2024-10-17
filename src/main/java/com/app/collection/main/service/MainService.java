package com.app.collection.main.service;

import com.app.collection.main.dao.Member;
import com.app.collection.main.repository.MemoryMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MainService {

    private final MemoryMemberRepository memoryMemberRepository;

    public String main() {

        memoryMemberRepository.save();
        memoryMemberRepository.save();
        return memoryMemberRepository.findAll().toString();
    }
}
