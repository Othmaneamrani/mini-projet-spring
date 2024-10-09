package org.example.miniprojetspring.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.miniprojetspring.dto.CaseDto;
import org.example.miniprojetspring.entity.Case;
import org.example.miniprojetspring.mapper.ICaseMapper;
import org.example.miniprojetspring.repository.ICaseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Transactional
@Service
public class ICaseServiceImpl implements ICaseService {


    private ICaseRepository iCaseRepository;
    private ICaseMapper iCaseMapper;

    @Override
    public CaseDto getCaseById(int caseId) {

        Optional<Case> byId = iCaseRepository.findById(caseId);
        if (byId.isPresent()){
            return iCaseMapper.convertEntityToDto(byId.get());

            }else throw new RuntimeException("Case not found.");
    }

    @Override
    public CaseDto updateCase(int caseId,CaseDto caseDto) {
        Optional<Case> byId = iCaseRepository.findById(caseId);
        if (byId.isPresent()){
            Case updatedCase = iCaseMapper.convertDtoToEntity(caseDto);
            updatedCase.setCaseId(caseId);
            iCaseRepository.save(updatedCase);
            return iCaseMapper.convertEntityToDto(updatedCase);
        }else throw new RuntimeException("Case not found.");
    }

    @Override
    public CaseDto createCase(CaseDto createdCaseDto) {
        Case createdCase = iCaseMapper.convertDtoToEntity(createdCaseDto);
        Case save = iCaseRepository.save(createdCase);
        return iCaseMapper.convertEntityToDto(save);
    }


    @Override
    public void deleteCase(int caseId) {
        Optional<Case> byId = iCaseRepository.findById(caseId);
        if (byId.isPresent()){
            iCaseRepository.delete(byId.get());
        }else throw new RuntimeException("Case not found.");
    }
}
