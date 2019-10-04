package info.sanaulla;

public class Main {
    public static void main(String[] args) {
        String aBlock = """
        SELECT id, first_name, last_name, dob
        FROM person
        WHERE id = ?
        """;

        String aIndentedBlock = """
            SELECT id, first_name, last_name, dob
            FROM person
            WHERE id = ?
        """;

        String anotherBlock = """
        SELECT id, first_name, last_name, dob
        FROM person
        WHERE id = ?""";

        System.out.print(aBlock);
        System.out.print(aIndentedBlock);
        System.out.print(anotherBlock);
        System.out.println("This comes in the same line");

        System.out.println("""
        Block containing "" ' '
        """);
//        String thisIsInvalid = """This is invalid""";
//        String thisIsALsoInvalid = """THis is also invalid
//        """;
        String thisIsValid = """
This is valid""";
    }
}
