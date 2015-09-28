package org.sourceit.command.impl.speciality_subject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Anastasia on 16.09.2015.
 */
public class DeleteSpecialitySubjectCommand implements ICommand {
    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        try {
            Long specialitySubjectId = Long.parseLong(request.getParameter("id"));
            provider.deleteSpecialitySubject(specialitySubjectId);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=speciality_subject";
    }
}
