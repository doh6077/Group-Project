package AccountInteraction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BankAccount.BankAccount;
import BankAccount.CheckAccount;
import BankAccount.SavingAccount;
import Customer.Customer;
import DepositStrategy.DepositStrategy;
import Enum.AccountType;
import Exception.ExcessTransferException;
import Exception.InvalidInputException;
import Exception.MinimumBalanceException;
import Exception.SavingThresholdException;
import Exception.SavingTransferLimitException;
import Exception.UserNotFoundException;
import StrategyFactory.DepositStrategyFactory;
import StrategyFactory.TransferStrategyFactory;
import StrategyFactory.WithdrawStrategyFactory;
import TransferStrategy.TransferStrategy;

import java.util.List;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HomePageController {
    @FXML
    private ComboBox<String> selectAccount;

    @FXML
    private TextField accNoDepositCheck;

    @FXML
    private TextField accNoWithdraw;

    @FXML
    private TextField amtAccTransfer;

    @FXML
    private TextField amtDepositCheck;

    @FXML
    private TextField amtWithdraw;

    @FXML
    private Label checkACC;

    @FXML
    private Label checkBalance;

    @FXML
    private AnchorPane checkHomePane;

    @FXML
    private AnchorPane depositPaneCheck;

    @FXML
    private TextField fromAccTransfer;

    @FXML
    private AnchorPane homePane;

    @FXML
    private Label savingAcc;

    @FXML
    private Label savingBalance;

    @FXML
    private Label savingDeposit;

    @FXML
    private TextField toAccTransfer;

    @FXML
    private AnchorPane transferPane;

    @FXML
    private Label userHome;

    @FXML
    private AnchorPane withdrawPane;

    @FXML
    private AnchorPane savingHomePane;

    @FXML
    private AnchorPane depositPaneSaving;

    @FXML
    private TextField accNoDepositSaving;

    @FXML
    private TextField amtDepositSaving;

    @FXML
    private TextField termSaving;

    private Customer loggedInCustomer;
    private CheckAccount customerCheckAccount;
    private SavingAccount customerSavingAccount;

    /**
     * Dynamically display user information and add a list of available account to the combobox on the front-end home page control panel
     *
     * @param no parameter
     * @return void 
     * @throws 
     */
    @FXML
    public void initialize() {
        String currentUser = Main.getLoggedInUser();
        userHome.setText("Username: " + currentUser);
        List<String> accountTypes = getAccountTypesForUser(currentUser, "UserInfo.txt");
        selectAccount.getItems().clear();
        selectAccount.getItems().addAll(accountTypes);
    }

    /**
     * Get accounter types available to a user based on user name and database name
     *
     * @param username: user name of the user account
     * @param userInfoFile: file name of the user data file 
     * @return list<String>: list of string of account types
     * @throws 
     */
    private List<String> getAccountTypesForUser(String username, String userInfoFile) {
        List<String> accountTypes = new ArrayList<>();
        try (Scanner input = new Scanner(new File(userInfoFile))) {
            while (input.hasNext()) {
                String[] userInfo = input.nextLine().split(",");
                String userName = userInfo[0];
                if (userName.equals(username)) {
                    for (int i = 5; i < userInfo.length; i++) {
                        if ("CHECKINGACCOUNT".equals(userInfo[i]) || "SAVINGACCOUNT".equals(userInfo[i])) {
                            accountTypes.add(userInfo[i]);
                        }
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
        return accountTypes;
    }

    /**
     * show transfer pane for transfer activity
     * @param event: transfer action event
     * @return void
     * @throws 
     */
    @FXML
    void onTransfer(ActionEvent event) {
        showPane(transferPane);
    }

    /**
     * show different deposit panes based on different account types
     * @param event: deposit action event
     * @return void
     * @throws 
     */
    @FXML
    void onDeposit(ActionEvent event) {
        String selectedItem = (String) selectAccount.getValue();
        if ("CHECKINGACCOUNT".equals(selectedItem)) {
            showPane(depositPaneCheck);
        } else if ("SAVINGACCOUNT".equals(selectedItem)) {
            showPane(depositPaneSaving);
        } else{
            showPane(homePane);
        }
    }

    /**
     * show withdraw pane
     * @param event: withdraw action event
     * @return void
     * @throws 
     */
    @FXML
    void onWithdraw(ActionEvent event) {
        showPane(withdrawPane);
    }

    @FXML
    void onConfirmDepositCheck(ActionEvent event) {
        /*try{
            BankAccount account = initializeBankInfo(accNoDepositCheck,"UserInfo.txt");
            DepositStrategyFactory.getDepositStrategy(account).deposit(account,Double.parseDouble(amtDepositCheck.getText()));
            updateBalance(account,accNoDepositCheck,"UserInfo.txt");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/
            try {
            BankAccount account = initializeBankInfo(accNoDepositCheck, "UserInfo.txt");
            
            DepositStrategy strategy = DepositStrategyFactory.getDepositStrategy(account);
            
            if (strategy != null) {
                
                strategy.deposit(account, Double.parseDouble(amtDepositCheck.getText()));
               
                updateBalance(account, accNoDepositCheck, "UserInfo.txt");
               
                showAlert(AlertType.INFORMATION, "Deposit successful!");
            } else {
                showAlert(AlertType.ERROR, "Error: Invalid account type or strategy not found.");
            }
        } catch (Exception e) {
            showAlert(AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    void onCancelDepositCheck(ActionEvent event) {
        showPane(homePane);
    }

        @FXML
    void onConfirmDepositSaving(ActionEvent event) {
        /*try{
            BankAccount account = initializeBankInfo(accNoDepositSaving,"UserInfo.txt");
            DepositStrategyFactory.getDepositStrategy(account).deposit(account,Double.parseDouble(amtDepositSaving.getText()));
            account.setTerm(termSaving.getText());
            updateBalance(account,accNoDepositSaving,"UserInfo.txt");
            updateTerm(account,accNoDepositSaving,"UserInfo.txt");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        try {
            BankAccount account = initializeBankInfo(accNoDepositSaving, "UserInfo.txt");
            DepositStrategy strategy = DepositStrategyFactory.getDepositStrategy(account);

            if (strategy != null) {
                strategy.deposit(account, Double.parseDouble(amtDepositSaving.getText()));
                account.setTerm(termSaving.getText());
                updateBalance(account, accNoDepositSaving, "UserInfo.txt");
                updateTerm(account,accNoDepositSaving,"UserInfo.txt");
                showAlert(AlertType.INFORMATION, "Deposit successful!");
            } else {
                showAlert(AlertType.ERROR, "Error: Invalid account type or strategy not found.");
            }
        } catch(InvalidInputException e){
            showAlert(AlertType.ERROR, e.getMessage());
        } 
        catch(SavingThresholdException e){
            showAlert(AlertType.ERROR, e.getMessage());
        }
        catch (Exception e) {
            showAlert(AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    void onCancelDepositSaving(ActionEvent event) {
        showPane(homePane);
    }

    @FXML
    void onConfirmTransfer(ActionEvent event){
        try{
            System.out.println(1);
            BankAccount fromAccount = initializeBankInfo(fromAccTransfer,"UserInfo.txt");
            System.out.println(2);
            BankAccount toAccount = initializeBankInfo(toAccTransfer,"UserInfo.txt");
            System.out.println(3);
            TransferStrategy strategy = TransferStrategyFactory.getTransferStrategy(fromAccount);
            System.out.println(4);
            if (strategy != null){
                System.out.println(5);
                strategy.transfer(fromAccount,toAccount,Double.parseDouble(amtAccTransfer.getText()));
                System.out.println(6);
                updateBalance(fromAccount,fromAccTransfer,"UserInfo.txt");
                System.out.println(7);
                updateBalance(toAccount,toAccTransfer,"UserInfo.txt");
                System.out.println(8);
                showAlert(AlertType.INFORMATION, "Transfer successful!");
               
            }else {
                System.out.println(6);
                showAlert(AlertType.ERROR, "Error: Transfer FAILED");
            }
               
        }catch(ExcessTransferException e){
            showAlert(AlertType.ERROR, e.getMessage());
        }
        catch(InvalidInputException e){
            showAlert(AlertType.ERROR, e.getMessage());
        }
        catch(MinimumBalanceException e){
            showAlert(AlertType.ERROR, e.getMessage());
        }
        catch(SavingTransferLimitException e){
            showAlert(AlertType.ERROR, e.getMessage());
        }
        catch(Exception e){
           
            showAlert(AlertType.ERROR, e.getMessage());
        }
        
    }

    @FXML
    void onCancelTransfer(ActionEvent event) {
        showPane(homePane);
    }

    @FXML
    void onConfirmWithdraw(ActionEvent event) {
         try{
            BankAccount account = initializeBankInfo(accNoWithdraw,"UserInfo.txt");
            WithdrawStrategyFactory.getWithdrawStrategy(account).withdraw(account,Double.parseDouble(amtWithdraw.getText()));
            updateBalance(account,accNoWithdraw,"UserInfo.txt");
            showAlert(AlertType.INFORMATION, "Withdraw successful!");
               
        }catch(MinimumBalanceException e){
            showAlert(AlertType.ERROR, e.getMessage());
        }
        catch(ExcessTransferException e){
            showAlert(AlertType.ERROR, e.getMessage());
        }
        catch(InvalidInputException e){
            showAlert(AlertType.ERROR, e.getMessage());
        }
        catch(Exception e){
            showAlert(AlertType.ERROR, e.getMessage());
        }

        
    }

    @FXML
    void onCancelWithdraw(ActionEvent event) {
        showPane(homePane);
    }

    @FXML
    void onLogOut(ActionEvent event) {
        Main.setRoot("Main", 400, 200);
    }

    @FXML
    public void onSelect(ActionEvent event) {
        String selectedItem = (String) selectAccount.getValue();
        if ("CHECKINGACCOUNT".equals(selectedItem)) {
            showPane(checkHomePane);

        } else if ("SAVINGACCOUNT".equals(selectedItem)) {
            showPane(savingHomePane);

        } else {
            showPane(homePane);
        }
    }

    private void showPane(AnchorPane paneToShow) {
        homePane.setVisible(false);
        checkHomePane.setVisible(false);
        savingHomePane.setVisible(false);
        withdrawPane.setVisible(false);
        transferPane.setVisible(false);
        depositPaneCheck.setVisible(false);
        depositPaneSaving.setVisible(false);

        paneToShow.setVisible(true);

        homePane.setOpacity(paneToShow == homePane ? 1 : 0);
        checkHomePane.setOpacity(paneToShow == checkHomePane ? 1 : 0);
        savingHomePane.setOpacity(paneToShow == savingHomePane ? 1 : 0);
        withdrawPane.setOpacity(paneToShow == withdrawPane ? 1 : 0);
        transferPane.setOpacity(paneToShow == transferPane ? 1 : 0);
        depositPaneCheck.setOpacity(paneToShow == depositPaneCheck ? 1 : 0);
        depositPaneSaving.setOpacity(paneToShow == depositPaneSaving ? 1 : 0);
    }


    private ArrayList<String[]> readDataFiles(String filename){
        ArrayList<String[]> txtLines = new ArrayList();    
        try (Scanner input = new Scanner(new File(filename))) {   
            while (input.hasNext()) {
                String[] userInfo  = input.nextLine().split(",");
                txtLines.add(userInfo);
            }
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
        return  txtLines;
    }

    private void writeDataFiles(ArrayList<String[]> userData,String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for(String[] line : userData){
                for(int i=0; i<line.length; i++){
                    writer.print(line[i]+",");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }

    private String[] getRowColumnIndex(String accountID, String filename){
        String[] result = new String[2];
        ArrayList<String[]> readData = readDataFiles(filename);
        for(int i=0; i<readData.size(); i++){
            if(readData.get(i)[6].equals(accountID)){
                result[0] = String.valueOf(i);
                result[1] = String.valueOf(6);
            }else if (readData.get(i)[10].equals(accountID)){
                result[0] = String.valueOf(i);
                result[1] = String.valueOf(10);
            }
        }
        return result;
    }

    private BankAccount initializeBankInfo(TextField accountID, String filename){
        if (accountID == null ) {
            System.out.println("Invalid account ID provided."); // Debug message
            return null;
        }
        if (accountID.getText().isEmpty()) {
            System.out.println("account ID is empty."); // Debug message
            return null;
        }
        ArrayList<String[]> readData = readDataFiles(filename);
        BankAccount account = null;
        String[] rowColumnIndex = getRowColumnIndex(accountID.getText(), filename);
        if (rowColumnIndex != null && rowColumnIndex.length == 2) {
            int accountIDRow = Integer.parseInt(rowColumnIndex[0]);
            int accountIDColumn = Integer.parseInt(rowColumnIndex[1]);
        // Rest of the code remains unchanged
        
            String accountType = readData.get(accountIDRow)[accountIDColumn-1];
        
           
            switch (accountType){
                case "CHECKINGACCOUNT":
                    account = new CheckAccount();
                    account.setBalance(readData.get(accountIDRow)[accountIDColumn+1]);
                    break;
                case "SAVINGACCOUNT":
                    account = new SavingAccount();
                    account.setBalance(readData.get(accountIDRow)[accountIDColumn+1]);
                    account.setTerm(readData.get(accountIDRow)[accountIDColumn+2]);
                    break;
            }
        }
            return account;
        
    }

    private void updateBalance(BankAccount account,TextField accountID, String filename ){
        if (account == null) {
            System.out.println("Invalid account type provided."); // Debug message
            return;
        }
        if (accountID == null) {
            System.out.println("Invalid account ID provided."); // Debug message
            return;
        }
        if (accountID.getText().isEmpty()) {
            System.out.println("account ID is empty."); // Debug message
            return;
        }
        ArrayList<String[]> readData = readDataFiles(filename);
        String[] rowColumnIndex = getRowColumnIndex(accountID.getText(), filename);
        if (rowColumnIndex != null) {
            int accountBalanceRow = Integer.parseInt(rowColumnIndex[0]);
            int accountBalanceColumn = Integer.parseInt(rowColumnIndex[1]) + 1;
            readData.get(accountBalanceRow)[accountBalanceColumn]=account.getBalance();
            writeDataFiles(readData,filename);
        }
    }

    private void updateTerm(BankAccount account, TextField accountID, String filename){
        ArrayList<String[]> readData = readDataFiles(filename);
        String[] rowColumnIndex = getRowColumnIndex(accountID.getText(), filename);
        if (rowColumnIndex != null) {
            int accountTermRow = Integer.parseInt(rowColumnIndex[0]);
            int accountTermColumn = Integer.parseInt(rowColumnIndex[1]) + 2;
            readData.get(accountTermRow)[accountTermColumn]=account.getTerm();
            writeDataFiles(readData,filename);
        }
    }

    private void showAlert(AlertType type, String content) {
        Alert alert = new Alert(type);
        alert.setContentText(content);
        alert.showAndWait();
    }
   
}
