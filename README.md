![Test maven build](https://github.com/villChurch/ACNH-Spreadsheet-To-Csv/workflows/Test%20maven%20build/badge.svg)
[![GitHub issues](https://img.shields.io/github/issues/villChurch/ACNH-Spreadsheet-To-Csv)](https://github.com/villChurch/ACNH-Spreadsheet-To-Csv/issues)
[![GitHub forks](https://img.shields.io/github/forks/villChurch/ACNH-Spreadsheet-To-Csv)](https://github.com/villChurch/ACNH-Spreadsheet-To-Csv/network)
[![GitHub license](https://img.shields.io/github/license/villChurch/ACNH-Spreadsheet-To-Csv)](https://github.com/villChurch/ACNH-Spreadsheet-To-Csv/blob/master/LICENSE)

# ACNH-Spreadsheet-To-Csv
Convert acnh spreadsheet to seperate csv files

# Prerequisites 

* A google account - needed for oauth so the app read the sheet
* Java 8 or higher
* Optional - If you chose to self compile you will need maven, needs to be Maven version 3 or higher

# Installing Java 8
See https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html 

# Running
To run this you can either use the compiled jar in releases, or clone the repo and run a mvn package
## Compiling yourself
If you want to compile this yourself and run you will need a Google Cloud Project that has the Google Sheets API enabled.

With this you will then need to obtain your Client Configuration and place this as a json file called `google-sheets-client-secret.json` in `/src/main/resources`

Details of how to automatically create a Google Cloud Project and get your Client Configuration can be found here https://developers.google.com/sheets/api/quickstart/java.

## Using the compiled version
If you are happy running the compiled jar using my Google Cloud Project then just run the java file and login through the browser when prompted to authorise the app.

Jar file can be downloaded from the latest release which can be found [here](https://github.com/villChurch/ACNH-Spreadsheet-To-Csv/releases).

Then just naviaget to where the jar file is and run `java -jar jar file here`, eg `java -jar spreadsheet_to_csv-1.0-SNAPSHOT.jar`.

# Output
The output will be a number of CSVs, one for each sheet, that will be placed in the same directory as the jar file.

This should also fetch out the image links and place them in the image fields.

# Notes

Some of the columns names have been changed to strip spaces and `/`'s and replace them with `_`'s.

Also this code is just a quick script I knocked up to get the sheets as csv's and therefore has lots of room for improvements.

I may improve it in future, depends if I need/want to, but feel free to create a pull request if you want to.

# Contributors

* All the people over at the [ACNH Spreadsheet discord](https://discord.gg/DHGJuz) who have contributed towards the sheet which can be found [here](https://tinyurl.com/acnh-sheet)
* [ACNHCDN](https://acnhcdn.com/) for hosting the images found in the exported links
