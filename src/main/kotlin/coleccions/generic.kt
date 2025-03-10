package coleccions


class Personatge {
    private val nom: String
    private val fills: MutableList<Personatge>

    constructor(nom: String) {
        this.nom = nom
        fills = mutableListOf<Personatge>()
    }

    public fun getNom(): String {
        return this.nom
    }

    public fun getFills(): MutableList<Personatge> {
        return this.fills
    }

    public fun neixerFill(fill: Personatge) {
        fills.add(fill)
    }
}


class Parella<T> {
    private val primer: T
    private val segon: T

    constructor(primer: T, segon: T) {
        this.primer = primer
        this.segon = segon
    }

    public fun ajuntar(): T {
        var result: T
        when (primer) {
            is Int -> result = (primer + (segon as Int)) as T
            is Personatge -> {
                val p: T = (Personatge(primer.getNom() + " " + (segon as Personatge).getNom())) as T
                primer.neixerFill(p as Personatge)
                segon.neixerFill(p as Personatge)
                result = p
            }

            else -> throw (Exception("Tipus no vàlid"))
        }
        return result
    }
}

fun <T> sumar(a: T, b: T): T {
    return ((a as Int) + (b as Int)) as T
}

fun main() {
    val par: Parella<Int> = Parella(3, 4)
    println(par.ajuntar())

    val p1: Personatge = Personatge("Josep")
    val p2: Personatge = Personatge("Maria")
    println("Fills de p1: " + p1.getFills())
    println("Fills de p2: " + p2.getFills())

    val par2: Parella<Personatge> = Parella(p1, p2)
    val p3: Personatge = par2.ajuntar()
    println("p3: " + p3.getNom() + " : " + p3)
    println("Fills de p1: " + p1.getFills())
    println("Fills de p2: " + p2.getFills())

    val par3: Parella<String> = Parella("Hola", "Mon")

    try {
        println(par3.ajuntar())
    } catch (e: Exception) {
        println(e.message)
    }

}