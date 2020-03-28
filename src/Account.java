import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Account
{
    private ArrayList<Operation> account;

    public Account()
    {
        this.account = Main.loadFromFile();
    }

    public void getAllDeposit(){
        System.out.print("Всего поступило на счет: ");
    account.stream()
            .map(Operation::getDeposit)
            .reduce(Double::sum)
            .ifPresent(System.out::println);
    }

    public void getAllExpense(){
        System.out.print("Всего потрачено: ");
    account.stream()
            .map(Operation::getExpense)
            .reduce(Double::sum)
            .ifPresent(System.out::println);
    }
    public ArrayList<Operation> getAccount(){
        return account;
    }

    public void getMapExpense(){
        TreeMap<String, Double> mapExpense = new TreeMap<>();
        account.stream()
                .sorted(Comparator.comparing(Operation::getSpecificationOperation))
                .filter(o -> o.getExpense() != 0 )
                .forEach(o -> {
                if (mapExpense.containsKey(o.getSpecificationOperation())){
                    mapExpense.replace(o.getSpecificationOperation(), mapExpense.get(o.getSpecificationOperation()),
                            mapExpense.get(o.getSpecificationOperation()) + o.getExpense());
                }
                else {
                    mapExpense.put(o.getSpecificationOperation(), o.getExpense());
                }
                        }
                        );
        System.out.println("Выписка расходов: ");
        printMap(mapExpense);
    }
    public void getMapDeposit(){
        TreeMap<String, Double> map = new TreeMap<>();
        account.stream()
                .sorted(Comparator.comparing(Operation::getSpecificationOperation))
                .filter(o -> o.getDeposit() != 0 )
                .forEach(o -> {
                            if (map.containsKey(o.getSpecificationOperation())){
                                map.replace(o.getSpecificationOperation(), map.get(o.getSpecificationOperation()),
                                        map.get(o.getSpecificationOperation()) + o.getDeposit());
                            }
                            else {
                                map.put(o.getSpecificationOperation(), o.getDeposit());
                            }
                        }
                );
        System.out.println("Выписка доходов: ");
        printMap(map);
    }
    private static void printMap(Map<String, Double> map)
    {
        for (String key : map.keySet())
        {
            System.out.println(key + " - " + map.get(key));
        }
    }
}
