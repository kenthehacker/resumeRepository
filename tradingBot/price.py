from apiKey import apiKey
from apiKey import nakedKey
import time
import datetime
import json
import requests
import pandas as pd 
from pandas.io.json import json_normalize
class stock:
    def __init__(self, stock):
        self.stock = stock
    def getPriceHistory(self, period, periodType, frequency, frequencyType, endDate, startDate, needExtendedHoursData):
        tdURL = r'https://api.tdameritrade.com/v1/marketdata/'+self.stock+r'/pricehistory'
        inputVal = {'apikey':nakedKey, 'periodType':periodType, 'period':period, 'frequencyType':frequencyType, 'endDate':endDate, 'startDate':startDate, 'needExtendedHoursData': needExtendedHoursData}
        data = requests.get(url=tdURL,params=inputVal)
        readableData = data.json()
        filePath = r'/Users/kenichimatsuo/DataSets/TradingBot/jsonDumps/jsonDump.json'
        with open(filePath, 'w') as q:
            json.dump(readableData, q)
        q.close()
        #return json_normalize(readableData['candles'])
        return readableData

        #return readableData
    def timeToEpoch(self, theTime):
        #time has to be in format day.month.year hour:minute:seconds as a mf string
        pattern = '%d.%m.%Y %H:%M:%S'
        reformatTime = int(time.mktime(time.strptime(theTime, pattern)))*1000
        return reformatTime

    def nowEpoch(self):
        tday = datetime.datetime.now()
        hour = tday.hour
        minute = tday.minute
        second = tday.second
        day = tday.day
        month = tday.month
        year = tday.year
        if (hour>12):
            hour = hour-12
        test_time = str(day)+'.'+str(month)+'.'+str(year)+' '+str(hour)+':'+str(minute)+':'+str(second)
        #date_time = '17.05.2020 10:55:00'
        pattern = '%d.%m.%Y %H:%M:%S'
        reformatTime = int(time.mktime(time.strptime(test_time, pattern)))*1000
        return reformatTime


aapl = stock('AAPL')
tempVar=aapl.getPriceHistory(period='2',periodType='day',frequency='1',frequencyType='minute',endDate='1589504442000',startDate='1589418042000',needExtendedHoursData='true')
print(json_normalize(tempVar['candles']))










