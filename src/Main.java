import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static String file = "data/movementList.csv";

    public static void main(String[] args)
    {
        Account bank = new Account();
        bank.getAllDeposit();
        bank.getAllExpense();
        bank.getMapExpense();
        bank.getMapDeposit();


    }

    public static ArrayList<Operation> loadFromFile()
    {
        ArrayList<Operation> account = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(file));
            for(String line : lines)
            {
                if (line.replaceAll("\"", "").length() < line.length()){
                    line = line.substring(0, line.indexOf('\"' )) + line.substring(line.indexOf('\"' ) + 1,
                            line.lastIndexOf('\"')).replaceAll(",", ".");
                }

                String[] fragments = line.split(",");
                if(fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                if(fragments[6].replaceAll("[^0-9]", "").length() == 0 ||
                        fragments[7].replaceAll("[^0-9]", "").length() == 0)
                {
                continue;
                }

                account.add(new Operation(fragments[0], fragments[1], fragments[2], fragments[3]
                        , fragments[4], fragments[5], Double.parseDouble(fragments[6]),
                        Double.parseDouble(fragments[7])));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return account;
    }
}
