/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.MedicalExaminationCard;
import java.util.List;


/**
 *
 * @author macth
 */
public interface MedicalExaminationCardService {
           List<MedicalExaminationCard> getMedicalExaminationCards();
    MedicalExaminationCard getMedicalExaminationCardByID(int id);
     boolean addOrUpdate(MedicalExaminationCard m);
     boolean removeMedicalExaminationCard(int id);
     int countTodayMedCard(int doctorID);
     List<MedicalExaminationCard> getTodayMedCard(int doctorID);
}
