package dungeon;

import java.util.concurrent.ThreadLocalRandom;

public class Fight {
    private Character Player1 ;
    private Character Player2 ;

    public Character getPlayer1() {
        return Player1;
    }

    public void setPlayer1(Character player1) {
        Player1 = player1;
    }

    public Character getPlayer2() {
        return Player2;
    }

    public void setPlayer2(Character player2) {
        Player2 = player2;
    }

    public void fight(Character player1 , Weapon weapon1 , Character player2 , Weapon weapon2){
        double randomMultiplier1 = ThreadLocalRandom.current().nextInt(1, 20);
        randomMultiplier1 /= 5;
        double randomMultiplier2 = ThreadLocalRandom.current().nextInt(1, 20);
        randomMultiplier2 /= 5;

        int player1Strength = player1.getStrength();
        int weapon1Strength = weapon1.getWeaponStrength();
        double player1DamageInflicted = player1Strength*weapon1Strength*randomMultiplier1;

        int player2Strength = player2.getStrength();
        int weapon2Strength = weapon2.getWeaponStrength();
        double player2DamageInflicted = player2Strength*weapon2Strength*randomMultiplier2;

        int player1Life = player1.getLife();
        player1Life -= player2DamageInflicted;
        player1.setLife(player1Life);

        int player2Life = player2.getLife();
        player2Life -= player1DamageInflicted;
        player2.setLife(player2Life);

        System.out.println(player1.getName() + " (" + player1.getStrength() + ") has inflicted " + player1DamageInflicted + " damages with his " + weapon1 + " // (Bonus = " + randomMultiplier1 + ")");
        System.out.println(player2.getName() + "'s life is now : " + player2.getLife());
        //System.out.println("\n");
        System.out.println(player2.getName() + " (" + player2.getStrength() + ") has inflicted " + player2DamageInflicted + " damages with his " + weapon2 + " // (Bonus = " + randomMultiplier2 + ")");
        System.out.println(player1.getName() + "'s life is now : " + player1.getLife());
    }
}
