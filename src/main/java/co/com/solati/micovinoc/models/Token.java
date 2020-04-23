package co.com.solati.micovinoc.models;

public class Token {
    private String token;
    private int expira_en;
    private String expira;

    public Token(String token, int expira_en, String expira) {
        this.token = token;
        this.expira_en = expira_en;
        this.expira = expira;
    }
    public Token(){
        this.token = token;
        this.expira_en = expira_en;
        this.expira = expira;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpira_en() {
        return expira_en;
    }

    public void setExpira_en(int expira_en) {
        this.expira_en = expira_en;
    }

    public String getExpira() {
        return expira;
    }

    public void setExpira(String expira) {
        this.expira = expira;
    }
}
