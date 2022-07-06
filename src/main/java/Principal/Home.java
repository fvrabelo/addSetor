package Principal;

import java.io.IOException;

public class Home {

    public static void main(String[] args) throws IOException, InterruptedException {


        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

        AdicionandoSetor adSet = new AdicionandoSetor();
        adSet.Gerar();


    }
}
