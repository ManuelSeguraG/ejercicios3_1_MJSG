class Tiempo(var hora: Int = 0, var minuto: Int = 0, var segundo: Int = 0) {

    // Se sobrescribe la funcion toString(), para ahorrarnos la necesidad de crear una funcion adicional
    override fun toString(): String {
        return "${hora}h ${minuto}m ${segundo}s"
    }

}

fun main() {

    // Solicita la hora, es obligatoria y debe de estar entre el 1 y el 24
    var reloj1 = Tiempo()
    do {
        println("Entrada de texto: Hora")
        try {
            reloj1.hora = readLine()!!.toInt()
        } catch (_: NumberFormatException) {
            println("Error, se reintentara")
        }
        if (reloj1.hora !in 1..24) {
            println("Escribe un numero entre 1-24")
            reloj1.hora = 0
        }
    } while (reloj1.hora == 0)

    //Solicita los minutos, no es obligatorio (defecto 0)
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

    //Solicita los segundos, no es obligatorio (defecto 0)
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