import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ConvertToString check;
        check = new ConvertToString();

        CodeReviewer reviewer;
        reviewer = new CodeReviewer();

        if (args.length != 1) {
            //System.err.println("Uso: java src.CodeCheck <caminho_para_arquivo>");
            System.exit(1);
        }
        String filePath = args[0];
        try {
            String fileContent = check.readFileToString(filePath);
            //System.out.println("Conteúdo do arquivo:");
            //System.out.println(fileContent);
            reviewer.reviewCode(fileContent);
        } catch (IOException e) {
            System.err.println("Error to read the fle: " + e.getMessage());
            e.printStackTrace();
        }
    }
}