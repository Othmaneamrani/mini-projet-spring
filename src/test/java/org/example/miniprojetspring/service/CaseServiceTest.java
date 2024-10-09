package org.example.miniprojetspring.service;


import org.example.miniprojetspring.dto.CaseDto;
import org.example.miniprojetspring.entity.Case;
import org.example.miniprojetspring.mapper.ICaseMapper;
import org.example.miniprojetspring.repository.ICaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CaseServiceTest {

    @Mock
    private ICaseRepository iCaseRepository;

    @Mock
    private ICaseMapper iCaseMapper;

    @InjectMocks
    private ICaseServiceImpl iCaseService;




    @Test
    public void getCaseByIdTest (){
        int caseId = 1;
        Case case1 = Case.builder().caseId(1).build();
        CaseDto caseDto = CaseDto.builder().caseIdDto(1).build();

        when(iCaseMapper.convertEntityToDto(case1)).thenReturn(caseDto);
        when(iCaseRepository.findById(caseId)).thenReturn(Optional.of(case1));


        CaseDto result = iCaseService.getCaseById(caseId);

        assertNotNull(result);
        verify(iCaseMapper).convertEntityToDto(case1);
        verify(iCaseRepository).findById(caseId);

    }




    @Test
    public void createCaseTest(){
        Case case1 = Case.builder().build();
        CaseDto caseDto = CaseDto.builder().build();

        when(iCaseMapper.convertDtoToEntity(caseDto)).thenReturn(case1);
        when(iCaseRepository.save(case1)).thenReturn(case1);
        when(iCaseMapper.convertEntityToDto(case1)).thenReturn(caseDto);

        CaseDto result = iCaseService.createCase(caseDto);

        assertNotNull(result);
        verify(iCaseMapper).convertDtoToEntity(caseDto);
        verify(iCaseRepository).save(case1);
        verify(iCaseMapper).convertEntityToDto(case1);

    }




    @Test
    public void updateCaseTest(){
        Case case1 = Case.builder().build();
        CaseDto caseDto = CaseDto.builder().build();
        int caseId = 1;

        when(iCaseRepository.findById(caseId)).thenReturn(Optional.of(case1));
        when(iCaseMapper.convertDtoToEntity(caseDto)).thenReturn(case1);
        when(iCaseRepository.save(case1)).thenReturn(case1);
        when(iCaseMapper.convertEntityToDto(case1)).thenReturn(caseDto);


        CaseDto result = iCaseService.updateCase(caseId,caseDto);

        assertNotNull(result);
        verify(iCaseRepository).findById(caseId);
        verify(iCaseMapper).convertDtoToEntity(caseDto);
        verify(iCaseRepository).save(case1);
        verify(iCaseMapper).convertEntityToDto(case1);


    }




    @Test
    public void deleteCaseTest(){
        int caseId = 1;
        Case case1 = Case.builder().caseId(1).build();

        when(iCaseRepository.findById(caseId)).thenReturn(Optional.of(case1));

        iCaseService.deleteCase(caseId);

        verify(iCaseRepository).findById(caseId);
        verify(iCaseRepository).delete(case1);
    }




    @Test
    public void getCaseById_shouldThrowExceptionIfCaseNotFound(){
        int caseId = 2;

        when(iCaseRepository.findById(caseId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            iCaseService.getCaseById(caseId);
        });

        verify(iCaseRepository).findById(caseId);

    }



}
