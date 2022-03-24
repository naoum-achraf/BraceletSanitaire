# BraceletSanitaire
## Local 
Traitement qui s'éxecute localement recoit les données du streaming et en ajoutant d'autres données fixes qui existent au niveau de la base de données, pour prédire le résultat du modéle Machine learning et le stocker par aprés dans MySQL -PYTHON 
## Simulation des capteur
Script qui se lance et envoie un triplet {Température, Tension, Fréquence cardiaque} à Firebase realtime chaque minute -PYTHON
## Traitement Cloud
Script qui utilise Spark Streaming pour streamer les données du firebase et faire un traitement en calculant la myoyenne de chaque 15 triplet == 15 min -PYTHON
## Bracelet 
Partie Backend, contient les différents classes, les interaction avec la base de données, l'utilisation des Api -JAVA SPRING BOOT 
## WebApp 
Notre Application web qui présente l'ensemble des informations aux médecins et patients -REACT JS
## DataBase MySQL
l'ensemble des enregistrement concernant les différents entites, données provient du Cloud, résultat de la prédiction.
