public class Person {
    private Long id;
    private String FIO;
    private String company;
    private String position;

    public Person() {
    }

    public Person(Long id, String FIO, String company, String position) {
        this.id = id;
        this.FIO = FIO;
        this.company = company;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
