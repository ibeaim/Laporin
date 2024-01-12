package com.tubes.laporin.Controllers.User;

import com.tubes.laporin.Models.Lawyer;
import com.tubes.laporin.Models.Model;
import com.tubes.laporin.Views.LawyerCellFactory;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text user_name;
    public Label login_date;
    public ListView<Lawyer> lawyers_listview;
    public TextField appoint_lawname_fld;
    public TextField appoint_shift_fld;
    public TextField appoint_price_fld;
    public TextArea appoint_msg_fld;
    public Button appoint_send_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bindData();
        initLawyersList();
        lawyers_listview.setItems(Model.getInstance().getLawyers());
        lawyers_listview.setCellFactory(e -> new LawyerCellFactory());
    }
    private void initLawyersList(){
        if (Model.getInstance().getLawyers().isEmpty()){
            Model.getInstance().setLawyers();
        }
    }
    private void bindData() {
        user_name.textProperty().bind(Bindings.concat("Hi, ").concat(Model.getInstance().getUser().firstNameProperty()));
        login_date.setText("Today, " + LocalDate.now());
    }

//    private void onSendRequest() {
//        String lawnameFldText = appoint_lawname_fld.getText();
//        String shift = appoint_shift_fld.getText();
//        double price = Double.parseDouble(appoint_price_fld.getText());
//        String message = appoint_msg_fld.getText();
////        ResultSet resultSet = Model.getInstance().getDatabaseDriver().searchClient(receiver);
//        try {
//            if (resultSet.isBeforeFirst()){
//                Model.getInstance().getDatabaseDriver().updateBalance(receiver, amount, "ADD");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        // Subtract from sender's savings account
//        Model.getInstance().getDatabaseDriver().updateBalance(sender, amount, "SUB");
//        // Update the savings account balance in the client object
//        Model.getInstance().getClient().savingsAccountProperty().get().setBalance(Model.getInstance().getDatabaseDriver().getSavingsAccountBalance(sender));
//        // Record new transaction
//        Model.getInstance().getDatabaseDriver().newTransaction(sender, receiver, amount, message);
//        // Clear the fields
//        payee_fld.setText("");
//        amount_fld.setText("");
//        message_fld.setText("");
//    }
}
