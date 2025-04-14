package junit_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @Test
    void fahrenheitToCelsius() {
        assertEquals(0, TemperatureConverter.fahrenheitToCelsius(32));
        assertEquals(100, TemperatureConverter.fahrenheitToCelsius(212));
        assertEquals(-40, TemperatureConverter.fahrenheitToCelsius(-40));
        assertEquals(37.7778, TemperatureConverter.fahrenheitToCelsius(100), 0.0001);
    }

    @Test
    void celsiusToFahrenheit() {
        assertEquals(32, TemperatureConverter.celsiusToFahrenheit(0));
        assertEquals(212, TemperatureConverter.celsiusToFahrenheit(100));
        assertEquals(-40, TemperatureConverter.celsiusToFahrenheit(-40));
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37), 0.0001);
    }

}