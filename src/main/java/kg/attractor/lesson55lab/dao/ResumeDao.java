package kg.attractor.lesson55lab.dao;

import kg.attractor.lesson55lab.model.Resume;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResumeDao {
    private final List<Resume> resumes = new ArrayList<>();

    public void save(Resume resume) {
        resumes.add(resume);
    }

    public List<Resume> findAll() {
        return resumes;
    }
}