package fitxers

import java.io.*

import java.io.Serializable

class Persona : Serializable {
    private var nom: String
    private var mail: String

    constructor(nom: String = "", mail: String = ""){
        this.nom = nom
        this.mail = mail
    }

    fun getNom(): String { return this.nom }
    fun getMail(): String { return this.mail }

    fun setNom(nom: String) {
        this.nom = nom
    }
    fun setMail(mail: String) {
        this.mail = mail
    }

    override fun toString(): String {
        return "Nom: ${this.nom}\nMail: ${this.mail}"
    }
}

fun afegirPersona(fitxer: String, persona: Persona) {
    val persones = llegirPersones(fitxer).toMutableList()
    persones.add(persona)

    ObjectOutputStream(FileOutputStream(fitxer)).use { oos ->
        oos.writeObject(persones)
    }
    println("Persona afegida correctament.")
}

fun llegirPersones(fitxer: String): List<Persona> {
    val file = File(fitxer)
    if (!file.exists() || file.length() == 0L) return emptyList()

    ObjectInputStream(FileInputStream(fitxer)).use { ois ->
        return ois.readObject() as List<Persona>
    }
}