package io.github.laurencerawlings.barenecessities.tests;

import io.github.laurencerawlings.barenecessities.systems.AccountSystem;

/**
 * Test Class
 */
public class Main {
    public static void main(String[] args) {
        AccountSystem as = new AccountSystem();
        TestPlayer player = new TestPlayer();
        as.addAccount(player);

        System.out.println(as.findAccount(player.getUniqueId()));
    }
}
