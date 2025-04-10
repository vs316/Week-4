abstract class JobRole {
    String title;
    public JobRole(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

import java.util.ArrayList;
import java.util.List;

class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }

    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println("Screening resume for role: " + resume.getTitle());
        }
    }
}
public class ResumeMain {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareResumes = new Resume<>();
        softwareResumes.addResume(new SoftwareEngineer());

        Resume<DataScientist> dataScienceResumes = new Resume<>();
        dataScienceResumes.addResume(new DataScientist());

        System.out.println("Resume Screening:");
        Resume.screenResumes(softwareResumes.getResumes());
        Resume.screenResumes(dataScienceResumes.getResumes());
    }
}