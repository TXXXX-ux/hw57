package kg.attractor.lesson55lab.dao;

import kg.attractor.lesson55lab.model.Vacancy;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VacancyDao {
    private final List<Vacancy> vacancies = new ArrayList<>();

    public VacancyDao() {
        vacancies.add(new Vacancy(1L, "Java Developer", "Нужен спец по Spring Boot и SQL. Работа в офисе в Бишкеке.", 1500.0));
        vacancies.add(new Vacancy(2L, "Frontend Developer", "Знание React или Vue. Опыт от 1 года. Удаленка.", 1200.0));
        vacancies.add(new Vacancy(3L, "QA Automation", "Писать тесты на Java/Selenium. Гибкий график.", 1000.0));
        vacancies.add(new Vacancy(4L, "Project Manager", "Управление IT-командой, знание Agile/Scrum.", 2000.0));
    }
    


    public List<Vacancy> findAll() { return vacancies; }
    public void save(Vacancy vacancy) { vacancies.add(vacancy); }
}