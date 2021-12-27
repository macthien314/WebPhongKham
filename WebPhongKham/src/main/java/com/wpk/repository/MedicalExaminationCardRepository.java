/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;

import com.wpk.pojos.MedicalExaminationCard;
import java.util.Date;
import java.util.List;

/**
 *
 * @author macth
 */
public interface MedicalExaminationCardRepository {
    List<MedicalExaminationCard> getMedicalExaminationCard();
     MedicalExaminationCard getMedicalExaminationCardByID(int id);
     boolean addOrUpdate(MedicalExaminationCard m); 
     boolean removeMedicalExaminationCard(int id);
     
     List<MedicalExaminationCard> getTodayMedCard(int doctorID);
     int countTodayMedCard(int doctorID);
     List<MedicalExaminationCard> getMedicalExaminationCards(Date fromDate,Date toDate,String pageQuan, int page);
     Long countMedCards(Date fromDate,Date toDate);
}
