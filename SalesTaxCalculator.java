
interface SalesTaxBehavior {
    // Interface for the SalesTaxBehavior
    double compute(double value);

}
class NoTax implements SalesTaxBehavior{
    // Class for the NoTax behavior
    // The compute method returns 0 as there is no tax for Alaska
    public double compute(double value) {
        return 0;
    }
}

class SevenPercentTax implements SalesTaxBehavior{
    // Class for the SevenPercentTax behavior
    // The compute method returns 7% of the value if the state is Indiana
    public double compute(double value) {
        return (value * 0.07);
    }
}

class HawaiiTax implements SalesTaxBehavior{
    // Class for the HawaiiTax behavior
    // The compute method returns 4.5% of the value if the state is Hawaii
    public double compute(double value){
        return (value * 0.045);
    }
}

class State {
    // Stores the name of the state
    private String name;
    // Stores the SalesTaxBehavior
    private SalesTaxBehavior taxBehavior;
    // Getter for name
    public String getName() {
        return name;
    }
    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
    // Getter for taxBehavior
    public void setTaxBehavior(SalesTaxBehavior taxBehavior) {
        this.taxBehavior = taxBehavior;
    }
    // Method to show the tax
    public void showTax(double value){
        double tax = taxBehavior.compute(value);
        System.out.printf("The sales tax on $%.2f in %s is $%.2f\n", value, getName(), tax);
    }
}

public class SalesTaxCalculator {
    // Main class that takes in the state and the value and calculates the tax
    // Set the tac behavior dynamically based on the state
    public static void main(String[] args) {
        // State is the first argument
        // Value is the second argument
        String stateName = args[0];
        double value = Double.parseDouble(args[1]);

        // Check if the number of arguments is correct
        if (args.length != 2) {
            System.out.println("invalid number of arguments");
            return;
        }
        State state = new State();
        // Set the state based on the input
        state.setName(stateName);
        // Switch case to check the state
        switch (stateName) {
            case "Alaska":
                state.setTaxBehavior(new NoTax());
                break;
            case "Indiana":
                state.setTaxBehavior(new SevenPercentTax());
                break;
            case "Hawaii":
                state.setTaxBehavior(new HawaiiTax());
                break;
            default:
                // If the state is not valid, print an error message
                System.out.println("Invalid state");
        }
        // Show the tax
        state.showTax(value);
    }
}
