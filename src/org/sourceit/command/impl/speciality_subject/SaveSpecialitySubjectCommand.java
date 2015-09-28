package org.sourceit.command.impl.speciality_subject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.SpecialitySubject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Anastasia on 16.09.2015.
 */
public class SaveSpecialitySubjectCommand implements ICommand {
    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        SpecialitySubject specialitySubject = new SpecialitySubject();
        specialitySubject.setProfessionSubject(Integer.parseInt(request.getParameter("profession_id")));
        specialitySubject.setSubjectId(Integer.parseInt(request.getParameter("subject_id")));
        if (request.getParameter("sp_sb_id") != null) {
            specialitySubject.setId(Long.parseLong(request.getParameter("sp_sb_id")));
        }
        try {
            provider.saveSpecialitySubject(specialitySubject);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }
        return "controller?command=speciality_subject";
    }
}
