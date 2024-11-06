package be.athumi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CollectorsWineTest {
    @Test
    fun shouldNeverChange() {
        val wine = Wine(COLLECTORS_WINE, 80, 100)
        val shop = WineShop(listOf(wine))

        shop.next()
        shop.next()

        assertThat(wine.name).isEqualTo(COLLECTORS_WINE)
        assertThat(wine.price).isEqualTo(80)
        assertThat(wine.expiresInYears).isEqualTo(100)
    }

    @Test
    fun shouldNeverChangeEvenIfPriceIsBelow100() {
        val wine = Wine(COLLECTORS_WINE, 49, 100)
        val shop = WineShop(listOf(wine))

        shop.next()
        shop.next()

        assertThat(wine.name).isEqualTo(COLLECTORS_WINE)
        assertThat(wine.price).isEqualTo(49)
        assertThat(wine.expiresInYears).isEqualTo(100)
    }

    @Test
    fun expiresInDaysPassedHasNoImpactOnPrice() {
        val wine = Wine(COLLECTORS_WINE, 80, -10)
        val shop = WineShop(listOf(wine))

        shop.next()
        shop.next()

        assertThat(wine.name).isEqualTo(COLLECTORS_WINE)
        assertThat(wine.price).isEqualTo(80)
        assertThat(wine.expiresInYears).isEqualTo(-10)
    }

    companion object {
        private const val COLLECTORS_WINE = "Wine brewed by Alexander the Great"
    }
}
