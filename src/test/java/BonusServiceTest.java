import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {
    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service =new BonusService();
        //подготавливаем данные
        boolean registered = true;
        long amount = 1000_60;
        long expected = 30;
        //вызываем целевлй метод
        long actual = service.calculate(amount, registered);
        assertEquals (expected, actual);
    }
    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service =new BonusService();
        //подготавливаем данные
        boolean registered = true;
        long amount = 1000_000_60;
        long expected = 500;
        //вызываем целевлй метод
        long actual = service.calculate(amount, registered);
        assertEquals (expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndOverLimit() {
        BonusService service =new BonusService();
        //подготавливаем данные
        boolean registered = false;
        long amount = 3000000_60;
        long expected = 500;
        //вызываем целевлй метод
        long actual = service.calculate(amount, registered);
        assertEquals (expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {
        BonusService service =new BonusService();
        //подготавливаем данные
        boolean registered = false;
        long amount = 30000_00;
        long expected = 300;
        //вызываем целевлй метод
        long actual = service.calculate(amount, registered);
        assertEquals (expected, actual);
    }

}