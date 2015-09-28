package org.sourceit.command.impl.applicant;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Anastasia on 10.09.2015.
 */
public class SaveApplicantCommand implements ICommand {
    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        Applicant applicant = new Applicant();

        applicant.setFirstName(request.getParameter("first_name"));
        applicant.setLastName(request.getParameter("last_name"));
        //applicant.setProfessionName(request.getParameter("profession_name"));
        applicant.setEntranceYear(Integer.parseInt(request.getParameter("entrance_year")));
        applicant.setProfessionId(Integer.parseInt(request.getParameter("professionId")));
        if (request.getParameter("applicant_id") != null) {
            applicant.setId(Long.parseLong(request.getParameter("applicant_id")));
        }

        try {
            provider.saveApplicant(applicant);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=applicants";
    }
}

