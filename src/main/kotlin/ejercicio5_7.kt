class Coche(
    var colorCoche: String,
    var marcaCoche: String,
    var modeloCoche: String,
    var numeroCaballosCoche: Int,
    var numeroPuertasCoche: Int,
    var matriculaCoche: String
) {

    override fun toString(): String {
        return "El $marcaCoche $modeloCoche color $colorCoche matricula $matriculaCoche cuenta con $numeroCaballosCoche caballos de potencia y $numeroPuertasCoche puertas en el coche"
    }

}

fun main() {
    var coche1 = Coche("Negro", "Fiat", "Panda", 15, 4, "3001MJS")
    var coche2 = Coche("#69F420", "Mercedab", "MLGLA", 69, 7, "6942MLG")
    var coche3 = Coche("Rojo con lunares blancos", "Fiah", "Cascaoh", 2, 2, "0010LMH")

    println(coche1)
    println(coche2)
    println(coche3)
    println("")
    coche1.colorCoche = "Blanco"
    coche2.colorCoche = "#F42069"
    coche3.colorCoche = "Isabel Pantoja"
    println(coche1)
    println(coche2)
    println(coche3)
}