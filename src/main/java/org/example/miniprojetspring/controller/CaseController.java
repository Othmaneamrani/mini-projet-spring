package org.example.miniprojetspring.controller;


import lombok.AllArgsConstructor;
import org.example.miniprojetspring.dto.CaseDto;
import org.example.miniprojetspring.service.ICaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/cases")
public class CaseController {

    private ICaseService iCaseService;


    @GetMapping("/E{caseId}")
    public CaseDto getCaseById(@PathVariable int caseId){
        return iCaseService.getCaseById(caseId);
    }


    @PutMapping("/E{caseId}")
    public CaseDto updateCase(@PathVariable int caseId, @RequestBody CaseDto updatedCaseDto){
        return iCaseService.updateCase(caseId,updatedCaseDto);
    }


    @PostMapping
    public CaseDto createCase(@RequestBody CaseDto createdCaseDto){
        return iCaseService.createCase(createdCaseDto);
    }


    @DeleteMapping("/E{caseId}")
    public void deleteCase(@PathVariable int caseId){
        iCaseService.deleteCase(caseId);
    }

}
