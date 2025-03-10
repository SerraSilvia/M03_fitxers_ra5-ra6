package excepcions

import kotlin.io.path.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.util.*
import kotlin.io.path.Path
import kotlin.io.path.appendText
import kotlin.io.path.writeText

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

fun Exercici1() {
    val scan: Scanner = Scanner(System.`in`)
    var num1: Int = 0
    var num2: Int = 0
    var divisio: Int = 0

    try {
        num1 = Integer.parseInt(scan.next())
    } catch (nfe: NumberFormatException) {
        println(nfe.message)
        println(nfe.stackTraceToString())
        println(nfe.toString())
    }

    try {
        num2 = Integer.parseInt(scan.next())
    } catch (nfe: NumberFormatException) {
        println(nfe.message)
        println(nfe.stackTraceToString())
        println(nfe.toString())
    }


    try {
        divisio = num1 / num2
    } catch (ae: ArithmeticException) {
        println("Avís, ha succeït això: ${ae.message}")
        divisio = 0
    }

    println(divisio)
}


//EXEMPLE EDAT

class EdatNoValidaException: Exception {
    constructor(): this("Valor d’edat incorrecte") { }
    constructor(missatge: String): super(missatge) { }
}

class Persona {
    private var edat: Int = 0

    fun setEdat(edat: Int) {
        if (edat < 0 || edat > 120) {
            try {
                throw EdatNoValidaException ("Edat no vàlida")
            } catch (e: Exception) {
                println(e.message)
                e.printStackTrace()
            }

            this.edat = edat
        }
    }
}

fun mainPersona() {
    val p = Persona()

    try {
        p.setEdat(-6)
    }  catch (e: EdatNoValidaException){
        println(e.message)
        e.printStackTrace()
    }

    println("El programa segueix aquí")
}

