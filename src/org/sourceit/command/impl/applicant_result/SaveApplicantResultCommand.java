package org.sourceit.command.impl.applicant_result;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.ApplicantResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Anastasia on 16.09.2015.
 */
public class SaveApplicantResultCommand implements ICommand {
    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        ApplicantResult applicantResult = new ApplicantResult();

        applicantResult.setApplicantId(Integer.parseInt(request.getParameter("applicant_id")));
        applicantResult.setMark(Integer.parseInt(request.getParameter("mark")));
        applicantResult.setSubjectId(Integer.parseInt(request.getParameter("subject_id")));

        if (request.getParameter("applicant_result_id") != null) {
            applicantResult.setId(Long.parseLong(request.getParameter("applicant_result_id")));
        }

        try {
            provider.saveApplicantResult(applicantResult);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=applicant_result";
    }
}
