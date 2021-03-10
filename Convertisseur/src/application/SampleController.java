package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


//déclarer les variables 

public class SampleController implements Initializable{

	@FXML
	private ComboBox<String> cboVolume1;

	@FXML
	private TextField txtMasse1;

	@FXML
	private TextField txtMasse2;

	@FXML
	private TextField txtVolume2;

	@FXML
	private TextField txtVolume1;

	@FXML
	private ComboBox<String> cboLongeur2;

	@FXML
	private ComboBox<String> cboLongeur1;

	@FXML
	private ComboBox<String> cboVolume2;

	@FXML
	private Button button;

	@FXML
	private TextField txtLongeur2;

	@FXML
	private TextField txtLongeur1;

	@FXML
	private TextField txtEnergie1;

	@FXML
	private TextField txtEnergie2;

	@FXML
	private ComboBox<String> cboEnergie1;

	@FXML
	private ComboBox<String> cboEnergie2;

	@FXML
	private ComboBox<String> cboMasse2;

	@FXML
	private ComboBox<String> cboMasse1;


	@FXML
	private Tab TabV;

	@FXML
	private Tab TabL;

	@FXML
	private Tab TabE;

	@FXML
	private Tab TabM;


	
	
	// méthodes pour nommer les listes et pour faire les tableaux
	
	
	//La longeur

	private ObservableList<String> listeLongeur=(ObservableList<String>)FXCollections.observableArrayList("Kilomètre","Mètre","Centimètre","Millimètre", "Mile", "Pouce","Pied");

	double []TabLongeur= {0.001,1.0,100.0,1000.0,0.000621371,39.3701,3.28084};

	//Le Volume

	private ObservableList<String> listeVolume=(ObservableList<String>)FXCollections.observableArrayList("Litre","Millilitre","Mètre cube","Gallon impériale", "Pint impérialee", "Once impériale","Tasse impériale");

	double []TabVolume= {1.0,1000.0,0.001,0.219969,1.759752,35.19504,3.51951};

	//L'énergie

	private ObservableList<String> listeEnergie=(ObservableList<String>)FXCollections.observableArrayList("Joule","Kilojoule","Wattheure","Kilowattheure");

	double []TabEnergie= {1000.0,1.0,0.277778,0.000277778};

	//La Masse

	private ObservableList<String> listeMasse=(ObservableList<String>)FXCollections.observableArrayList("Kilogramme","Gramme","Milligramme","Livre","Once");

	double []TabMasse= {0.001,1.0,1000.0,0.00220462,0.035274};


    //Le public void initialize permet d'afficher les listes dans les ComboBox
	@Override
	public void initialize(URL location, ResourceBundle resources) 

	{

		//Longeur
		cboLongeur1.setItems(listeLongeur);
		cboLongeur2.setItems(listeLongeur);
		cboLongeur1.getSelectionModel().selectFirst();
		cboLongeur2.getSelectionModel().selectFirst();

		//Volume
		cboVolume1.setItems(listeVolume);
		cboVolume2.setItems(listeVolume);
		cboVolume1.getSelectionModel().selectFirst();
		cboVolume1.getSelectionModel().selectFirst();
		
		//Énergie
		cboEnergie1.setItems(listeEnergie);
		cboEnergie2.setItems(listeEnergie);
		cboEnergie1.getSelectionModel().selectFirst();
		cboEnergie1.getSelectionModel().selectFirst();

		//Masse
		cboMasse1.setItems(listeMasse);
		cboMasse2.setItems(listeMasse);
		cboMasse1.getSelectionModel().selectFirst();
		cboMasse2.getSelectionModel().selectFirst();


	}
	
	// Les voids si dessous permet de convertir les unités dans chacun des unités de mesure

	//Pour l'énergie

	@FXML
	void calculerE1()
	{
		convertir(txtEnergie1,txtEnergie2,cboEnergie1,cboEnergie2,TabE);
	}

	@FXML
	void calculerE2()
	{
		convertir(txtEnergie2,txtEnergie1,cboEnergie2,cboEnergie1,TabE);
	}
	
	// Pour la longeur
	@FXML
	void calculerL1()
	{
		convertir2(txtLongeur1,txtLongeur2,cboLongeur1,cboLongeur2,TabL);
	}

	@FXML
	void calculerL2()
	{
		convertir2(txtLongeur2,txtLongeur1,cboLongeur2,cboLongeur1,TabL);
	}
	
	//Pour le volume


	@FXML
	void calculerV1()
	{
		convertir1(txtVolume1,txtVolume2,cboVolume1,cboVolume2,TabV);
	}


	@FXML
	void calculerV2()
	{
		convertir1(txtVolume2,txtVolume1,cboVolume2,cboVolume1,TabV);
	}

	

	//Pour la masse

	@FXML
	void calculerM1()
	{
		convertir3(txtMasse1,txtMasse2,cboMasse1,cboMasse2,TabM);
	}

	@FXML
	void calculerM2()
	{
		convertir3(txtMasse2,txtMasse1,cboMasse2,cboMasse1,TabM);
	}
	
	//Les private voids si dessous permettent de calculer et afficher  les unités converties 

	private void convertir(TextField txtA, TextField txtB, ComboBox cboA, ComboBox cboB,
			Tab Tab ) {


		verifNum(txtA);

		int item1=cboA.getSelectionModel().getSelectedIndex(); 
		int item2=cboB.getSelectionModel().getSelectedIndex();
		double taux=TabEnergie[item2]/TabEnergie[item1]; 
		double res=taux*(Double.parseDouble(txtA.getText()));
		//String format
		txtB.setText(String.format("%.2f", res));



	}



    private void convertir1(TextField txtA, TextField txtB, ComboBox cboA,
			ComboBox cboB, Tab TabM) {

		verifNum(txtA);

		int item1=cboA.getSelectionModel().getSelectedIndex(); 
		int item2=cboB.getSelectionModel().getSelectedIndex();
		double taux=TabVolume[item2]/TabVolume[item1]; 
		double res=taux*(Double.parseDouble(txtA.getText()));
		txtB.setText(String.format("%.2f", res));


	} 
    
    private void convertir2(TextField txtA, TextField txtB, ComboBox cboA,
			ComboBox cboB, Tab TabL) {

		verifNum(txtA);

		int item1=cboA.getSelectionModel().getSelectedIndex(); 
		int item2=cboB.getSelectionModel().getSelectedIndex(); 
		double taux=TabLongeur[item2]/TabLongeur[item1]; 
		double  res=taux*(Double.parseDouble(txtA.getText()));
		txtB.setText(String.format("%.2f", res));


	}

	private void convertir3(TextField txtA, TextField txtB, ComboBox cboA,
			ComboBox cboB, Tab TabM) {

		verifNum(txtA);

		int item1=cboA.getSelectionModel().getSelectedIndex(); 
		int  item2=cboB.getSelectionModel().getSelectedIndex(); 
		double  taux=TabMasse[item2]/TabMasse[item1]; 
		double res=taux*(Double.parseDouble(txtA.getText()));
		txtB.setText(String.format("%.2f", res));


	}

	
// méthode pour faire fonctionner le bouton de fermeture
	@FXML
	void sortir()
	{
		System.exit(0);
	}

 


	//Gestion numérique - accepter des caratères numériques seulement
	@FXML 
	public void verifNum(TextField a)
	{
		if(a.getText().equals(""))a.setText("0");
		a.textProperty().addListener((observable,oldValue,newValue)->
		{
			if(!newValue.matches("^[0-9](\\.[0-9]+)?$"))
			{
				a.setText(newValue.replaceAll("[^\\d*\\.]", ""));
			}

		});

	}
}


	
