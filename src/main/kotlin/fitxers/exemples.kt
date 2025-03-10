package fitxers

import kotlin.io.path.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.util.*
import kotlin.io.path.Path
import kotlin.io.path.appendText
import kotlin.io.path.writeText

fun crearFicheroConNumerosEnteros(
    rutaArchivo: String,
    separador: String = " ",
    cantidadNumeros: Int = 42,
    desde: Int = 3,
    hasta: Int = 95
) {
    val path = Path(rutaArchivo)
    if (!path.exists()) {
        path.createFile()
    }
    path.writeText("")
    for (i in 1..cantidadNumeros) {
        val numeroRandom = (desde..hasta).random()
        path.appendText(numeroRandom.toString())
        if (i != cantidadNumeros) {
            path.appendText(separador)
        }

    }
}

//l'arxiu d'origen (NumbersI.txt) cada número en una línia diferent
//els arxius de sortida (parellsI.txt i senarsI.txt) els escribim amb els elements en diferents línies
fun exercici31I() {
    val fOrigen = File("./txt/NumbersI.txt")

    val fDestiParell = Path("./txt/parellsI.txt")
    val fDestiSenar = Path("./txt/senarsI.txt")

    fDestiParell.writeText("")
    fDestiSenar.writeText("")

    fOrigen.forEachLine {
        val text: String = it + "\n"
        if (it.toInt() % 2 == 0) fDestiParell.appendText(text)
        else fDestiSenar.appendText(text)
    }
}

//l'arxiu d'origen (NumbersII.txt) té totes les dades en una sola línia, amb els elements separats per un espai en blanc
//els arxius de sortida (parellsII.txt i senarsII.txt) els escribim amb tots els elements en una sola línia, separats per un espai en blanc
fun exercici31II() {
    val fileName = "./txt/NumbersII.txt"
    val sc = Scanner(File(fileName))

    val fDestiParell = Path("./txt/parellsII.txt")
    val fDestiSenar = Path("./txt/senarsII.txt")

    fDestiParell.writeText("")
    fDestiSenar.writeText("")

    while (sc.hasNextLine()) {
        val num = sc.nextInt()
        if (num % 2 == 0) fDestiParell.appendText("$num ")
        else fDestiSenar.appendText("$num ")
    }
}

fun main() {
    //exercici31I()
    //exercici31II()
}

fun mainFitxers() {
    try {
        val file = File("./txt/arxiu.txt")

        println("Contingut inicial:")
        file.forEachLine { println(it) }

        file.appendText("hola que tal\n")

        println("Contingut final:")
        file.forEachLine { println(it) }
    } catch (fnfe: FileNotFoundException) {
        print(fnfe.message)
    } catch (ioe: IOException) {
        print(ioe.message)
    } catch (e: Exception) {
        print("ERROR: Fatal ERROR. Error no tractat")
    }
}

