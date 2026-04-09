package kg.attractor.lesson55lab.dto;

public class UserProfileDto {
    private String name;
    private String email;
    private String about;
    private String accountType;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
}