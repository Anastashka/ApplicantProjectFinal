package org.sourceit.command.impl.applicant;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Profession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Anastasia on 10.09.2015.
 */
public class EditApplicantCommand implements ICommand {
    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        try {
            Long applicantId = Long.parseLong(request.getParameter("id"));
            Applicant applicant = provider.getApplicant(applicantId);
            List<Profession> professions = provider.getProfessions();
            request.setAttribute("applicant", applicant);
            request.setAttribute("professions", professions);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "pages/edit_applicant.jsp";
    }
}
