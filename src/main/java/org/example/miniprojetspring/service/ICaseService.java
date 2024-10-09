package org.example.miniprojetspring.service;

import org.example.miniprojetspring.dto.CaseDto;

public interface ICaseService {

    CaseDto getCaseById(int caseId);

    CaseDto updateCase(int caseId,CaseDto caseDto);
    CaseDto createCase(CaseDto createdCaseDto);
    void deleteCase(int caseId);

}
