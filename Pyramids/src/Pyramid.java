public class Pyramid {
    public double height;
    public String modern_name;
    private String pharao;
    private String site;

    public Pyramid(String pharao, String modern_name, String site, double height) {
        this.height = height;
        this.pharao = pharao;
        this.modern_name = modern_name;
        this.site = site;
    }

    public double getHeight() {
        return height;
    }

    public String getModern_name() {
        return modern_name;
    }

    public String getPharao() {
        return pharao;
    }

    public String getSite() {
        return site;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public void setPharao(String pharao) {
        this.pharao = pharao;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
