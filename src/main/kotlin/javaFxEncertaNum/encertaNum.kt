package javaFxEncertaNum
/*
import javafx.application.Application
import org.example.model.NumMagic
import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.stage.Stage
import java.lang.StrictMath.random
import kotlin.random.Random

class NumMagic : Application() {
    private var numeroAleatori = (0..100).random()
    private var intents: Int = 5
    private var guanyat: Boolean = false
    private var ultimNumeroUsat: Int? = null // guardar l'ultim número ingressat
    private val numerosIntroduits = mutableListOf<Int>() // Llista per guardar els números introduïts

    override fun start(primerStage: Stage) {

        primerStage.title = "ENDEVINA EL NÚMERO!"
        primerStage.show()

        //Aqui anirà un camp per escriure el número
        val txtNumero = TextField()

        // Instruccions per l'usuari
        val lblInstruccions = Label("Endevina el número màgic, està entre 0 i 100")
        lblInstruccions.styleClass.add("lblInstruccions")

        //Aqui aniran els missatges que se li mostren a l'usuari
        val lblResultat = Label("")
        val lblNumerosIntroduits = Label("Números introduïts: ") // Label per mostrar els números

        //botó d'acceptar
        val btnAcceptar = Button("Acceptar")

        // Deshabilitem el botó al principi per no acceptar un camp buit:
        btnAcceptar.isDisable = true

        //Definim una acció pel botó:  (igual que el onclick de js)
        btnAcceptar.setOnAction {

            try {
                val numUser = txtNumero.text.toInt()

                //comprovem que l'usuari canvia el número
                if (numUser == ultimNumeroUsat) {
                    lblResultat.textFill = Color.RED
                    lblResultat.text = "Has de triar un altre número"
                } else {
                    ultimNumeroUsat = numUser
                    if(numUser <= 100 && numUser >= 0) {
                        numerosIntroduits.add(numUser) // Afegim el número a la llista
                        lblNumerosIntroduits.text =
                            "Números introduïts: ${numerosIntroduits.joinToString(", ")}" // Actualitzem el text del label
                    }
                    if (numUser < 0 || numUser > 100) {
                        lblResultat.textFill = Color.RED
                        lblResultat.text = "Número fora de rang"
                    } else {

                        if (numUser == numeroAleatori) {
                            lblResultat.text = "¡ENHORABONA! Has emprat ${5 - intents} intents."
                            guanyat = true
                            mostrarTornarAJugar(primerStage)

                        } else if (numUser > numeroAleatori) {
                            lblResultat.textFill = Color.BLACK
                            intents--
                            lblResultat.text = "El número és menor, et queden ${intents} intents. "

                        } else {
                            lblResultat.textFill = Color.BLACK
                            intents--
                            lblResultat.text = "El número és major, et queden ${intents} intents."
                        }
                    }
                }
                txtNumero.clear() // Netejem el camp de text després de cada intent
            } catch (nfe: NumberFormatException) {
                lblResultat.textFill = Color.RED
                lblResultat.text = "No has ingressat un número"
            }

            if (intents == 0 && !guanyat) {
                lblResultat.textFill = Color.RED
                lblResultat.text = "S' han esgotat els intents. El número era $numeroAleatori."
                mostrarTornarAJugar(primerStage)
            }
        }

        // Habilitem el botó un cop tenim un número en el TextField
        txtNumero.textProperty().addListener { _, _, newValue ->
            btnAcceptar.isDisable = newValue.isNullOrEmpty()
        }

        val vbox = VBox(20.0)
        vbox.styleClass.add("panel-fondo")
        vbox.padding = Insets(20.0)
        vbox.children.addAll(
            lblInstruccions,
            Label("Introdueix el número a encertar (0 - 100):"),
            txtNumero,
            btnAcceptar,
            lblResultat,
            lblNumerosIntroduits // Afegim el label al layout
        )

        val scene = Scene(vbox, 400.0, 300.0)
        //scene.stylesheets.add("styles.css")
        primerStage.title = "El Número Màgic"
        primerStage.scene = scene
        txtNumero.requestFocus()
        primerStage.show()
    }

    private fun mostrarTornarAJugar(stage: Stage) {
        val dialeg = javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION)
        dialeg.title = "Tornar a Jugar"
        dialeg.contentText = "¿Vols tornar a jugar?"
        val resultat = dialeg.showAndWait()
        if (resultat.get() == javafx.scene.control.ButtonType.OK) {
            reiniciarJoc(stage)
        } else {
            stage.close()
        }
    }

    private fun reiniciarJoc(stage: Stage) {
        intents = 5
        guanyat = false
        numeroAleatori = (0..100).random()
        numerosIntroduits.clear() // Netejem la llista quan es reinicia el joc
        start(stage)
    }
}


//EN EL MAIN:

fun main() {
    Application.launch(NumMagic::class.java)
}

 */