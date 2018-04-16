package br.com.lav.java.test.frontend.ui.views;

import com.vaadin.ui.Grid;

import br.com.lav.java.test.domain.Employee;

/***
 * Show up the Grid with employee list
 * @author laverson
 *
 */
public class EmployeeDisplay extends Grid<Employee> {

	private static final long serialVersionUID = 1L;
	
	/***
	 * Configure Grid's data source
	 * @param employee
	 */
	public void setEmployee(Employee[] employee) {
		setItems(employee);
		addColumn(fc -> fc.getId()).setCaption("##").setExpandRatio(0);
		addColumn(fc -> fc.getName()).setCaption("Nome");
		addColumn(fc -> fc.getRole()).setCaption("Cargo");
		addColumn(fc -> fc.getSalary()).setCaption("Salário");
	}
}
