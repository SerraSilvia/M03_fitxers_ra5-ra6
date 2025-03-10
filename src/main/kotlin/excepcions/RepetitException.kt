package excepcions

class RepetitException: Exception {
    constructor(): super("El numero esta repetit!!") { }
    constructor(missatge: String): super(missatge) { }
}