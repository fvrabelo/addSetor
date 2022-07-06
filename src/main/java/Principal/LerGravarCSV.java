package Principal;


import java.util.ArrayList;
import java.io.IOException;
import javax.swing.JFileChooser;

public class LerGravarCSV {

    public static final ArrayList<String> DISTRITO = new ArrayList<String>();
    static final ArrayList<String> NUMLIGACAO = new ArrayList<String>();
    static String distrito;
    static String numLigacao;

    //escolhe CSV
    public String escolherArquivos() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o arquivo .CSV");
        fc.setDialogType(fc.OPEN_DIALOG);
        fc.setApproveButtonText("OK");
        fc.setFileSelectionMode(fc.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }
        String arquivo = fc.getSelectedFile().getPath();

        return arquivo;
    }

    //escolhe CSV
    public void gravar() {

        try {
            TextFile arquivo = new TextFile(escolherArquivos());
            arquivo.openTextFile();
            String[] vDados;

            while (arquivo.next()) {
                //le linha
                String Linha = arquivo.readLine();
                //separa linha por caracter ';'
                vDados = Linha.split(";", -1);
                //parametro p armazenar posicao zero da linha lida, com separacao trim das demais. No caso, forma primeira coluna
                distrito = vDados[0].trim();
                //Array com valor vindo do parametro
                DISTRITO.add(distrito);
                System.out.println("Matricula: " + distrito);

                numLigacao = vDados[2].trim();
                NUMLIGACAO.add(numLigacao);
                System.out.println("Nº Ligacao: " + numLigacao);


            }


        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }


    }


}

