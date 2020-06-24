package com.example.demo.repository;

import com.example.demo.model.VerificationTokenUserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenUserAdminRepo extends JpaRepository<VerificationTokenUserAdmin, Long> {

    VerificationTokenUserAdmin findByValueUser(String value);
    VerificationTokenUserAdmin findByValueAdmin(String value);


}
