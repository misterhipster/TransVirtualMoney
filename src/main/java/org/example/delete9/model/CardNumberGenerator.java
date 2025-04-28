package org.example.delete9.model;

import lombok.Builder;

import java.util.Random;

@Builder
public class CardNumberGenerator {
    private String cardNumber;

    public static CardNumberGenerator generateVisaCard() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder("4"); // Visa prefix
        for (int i = 0; i < 14; i++) { // 15 digits (last one is checksum)
            cardNumber.append(random.nextInt(10));
        }
        cardNumber.append(calculateLuhnChecksum(cardNumber.toString()));
        return CardNumberGenerator.builder().cardNumber(cardNumber.toString()).build();
    }

    private static int calculateLuhnChecksum(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (10 - (sum % 10)) % 10;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}