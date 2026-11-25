package Units;

import Item.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {
            Team t1;
            Team t2;
            Monster orc;
            Monster human;
            HashMap<Integer, Amor> amorMap;
            HashMap<Integer, Weapon> weaponMap;
            HashMap<Integer, Jewlery> jewleryMap;


            @BeforeEach
            void setUp() {
                HashMap<Integer, Monster> monsterMap = MonsterTypes.makeMonsters();
                amorMap = AmorItems.makeAmor();
                weaponMap = WeaponItems.makeWeapons();
                jewleryMap = JewleryItems.makeJewlery();

                t1 = new Team("Andreas");
                t2 = new Team("Tanya");

                orc = monsterMap.get(0);
                human = monsterMap.get(1);

                t1.setCurrentMonster(orc);
                t2.setCurrentMonster(human);

            }
            @Test
            void amorCalculations() {
                orc.setAmor(amorMap.get(0));

                int defenseActual = orc.calculateTotalDefense();

                int defenseExpected = orc.getAmor().getDefense();
                assertEquals(defenseExpected,defenseActual);


            }

            @Test
            void damageCalculations() {
                orc.setWeapon(weaponMap.get(0));
                int damageExpected = orc.calculateTotalDamage();
                int damageActual = orc.getDamage() + weaponMap.get(0).getAttack();

                assertEquals(damageExpected, damageActual);
            }

            @Test
            void critCalculations() {
                orc.setJewlery(jewleryMap.get(0));

                int expectedCritChance = orc.getCrit() + jewleryMap.get(0).getCritChance();
                int actualCritChance = orc.calculateTotalCrit();

                assertEquals(expectedCritChance, actualCritChance);

            }

            @Test
            void dodgeCalculations() {
                orc.setJewlery(jewleryMap.get(1));
                int expectedHealth = orc.getHp();
                int damage = human.dealDmg(10L);
                human.attack(orc,damage,10L);
                int actualHealth = orc.getHp();

                assertEquals(expectedHealth, actualHealth);

            }

        }




