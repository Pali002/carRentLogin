package views;
public class Main {
    public static void main(String[] args) throws Exception{
        IdandPasswords idandPasswords = new IdandPasswords();

        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
    }
}
