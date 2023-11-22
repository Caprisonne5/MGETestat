# Tennis Score App

## Description
Die Tennis Score App ist eine, in Java geschriebene Android Applikation.
Die App nimmt einem, während eines Tennisspiels unter Freunden / Bekannten / Rivalen, nicht
nur das Zählen ab, mithilfe der Room Library werden die absolvierten Spiele gespeichert und
übersichtlich nach Datum, auf der Startseite der App aufgelistet.

## How to Use it
Auf der Startseite sehen Sie, die gespielten Spiele mit den jeweiligen Gewinnern.
Mithilfe des "Create New Match" Buttons können sie ein neues Spiel starten


Startseite:


<img src="https://github.com/Caprisonne5/MGETestat/blob/main/1.png" width="400">


In der darauf folgenden Ansicht, müssen zwei Namen für Spieler 1 und 2 eingetragen werden (2 < Namenlänge <= 15),
erst dann wird der "Start Match" Button clickable.


<img src="https://github.com/Caprisonne5/MGETestat/blob/main/2.png" width="400">


Die Match-Seite ist Simpel gehalten. Oben findet man die Punktzahl des aktuellen Sets. Darunter befinden sich
die Knöpfe, mit welchen Sie Punkte auf die Konten der jeweiligen Spieler addieren können. Darauf folgt die
Punkteübersicht zum aktuellen Game.

<img src="https://github.com/Caprisonne5/MGETestat/blob/main/3.png" width="400">


Die Punktezählung entspricht der normalen Zählungsweise im Tennis.


<img src="https://github.com/Caprisonne5/MGETestat/blob/main/4.png" width="400">


Bei Set-Stand 6 : 6 wechselt die Punkteübersicht für Games zur Punkteübersicht für das zu spielende Tiebreak.


<img src="https://github.com/Caprisonne5/MGETestat/blob/main/5.png" width="400">


Nachdem das erste Set zu ende gespielt wurde, erscheint das Resultat über dem "End Match" Button.
Es können nun beliebig viele Sets gespielt werden.


<img src="https://github.com/Caprisonne5/MGETestat/blob/main/6.png" width="400">


Nach dem ersten fertig gespielten Set, kann mit dem "End Match" Button, das Spiel beendet werden.
Daraufhin wird man wieder auf die Startseite geführt, wo nun das soeben beendete Match zuoberst 
erscheint.



<img src="https://github.com/Caprisonne5/MGETestat/blob/main/7.png" width="400">



## Testat Punkteliste
- 3 Verschiedene Activitys
- Persistenz durch Room
- 1 zu n Beziehung mit Hilfsklasse
- Zählungsweise Sets und Games
- Recyclerview mit custom layout Elementen
