package be.athumi

fun main(args: Array<String>) {

    println("BZZZT BZZZT BZZZT!")

    val wines = listOf(
        Wine("Standard Wine", 20, 10),
        Wine("Another Standard Wine", 7, 2),
        Wine("Bourdeaux Conservato", 0, 2),
        Wine("Wine brewed by Alexander the Great", 80, 0),
        Wine("Wine brewed by Alexander the Great", 150, -1),
        Wine("Event Wine", 20, 8),
        Wine("Event Wine", 49, 7),
        Wine("Event Wine", 49, 3),
        Wine("Event Wine", 49, 1),
        // this eco wine does not work properly yet
        Wine("Eco Brilliant Wine", 10, 3)
    )

    val app = WineShop(wines)

    var days = 4
    if (args.isNotEmpty()) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("wine, price, expiresInYears")
        wines.forEach { println(it) }
        println()
        app.next()
    }
}
