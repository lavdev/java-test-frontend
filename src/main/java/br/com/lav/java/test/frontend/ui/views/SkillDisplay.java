package br.com.lav.java.test.frontend.ui.views;

import com.vaadin.ui.TwinColSelect;

import br.com.lav.java.test.domain.Skill;

/***
 * Show up the choice component Skill list
 * @author laverson
 *
 */
public class SkillDisplay extends TwinColSelect<Skill>{

	private static final long serialVersionUID = 1L;

	/***
	 * Configure column data and caption Grid
	 * @param skills
	 */
	public void setSkill(Skill[] skills) {
        setItems(skills);
    }
}
