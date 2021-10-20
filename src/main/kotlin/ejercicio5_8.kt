class Tiempo(var hora: Int = 0, var minuto: Int = 0, var segundo: Int = 0) {

    override fun toString(): String {
        return "${hora}h ${minuto}m ${segundo}s"
    }

}

fun main() {

    var reloj1 = Tiempo()
    do {
        println("Entrada de texto: Hora")
        try {
            reloj1.hora = readLine()!!.toInt()
        } catch (_: NumberFormatException) {
            println("Error, se pasa al siguiente")
        }
        if (reloj1.hora <= 0 || reloj1.hora > 24)
            reloj1.hora = 0
    } while (reloj1.hora == 0)

    println("Entrada de texto: Minuto")
    try {
        reloj1.minuto = readLine()!!.toInt()
    } catch (_: NumberFormatException) {
        println("Error, sera 0")
    }
    if (reloj1.minuto < 0 || reloj1.minuto > 60) {
        println("Te has pasado o quedado corto, sera 0")
        reloj1.minuto = 0
    }

    println("Entrada de texto: Segundo")
    try {
        reloj1.segundo = readLine()!!.toInt()
    } catch (_: NumberFormatException) {
        println("Error, sera 0")
    }
    if (reloj1.segundo < 0 || reloj1.segundo > 60) {
        println("Te has pasado o quedado corto, sera 0")
        reloj1.segundo = 0
    }

    println(reloj1)

}