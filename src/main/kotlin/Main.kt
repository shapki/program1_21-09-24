import kotlin.random.Random
fun main() {
    // Создать консольную игру "Камень-Ножницы-Бумага" (три события). На консоль выводится выбор компьютера (случайное значение) и выбор игрока. Для ускорения ввода выбора игрока можно условиться, что, например, 1 - это камень, 2 - ножницы, 3 - бумага. Выполненное задание представить в виде ссылки на GitHub
    // Победитель определяется по следующим правилам:
    // Бумага побеждает камень («бумага обёртывает камень»).
    // Камень побеждает ножницы («камень затупляет или ломает ножницы»).
    // Ножницы побеждают бумагу («ножницы разрезают бумагу»).
    // Если игроки показали одинаковый знак, то засчитывается ничья и игра переигрывается.

    println("Камень-Ножницы-Бумага")

    while(true){
        val pcChoice = getRandChoice()
        val plChoice = getPlyChoice()

        println("\nКомпьютер выбрал: $pcChoice")
        println("Вы выбрали: $plChoice")

        when (getWinner(pcChoice,plChoice)){
            "Победа" -> println("\nВы победили")
            "Проиграл" -> println("\nВы проиграли")
            "Ничья" -> println("\nНичья")
        }
        if (getWinner(pcChoice,plChoice) != "Ничья") break
    }
}

fun getRandChoice(): String {
    val choices = listOf("Камень", "Ножницы", "Бумага")
    return choices[Random.nextInt(choices.size)]
}

fun getPlyChoice(): String {
    while(true){
        println("Есть выбор:")
        println("1 - Камень")
        println("2 - Ножницы")
        println("3 - Бумага")
        print("Ваш выбор: ")
        val choice = readln()

        when(choice){
            "1" -> return "Камень"
            "2" -> return "Ножницы"
            "3" -> return "Бумага"
            else -> println("Неверный выбор")
        }
    }
}

fun getWinner(pcChoice: String, plChoice: String): String {
    if(pcChoice == plChoice){
        return "Ничья"
    }
    return when(pcChoice) {
        "Камень" -> if (plChoice == "Ножницы") "Проиграл" else "Победа"
        "Ножницы" -> if (plChoice == "Бумага") "Проиграл" else "Победа"
        "Бумага" -> if (plChoice == "Камень") "Проиграл" else "Победа"
        else -> "Ошибка"
    }
}