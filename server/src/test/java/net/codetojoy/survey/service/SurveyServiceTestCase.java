package net.codetojoy.survey.service;

import static net.codetojoy.survey.model.Constants.*;

import net.codetojoy.survey.model.Answer;
import net.codetojoy.survey.model.Survey;
import net.codetojoy.survey.model.UpdateSurveyRequest;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class SurveyServiceTestCase {
    private SurveyService surveyService = new SurveyService();

    @Test
    public void testCanary() {
        assertEquals(4, 2+2);
    }

    @Test
    public void testUpdateAnswer_notSelected() {
        Answer answer = new Answer();
        answer.setComment("bogus");
        UpdateSurveyRequest updateSurveyRequest = new UpdateSurveyRequest();

        // test
        surveyService.updateAnswer(answer, updateSurveyRequest);

        assertEquals("", answer.getComment());
        assertFalse(answer.isSelected());
    }

    @Test
    public void testUpdateAnswer_selected() {
        Answer answer = new Answer();
        answer.setId(5150);

        UpdateSurveyRequest updateSurveyRequest = new UpdateSurveyRequest();
        Answer updatedAnswer = new Answer();
        updatedAnswer.setId(5150);
        updatedAnswer.setComment("new comment");
        List<Answer> updatedAnswers = new ArrayList<>();
        updatedAnswers.add(updatedAnswer);
        updateSurveyRequest.setAnswers(updatedAnswers);

        // test
        surveyService.updateAnswer(answer, updateSurveyRequest);

        assertEquals("new comment", answer.getComment());
        assertTrue(answer.isSelected());
    }

    @Test
    public void testFindById_basic() {

        // test
        Survey survey = surveyService.findSurveyById(SURVEY2_ID);

        assertNotNull(survey);
    }
}
