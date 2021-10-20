class Rectangulo(var base: Double, var altura: Double) {

    override fun toString(): String {
        return super.toString()
    }

    fun calcularArea(): Double = base * altura

    fun calcularPerimetro(): Double = 2 * base + 2 * altura
}

fun main() {
    var rectangulo1 = Rectangulo(1.5, 2.0)
    var rectangulo2 = Rectangulo(1.0, 5.5)
    var rectangulo3 = Rectangulo(4.5, 3.0)

    println("Area rectangulo 1: ${rectangulo1.calcularArea()}")
    println("Area rectangulo 2: ${rectangulo2.calcularArea()}")
    println("Area rectangulo 3: ${rectangulo3.calcularArea()}")
    println("Perimetro rectangulo 1: ${rectangulo1.calcularPerimetro()}")
    println("Perimetro rectangulo 2: ${rectangulo2.calcularPerimetro()}")
    println("Perimetro rectangulo 3: ${rectangulo3.calcularPerimetro()}")
}