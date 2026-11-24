package Units;

import Item.Amor;
import Item.AmorItems;
import Item.Weapon;
import Item.WeaponItems;
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


            @BeforeEach
            void setUp() {
                HashMap<Integer, Monster> monsterMap = MonsterTypes.makeMonsters();
                amorMap = AmorItems.makeAmor();
                weaponMap = WeaponItems.makeWeapons();

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
        }




