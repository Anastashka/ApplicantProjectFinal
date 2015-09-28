package org.sourceit.command.impl.speciality_subject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;
import org.sourceit.entities.SpecialitySubject;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Anastasia on 16.09.2015.
 */
public class EditSpecialitySubjectCommand implements ICommand {
    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        try {
            Long specialitySubjectId = Long.parseLong(request.getParameter("id"));
            SpecialitySubject specialitySubject = provider.getSpecialitySubject(specialitySubjectId);
            List<Subject> subjects = provider.getSubjects();
            List<Profession> professions = provider.getProfessions();

            request.setAttribute("specialitySubject", specialitySubject);
            request.setAttribute("subjects", subjects);
            request.setAttribute("professions", professions);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "pages/edit_speciality_subject.jsp";
    }
}
