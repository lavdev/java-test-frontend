package br.com.lav.java.test.frontend.ui;

import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.themes.ValoTheme;

import br.com.lav.java.test.domain.Skill;
import br.com.lav.java.test.frontend.ui.views.EmployeeDisplay;
import br.com.lav.java.test.frontend.ui.views.SkillDisplay;
import br.com.lav.java.test.service.JsonService;


/***
 * Main UI test class, this the main view application
 * @author laverson
 *
 */
@SpringUI
@Viewport("width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")
@Title("Laverson | Java Software Developer TEST")
@CDIUI(value = "test")
public class TestUI  extends UI {

	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestUI.class);

    // service to GET data from REST server
    JsonService service = new JsonService();
    // Skill view component
    SkillDisplay skillDisplay = new SkillDisplay();
    // Employee view component
	EmployeeDisplay employeeDisplay = new EmployeeDisplay();
    // mapped root
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = TestUI.class)
	public static class Servlet extends VaadinServlet {	
		private static final long serialVersionUID = 1L;	
		@Override
	    protected void servletInitialized() throws ServletException {
	        super.servletInitialized();
	    }
	}

    @Override
	protected void init(VaadinRequest request) {

	    // create basic layout
		buildLayout();
		// attach Skill and Employee component
		configureComponents();

		// error will be catch up by this service..
		VaadinService.getCurrent().setSystemMessagesProvider(new SystemMessagesProvider() {
			private static final long serialVersionUID = -9118140641761605204L;

			@Override
			public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo) {
				CustomizedSystemMessages messages = new CustomizedSystemMessages();
				messages.setCommunicationErrorCaption("Comm Err");
				messages.setCommunicationErrorMessage("This is bad.");
				messages.setCommunicationErrorNotificationEnabled(true);
				messages.setCommunicationErrorURL("http://localhost:8080");
				return messages;
			}
		});
	}
    
    /***
     * Configure components data and view
     */
    private void configureComponents() {
    	skillDisplay.setSkill(service.getSkillList());
    	employeeDisplay.setEmployee(service.getEmployeeList());
    }
	
    /*
     * Build view layout.
     */
    private void buildLayout() {

    	// Create a Window
		Window w = new Window(" Test Java - Laverson");
		w.setModal(true);

    	// Create a grid layout
    	GridLayout mainLayout = new GridLayout(3, 3);
    	
    	// add Label component
    	mainLayout.addComponent(new Label("Filtro de Habilidades"), 0, 0);
    	
    	// add Filter component
    	mainLayout.addComponent(skillDisplay, 0, 1);
    	mainLayout.setComponentAlignment(skillDisplay, Alignment.TOP_LEFT);
    	
    	Button btn = new Button("Filtrar");
    	btn.addStyleName(ValoTheme.BUTTON_SMALL);
    	btn.addClickListener(event -> doClick());
    	
    	// add Button component
    	mainLayout.addComponent(btn, 0, 2);
    	mainLayout.setComponentAlignment(skillDisplay, Alignment.TOP_RIGHT); 	
    	
    	// add Grid component
    	mainLayout.addComponent(new Label("Lista de Empregados"), 2, 0);    	
    	mainLayout.addComponent(employeeDisplay, 2, 1);
    	mainLayout.setComponentAlignment(employeeDisplay, Alignment.TOP_RIGHT);


    	w.setContent(mainLayout);
		// Split and allow resizing
		addWindow(w);
    }

    /***
     * Click listening
     * @return null
     */
	private Object doClick() {
		Set<Skill> selected = skillDisplay.getSelectedItems();
		if(selected.isEmpty()) {
			employeeDisplay.setItems(service.getEmployeeList());
		}else {
		    // create query parameter
            String b = selected.stream().map(skill -> skill.getName() + ",").collect(Collectors.joining());
            // get employee list
			service.getEmployeeList(b);

			// rebind restult set
			employeeDisplay.setItems(service.getEmployeeList(b));
		}
		employeeDisplay.getDataProvider().refreshAll();
		return null;
	}
}


