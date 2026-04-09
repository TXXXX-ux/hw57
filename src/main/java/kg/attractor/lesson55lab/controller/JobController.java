package kg.attractor.lesson55lab.controller;

import kg.attractor.lesson55lab.model.Resume;
import kg.attractor.lesson55lab.model.Vacancy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class JobController {

    @GetMapping("/vacancies")
    public String vacanciesPage(Model model) {
        List<Vacancy> vacancies = List.of(
                new Vacancy(1L, "Java Developer", "Spring Boot, Hibernate, SQL. Работа в офисе.", 120000.0),
                new Vacancy(2L, "Python Engineer", "Django, Fast API. Удаленка.", 100000.0),
                new Vacancy(3L, "Frontend React", "Redux, TypeScript, Bootstrap 5.", 95000.0),
                new Vacancy(4L, "QA Automation", "Selenium, JUnit, Java.", 80000.0),
                new Vacancy(5L, "Project Manager", "Agile, Scrum, Jira.", 110000.0),
                new Vacancy(6L, "DevOps Specialist", "Docker, Kubernetes, CI/CD.", 140000.0),
                new Vacancy(7L, "Data Analyst", "Pandas, SQL, Tableau.", 90000.0),
                new Vacancy(8L, "UI/UX Designer", "Figma, Adobe XD, Prototyping.", 75000.0),
                new Vacancy(9L, "System Architect", "Microservices, AWS, Design Patterns.", 200000.0),
                new Vacancy(10L, "Mobile Developer", "Kotlin / Swift. Разработка приложений.", 130000.0),
                new Vacancy(11L, "Cybersecurity Expert", "Penetration testing, Network security, Kali Linux.", 160000.0),
                new Vacancy(12L, "Game Developer", "Unity, C#, 3D Math, Shader programming.", 115000.0)
        );
        model.addAttribute("vacancies", vacancies);
        return "vacancies";
    }

    @GetMapping("/resumes")
    public String resumesPage(Model model) {
        List<Resume> resumes = List.of(
                new Resume(1L, "Junior Java Developer", "Знаю основы Java Core и SQL"),
                new Resume(2L, "Middle Python Dev", "Опыт работы с Django 3 года"),
                new Resume(3L, "Product Designer", "Портфолио в Behance")
        );
        model.addAttribute("resumes", resumes);
        return "resumes";
    }
}