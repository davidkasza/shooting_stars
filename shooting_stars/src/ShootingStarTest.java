import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class ShootingStarTest {
    ShootingStar shootingStars = new ShootingStar();
    HashMap<Integer, HashMap<String, HashMap<Integer, Integer>>> shootingStarsMap = shootingStars.fillShootingStarData(2019, 2019);

    @Test
    public void testShootingStarsEveryNovemberReturnsWithTheCorrectNumber() {
        Assertions.assertEquals(60, shootingStars.shootingStarsEveryNovember(shootingStarsMap));
    }

    @Test
    void testShootingStarsSecondDayOfAnyMonthReturnsWithTheCorrectNumber() {
        Assertions.assertEquals(24, shootingStars.shootingStarsSecondDayOfAnyMonth(shootingStarsMap));
    }
}