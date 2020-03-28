

public class Operation
{
    private String typeAccount;
    private String accountNumber;
    private String currency;
    private String date;
    private String reference;
    private String specificationOperation;
    private double deposit;
    private double expense;

    public Operation(String typeAccount, String accountNumber, String currency, String date, String reference,
                     String specificationOperation, double deposit, double expense)
    {
        this.typeAccount = typeAccount;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.date = date;
        this.reference = reference;
        String[] specOper = specificationOperation.split(" {4}");
        String specOper1 = specOper[1].trim().replaceAll("\\\\", "/");
        this.specificationOperation = specOper1.substring(specOper1.lastIndexOf("/") + 1).trim();
        this.deposit = deposit;
        this.expense = expense;
    }

    public String toString()
    {
        return typeAccount + " - " + accountNumber + " - " + currency + " - " + date + " - " + reference
                + " - " + specificationOperation + " - " + deposit + " - " + expense;
    }
    public String getTypeAccount() {
        return typeAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDate() {
        return date;
    }

    public String getReference() {
        return reference;
    }

    public String getSpecificationOperation() {
        return specificationOperation;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getExpense() {
        return expense;
    }
}
