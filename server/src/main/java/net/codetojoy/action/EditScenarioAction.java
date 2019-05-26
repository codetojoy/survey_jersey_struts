package net.codetojoy.action;

import com.opensymphony.xwork2.ActionSupport;

import net.codetojoy.model.*;
import net.codetojoy.service.*;

import org.apache.log4j.Logger;

// legacy
public class EditScenarioAction extends ActionSupport {

    // ------- logger
    private static final Logger logger = Logger.getLogger(EditScenarioAction.class);
    private static final String VERSION = "v1";
    private static int instanceCount = 0;

    private void logIt(String msg) {
        String prefix = "TRACER [EditScenarioAction " + VERSION + "(" + instanceCount + ")" + "] ";
        logger.info(prefix + " " + msg);
    }
    //

	private static final long serialVersionUID = 1L;

	private ScenarioService scenarioService = new ScenarioServiceImpl();
	private Scenario scenarioBean;

    public EditScenarioAction() {
        super();
        logIt("constructor");
        instanceCount++;
    }

	public String execute() throws Exception {
        logIt("execute begin");
	    scenarioService.saveScenario( getScenarioBean() );
		return SUCCESS;
	}

	public String input() throws Exception {
        logIt("input begin");
		setScenarioBean( scenarioService.getScenario() );
		return INPUT;
	}

	public Scenario getScenarioBean() { return scenarioBean; }
	public void setScenarioBean(Scenario scenario) { scenarioBean = scenario; }

	public ScenarioService getScenarioService() { return scenarioService; }
	public void setScenarioService(ScenarioService scenarioService) {
        logIt("setting scenario service");
        this.scenarioService = scenarioService;
    }
}
