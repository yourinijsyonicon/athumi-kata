package be.athumi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CellarWineTest {
    @ParameterizedTest
    @ValueSource(strings = [BOURGOGNE_CONSERVATO, BOURDEAUX_CONSERVATO])
    fun shouldIncreaseWineByOne(wineName: String) {
        val wine = Wine(wineName, 20, 11)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(wineName)
        assertThat(wine.price).isEqualTo(21)
        assertThat(wine.expiresInYears).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = [BOURGOGNE_CONSERVATO, BOURDEAUX_CONSERVATO])
    fun shouldNeverExceed100InWine(wineName: String) {
        val wine = Wine(wineName, 100, -1)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(wineName)
        assertThat(wine.price).isEqualTo(100)
        assertThat(wine.expiresInYears).isEqualTo(-2)
    }

    @ParameterizedTest
    @ValueSource(strings = [BOURGOGNE_CONSERVATO, BOURDEAUX_CONSERVATO])
    fun passingExpiresInYearsDoesIncreaseWineBy2(wineName: String) {
        val wine = Wine(wineName, 10, -1)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(wineName)
        assertThat(wine.price).isEqualTo(12)
        assertThat(wine.expiresInYears).isEqualTo(-2)
    }

    companion object {
        private const val BOURDEAUX_CONSERVATO = "Bourdeaux Conservato"
        private const val BOURGOGNE_CONSERVATO = "Bourgogne Conservato"
    }
}
