module com.tubes.laporin {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires mysql.connector.j;

    opens com.tubes.laporin to javafx.fxml;
    exports com.tubes.laporin;
    exports com.tubes.laporin.Controllers;
    exports com.tubes.laporin.Controllers.Lawyer;
    exports com.tubes.laporin.Controllers.User;
    exports com.tubes.laporin.Models;
    exports com.tubes.laporin.Views;
}