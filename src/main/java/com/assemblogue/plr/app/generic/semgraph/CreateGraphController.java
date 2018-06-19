package com.assemblogue.plr.app.generic.semgraph;


import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * グラフ作成ウィンドウのコントローラクラスです。
 *
 * @author <a href="mailto:kaneko@cri-mw.co.jp">KANEKO, yukinori</a>
 */
public class CreateGraphController implements Initializable {
    @FXML private Button graphCancel;
    @FXML private Button graphCreate;
    @FXML private TextField graphName;

    private AppController appcontroller;
    private Stage ownerStage;
    private Stage stage;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeUI();
    }

	private void initializeUI() {
        graphCancel.setOnAction(mouseEvent -> exec_cancel());
        graphCreate.setOnAction(mouseEvent -> exec_create());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setOwnerStage(Stage stage) { ownerStage = stage; }
    public void setAppController(AppController ctrl) { appcontroller = ctrl; }

    private void exec_cancel() {
        stage.close();
    }

    private void exec_create() {
        String name = graphName.getText();

        if (name.compareTo("")== 0) {
            name = Messages.getString("nodepain.noname");
        }

        appcontroller.createGraph(name);
        stage.close();
    }
}
