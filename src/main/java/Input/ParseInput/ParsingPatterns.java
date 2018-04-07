package Input.ParseInput;

public class ParsingPatterns {
    public static String Price = "[\\d.,]+";
    public static String Manufacturer =
            "[Aa][Dd]{1,2}[Ii][Dd][aA][Ss]|" + //Addidas
            "[Nn][Ii][Kk][Ee]|" + //Nike
            "[Pp][Uu][Mm][Aa]|" + //Puma
            "[Aa][Ss][Ii][Cc]"; // Asic
    public static String Colors =
            "[Ww][Hh][Ii][Tt][Ee]|" + //White
            "[Bb][Ll][Uu][Ee]|" + //Blue
                    "[Yy][Ee][Ll]{1,2}[Oo][Ww]|" + //Yellow
                    "[Bb][Ll][Aa][Cc][Kk]|" + //Black
                    "[Gg][Rr][Ee]{1,2}[Nn]|" + //Green
                    "[Rr][Ee][Dd]|" + //Red
                    "[Pp][Uu][Rr][Pp][Ll][Ee]"; //Purple
    public static String Logotypes = "[Tt][Ee][Ss][Tt]";
    public static String withPrint = "yes|no";
    public static String TextOnFace = "exampletext";


}
