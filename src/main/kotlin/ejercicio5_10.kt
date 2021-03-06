class Libro(
    var tituloLibro: String,
    var autorLibro: String,
    var numeroPaginas: Int,
    var calificacionLibro: Int
) {

    init {
        require(numeroPaginas > 0) { "El numero de paginas es negativo" }
        require(calificacionLibro in 0..10) { "La calificicacion no entra dentro de los limites establecidos" }
    }

    fun informacionLibro(): String =
        "Titulo: $tituloLibro, Autor/a: $autorLibro, Numero de paginas: $numeroPaginas, Calificacion del Libro: $calificacionLibro"
}

class ConjuntoLibros() {
    var librosContenidos: Array<Libro?> = arrayOfNulls<Libro>(5)
    var contador: Int = 0
    var posicion: Int = 0
    var libroAnadido: Boolean = false
    var libroEliminado: Boolean = false
    var cantidadLibrosEliminados: Int = 0
    var calificacionMayorMenor: Int = 0
    var tituloMayorMenor: String = ""

    fun insertarLibro(libroPorAnadir: Libro): String{
        contador = 0
        posicion = 0
        libroAnadido = false
        while(contador < 5){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]?.tituloLibro.toString() == libroPorAnadir.tituloLibro) {
                    contador = 5
                } else {
                    contador++
                }
            } else {
                librosContenidos[contador] = libroPorAnadir
                libroAnadido = true
                posicion = contador
                contador = 5
            }
        }

        return if (libroAnadido) {
            "Libro Añadido en la posicion $posicion"
        } else {
            "Libro no Añadido"
        }
    }

    fun eliminarLibroPorTitulo(informacion: String): String{
        contador = 0
        libroEliminado = false
        while(contador < 5){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]?.tituloLibro.toString() == informacion) {
                    librosContenidos[contador] = null
                    libroEliminado = true
                    contador = 5
                } else {
                    contador ++
                }
            } else {
                contador ++
            }
        }

        return if (libroEliminado) {
            "El Libro $informacion ha sido eliminado"
        } else {
            "No se ha hecho nada"
        }
    }

    fun eliminarLibroPorAutor(informacion: String): String{
        contador = 0
        cantidadLibrosEliminados = 0
        while(contador < 5){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]?.autorLibro.toString().uppercase() == informacion.uppercase()) {
                    librosContenidos[contador] = null
                    cantidadLibrosEliminados++
                    contador++
                } else {
                    contador ++
                }
            } else {
                contador ++
            }
        }

        return if (cantidadLibrosEliminados > 0) {
            "$cantidadLibrosEliminados libros del Autor/a ${informacion.uppercase()} han sido eliminados"
        } else {
            "No se ha hecho nada"
        }
    }

    fun mayorMenor(){
        contador = 0
        calificacionMayorMenor = 0
        tituloMayorMenor = ""
        while(contador < 5){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]!!.calificacionLibro > calificacionMayorMenor) {
                    calificacionMayorMenor = librosContenidos[contador]!!.calificacionLibro
                    tituloMayorMenor = librosContenidos[contador]!!.tituloLibro
                    contador++
                } else {
                    contador ++
                }
            } else {
                contador ++
            }
        }
        println("El libro con mayor calificacion es $tituloMayorMenor, con una calificacion de $calificacionMayorMenor")

        contador = 0
        calificacionMayorMenor = 10
        tituloMayorMenor = ""
        while(contador < 5){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]!!.calificacionLibro < calificacionMayorMenor) {
                    calificacionMayorMenor = librosContenidos[contador]!!.calificacionLibro
                    tituloMayorMenor = librosContenidos[contador]!!.tituloLibro
                    contador++
                } else {
                    contador ++
                }
            } else {
                contador ++
            }
        }
        println("El libro con menor calificacion es $tituloMayorMenor, con una calificacion de $calificacionMayorMenor")
    }

    fun imprimirLibros(){
        contador = 0
        while (contador < 5){
            println("${librosContenidos[contador]?.tituloLibro}, ${librosContenidos[contador]?.autorLibro}")
            contador++
        }
    }

}

fun main() {
    var libro1 = Libro(
        "Geronimo Stilton: Viaje al Reino de la Fantasia",
        "Elisabetta Dami",
        352,
        9
    )
    var libro2 = Libro(
        "El Señor de los Anillos: La comunidad del Anillo",
        "J.R.R Tolkien",
        412,
        10
    )
    var libro3 = Libro(
        "Harry Potter y la Piedra Filosofal",
        "J.K. Rowling",
        412,
        6
    )
    var libro4 = Libro(
        "Harry Potter y la Prision de Azkaban",
        "J.K. Rowling",
        413,
        4
    )
    var libro5 = Libro(
        "Harry Potter y la mama de Hargrid",
        "J.K. Rowling",
        416,
        7
    )

    var coleccionLibros = ConjuntoLibros()

    println(libro1.informacionLibro())
    println(libro2.informacionLibro())
    println("")
    println(coleccionLibros.insertarLibro(libro1))
    println(coleccionLibros.insertarLibro(libro1))
    println(coleccionLibros.insertarLibro(libro2))
    println(coleccionLibros.insertarLibro(libro3))
    println(coleccionLibros.insertarLibro(libro4))
    println(coleccionLibros.insertarLibro(libro5))
    println("")

    coleccionLibros.imprimirLibros()
    println("")
    println(coleccionLibros.eliminarLibroPorTitulo("El Señor de los Anillos: La comunidad del Anillo"))
    println(coleccionLibros.eliminarLibroPorTitulo("El Señor de los Anillos: La comunidad del Anillo"))
    println("")
    coleccionLibros.imprimirLibros()
    println("")
    println(coleccionLibros.eliminarLibroPorAutor("j.k. rowling"))
    println(coleccionLibros.eliminarLibroPorAutor("J.K. Rowling"))
    println("")
    coleccionLibros.imprimirLibros()
    println("")
    println(coleccionLibros.insertarLibro(libro2))
    println(coleccionLibros.insertarLibro(libro3))
    println(coleccionLibros.insertarLibro(libro4))
    println(coleccionLibros.insertarLibro(libro5))
    println("")
    coleccionLibros.mayorMenor()

}

