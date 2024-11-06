package be.athumi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StandardWineTest {
    @Test
    fun shouldDecreasePriceBy1IfNotPassedExpiresInDays() {
        val wine = Wine(WINE_NAME, 20, 10)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(WINE_NAME)
        assertThat(wine.price).isEqualTo(19)
        assertThat(wine.expiresInYears).isEqualTo(9)
    }

    @Test
    fun shouldDecreasePriceBy2IfPassedExpiresInDays() {
        val wine = Wine(WINE_NAME, 20, 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(WINE_NAME)
        assertThat(wine.price).isEqualTo(18)
        assertThat(wine.expiresInYears).isEqualTo(-1)
    }

    @Test
    fun shouldNeverHaveNegativePrice() {
        val wine = Wine(WINE_NAME, 0, 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(WINE_NAME)
        assertThat(wine.price).isEqualTo(0)
        assertThat(wine.expiresInYears).isEqualTo(-1)
    }

    companion object {
        private const val WINE_NAME = "Elixir of the Mongoose"
    }
}
