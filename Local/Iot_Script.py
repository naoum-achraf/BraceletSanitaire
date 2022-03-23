import time
import pandas as pd
from ReadData import getData, getDataFromSensors, PushSql, Average, getFixData, InputModel, Getprediction, SendDanger,GetDonnéeTraitée

Sure=0
Up=0
i=0
while True:

    # Methode pour stocker les données de firebase dans un file.json
    getDataFromSensors()

    # Lire les données est extraire 15 valeurs
    Temp, Tens, Freq = getData(i)
    i+=15

    # Stocker les données dans une table Mysql
    PushSql(Temp, Tens, Freq,Up)
    Up=1

    # Récupération des données Fixées par le médecin
    DataFix = getFixData()

    AvgTemp, AvgTens, AvrFreq =GetDonnéeTraitée()

    # Préparation des données pour predict
    data =[[int(DataFix[0]), DataFix[1], DataFix[2], AvgTens, int(DataFix[3]), int(DataFix[6]), DataFix[5], AvrFreq, DataFix[4], int(DataFix[8]), DataFix[7]]]
    df = pd.DataFrame(data, columns = ['Age','Sex','ChestPainType','RestingBP','Cholesterol','FastingBS','RestingECG','MaxHR','ExerciseAngina','Oldpeak','ST_Slope'])

    #Préparation du data pour le modele
    Input = InputModel(df)

    #Get Prédiction from modéle
    Prediction = Getprediction(Input)
    if Prediction == 1:
        SendDanger()


    print("Predection Send at : %s" % time.ctime())
    time.sleep(900)


