module lab13.sols {
    requires javafx.controls;
    requires javafx.fxml;
    opens lab13.sols.problem3  to javafx.fxml;
    opens lab13.sols.problem2  to javafx.fxml;

    opens lab13.sols.problem3.A  to javafx.fxml;
    exports lab13.sols.problem3.A  to javafx.graphics;

    exports lab13.sols.problem3  to javafx.graphics;
    exports lab13.sols.problem2  to javafx.graphics;

    opens lab13.sols.problem3.B.a  to javafx.fxml;
    exports lab13.sols.problem3.B.a to javafx.graphics;

    opens lab13.sols.problem3.B.b  to javafx.fxml;
    exports lab13.sols.problem3.B.b to javafx.graphics;

    opens lab13.sols.problem3.B.c to javafx.fxml;
    exports lab13.sols.problem3.B.c to javafx.graphics;

    opens lab13.sols.problem3.B.d  to javafx.fxml;
    exports lab13.sols.problem3.B.d to javafx.graphics;

    opens lab13.sols.problem3.B.e  to javafx.fxml;
    exports lab13.sols.problem3.B.e to javafx.graphics;

    opens lab13.sols.problem3.B.f  to javafx.fxml;
    exports lab13.sols.problem3.B.f to javafx.graphics;
}