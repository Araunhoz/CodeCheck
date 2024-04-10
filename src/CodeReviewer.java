import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeReviewer {
    public static void reviewCode(String code) {
        checkVariableNaming(code);
        checkMethodNaming(code);
        checkClassNaming(code);
        // Add more review checks here as needed
    }

    public static void checkVariableNaming(String code) {
        Pattern pattern = Pattern.compile("\\b(int|long|double|float|boolean|char|String)\\s+(\\w+)(\\s*=\\s*.*)?;");
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            String variableName = matcher.group(2);
            if (!Character.isLowerCase(variableName.charAt(0))) {
                System.out.println("Variable name \"" + variableName + "\" should start with a lowercase letter.");
            }
        }
    }

    public static void checkMethodNaming(String code) {
        Pattern pattern = Pattern.compile("\\b(public|private|protected)?\\s+(static\\s+)?\\w+\\s+(\\w+)\\s*\\(.*\\)\\s*\\{");
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            String methodName = matcher.group(3);
            if (!Character.isLowerCase(methodName.charAt(0))) {
                System.out.println("Method name \"" + methodName + "\" should start with a lowercase letter.");
            }
        }
    }

    public static void checkClassNaming(String code) {
        Pattern pattern = Pattern.compile("\\bclass\\s+(\\w+)");
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            String className = matcher.group(1);
            if (!Character.isUpperCase(className.charAt(0))) {
                System.out.println("Class name \"" + className + "\" should start with an uppercase letter.");
            }
        }
    }
}
