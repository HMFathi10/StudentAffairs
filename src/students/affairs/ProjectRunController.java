package students.affairs;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXTextField;
import static java.awt.SystemColor.text;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import static org.apache.poi.openxml4j.opc.OPCPackage.open;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.PackageHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ProjectRunController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField SearchTF;
    @FXML
    private ImageView ProfileImageView;
    @FXML
    private JFXButton EditProfileButton;
    @FXML
    private JFXTextField ProfileNameTF;
    @FXML
    private JFXTextField ProfileAYTF;
    @FXML
    private JFXTextField ProfileSectionTF;
    @FXML
    private JFXTextField SSNTF;
    @FXML
    private JFXTextField AddressTF;
    @FXML
    private JFXTextField TelTF;
    @FXML
    private JFXTextField DOFTF;
    @FXML
    private Text TotalHoursTF;
    @FXML
    private Text GPATF;
    @FXML
    private ScrollPane AddStudent;
    @FXML
    private ImageView StudentImageView;
    @FXML
    private ScrollPane StudentDataScrollPane;
    private AnchorPane ToolBarAnchorPane;
    @FXML
    private JFXTextField AddStudentNameTextField;
    @FXML
    private JFXTextField AddStudentSSNTextField;
    @FXML
    private JFXDatePicker AddStudentDOFTextField;
    @FXML
    private JFXTextField AddStudentTelTextField;
    @FXML
    private JFXComboBox<String> AddStudentAcaYearComboBox;
    @FXML
    private JFXButton AddStudentDoneButton;
    @FXML
    private JFXComboBox<String> AddStudentDepartmentComboBox;
    @FXML
    private JFXButton SaveChangesButton;
    @FXML
    private ScrollPane AddFileScrollPane;
    @FXML
    private JFXButton AddFieldButton;
    @FXML
    private JFXButton RemoveFieldButton;
    @FXML
    private TableView<ContentClass> AllContentTableView;
    @FXML
    private TableColumn<ContentClass, String> AllContentColumn;
    @FXML
    private TableView<ContentClass> CheckedContentTableView;
    @FXML
    private TableColumn<ContentClass, String> CheckedContentColumn;
    @FXML
    private ScrollPane ComTFilesScrollPane;
    @FXML
    private TableView<ComData> InStudentsTableView;
    @FXML
    private TableColumn<ComData, String> InStudentsNameColumn;
    @FXML
    private TableColumn<ComData, String> InStudentsSSNColumn;
    @FXML
    private TableView<ComData> OutStudentsTableView;
    @FXML
    private TableColumn<ComData, String> OutStudentsNameColumn;
    @FXML
    private TableColumn<ComData, String> OutStudentsSSNColumn;
    @FXML
    private BorderPane ListBorderPane;
    @FXML
    private BorderPane StudentSubjectsBorderPane;
    @FXML
    private JFXTextField AddSubjectStudentNameTextField;
    @FXML
    private Label GPALabel;
    @FXML
    private Label AAndDLable;
    @FXML
    private Label TotalHoursLabel;
    @FXML
    private VBox SubjectsVBox;
    @FXML
    private Label AvSubjectsGPALable;
    private Label LinkLabel;
    @FXML
    private Text Linktxt;
    @FXML
    private TableView<Subject> AddSubjectTableView;
    @FXML
    private TableColumn<Subject, String> SubjectColumn;
    @FXML
    private TableColumn<Subject, String> CodeColumn;
    @FXML
    private TableColumn<Subject, String> PreColumn;
    @FXML
    private TableColumn<Subject, String> ArrColumn;
    @FXML
    private TableColumn<Subject, Integer> HoursColumn;
    @FXML
    private JFXButton SaveDegreeButton;
    @FXML
    private TableView<Subject> AVSubjectTableView;
    @FXML
    private TableColumn<Subject, String> SubjectColumn1;
    @FXML
    private TableColumn<Subject, String> CodeColumn1;
    @FXML
    private TableColumn<Subject, String> PreColumn1;
    @FXML
    private TableColumn<Subject, String> ArrColumn1;
    @FXML
    private TableColumn<Subject, Integer> HoursColumn1;
    @FXML
    private JFXButton AddStudentButton;
    @FXML
    private JFXButton ShowStudentInformationButton;
    @FXML
    private JFXButton AvailableSubjectsButton;
    @FXML
    private JFXButton AddNewFileButton;
    @FXML
    private JFXButton CompareTwoFilesButton;
    @FXML
    private JFXButton ScheduleInformationButton;
    @FXML
    private Label CloseButton;
    @FXML
    private VBox CoursesVBox;
    @FXML
    private VBox CoursesVBox1;

    static ResultSet resultSet;
    static Connection connection;
    static PreparedStatement preparedStatement;
    ArrayList<HBox> arrHB = new ArrayList<>();
    ArrayList<Label> arrCode = new ArrayList<>();
    String s;
    XSSFSheet sheet;
    int index;
    int i = 0;
    int gCount = 0;
    int size;
    File excelFile1;
    FileInputStream fls1;
    XSSFWorkbook workbook1;
    XSSFSheet sheet1;
    File excelFile2;
    FileInputStream fls2;
    XSSFWorkbook workbook2;
    XSSFSheet sheet2;
    boolean valid = false;
    ArrayList<TextField> arr1 = new ArrayList<>();
    ArrayList<Label> arr2 = new ArrayList<>();
    @FXML
    private JFXTextField AddStudentAddressTextField;

    public void Con() throws ClassNotFoundException, SQLException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        connection = DriverManager.getConnection("jdbc:ucanaccess://StudentsAffairsDatabase.accdb");
    }

    public void Con2() throws ClassNotFoundException, SQLException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        connection = DriverManager.getConnection("jdbc:ucanaccess://LayhaDatabase.accdb");
    }

    public void Tooltips() {
        CloseButton.setTooltip(new Tooltip("Close."));
        AddSubjectStudentNameTextField.setTooltip(new Tooltip("Enter Social Security Number for student."));
        AddStudentButton.setTooltip(new Tooltip("Add new student manually."));
        ShowStudentInformationButton.setTooltip(new Tooltip("Show Student personal data and current courses."));
        AvailableSubjectsButton.setTooltip(new Tooltip("Show available courses, add new courses and delete courses."));
        AddNewFileButton.setTooltip(new Tooltip("Add Excell file sheet."));
        CompareTwoFilesButton.setTooltip(new Tooltip("Compare between two Excell sheets to show new student and out student."));
        ScheduleInformationButton.setTooltip(new Tooltip("Show schedule information."));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Tooltips();
            //   CoursesVBox.getChildren().clear();
            AllContentColumn.setCellValueFactory(new PropertyValueFactory<>("Content"));
            CheckedContentColumn.setCellValueFactory(new PropertyValueFactory<>("Content"));
            OutStudentsNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
            InStudentsNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
            InStudentsSSNColumn.setCellValueFactory(new PropertyValueFactory<>("SSN"));
            OutStudentsSSNColumn.setCellValueFactory(new PropertyValueFactory<>("SSN"));
            SubjectColumn.setCellValueFactory(new PropertyValueFactory<>("SubName"));
            CodeColumn.setCellValueFactory(new PropertyValueFactory<>("Code"));
            PreColumn.setCellValueFactory(new PropertyValueFactory<>("pre"));
            ArrColumn.setCellValueFactory(new PropertyValueFactory<>("Arr"));
            HoursColumn.setCellValueFactory(new PropertyValueFactory<>("Hours"));
            SubjectColumn1.setCellValueFactory(new PropertyValueFactory<>("SubName"));
            CodeColumn1.setCellValueFactory(new PropertyValueFactory<>("Code"));
            PreColumn1.setCellValueFactory(new PropertyValueFactory<>("pre"));
            ArrColumn1.setCellValueFactory(new PropertyValueFactory<>("Arr"));
            HoursColumn1.setCellValueFactory(new PropertyValueFactory<>("Hours"));
            Con();
            CloseAllScrollPanes(false);
            rootPane.setOpacity(0);
            makeFadeInTransition();
            AddStudentAcaYearComboBox.getItems().addAll("1", "2", "3", "4");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void CloseAllScrollPanes(boolean in) {
        ComTFilesScrollPane.setVisible(in);
        StudentDataScrollPane.setVisible(in);
        AddStudent.setVisible(in);
        AddFileScrollPane.setVisible(in);
        ListBorderPane.setVisible(in);
        StudentSubjectsBorderPane.setVisible(in);
    }

    private void EditSet(boolean In) {
        ProfileNameTF.setEditable(In);
        ProfileAYTF.setEditable(In);
        ProfileSectionTF.setEditable(In);
        SSNTF.setEditable(In);
        AddressTF.setEditable(In);
        TelTF.setEditable(In);
        DOFTF.setEditable(In);
        SaveChangesButton.setVisible(In);
    }

    private void makeFadeInTransition() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    @FXML
    private void ExitAction(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    private void EditProfileAction(ActionEvent event) {
        EditSet(true);
    }

    @FXML
    private void AddImageButtonAction(ActionEvent event) {
        try {
            FileChooser chooser = new FileChooser();
            File f = chooser.showOpenDialog(null);
            if (f != null) {
                s = f.getPath();
                Image Image = new Image(new File(s).toURI().toURL().toExternalForm());
                StudentImageView.setImage(Image);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    private void AddStudentAction(ActionEvent event) {
        CloseAllScrollPanes(false);
        AddStudent.setVisible(true);
        EditSet(false);
    }

    @FXML
    private void ViewStudentDataAction(ActionEvent event) {
        CloseAllScrollPanes(false);
        StudentDataScrollPane.setVisible(true);
        EditSet(false);
    }

    private boolean checkRequirdData() {
        if (!AddStudentNameTextField.getText().isEmpty()) {
            if (!AddStudentSSNTextField.getText().isEmpty()) {
                if (AddStudentDOFTextField.getValue() != null) {
                    if (!AddStudentTelTextField.getText().isEmpty()) {
                        if (AddStudentAcaYearComboBox.getValue() != null) {
                            if (AddStudentDepartmentComboBox.getValue() != null) {
                                if (StudentImageView.getImage() != null) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "All data are required");
        return false;
    }

    private void clearAllData() {
        AddStudentNameTextField.clear();
        AddStudentAcaYearComboBox.getItems().clear();
        AddStudentSSNTextField.clear();
        AddStudentDOFTextField.getEditor().clear();
        AddStudentTelTextField.clear();
        AddStudentDepartmentComboBox.getItems().clear();
        StudentImageView.setImage(null);
    }

    @FXML
    private void AddStudentDoneButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (checkRequirdData()) {
            try {
                Con2();
                preparedStatement = connection.prepareStatement("insert into Students (Name,SSN,BirthDate,Phone,level,Department,Image,adress) "
                        + "VALUES ('" + AddStudentNameTextField.getText() + "','" + AddStudentSSNTextField.getText() + "',"
                        + "'" + AddStudentDOFTextField.getValue().toString() + "','" + AddStudentTelTextField.getText() + "','" + AddStudentAcaYearComboBox.getValue() + "',"
                        + "'" + AddStudentDepartmentComboBox.getValue() + "','" + s + "','"+AddStudentAddressTextField.getText()+"')");
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Done");
                clearAllData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    @FXML
    private void EnterKeyPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (!SearchTF.getText().isEmpty()) {
                try {
                    Con2();
                    preparedStatement = connection.prepareStatement("select * from StudentCourses where SSN='" + SearchTF.getText() + "'");
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        arrHB.add(new HBox());
                        arrHB.get(arrHB.size() - 1).setPadding(new Insets(10, 10, 10, 10));
                        HBox.setMargin(new VBox(), new Insets(0, 20, 0, 0));
                        int num = arr2.size() + 1;
                        arrCode.add(new Label(resultSet.getString("CourseCode")));
                        arr2.add(new Label(num + "- " + resultSet.getString("CourseName")));
                        arr2.get(arr2.size() - 1).setPadding(new Insets(10, 10, 10, 10));
                        arrCode.get(arr2.size() - 1).setPadding(new Insets(10, 10, 10, 10));
                        arr1.add(new TextField());
                        arr1.get(arr1.size() - 1).setPadding(new Insets(10, 10, 10, 10));
                        arrHB.get(arrHB.size() - 1).getChildren().addAll(arr2.get(arr2.size() - 1), arrCode.get(arrCode.size() - 1), arr1.get(arr1.size() - 1));
                        CoursesVBox.getChildren().add(arrHB.get(arrHB.size() - 1));
                    }
                    preparedStatement = connection.prepareStatement("select * from Students where SSN= '" + (SearchTF.getText()) + "'");
                    resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    ProfileNameTF.setText(resultSet.getString("Name"));
                    ProfileAYTF.setText(resultSet.getString("level"));
                    ProfileSectionTF.setText(resultSet.getString("Department"));
                    AddressTF.setText(resultSet.getString("adress"));
                    SSNTF.setText(resultSet.getString("SSN"));
                    TelTF.setText(resultSet.getString("Phone"));
                    DOFTF.setText(resultSet.getString("BirthDate"));
                    GPATF.setText("GPA: " + resultSet.getString("GPA").toString());
                    if (Double.parseDouble(resultSet.getString("GPA")) >= 2.00 || resultSet.getString("level").equals("1")) {
                        TotalHoursTF.setText("Total hours: " + 18);
                    } else {
                        TotalHoursTF.setText("Total hours: " + 12);
                    }
                    Image Image = new Image(new File(resultSet.getString("Image")).toURI().toURL().toExternalForm());
                    ProfileImageView.setImage(Image);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Not Found!");
                }
            }
        }
    }

    @FXML
    private void SaveChangesButtonAction(ActionEvent event) {
        try {
            Con();
            preparedStatement = connection.prepareStatement("Update StudentData set Name='" + ProfileNameTF.getText() + "' where Name='" + SearchTF.getText() + "'");
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Done");
            EditSet(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void AddNewFileAction(ActionEvent event) throws FileNotFoundException, IOException {
        try {
            CloseAllScrollPanes(false);
            AddFileScrollPane.setVisible(true);
            FileChooser chooser = new FileChooser();
            File f = chooser.showOpenDialog(null);
            if (f != null) {
                String Pa = f.getPath();
                File excelFile = new File(Pa);
                FileInputStream fls = new FileInputStream(excelFile);
                XSSFWorkbook workbook = new XSSFWorkbook(fls);
                sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIT = sheet.iterator();
                Row row = rowIT.next();
                Iterator<Cell> cellIt = row.cellIterator();
                while (cellIt.hasNext()) {
                    Cell c = cellIt.next();
                    AllContentTableView.getItems().add(new ContentClass(c.toString()));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void AllContentTableViewAction(MouseEvent event) {
        index = AllContentTableView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void AddFieldButtonAction(ActionEvent event) {
        try {
            if (index > -1) {
                int count = 0;
                int j = 0;
                Iterator<Row> rowIT = sheet.iterator();
                Row row1 = rowIT.next();
                Iterator<Cell> cellIt = row1.cellIterator();
                s = AllContentColumn.getCellData(index);
                CheckedContentTableView.getItems().add(new ContentClass(s));
                XSSFRow rr = sheet.getRow(0);
                size = rr.getLastCellNum();
                while (cellIt.hasNext()) {
                    Cell c = cellIt.next();
                    if (c.toString().equals(s)) {
                        rr = sheet.getRow(0);
                        XSSFCell cc = rr.getCell(count);
                        break;
                    }
                    count++;
                }
                AllContentTableView.getItems().remove(index);
                while (rowIT.hasNext()) {
                    row1 = rowIT.next();
                    cellIt = row1.cellIterator();
                    Cell c = cellIt.next();
                    XSSFRow row = sheet.getRow(++j);
                    XSSFCell cell = row.getCell(count);
//                    arrlist.add(new Label(cell.toString()));
//                    GridPane.add(arrlist.get(arrlist.size() - 1 % size), gCount, j - 1);
                }
                gCount++;
            }
            index = -1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Wrong proccess");
        }
    }

    @FXML
    private void CheckedContentTableViewAction(MouseEvent event) {
        index = CheckedContentTableView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void RemoveFieldButtonAction(ActionEvent event
    ) {
        try {
            if (index > -1) {
                AllContentTableView.getItems().add(new ContentClass((CheckedContentColumn.getCellData(index))));
                CheckedContentTableView.getItems().remove(index);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong proccess");
        }
    }

    @FXML
    private void CompareTwoFilesAction(ActionEvent event) {
        CloseAllScrollPanes(false);
        ComTFilesScrollPane.setVisible(true);
    }

    void InCompare(XSSFSheet s1, XSSFSheet s2) {
        int rowCount1 = s1.getPhysicalNumberOfRows();
        int rowCount2 = s1.getPhysicalNumberOfRows();
        for (int i = 0; i < rowCount1; i++) {
            XSSFRow row1 = s1.getRow(i);
            XSSFRow row2 = s2.getRow(i);
            String idstr1 = "";
            XSSFCell id1 = row1.getCell(0);
            if (id1 != null) {
                idstr1 = id1.toString();
            }
            String idstr2 = "";
            XSSFCell id2 = row2.getCell(0);
            if (id1 != null) {
                idstr2 = id2.toString();
            }
            if (!idstr1.equals(idstr2)) {
                boolean check = false;
                String celstr2 = "";
                int j;
                for (j = 0; j < rowCount2; j++) {
                    XSSFRow rr2 = s2.getRow(j);
                    XSSFCell cel2 = rr2.getCell(0);
                    if (cel2 != null) {
                        celstr2 = cel2.toString();
                    }
                    if (idstr1.equals(celstr2)) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    XSSFRow rTemp = s1.getRow(i);
                    XSSFCell cTemp = rTemp.getCell(1);
                    InStudentsTableView.getItems().add(new ComData(cTemp.toString(), idstr1));
                }
            }
        }
    }

    void OutCompare(XSSFSheet s1, XSSFSheet s2) {
        int rowCount1 = s1.getPhysicalNumberOfRows();
        int rowCount2 = s1.getPhysicalNumberOfRows();
        for (int i = 0; i < rowCount1; i++) {
            XSSFRow row1 = s1.getRow(i);
            XSSFRow row2 = s2.getRow(i);
            String idstr1 = "";
            XSSFCell id1 = row1.getCell(0);
            if (id1 != null) {
                idstr1 = id1.toString();
            }
            String idstr2 = "";
            XSSFCell id2 = row2.getCell(0);
            if (id1 != null) {
                idstr2 = id2.toString();
            }
            if (!idstr1.equals(idstr2)) {
                boolean check = false;
                String celstr2 = "";
                int j;
                for (j = 0; j < rowCount2; j++) {
                    XSSFRow rr2 = s2.getRow(j);
                    XSSFCell cel2 = rr2.getCell(0);
                    if (cel2 != null) {
                        celstr2 = cel2.toString();
                    }
                    if (idstr1.equals(celstr2)) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    XSSFRow rTemp = s1.getRow(i);
                    XSSFCell cTemp = rTemp.getCell(1);
                    OutStudentsTableView.getItems().add(new ComData(cTemp.toString(), idstr1));
                }
            }
        }
    }

    @FXML
    private void AddFirstFileAction(MouseEvent event) throws FileNotFoundException, IOException {
        int count = 0;
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(null);
        if (f != null) {
            String Pa = f.getPath();
            excelFile1 = new File(Pa);
            fls1 = new FileInputStream(excelFile1);
            workbook1 = new XSSFWorkbook(fls1);
            sheet1 = workbook1.getSheetAt(0);
            valid = true;
        }
    }

    @FXML
    private void AddSecondFileAction(MouseEvent event) throws FileNotFoundException, IOException {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(null);
        if (f != null && valid) {
            String Pa = f.getPath();
            excelFile2 = new File(Pa);
            fls2 = new FileInputStream(excelFile2);
            workbook2 = new XSSFWorkbook(fls2);
            sheet2 = workbook2.getSheetAt(0);
            InCompare(sheet1, sheet2);
            OutCompare(sheet2, sheet1);
        }
    }

    @FXML
    private void SaveNewSheetAction(ActionEvent event) {
        try {
            int cellid = 0;
            String colName;
            XSSFWorkbook workbook1 = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook1.createSheet(" Employee Info ");
            XSSFRow newRow;
            String[][] arr = new String[sheet.getLastRowNum()][size];
            int value = 0;
            int matColumnSize = 0;
            for (int i = 0; i < CheckedContentTableView.getItems().size(); i++) {
                int count = 0;
                colName = CheckedContentColumn.getCellData(i);
                //        JOptionPane.showMessageDialog(null, colName);
                Iterator<Row> rowIT = sheet.iterator();
                Row row1 = rowIT.next();
                Iterator<Cell> cellIt = row1.cellIterator();
                XSSFRow rr = sheet.getRow(0);
                while (cellIt.hasNext()) {
                    Cell c = cellIt.next();
                    if (c.toString().equals(colName)) {
                        rr = sheet.getRow(0);
                        XSSFCell cc = rr.getCell(count);
                        break;
                    }
                    count++;
                }
                int rowid = 0;
                int j = 0;
                int matRowSize = 0;
                while (rowIT.hasNext()) {
                    row1 = rowIT.next();
                    cellIt = row1.cellIterator();
                    Cell c = cellIt.next();
                    XSSFRow row = sheet.getRow(++j);
                    XSSFCell cell = row.getCell(count);
                    arr[matRowSize++][matColumnSize] = cell.toString();
                }
                matColumnSize++;
            }
            int rowid = 0;
            for (int k = 0; k < arr.length; k++) {
                newRow = spreadsheet.createRow(rowid++);
                cellid = 0;
                for (int l = 0; l < arr[k].length; l++) {
                    Cell newCell = newRow.createCell(cellid++);
                    newCell.setCellValue(arr[k][l]);
                }
            }
            FileChooser chooser = new FileChooser();
            File f = chooser.showOpenDialog(null);
            if (f != null) {
                String Pa = f.getPath();
                FileOutputStream out = new FileOutputStream(
                        new File(Pa));
                workbook1.write(out);
                out.close();
            }
            JOptionPane.showMessageDialog(null, "Done");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void ScheduleInformationAction(ActionEvent event) {
        CloseAllScrollPanes(false);
        ListBorderPane.setVisible(true);
    }
    int HourCount;

    @FXML
    private void AddSubjectStudentNameAction(KeyEvent event) {
        try {
            if (event.getCode().equals(KeyCode.ENTER)) {
                AddSubjectTableView.getItems().clear();
                AVSubjectTableView.getItems().clear();
                HourCount = 0;
                int level;
                Con2();
                preparedStatement = connection.prepareStatement("select * from Students where SSN='" + AddSubjectStudentNameTextField.getText() + "' ");
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                if (resultSet.getString("SSN").equalsIgnoreCase(AddSubjectStudentNameTextField.getText())) {
                    AddSubjectTableView.setVisible(true);
                    AVSubjectTableView.setVisible(true);
                    String ssn = resultSet.getString("SSN");
                    level = Integer.parseInt(resultSet.getString("level"));
                    AAndDLable.setVisible(true);
                    AvSubjectsGPALable.setVisible(true);
                    GPALabel.setVisible(true);
                    TotalHoursLabel.setVisible(true);
                    GPALabel.setText(resultSet.getString("GPA"));
                    if (Double.parseDouble(resultSet.getString("GPA")) > 2.000 || Double.parseDouble(resultSet.getString("GPA")) == 0.0 && level == 1) {
                        TotalHoursLabel.setText("Total hours: 18");
                    } else {
                        TotalHoursLabel.setText("Total hours: 12");
                    }
                    AAndDLable.setText("Academic year: " + resultSet.getString("level") + " \nDepartment: " + resultSet.getString("Department"));
                    preparedStatement = connection.prepareStatement("select * from Courses");
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        boolean check = true;
                        if (Integer.parseInt(resultSet.getString("Year")) <= level) {
                            PreparedStatement PreparedStatement2;
                            ResultSet resultSet2;
                            PreparedStatement2 = connection.prepareStatement("select * from Pre where PreOrder='" + resultSet.getString("Code") + "'");
                            resultSet2 = PreparedStatement2.executeQuery();
                            String pre = "";
                            while (resultSet2.next() != false) {
                                check = false;
                                PreparedStatement preparedStatement3;
                                ResultSet resultSet3;
                                preparedStatement3 = connection.prepareStatement("select * from Courses_Students_Degree where Code_Course='" + resultSet2.getString("Code") + "' and SSN_Student='" + ssn + "'");
                                resultSet3 = preparedStatement3.executeQuery();

                                if (resultSet3.next() != false) {
                                    check = true;
                                    if (Double.parseDouble(resultSet3.getString("Degree")) < 45.0) {
                                        check = false;
                                        break;
                                    }
                                    pre += resultSet2.getString("Code") + ",";
                                }
                                if (!check) {
                                    break;
                                }
                            }
                            PreparedStatement preparedStatement4 = connection.prepareStatement("select * from StudentCourses where CourseCode='" + resultSet.getString("Code") + "' and SSN='" + ssn + "'");
                            ResultSet resultSet4 = preparedStatement4.executeQuery();
                            if (resultSet4.next() != false) {
                                check = false;
                            }
                            PreparedStatement preparedStatement5 = connection.prepareStatement("select * from Courses_Students_Degree where Code_Course='" + resultSet.getString("Code") + "' and SSN_Student= '" + ssn + "'");
                            ResultSet resultSet5 = preparedStatement5.executeQuery();
                            if (resultSet5.next() != false) {
                                if (Double.parseDouble(resultSet5.getString("Degree")) >= 60) {
                                    check = false;
                                }
                            }
                            if (check) {
                                AddSubjectTableView.getItems().add(new Subject(resultSet.getString("Name"),
                                        resultSet.getString("Code"), pre, resultSet.getString("Year"), Integer.parseInt(resultSet.getString("Hours"))));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void AvailableSubjectsAction(ActionEvent event) {
        CloseAllScrollPanes(false);
        AddSubjectTableView.setVisible(false);
        AddSubjectTableView.getItems().clear();
        AVSubjectTableView.getItems().clear();
        StudentSubjectsBorderPane.setVisible(true);
        AAndDLable.setVisible(false);
        AvSubjectsGPALable.setVisible(false);
        GPALabel.setVisible(false);
        TotalHoursLabel.setVisible(false);
        AVSubjectTableView.setVisible(false);
        AddSubjectStudentNameTextField.clear();
    }

    @FXML
    private void LinkMouse(MouseEvent event) throws InvalidFormatException, IOException {
        Linktxt.setFill(Color.BLUEVIOLET);
    }

    @FXML
    private void LinkMouseOut(MouseEvent event) throws InvalidFormatException {
        Linktxt.setFill(Color.WHITE);
    }

    @FXML
    private void LinkClickAction(MouseEvent event) throws IOException {
        String url_open = "56.svg";
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
    }

    @FXML
    private void SaveDegreeAction(ActionEvent event) {
        try {
            for (int j = 0; j < arr2.size(); j++) {
                if (arr1.get(j).getText().isEmpty()) {
                    throw new Exception();
                }
            }
            Con2();
            PreparedStatement preparedStatement2;
            for (int i = 0; i < arr2.size(); i++) {
                JOptionPane.showMessageDialog(null, arr1.get(i).getText() + "   " + arr2.get(i).getText() + "  " + arrCode.get(i).getText());
                preparedStatement2 = connection.prepareStatement("INSERT into Courses_Students_Degree (Degree,SSN_Student,Code_Course) VALUES('" + arr1.get(i).getText()
                        + "','" + SSNTF.getText() + "','" + arrCode.get(i).getText() + "')");
                preparedStatement2.execute();
                preparedStatement2 = connection.prepareStatement("delete * from StudentCourses where CourseCode= '" + arrCode.get(i).getText() + "'");
                preparedStatement2.execute();
            }
            arr1.clear();
            arr2.clear();
            arrHB.clear();
            arrCode.clear();
            CoursesVBox.getChildren().clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void DoubleClickMouseAddSubjectTableView(MouseEvent event) {
        try {
            if (event.getClickCount() == 2 && !event.isConsumed()) {
                event.consume();
                int index = AddSubjectTableView.getSelectionModel().getSelectedIndex();
                AVSubjectTableView.getItems().addAll(new Subject(SubjectColumn.getCellData(index), CodeColumn.getCellData(index),
                        PreColumn.getCellData(index), ArrColumn.getCellData(index), HoursColumn.getCellData(index)));
                HourCount += HoursColumn.getCellData(index);
                AddSubjectTableView.getItems().remove(index);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void DoubleClickMouseAVSubjectTableView(MouseEvent event) {
        try {
            if (event.getClickCount() == 2 && !event.isConsumed()) {
                event.consume();
                int index = AVSubjectTableView.getSelectionModel().getSelectedIndex();
                AddSubjectTableView.getItems().addAll(new Subject(SubjectColumn1.getCellData(index), CodeColumn1.getCellData(index),
                        PreColumn1.getCellData(index), ArrColumn1.getCellData(index), HoursColumn1.getCellData(index)));
                HourCount -= HoursColumn.getCellData(index);
                AVSubjectTableView.getItems().remove(index);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void SubmitButtonAction(ActionEvent event) {
        try {
            String[] arr = TotalHoursTF.getText().split(": ");
            if (HourCount <= Integer.parseInt(arr[1])) {
                Con2();
                for (int i = 0; i < AVSubjectTableView.getItems().size(); i++) {
                    preparedStatement = connection.prepareStatement("insert into StudentCourses VALUES('" + AddSubjectStudentNameTextField.getText() + "','" + CodeColumn1.getCellData(i) + "','" + SubjectColumn1.getCellData(i) + "')");
                    preparedStatement.execute();
                }
                JOptionPane.showMessageDialog(null, "Done");
            } else {
                JOptionPane.showMessageDialog(null, "There is more than " + TotalHoursTF.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void WhatDepart(MouseEvent event) {
        try {
            if (AddStudentAcaYearComboBox.getValue() != "") {
                switch (AddStudentAcaYearComboBox.getValue()) {
                    case "1": {
                        AddStudentDepartmentComboBox.getItems().clear();
                        AddStudentDepartmentComboBox.getItems().addAll("1G", "SE", "BIO");
                    }
                    break;
                    case "2": {
                        AddStudentDepartmentComboBox.getItems().clear();
                        AddStudentDepartmentComboBox.getItems().addAll("2G", "SE", "BIO");
                    }
                    break;
                    case "3": {
                        AddStudentDepartmentComboBox.getItems().clear();
                        AddStudentDepartmentComboBox.getItems().addAll("CS", "IS", "IT", "SE", "BIO");
                    }
                    break;
                    case "4": {
                        AddStudentDepartmentComboBox.getItems().clear();
                        AddStudentDepartmentComboBox.getItems().addAll("CS", "IS", "IT", "SE", "BIO");
                    }
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    private void WhatAcaYear(MouseEvent event) {
        AddStudentDepartmentComboBox.getItems().clear();
    }
}
