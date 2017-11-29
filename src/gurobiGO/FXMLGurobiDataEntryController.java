/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gurobiGO;

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author nanda
 */
public class FXMLGurobiDataEntryController implements Initializable {

    @FXML
    private Label labelSolve;
    @FXML
    private Label labelT;
    @FXML
    private Label labelNomeDpto;
    @FXML
    private TextField txtDepto;
    @FXML
    private Button buttonOk;
    @FXML
    private Pane pane;
    @FXML
    private TextField rt1;
    @FXML
    private TextField rt2;
    @FXML
    private TextField rt3;
    @FXML
    private TextField rt4;
    @FXML
    private TextField rt5;
    @FXML
    private TextField rt6;
    @FXML
    private TextField rt7;
    @FXML
    private TextField rt8;
    @FXML
    private TextField rt9;
    @FXML
    private Label h9;
    @FXML
    private Label h10;
    @FXML
    private Label h11;
    @FXML
    private Label h12;
    @FXML
    private Label h13;
    @FXML
    private Label h14;
    @FXML
    private Label h15;
    @FXML
    private Label h16;
    @FXML
    private Label h17;
    

    private Double rt;

    @FXML
    private void GurobiGo() {
        try {

            // Model
            GRBEnv env = new GRBEnv(txtDepto.getText());
            GRBModel model = new GRBModel(env);

            // Create variables
            GRBVar x1 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x1");
            GRBVar x2 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x2");
            GRBVar x3 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x3");
            GRBVar x4 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x4");
            GRBVar x5 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x5");
            GRBVar x6 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x6");
            GRBVar x7 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x7");
            GRBVar x8 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x8");
            GRBVar x9 = model.addVar(0.0, GRB.INFINITY, 1.0, GRB.INTEGER, "x9");

            // Set objective: minimize x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9
            GRBLinExpr expr = new GRBLinExpr();
            /* expr.addTerm(1.0, x1);
            expr.addTerm(1.0, x2);
            expr.addTerm(1.0, x3);
            expr.addTerm(1.0, x4);
            expr.addTerm(1.0, x5);
            expr.addTerm(1.0, x6);
            expr.addTerm(1.0, x7);
            expr.addTerm(1.0, x8);
            expr.addTerm(1.0, x9);*/
            // model.setObjective(expr, GRB.MINIMIZE);*/
            model.set(GRB.IntAttr.ModelSense, GRB.MINIMIZE);

            // Add constraint: x1 >= 2
            rt = Double.parseDouble(rt1.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x1);
            model.addConstr(expr, GRB.GREATER_EQUAL, rt, "c1");

            // Add constraint: x1 + x2 >= 2
            rt = Double.parseDouble(rt2.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x1);
            expr.addTerm(1.0, x2);
            model.addConstr(expr, GRB.GREATER_EQUAL, 2.0, "c2");

            // Add constraint: x1 + x2 +x3 >= 3
            rt = Double.parseDouble(rt3.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x1);
            expr.addTerm(1.0, x2);
            expr.addTerm(1.0, x3);
            model.addConstr(expr, GRB.GREATER_EQUAL, 3.0, "c3");

            // Add constraint:  x2 + x3 >= 3
            rt = Double.parseDouble(rt4.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x3);
            expr.addTerm(1.0, x2);
            model.addConstr(expr, GRB.GREATER_EQUAL, 3.0, "c4");

            // Add constraint: x4 = 0            
            expr = new GRBLinExpr();
            expr.addTerm(0.0, x4);
            model.addConstr(expr, GRB.EQUAL, 0.0, "c5");

            // Add constraint:  x5 +x3 >= 3
            rt = Double.parseDouble(rt5.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x5);
            expr.addTerm(1.0, x3);
            model.addConstr(expr, GRB.GREATER_EQUAL, 3.0, "c6");

            // Add constraint:  x6 + x5 >= 3
            rt = Double.parseDouble(rt6.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x6);
            expr.addTerm(1.0, x5);
            model.addConstr(expr, GRB.GREATER_EQUAL, 3.0, "c7");

            // Add constraint:  x7 +x6 +x5 >= 3
            rt = Double.parseDouble(rt7.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x7);
            expr.addTerm(1.0, x6);
            expr.addTerm(1.0, x5);
            model.addConstr(expr, GRB.GREATER_EQUAL, 3.0, "c8");

            // Add constraint:  x8 +x7 +x6 >= 3
            rt = Double.parseDouble(rt8.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x8);
            expr.addTerm(1.0, x7);
            expr.addTerm(1.0, x6);
            model.addConstr(expr, GRB.GREATER_EQUAL, 3.0, "c9");

            // Add constraint:  x9 +x8 +x7 >= 3
            rt = Double.parseDouble(rt9.getText());
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x9);
            expr.addTerm(1.0, x8);
            expr.addTerm(1.0, x7);
            model.addConstr(expr, GRB.GREATER_EQUAL, 3.0, "c10");

            // Add constraint:  x1 ... x9 >= 0
            expr = new GRBLinExpr();
            expr.addTerm(1.0, x1);
            expr.addTerm(1.0, x2);
            expr.addTerm(1.0, x3);
            expr.addTerm(0.0, x4);
            expr.addTerm(1.0, x5);
            expr.addTerm(1.0, x6);
            expr.addTerm(1.0, x7);
            expr.addTerm(1.0, x8);
            expr.addTerm(1.0, x9);
            model.addConstr(expr, GRB.GREATER_EQUAL, 0.0, "c11");

            // Optimize model
            model.optimize();

            h9.setText(Double.toString(x1.get(GRB.DoubleAttr.X)).substring(0, 1));
            h10.setText(Double.toString(x2.get(GRB.DoubleAttr.X)).substring(0, 1));
            h11.setText(Double.toString(x3.get(GRB.DoubleAttr.X)).substring(0, 1));
            h12.setText(Double.toString(x4.get(GRB.DoubleAttr.X)).substring(0, 1));
            h13.setText(Double.toString(x5.get(GRB.DoubleAttr.X)).substring(0, 1));
            h14.setText(Double.toString(x6.get(GRB.DoubleAttr.X)).substring(0, 1));
            h15.setText(Double.toString(x7.get(GRB.DoubleAttr.X)).substring(0, 1));
            h16.setText(Double.toString(x8.get(GRB.DoubleAttr.X)).substring(0, 1));
            h17.setText(Double.toString(x9.get(GRB.DoubleAttr.X)).substring(0, 1));

            String label;

            label = Double.toString(model.get(GRB.DoubleAttr.ObjVal));
            labelT.setText("O " + txtDepto.getText() + " precisa de no mínimo: " + label.substring(0, label.length() - 2) + " estagiários.");

            // Dispose of model and environment
            model.dispose();
            env.dispose();

        } catch (GRBException e) {
            System.out.println("Error code: " + e.getErrorCode() + ". "
                    + e.getMessage());
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (!txtDepto.getText().equals("")) {
            GurobiGo(); 
            labelNomeDpto.setText(txtDepto.getText());
            txtDepto.setVisible(false);
            labelNomeDpto.setVisible(true);
            labelT.setVisible(true);
            labelSolve.setText("Número de Estagiários Iniciando no Turno:");
            rt1.setVisible(false);
            h9.setVisible(true);
            rt2.setVisible(false);
            h10.setVisible(true);
            rt3.setVisible(false);
            h11.setVisible(true);
            rt4.setVisible(false);
            h12.setVisible(true);
            rt5.setVisible(false);
            h13.setVisible(true);
            rt6.setVisible(false);
            h14.setVisible(true);
            rt7.setVisible(false);
            h15.setVisible(true);
            rt8.setVisible(false);
            h16.setVisible(true);
            rt9.setVisible(false);
            h17.setVisible(true);
            buttonOk.setVisible(false);
        } else {

        }
    }

    @FXML
    private void handleButtonLimpar(ActionEvent event
    ) {
            
            txtDepto.setVisible(true);
            txtDepto.clear();
            labelNomeDpto.setVisible(false);
            labelT.setVisible(false);
            labelSolve.setText("Nº Mínimo de Estagiários:");
            rt1.setVisible(true);
            rt1.clear();
            h9.setVisible(false);
            rt2.setVisible(true);
            rt2.clear();
            h10.setVisible(false);
            rt3.setVisible(true);
            rt3.clear();
            h11.setVisible(false);
            rt4.setVisible(true);
            rt4.clear();
            h12.setVisible(false);
            rt5.setVisible(true);
            rt5.clear();
            h13.setVisible(false);
            rt6.setVisible(true);
            rt6.clear();
            h14.setVisible(false);
            rt7.setVisible(true);
            rt7.clear();
            h15.setVisible(false);
            rt8.setVisible(true);
            rt8.clear();
            h16.setVisible(false);
            rt9.setVisible(true);
            rt9.clear();
            h17.setVisible(false);
            buttonOk.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        pane.setVisible(true);

    }
}
