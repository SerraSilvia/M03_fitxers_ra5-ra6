package excepcions

class AuditoriaException: Exception {
    constructor(): this("Seràs auditat/da! Prepara't!!!") { }
    constructor(missatge: String): super(missatge) { }
}

fun main(){
    var nomProfe: String

    do {
        print("Escriu el nom del teu professor@: ")
        nomProfe = readLine()!!
        try {
            auditar(nomProfe)
        }catch(a: AuditoriaException){
            println("No passa res, tot passa.")
        }
        //
    }while (nomProfe.lowercase() != "sortir")
}

/**
 * Mètode que comprova si el teu profe ha de ser auditat
 * Especificar @Throws(AuditoriaException::class) és opcional
 * Qui cridi a aquest mètode, haurà de gestionar l'excepció Auditoria,
 * si no ho fa, podria petar el programa en temps d'execució.
 * @author RIS
 */
@Throws(AuditoriaException::class)
fun auditar(profe: String){
    if (profe.lowercase() == "david"){
        throw AuditoriaException()
    }else{
        println("Te n'has salvat aquest cop!")
    }
}