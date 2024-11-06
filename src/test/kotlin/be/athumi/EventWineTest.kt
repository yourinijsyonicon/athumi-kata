package be.athumi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class EventWineTest {
    @Test
    @DisplayName("Event Wine should increase price by 1 if expiresInDays is > 7 days away")
    fun shouldIncreaseInPriceByOneIfExpiresInYearsIsMoreThan10DaysAway() {
        val wine = Wine(EVENT_WINE, 20, 11)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(EVENT_WINE)
        assertThat(wine.price).isEqualTo(21)
        assertThat(wine.expiresInYears).isEqualTo(10)
    }

    @Test
    @DisplayName("Event Wine should increase price by 2 if expiresInDays is <= 7 (but > 2) days away")
    fun shouldIncreaseInPriceByTwoIfExpiresInYearsIsBetween5And10DaysAway_upperBoundary() {
        val wine = Wine(EVENT_WINE, 20, 7)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(EVENT_WINE)
        assertThat(wine.price).isEqualTo(22)
        assertThat(wine.expiresInYears).isEqualTo(6)
    }

    @Test
    @DisplayName("Event Wine should increase price by 2 if expiresInDays is > 2 (but <= 7) days away")
    fun shouldIncreaseInPriceByTwoIfExpiresInYearsIsBetween5And10DaysAway_lowerBoundary() {
        val wine = Wine(EVENT_WINE, 20, 6)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(EVENT_WINE)
        assertThat(wine.price).isEqualTo(22)
        assertThat(wine.expiresInYears).isEqualTo(5)
    }

    @Test
    @DisplayName("Event Wine should increase price by 4 if expiresInDays is <= 2 days (but > 0) away")
    fun shouldIncreaseInPriceByThreeIfExpiresInYearsIsBetween0And5DaysAway_upperBoundary() {
        val wine = Wine(EVENT_WINE, 20, 2)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(EVENT_WINE)
        assertThat(wine.price).isEqualTo(24)
        assertThat(wine.expiresInYears).isEqualTo(1)
    }

    @Test
    @DisplayName("Event Wine should increase price by 4 if expiresInYears is > 0 (but <= 2) days away")
    fun shouldIncreaseInPriceByThreeIfExpiresInYearsIsBetween0And5DaysAway_lowerBoundary() {
        val wine = Wine(EVENT_WINE, 20, 1)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(EVENT_WINE)
        assertThat(wine.price).isEqualTo(24)
        assertThat(wine.expiresInYears).isEqualTo(0)
    }

    @Test
    @DisplayName("Event Wine should drop price to zero if expiresInYears is zero.")
    fun shouldDropPriceToZeroIfExpiresInYearsIs0() {
        val wine = Wine(EVENT_WINE, 20, 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(EVENT_WINE)
        assertThat(wine.price).isEqualTo(0)
        assertThat(wine.expiresInYears).isEqualTo(-1)
    }

    @Test
    @DisplayName("Event Wine should drop price to zero if expiresInYears is less than zero.")
    fun shouldDropPriceToZeroIfExpiresInYearsIsLessThan0() {
        val wine = Wine(EVENT_WINE, 20, -10)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(EVENT_WINE)
        assertThat(wine.price).isEqualTo(0)
        assertThat(wine.expiresInYears).isEqualTo(-11)
    }

    @Test
    fun shouldNeverExceed100InPrice() {
        val wine = Wine(EVENT_WINE, 99, 1)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.name).isEqualTo(EVENT_WINE)
        assertThat(wine.price).isEqualTo(100)
        assertThat(wine.expiresInYears).isEqualTo(0)
    }

    companion object {
        private const val EVENT_WINE = "Event Wine"
    }
}
