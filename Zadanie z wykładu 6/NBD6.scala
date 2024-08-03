object NBD6 {
  def zad1e(weekDays: List[String]): Unit = {

    if (weekDays.nonEmpty) {
      println(weekDays.head)
      zad1e(weekDays.tail)
    }
  }

  def zad1f(weekDays: List[String]): Unit = {

    if (weekDays.nonEmpty) {
      zad1f(weekDays.tail)
      println(weekDays.head)
    }
  }

  def zad1(): Unit = {
    val weekDays = List("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela")

    // a
    println("=== a ===")
    for (day <- weekDays) {
      println(day)
    }

    // b
    println("=== b ===")
    for (day <- weekDays; if day.startsWith("p")) {
      println(day)
    }

    // c
    println("=== c ===")
    weekDays.foreach(day => println(day))

    // d
    println("=== d ===")
    var i = 0
    while (i < weekDays.length) {
      println(weekDays(i))
      i += 1
    }

    // e
    println("=== e ===")
    zad1e(weekDays)

    // f
    println("=== f ===")
    zad1f(weekDays)


    // g
    println("=== g ===")

    weekDays.foldLeft(()) { (_, day) =>
      println(day)
    }

    println("======")
    weekDays.foldRight(()) { (day, _) =>
      println(day)
    }

    // h
    println("=== h ===")

    weekDays.foldLeft(()) { (_, day) =>
      if (day.startsWith("p"))
        println(day)
      else
        ()
    }
  }

  def zad2(): Unit = {
    val products = Map(
      "Telewizor" -> 2000.0,
      "Laptop" -> 3000.0,
      "Smartfon" -> 1500.0,
    )

    val productsWithDiscount = products.view.mapValues(price => price * 0.9)

    for (product <- productsWithDiscount) {
      println(product)
    }
  }

  def zad3(tuple: (Int, String, Boolean)): Unit = {
    val (value1, value2, value3) = tuple

    println(s"Wartość 1: $value1")
    println(s"Wartość 2: $value2")
    println(s"Wartość 3: $value3")

  }

  def zad4(): Unit = {
    val people = Map(
      "Jan Kowalski" -> 30,
      "Anna Nowak" -> 25,
    )

    println(people.getOrElse("Jan Kowalski", "Brak"))
    println(people.getOrElse("Anna Nowak", "Brak"))
    println(people.getOrElse("Piotr Nowakowski", "Brak"))

    if (people.get("Piotr Nowakowski").isEmpty) {
      println("Brak")
    }
  }

  def zad5(day: String): String = day match {
    case "poniedziałek" => "Praca"
    case "wtorek" => "Praca"
    case "środa" => "Praca"
    case "czwartek" => "Praca"
    case "piątek" => "Praca"
    case "sobota" => "Weekend"
    case "niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }

  // zad6
  class KontoBankowe(private var _stanKonta: Double) {

    def stanKonta: Double = _stanKonta

    def this() = {
      this(0)
    }

    def wplata(wartosc: Double): Unit = {
      _stanKonta += wartosc
    }

    def wyplata(wartosc: Double): Unit = {
      _stanKonta -= wartosc
    }
  }

  // zad7
  class Osoba(var imie: String, var nazwisko: String) {}

  def zad7(osoba: Osoba): String = osoba match {
    case osoba: Osoba if osoba.imie == "Jan" => s"Witaj ${osoba.imie}"
    case osoba: Osoba if osoba.nazwisko == "Nowak" => s"Dzień dobry ${osoba.imie} ${osoba.nazwisko}"
    case osoba: Osoba if osoba.imie == "Piotr" && osoba.nazwisko == "Nowakowski" => s"Hello ${osoba.imie}"
    case _ => "Witaj"
  }

  def zad8(lista: List[Int]): List[Int] = {
    lista.filter(_ != 0)
  }

  def zad9(lista: List[Int]): List[Int] = {
    lista.map(_ + 1)
  }

  def zad10(lista: List[Double]): List[Double] = {
    lista.filter(num => num > -5 && num < 12).map(math.abs)
  }

  def main(args: Array[String]): Unit = {
    zad1()
    zad2()
    zad3(42, "Hello", true)
    zad4()
    println(zad5("sobota"))

    // zad6
    val konto = new KontoBankowe(1000.0)
    konto.wplata(500)
    konto.wyplata(200)
    println(konto.stanKonta)

    // zad7
    val osoba1 = new Osoba("Jan", "Kowalski")
    val osoba2 = new Osoba("Anna", "Nowak")
    val osoba3 = new Osoba("Marta", "Wiśniewska")
    val osoba4 = new Osoba("Piotr", "Nowakowski")

    println(zad7(osoba1))
    println(zad7(osoba2))
    println(zad7(osoba3))
    println(zad7(osoba4))

    // zad8
    val lista = List(1, 0, 5, 0, 3, 0, 8)
    println(zad8(lista))

    // zad9
    val lista2 = List(1, 2, 3, 4, 5)
    println(zad9(lista2))

    // zad 10
    val lista3 = List(-10.5, -4.7, 0.2, 7.8, 15.3)
    print(zad10(lista3))
  }
}