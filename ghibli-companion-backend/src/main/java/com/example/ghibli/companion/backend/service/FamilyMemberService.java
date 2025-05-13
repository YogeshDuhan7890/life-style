package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.FamilyMember;
import com.example.ghibli.companion.backend.repository.FamilyMemberRepository;
@Service
public class FamilyMemberService {
    @Autowired
    private FamilyMemberRepository repository;
    public List<FamilyMember> getAllFamilyMembers() {
        return repository.findAll();
    }
    public Optional<FamilyMember> getFamilyMemberById(Long id) {
        return repository.findById(id);
    }
    public FamilyMember createFamilyMember(FamilyMember familyMember) {
        return repository.save(familyMember);
    }
    public FamilyMember updateFamilyMember(Long id, FamilyMember familyMember) {
        if (repository.existsById(id)) {
            familyMember.setId(id);
            return repository.save(familyMember);
        }
        return null;
    }
    public boolean deleteFamilyMember(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}