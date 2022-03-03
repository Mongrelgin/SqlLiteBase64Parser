import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try {
            DbHandler dbHandler = DbHandler.getInstance();
            FileWriter fileWriter = new FileWriter("C://Users//mongr//Desktop//Work//Sportsoft//persons.txt");
            for (Person person: dbHandler.getAllPersons()) {
                fileWriter.write(person.getId() + " " + person.getFIO() + " " + person.getCompany() + " " + person.getPosition() + System.lineSeparator());
            }
            fileWriter.close();
            Base64ToPhoto base64ToPhoto = new Base64ToPhoto();
            base64ToPhoto.base64Parsing(dbHandler.getAllBase64());
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}