package com.gcorp.service.app.pnrservice.domain.models;

import java.security.SecureRandom;

public class PnrGenerator {

    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int PNR_LENGTH = 6;

    /**
     * Generates a random PNR code.
     * @return A 6-character alphanumeric PNR string.
     */
    public String generate() {
        SecureRandom random = new SecureRandom();
        StringBuffer pnr = new StringBuffer(PNR_LENGTH);

        for (int i = 0; i < PNR_LENGTH; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            pnr.append(CHAR_POOL.charAt(index));
        }

        return pnr.toString();
    }
}
