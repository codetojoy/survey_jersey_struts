package net.codetojoy.action;

import net.codetojoy.survey.model.Survey;
import net.codetojoy.survey.service.SurveyService;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

// A "legacy" Struts action that uses the REST model and service

public class SurveysAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

    private String testField = "HELLO";
    private List<Survey> surveys = null;

    private SurveyService surveyService = new SurveyService();

    // ------- logger
    private static final Logger logger = Logger.getLogger(SurveysAction.class);
    private static final String VERSION = "v1";
    private static int instanceCount = 0;

    private void logIt(String msg) {
        String prefix = "TRACER [SurveysAction " + VERSION + "(" + instanceCount + ")" + "] ";
        logger.info(prefix + " " + msg);
    }
    //

    public SurveysAction() {
        super();
        logIt("constructor");
        instanceCount++;
    }

	public String viewAll() throws Exception {
        logIt("view begin");

        surveys = surveyService.getSurveys();

		return SUCCESS;
	}

	public String viewOne() throws Exception {
        logIt("view begin");

        // TODO: pass in as parameter
        long surveyId = 302L;

        Survey survey = surveyService.getSurvey(302L);
        surveys = new ArrayList<>();
        surveys.add(survey);

		return SUCCESS;
	}

    // getters, setters

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }
}
