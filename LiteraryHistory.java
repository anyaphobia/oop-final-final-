public class LiteraryHistory {
    private String borrowerName;
    private String materialTitle;
    private String action;
    private String date;

    public LiteraryHistory(String borrowerName, String materialTitle, String action, String date) {
        this.borrowerName = borrowerName;
        this.materialTitle = materialTitle;
        this.action = action;
        this.date = date;
    }

public String getBorrowerName() { 
    return borrowerName; 
}
public String getMaterialTitle() { 
    return materialTitle; 
}
public String getAction() { 
    return action; 
}
public String getDate() { 
    return date; 
}
    @Override
    public String toString() {
        return date + " | " + materialTitle + " | " + action + " BY | " + borrowerName + " | ";
    }
}

