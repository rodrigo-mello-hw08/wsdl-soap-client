package com.example.soap_ws.service;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibilityService {

    public Acknowledgement checkLoanEligibility(CustomerRequest request) {
        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = getMismatchCriteriaList(request, acknowledgement);
        checkCriteria(mismatchCriteriaList, acknowledgement);
        return acknowledgement;
    }

    private static List<String> getMismatchCriteriaList(CustomerRequest request, Acknowledgement acknowledgement) {
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

        boolean eligible = request.getAge() > 30 && request.getAge() <= 60;
        if (!eligible) {
            mismatchCriteriaList.add("Person age should be in between 30 and 60");
        }
        if (!(request.getYearlyIncome() > 200000)) {
            mismatchCriteriaList.add("Minimum income should be more than 200000");
        }
        if (!(request.getCibilScore() > 500)) {
            mismatchCriteriaList.add("Low CIBIL Score please try after 6 month");
        }
        return mismatchCriteriaList;
    }

    private static void checkCriteria(List<String> mismatchCriteriaList, Acknowledgement acknowledgement) {
        if (!mismatchCriteriaList.isEmpty()) {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        } else {
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear();
        }
    }
}
