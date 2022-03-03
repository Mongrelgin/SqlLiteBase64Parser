public class Photo {
    private Long personId;
    private String base64Photo;

    public Photo(Long personId, String base64Photo) {
        this.personId = personId;
        this.base64Photo = base64Photo;
    }

    public Photo() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getBase64Photo() {
        return base64Photo;
    }

    public void setBase64Photo(String base64Photo) {
        this.base64Photo = base64Photo;
    }
}
