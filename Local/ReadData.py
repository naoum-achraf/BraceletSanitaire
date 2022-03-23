import json
from mysql.connector import (connection)
import pandas as pd
from sklearn.model_selection import train_test_split
import pickle
import time



def getData(index):
    f = open(r'C:\Users\HP\Desktop\iotapp.json')
    data = json.load(f)
    s = json.dumps(data, indent=4)
    c = json.loads(s)
    a = c['data0']
    temp = []
    tens = []
    freq = []
    for i in a.values():
        temp.append(int(i['Température']))
    # 	print(i['Température'])
    print("Tension :")
    for i in a.values():
        tens.append(int(i['Tension']))

    # 	print(i['Tension'])
    for i in a.values():
        freq.append(int(i['frequence cardiaque']))
    temp = temp[index:index+15]
    tens = tens[index:index+15]
    freq = freq[index:index+15]
    f.close()
    return temp, tens, freq

def getDataFromSensors():
    from firebase import firebase
    url = 'https://iotapp-ae6e4-default-rtdb.firebaseio.com/'
    firebase = firebase.FirebaseApplication(url)
    result = firebase.get('', '')
    vocab = list(result.keys())
    i = 0
    result['data' + str(i)] = result.pop(vocab[1])
    with open(r'C:\Users\HP\Desktop\iotapp.json', 'w') as my_file:
        json.dump(result, my_file)

def PushSql(Temp, Tens, Freq, index):
    cnx = connection.MySQLConnection(user='root',
                                     host='127.0.0.1',
                                     database='bracelet',
                                     port=3308)
    cursor = cnx.cursor()

    queryTemperature = ("INSERT INTO temperature(Temp1, Temp2, Temp3, Temp4, Temp5, Temp6, Temp7, "
                        "Temp8, Temp9, Temp10, Temp11, Temp12, Temp13, Temp14, Temp15, user_id) "
                        "VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,8)")
    queryTension = ("INSERT INTO tension(Tens1, Tens2, Tens3, Tens4, Tens5, Tens6, Tens7, "
                    "Tens8, Tens9, Tens10, Tens11, Tens12, Tens13, Tens14, Tens15, user_id) "
                    "VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,8)")
    queryFrequence = ("INSERT INTO frequence(Freq1, Freq2, Freq3, Freq4, Freq5, Freq6, Freq7, "
                      "Freq8, Freq9, Freq10, Freq11, Freq12, Freq13, Freq14, Freq15, user_id) "
                      "VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,8)")

    UpdateTemp = ("UPDATE temperature SET Temp1=%s, Temp2=%s, Temp3=%s, Temp4=%s, Temp5=%s, Temp6=%s, Temp7=%s, "
                        "Temp8=%s, Temp9=%s, Temp10=%s, Temp11=%s, Temp12=%s, Temp13=%s, Temp14=%s, Temp15=%s where id = 1")
    UpdateTens = ("UPDATE tension SET Tens1=%s, Tens2=%s, Tens3=%s, Tens4=%s, Tens5=%s, Tens6=%s, Tens7=%s, "
                    "Tens8=%s, Tens9=%s, Tens10=%s, Tens11=%s, Tens12=%s, Tens13=%s, Tens14=%s, Tens15=%s where id = 1")
    UpdateFreq = ("UPDATE frequence SET Freq1=%s, Freq2=%s, Freq3=%s, Freq4=%s, Freq5=%s, Freq6=%s, Freq7=%s, "
                      "Freq8=%s, Freq9=%s, Freq10=%s, Freq11=%s, Freq12=%s, Freq13=%s, Freq14=%s, Freq15=%s where id = 1")

    if index==0:
        cursor.execute(queryTemperature, tuple(Temp))
        cursor.execute(queryTension, tuple(Tens))
        cursor.execute(queryFrequence, tuple(Freq))
    else:
        cursor.execute(UpdateTemp, tuple(Temp))
        cursor.execute(UpdateTens, tuple(Tens))
        cursor.execute(UpdateFreq, tuple(Freq))
    cnx.commit()
    print("Send to Mysql at : %s" % time.ctime())
    cnx.close()

def Average(lst):
    return sum(lst) / len(lst)

def getFixData():
    cnx = connection.MySQLConnection(user='root',
                                     host='127.0.0.1',
                                     database='Bracelet',
                                     port=3308)
    cursor = cnx.cursor()
    Query = "SELECT age,sex,`chest_pain_type`,`cholesterol`,`exercise_angina`,`restingecg`,`fastingbs`,`st_slope`,`oldpeak` FROM `infos` WHERE id = 2"
    cursor.execute(Query)
    return cursor.fetchone()


def InputModel(df):
    data = pd.read_csv(r'C:\Users\HP\Desktop\Downloads\heart.csv')
    train, test = train_test_split(data, test_size=0.2, random_state=4)
    x_train = train.drop(columns=["HeartDisease"])
    x = x_train.append(df, ignore_index=True)
    tr = pd.get_dummies(x)
    Output=tr.loc[[734]]
    return Output.values.astype(float)

def Getprediction(input):
    filename = r'C:\Users\HP\finalized_model.sav'
    loaded_model = pickle.load(open(filename, 'rb'))
    return loaded_model.predict(input)[0]

def SendDanger():
    cnx = connection.MySQLConnection(user='root',
                                     host='127.0.0.1',
                                     database='Bracelet',
                                     port=3308)
    cursor = cnx.cursor()
    sql = "UPDATE infos SET danger = 1 where id = 4"
    cursor.execute(sql)
    cnx.commit()
    print('updated')


def GetDonnéeTraitée():
    from firebase import firebase
    url = 'https://iotapp-ae6e4-default-rtdb.firebaseio.com/'
    firebase = firebase.FirebaseApplication(url)
    result = firebase.get('', '')
    vocab = list(result.keys())

    result['data' + str(0)] = result.pop(vocab[1])
    a=list(result["AVERAGE"].values())[-1]
    return a['Température'],a['Tension'],a['frequence cardiaque']