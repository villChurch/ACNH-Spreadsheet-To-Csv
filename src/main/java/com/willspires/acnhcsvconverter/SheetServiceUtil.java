package com.willspires.acnhcsvconverter;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;

class SheetServiceUtil {

    private static final String APPLICATION_NAME = "ACNH spreadsheet to csv converter";

    static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        try {
            Credential credential = GoogleAuthorizeUtil.authorize();
            return new Sheets.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    JacksonFactory.getDefaultInstance(), credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (NullPointerException exception) {
            System.out.println("Could not find google-sheets-client-secret.json in /src/main/resources");
            System.exit(-1);
            return null;
        }
    }
}
