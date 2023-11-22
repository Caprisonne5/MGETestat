## Tennis Score App

# Description
Die Tennis Score App ist eine, in Java geschriebene Android Applikation.
Die App nimmt einem, während eines Tennisspiels unter Freunden / Bekannten / Rivalen, nicht
nur das Zählen ab, mithilfe der Room Library werden die absolvierten Spiele gespeichert und
übersichtlich nach Datum, auf der Startseite der App aufgelistet.

# How to Use it
Auf der Startseite sehen Sie, die gespielten Spiele mit den jeweiligen Gewinnern.
Mithilfe des "Create New Match" Buttons können sie ein neues Spiel starten

Startseite:

![StartScreenshot](https://github.com/Caprisonne5/MGETestat/assets/145682755/9b6ead67-b294-44c0-87f8-091885c15ca2)
![Alt text]((https://github.com/Caprisonne5/MGETestat/assets/145682755/9b6ead67-b294-44c0-87f8-091885c15ca2))

In der darauf folgenden Ansicht, müssen zwei Namen für Spieler 1 und 2 eingetragen werden (2 < Namenlänge <= 15),
erst dann wird der "Start Match" Button clickable.

![StartMatchScreenshot](https://github.com/Caprisonne5/MGETestat/assets/145682755/6900bbed-b2a6-4946-97b0-ec93ab89fdf9)

Die Match-Seite ist Simpel gehalten. Oben findet man die Punktzahl des aktuellen Sets. Darunter befinden sich
die Knöpfe, mit welchen Sie Punkte auf die Konten der jeweiligen Spieler addieren können. Darauf folgt die
Punkteübersicht zum aktuellen Game.

![InitialMatchState](https://github.com/Caprisonne5/MGETestat/assets/145682755/8e4d3a8f-d1ae-4d20-8e5a-3bae98d95b94)

Die Punktezählung entspricht der normalen Zählungsweise im Tennis.

![AdvScreenshot](https://github.com/Caprisonne5/MGETestat/assets/145682755/7336291f-59be-4c03-b5de-26ed03acbd4b)

Bei Set-Stand 6 : 6 wechselt die Punkteübersicht für Games zur Punkteübersicht für das zu spielende Tiebreak.

![TieBreakScreenshot](https://github.com/Caprisonne5/MGETestat/assets/145682755/ebb49d58-c693-4c07-926d-d83440dddcb5)

Nachdem das erste Set zu ende gespielt wurde, kann das Match mit dem "End Match" Button beendet werden und man wird zurück
auf die Startseite geführt.

![MatchFinishedOverviewScreenshot](https://github.com/Caprisonne5/MGETestat/assets/145682755/ef8fa855-5e72-426a-a3b9-0352b5c51c06)

# Testat Punkteliste
- 3 Verschiedene Activitys
- Persistenz durch Room
- 1 zu n Beziehung mit Hilfsklasse
- Zählungsweise Sets und Games
- Recyclerview mit custom layout Elementen
