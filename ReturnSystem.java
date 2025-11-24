import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class ReturnSystem {
    private UserManager userManager;
    private ArrayList<BorrowerHistory> borrowerHistory;
    private ArrayList<LiteraryHistory> literaryHistory;
    
    public ReturnSystem(ArrayList<Material> materials, UserManager userManager, ArrayList<BorrowerHistory> borrowerHistory, ArrayList<LiteraryHistory> literaryHistory){
    this.userManager = userManager;
    this.borrowerHistory = borrowerHistory;
    this.literaryHistory = literaryHistory;
    }
    public void returnMaterial() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n================================");
        System.out.println("         RETURN MATERIALS       ");
        System.out.println("================================");
        System.out.print("\nEnter your full name: ");
        String fullName = input.nextLine();

        //checks if user exists
        Person user = userManager.getUserByFullName(fullName);
        if (user == null) {
            System.out.println("Borrower is not registered. Please register first.");
            return;
        }

        //checking if user has borrowed material
        if (!user.isHasBorrowed() || user.getBorrowedMaterial() == null) {
            System.out.println("You have no borrowed material to return.");
            return;
        }

        Material borrowed = user.getBorrowedMaterial();
        System.out.println("You are returning: " + borrowed.getTitleOrName() + " (" + borrowed.getMaterialType() + ")");

        //ask how many days the material was held
        System.out.print("Enter the number of days you had this material: ");
        int daysHeld = input.nextInt();

        //allowed days based on materialstype
        int allowedDays = switch (borrowed.getMaterialType()) {
            case "Book" -> 7;
            case "Journal" -> 3;
            case "Magazine" -> 0; // same day
            case "ThesisBook" -> 2;
            default -> 0;
        };

        if (daysHeld > allowedDays) {
            System.out.println("Returned late! One strike added.");
            user.addStrike();
        } else {
            System.out.println("Returned on time. Thank you!");
            LocalDate returnDate = LocalDate.now().plusDays(daysHeld);  
            String returnDateStr = returnDate.toString();
            borrowerHistory.add(new BorrowerHistory(fullName, borrowed.getTitleOrName(), "RETURNED", returnDateStr));
            literaryHistory.add(new LiteraryHistory(fullName, borrowed.getTitleOrName(), "RETURNED", returnDateStr));
        }

        //update copies and user status
        borrowed.copies += 1;
        user.setHasBorrowed(false);
        user.setBorrowedMaterial(null);

        System.out.println("Return process completed successfully!");
    }
}

