package org.sourceit.command.impl.subject;

import org.sourceit.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Anastasia on 16.09.2015.
 */
public class AddSubjectCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        return "pages/edit_subjects.jsp";
    }
}
