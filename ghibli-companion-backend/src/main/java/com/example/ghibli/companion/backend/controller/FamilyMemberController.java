package com.example.ghibli.companion.backend.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ghibli.companion.backend.entity.FamilyMember;
import com.example.ghibli.companion.backend.service.FamilyMemberService;
@RestController
@RequestMapping("/api/family_members")
public class FamilyMemberController {
    @Autowired
    private FamilyMemberService service;
    @GetMapping
    public List<FamilyMember> getAllFamilyMembers() {
        return service.getAllFamilyMembers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<FamilyMember> getFamilyMemberById(@PathVariable Long id) {
        Optional<FamilyMember> familyMember = service.getFamilyMemberById(id);
        return familyMember.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public FamilyMember createFamilyMember(@RequestBody FamilyMember familyMember) {
        return service.createFamilyMember(familyMember);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FamilyMember> updateFamilyMember(@PathVariable Long id, @RequestBody FamilyMember familyMember) {
        FamilyMember updated = service.updateFamilyMember(id, familyMember);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFamilyMember(@PathVariable Long id) {
        return service.deleteFamilyMember(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}