# BraceletSanitaire
## Local 
Traitement qui s'éxecute localement recoit les données du streaming et ajouter les données fixes qui existe au niveau de la base de données, et prédire le résultat du modéle et la stocker par aprés dans mysql -PYTHON 
## Simulation des capteur
Script qui se lance et envoie un triplet {Température, Tension, Fréquence cardiaque} à Firebase realtime chaque minute -PYTHON
## Traitement Cloud
Script qui utilise spark straming pour lire streamer les données du firebase et faire un traitement sur chaque 15 triplet == 15 min -PYTHON
## Bracelet 
Partie Backend -JAVA SPRING BOOT 
## WebApp 
Notre Application web qui gére l'ensemble des transaction avec la base de données en utilisant des Api -REACT JS
## DataBase MySQL
l'ensemble des enregistrement concernant les différents entites, et les données provient du Cloud et le résultat de la prédiction.
