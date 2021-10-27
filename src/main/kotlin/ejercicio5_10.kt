class Libro(
    var idLibro: Int,
    var tituloLibro: String,
    var autorLibro: String,
    var numeroPaginasLibro: Int,
    calificacionLibro: Int
) {

    var calificacionLibro: Int = comprobarPuntuacion(calificacionLibro)
        set(value) {
            field = comprobarPuntuacion(value)
        }

    fun comprobarPuntuacion(puntuacion: Int): Int {
        return if (puntuacion in 0..10) {
            puntuacion
        } else {
            0
        }
    }

    fun infoLibro(): String =
        "Titulo: $tituloLibro \n Autor: $autorLibro \n Numero de Paginas: $numeroPaginasLibro \n Calificacion $calificacionLibro"

}

class ConjuntoLibros() {
    var conLibro = Array(5) { Libro(0, "", "", 0, 0) }
    var contador: Int = 0
    var posicionLibro: Int = 0
    var libroInsertado: Boolean = false

    fun anadirLibro(LibroPorAnadir: Libro, posicion: Int): String {
        conLibro[posicion] = LibroPorAnadir
        return "Libro Añadido, posicion $posicion"
    }

//    fun anadirLibro(libroPorAnadir: Libro): String {
//        contador = 0
//        posicionLibro = 0
//        libroInsertado = false
//        while (!libroInsertado or (contador < 4)) {
//            if (!conLibro[contador].idLibro.toString().equals("0")) {
//                contador++
//            } else {
//                if (conLibro[contador].idLibro.toString().equals(libroPorAnadir.idLibro.toString())) {
//                    contador++
//                } else {
//                    conLibro[contador] == libroPorAnadir
//                    libroInsertado = true
//                    posicionLibro = contador
//                    contador = 4
//                }
//            }
//        }
//
//        return if (libroInsertado) {
//            "Libro Añadido en la posicion $posicionLibro"
//        } else {
//            "Libro no insertado"
//        }
//    }


}

fun main() {
    var libro1 = Libro(69420, "Guia profesional de caza", "Mimiar", 654, -2)
    var libro2 = Libro(69421, "Guia profesional de carpinteria", "Mimiar", 654, -2)
    var libro3 = Libro(69422, "Guia profesional de pesca", "Mimiar", 654, -2)
    var conju1 = ConjuntoLibros()

    println(libro1.infoLibro())
    println(conju1.anadirLibro(libro1, 1))
    println("")
    println(libro2.infoLibro())
    println(conju1.anadirLibro(libro2, 2))
    println("")
    println(libro3.infoLibro())
    println(conju1.anadirLibro(libro3, 3))
}