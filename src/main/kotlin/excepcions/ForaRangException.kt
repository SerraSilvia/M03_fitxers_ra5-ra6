package excepcions

class ForaRangException: Exception {
        constructor(): super("El numero no es pot inserir!!") { }
        constructor(missatge: String): super(missatge) { }
    }
