package org.sourceit.command.impl.applicant_result;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Anastasia on 16.09.2015.
 */
public class AddApplicantResultCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        List<Subject> subjects = null;
        List<Applicant> applicants = null;

        try {
            subjects = provider.getSubjects();
            applicants = provider.getApplicants();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("applicants", applicants);
        request.setAttribute("subjects", subjects);

        return "pages/edit_applicant_result.jsp";
    }

}

