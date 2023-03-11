package fxml;

// Fig. 14.14: CreditInquiry.java
// This program reads a file sequentially and displays the
// contents based on the type of account the user requests 
// (credit balance, debit balance or zero balance).
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.AccountRecord;
import javafx.stage.FileChooser;

public class CreditInquiry {

    private MenuOption accountType;
    private Scanner input;

    // read records from file and display only records of appropriate type
    // Update this method to write output to TextArea
    private String readRecords() {
        // object to be written to file

        StringBuilder sb = new StringBuilder();
        try // read records
        {
            // open file to read from beginning
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("."));
            File file = fc.showOpenDialog(null);

            if(file == null) return "Error reading file";
//            input = new Scanner(new File("clients.txt"));
            input = new Scanner(file);
            while (input.hasNext()) // input the values from the file
            {
                AccountRecord record = new AccountRecord(input.nextInt(),input.next(),input.next(),input.nextDouble());
// replaces usage of setmethods when AccountRecord is defined as a class
//                record.setAccount(input.nextInt()); // read account number
//                record.setFirstName(input.next()); // read first name
//                record.setLastName(input.next()); // read last name
//                record.setBalance(input.nextDouble()); // read balance

                // if proper acount type, display record
                if (shouldDisplay(record.balance())) {
                    sb.append(String.format("%-10d%-12s%-12s%10.2f\n",
                            record.acctNo(), record.firstName(), record.lastName(),record.balance()));
                }
            } // end while
        } // end try
        catch (NoSuchElementException elementException) {
            sb.append("File improperly formed.");
            input.close();
            System.exit(1);
        } // end catch
        catch (IllegalStateException stateException) {
            sb.append("Error reading from file.");
            System.exit(1);
        } // end catch
        catch (FileNotFoundException fileNotFoundException) {
            sb.append("File cannot be found.");
            System.exit(1);
        } // end catch
        finally {
            if (input != null) {
                input.close(); // close the Scanner and the file
            }
        } // end finally
        return sb.toString();
    } // end method readRecords

    // use record type to determine if record should be displayed
    private boolean shouldDisplay(double balance) {
        if ((accountType == MenuOption.CREDIT_BALANCE)
                && (balance < 0)) {
            return true;
        } else if ((accountType == MenuOption.DEBIT_BALANCE)
                && (balance > 0)) {
            return true;
        } else if ((accountType == MenuOption.ZERO_BALANCE)
                && (balance == 0)) {
            return true;
        }

        return false;
    } // end method shouldDisplay

    public String processRequests( MenuOption option) {
        // get user's request (e.g., zero, credit or debit balance)
        accountType = option;
        return readRecords();
    } // end method processRequests
} // end class CreditInquiry

